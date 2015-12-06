package com.mig.cpsudev.mynote;

/**
 * Created by Mig on 06-Dec-15.
 */
public class Note {
    private String title;
    private String detail;
    private String priority;

    public Note() {
    }

    public Note(String title, String detail, String priority) {
        this.title = title;
        this.detail = detail;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
