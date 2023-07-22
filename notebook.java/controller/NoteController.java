package controller;

import java.util.List;
import java.util.Objects;
import model.Note;
import repository.Repository;

public class NoteController {
    private final Repository<Note, Long> repository;

    public NoteController(Repository<Note, Long> repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {
        repository.create(note);
    }

    public Note readNote(Long noteId) throws Exception {
        List<Note> notes = repository.findAll();
        for (Note note : notes) {
            if (Objects.equals(note.getId(), noteId)) {
                return note;
            }
        }

        throw new RuntimeException("Note not found");
    }

    public List<Note> readAllNotes() {
        return repository.findAll();
    }

    public void updateNote(Long noteId, Note note) {
        note.setId(noteId);
        repository.update(noteId, note);
    }
    
    public void deleteNote(Note note, String id) {
        repository.delete(note, id);
    }


}
