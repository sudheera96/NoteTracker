package com.example.andriodapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.firebase.database.IgnoreExtraProperties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@IgnoreExtraProperties
@JsonIgnoreProperties(ignoreUnknown = true)
public class Note implements Comparable<Note> {
    private Long id;
    private String note;
    private String dueDate;
    private String dueTime;
    private String alarmTime;
    private String priority;
    private Long baseTime;

    public Note() {
    }

    public Note(Long id, String note, String dueDate, String dueTime, String alarmTime, String priority, Long baseTime) {
        this.id = id;
        this.note = note;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.alarmTime = alarmTime;
        this.priority = priority;
        this.baseTime = baseTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(Long baseTime) {
        this.baseTime = baseTime;
    }

    @Override
    public int compareTo(Note note) {
//        return 0;
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        if (getDueDate() != null && note.getDueDate() != null) {
            Date curObjDate, passedObjDate;
            try {
                curObjDate = formatter.parse(getDueDate());
                passedObjDate = formatter.parse(note.getDueDate());
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
            return curObjDate.compareTo(passedObjDate);
        } else {
            return 0;
        }
    }
}

