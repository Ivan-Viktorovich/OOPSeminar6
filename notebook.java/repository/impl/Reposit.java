package repository.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import model.Note;
import model.database.DBFunctional;
import repository.Repository;
import view.notmap.impl.NoteMapper;


public class Reposit implements Repository<Note, Long>{
    private final NoteMapper mapper;
    private final DBFunctional operation;

    public Reposit(DBFunctional operation) {
        this.mapper = new NoteMapper();
        this.operation = operation;
    }

    @Override
    public List<Note> findAll() {
        List<String> lines = operation.readAll();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.toOutput(line));
        }
        return notes;
    }

    @Override
    public Note create(Note note) {
        List<Note> notes = findAll();
        long max = 0L;
        for (Note u : notes) {
            long id = u.getId();
            if (max < id){
                max = id;
            }
        }
        long next = max + 1;
        note.setId(next);
        notes.add(note);
        write(notes);
        return note;
    }


    @Override
    public Optional<Note> update(Long id, Note note) {
        List<Note> notes = findAll();
        Note editUser = notes.stream().filter(u -> u.getId().equals(id))
                    .findFirst().orElseThrow(() -> new RuntimeException("Note not found"));
        editUser.setId(id);
        editUser.setHeading(note.getHeading());
        editUser.setText(note.getText());
        editUser.setDate(note.getDate());
        write(notes);
        return Optional.empty();
    }
    private void write(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note u : notes) {
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
    }


    @Override
    public Optional<Note> delete(Note note, String id) {
        List<Note> notes = findAll();
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note nextNote = iterator.next();
            if(nextNote.getId().equals(note.getId())){
                notes.remove(nextNote);
                write(notes);
                break;
            }
        }
        return Optional.empty();
    }

}
