package com.example.andriodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(Context context, ArrayList<Note> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Note note = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView noteText = (TextView) convertView.findViewById(R.id.note);
        noteText.setText(note.getNote());

        TextView dueDateText = (TextView) convertView.findViewById(R.id.dueDateText);

        if(note.getDueDate() == null && note.getDueTime() == null) {
            dueDateText.setText("");
        }

        if(note.getDueDate() != null || note.getDueTime() != null) {

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Due on: ");

            if(note.getDueDate() != null){
                stringBuilder.append(note.getDueDate() + " ");
            }

            if(note.getDueTime() != null) {
                stringBuilder.append(note.getDueTime());
            }

            dueDateText.setText(stringBuilder.toString());

            TextView alarmText = (TextView) convertView.findViewById(R.id.alarmEditBg);
            if(note.getAlarmTime() != null) {
                alarmText.setVisibility(View.VISIBLE);
            }
        }

        TextView priorityEditText = (TextView) convertView.findViewById(R.id.priorityEditText);

        if(note.getPriority() == null) {
            priorityEditText.setText("");
        }

        if(note.getPriority() != null) {
            if(note.getPriority().equalsIgnoreCase("p1")) {
                priorityEditText.setText(" I ");
            }
            if(note.getPriority().equalsIgnoreCase("p2")) {
                priorityEditText.setText(" II ");
            }
            if(note.getPriority().equalsIgnoreCase("p3")) {
                priorityEditText.setText(" III ");
            }
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
