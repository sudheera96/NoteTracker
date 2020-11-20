package com.example.andriodapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;

@IgnoreExtraProperties
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotesList {
    private ArrayList<Note> notesList;

    public NotesList(ArrayList<Note> notesList) {
        this.notesList = notesList;
    }

    public NotesList() {
        notesList = new ArrayList<>();
    }

    public ArrayList<Note> getNotesList() {
        return notesList;
    }

    
}
