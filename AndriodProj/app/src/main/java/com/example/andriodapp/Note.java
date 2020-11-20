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

    

