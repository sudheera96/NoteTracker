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

    public void setNotesList(ArrayList<Note> notesList) {
        this.notesList = notesList;
    }

    private static NotesList theModel = null;

    //Implementing the singleton design patter for a unique object
    public static NotesList getSingleton() {
        if (theModel == null) {
            theModel = new NotesList();
        }
        return theModel;
    }
}
