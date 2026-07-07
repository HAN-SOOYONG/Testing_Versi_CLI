package com.keep;

public class note {
    private int id;
    private String title;
    private String content;
    private String label;
    private String reminder;


    public note(int id, String title, String content, String label, String reminder) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.label = label;
        this.reminder = reminder;
    }

   
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getLabel() { return label; }
    public String getReminder() { return reminder; }
}