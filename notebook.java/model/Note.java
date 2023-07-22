package model;

import java.time.LocalDate;

public class Note {
    private Long id;
    private String heading;
    private String text;
    private LocalDate date;
    
    public Note(String heading, String text) {
        this.heading = heading;
        this.text = text;
    }


    public Note(Long id, String heading, String text, LocalDate date) {
        this(heading, text);
        this.id = id;
        this.date = date;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getHeading() {
        return heading;
    }


    public void setHeading(String heading) {
        this.heading = heading;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("\n\nid: %s\nHeading: %s,\nText: %s,\nDate: %s", id, heading, text, date);
    }
    
}
