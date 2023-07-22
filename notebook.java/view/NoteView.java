package view;

import java.util.List;
import java.util.Scanner;

import controller.NoteController;
import model.Note;
import view.comands.Commands;

public class NoteView {
    private final NoteController noteController;

    public NoteView(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Comands: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String heading = prompt("Heading: ");
                    String text = prompt("Text: ");
                    noteController.saveNote(new Note(heading, text));
                    break;
                case READ:
                    String id = prompt("id: ");
                    try {
                        Note note = noteController.readNote(Long.parseLong(id));
                        System.out.println(note);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    try {
                        List<Note> notes = noteController.readAllNotes();
                        System.out.println(notes);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    try {
                        String heading1 = prompt("Heading: ");
                        String text1 = prompt("Text: ");
                        Long noteid = Long.parseLong(prompt("Введите id"));
                        Note updated = new Note(heading1, text1);
                        noteController.updateNote(noteid, updated);
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                    break;
                case DELETE:
                    id = prompt("id: ");
                    try {
                        Note note = noteController.readNote(Long.parseLong(id));
                        noteController.deleteNote(note, id);
                    } catch (Exception e) {
                        throw new RuntimeException("id is not");
                    }
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
