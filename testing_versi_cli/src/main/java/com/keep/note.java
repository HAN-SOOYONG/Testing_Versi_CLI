package com.keep;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private int id;
    private String title;
    private String content;
    private String label;
    private String reminder; 

    private boolean isDeleted = false;
    private boolean showCheckboxes = false;
    private boolean darkModeEnabled = false;
    private boolean lightModeEnabled = false; 
    private List<String> checklistItems = new ArrayList<>();
    private List<Boolean> checklistStatus = new ArrayList<>();


    public Note(String title, String content) {
        this.id = 0;
        this.title = title;
        this.content = content;
        this.label = null;
        this.reminder = null;
    }


    public Note(int id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.label = null;
    this.reminder = null;
}

    public Note(int id, String title, String content, String label, String reminder) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.label = label;
        this.reminder = reminder;
    }

    public Note cloneNote() {
        Note cloned = new Note(this.id, this.title, this.content, this.label, this.reminder);
        cloned.setDeleted(this.isDeleted);
        cloned.setShowCheckboxes(this.showCheckboxes);
        cloned.setDarkModeEnabled(this.darkModeEnabled);
        cloned.setLightModeEnabled(this.lightModeEnabled);
        return cloned;
    }

    public void addChecklistItem(String item, boolean status) {
        this.checklistItems.add(item);
        this.checklistStatus.add(status);
    }

    public void checkAllItems() {
        for (int i = 0; i < checklistStatus.size(); i++) {
            checklistStatus.set(i, true);
        }
    }

    public void delete() { 
        this.isDeleted = true; 
    }

    public String convertToGoogleDocsFormat() {
        return "=== GOOGLE DOCS EXPORT ===\n" + "Title: " + this.title + "\nContent: " + this.content;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public String getReminder() { return reminder; }
    public void setReminder(String reminder) { this.reminder = reminder; }
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }
    public boolean isShowCheckboxes() { return showCheckboxes; }
    public void setShowCheckboxes(boolean showCheckboxes) { this.showCheckboxes = showCheckboxes; }
    public boolean isDarkModeEnabled() { return darkModeEnabled; }
    public void setDarkModeEnabled(boolean darkModeEnabled) { this.darkModeEnabled = darkModeEnabled; }
    public boolean isLightModeEnabled() { return lightModeEnabled; }
    public void setLightModeEnabled(boolean lightModeEnabled) { this.lightModeEnabled = lightModeEnabled; }
    public List<String> getChecklistItems() { return checklistItems; }
    public List<Boolean> getChecklistStatus() { return checklistStatus; }
}