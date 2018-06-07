package de.fh_zwickau.timemanagement2;

import java.util.Date;

/**
 * Our Task
 */
public class Task {
    private String text;
    private boolean isDone;
    private Date date;
    public Task(String text){
        this.text = text;
    }
    public Task(){

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return isDone;
    }
}
