package view.notmap.impl;

import java.time.LocalDate;

import model.Note;
import view.notmap.Mapper;

public class NoteMapper implements Mapper<Note, String>{
    public String toInput(Note note) {
        return String.format("%s,%s,%s,%s", note.getId(), note.getHeading(), note.getText(), note.getDate());
    }

    @Override
    public Note toOutput(String s) {
        String[] lines = s.split(",");
        long id;
        LocalDate date;
        if (isDigit(lines[0])) {
            date = LocalDate.now();
            id = Long.parseLong(lines[0]);
            return new Note(id, lines[1], lines[2], date);
        }
        throw new NumberFormatException("Id must be a large number");
    }


    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
