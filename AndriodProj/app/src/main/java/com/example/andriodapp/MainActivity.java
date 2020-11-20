package com.example.andriodapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Note> noteArrayList;
    private ArrayAdapter<Note> noteAdapter;
    private ListView listView;
    private Button button;
    FirebaseDatabase rootNode;
    @Override
    protected void onResume() {
        super.onResume();
        Collections.sort(noteArrayList);
        noteAdapter.notifyDataSetChanged();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onStart()
     */
    @Override
    protected void onStart() {
        super.onStart();
        Collections.sort(noteArrayList);
        noteAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        noteArrayList = NotesList.getSingleton().getNotesList();
        noteAdapter = new NoteAdapter(this, noteArrayList);
        listView.setAdapter(noteAdapter);

        rootNode = FirebaseDatabase.getInstance();
        Query myMostViewedPostsQuery = rootNode.getReference();

        myMostViewedPostsQuery.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onDataChange(DataSnapshot dataSnapshot) {
//                noteAdapter.clear();
                noteArrayList.clear();
                NotesList notesList = FirebaseUtil.deserialize(dataSnapshot, NotesList.class);
                if(notesList!=null && notesList.getNotesList() != null && !notesList.getNotesList().isEmpty()){
                    notesList.getNotesList().stream().forEach(note -> {
                        noteArrayList.add(note);
                    });
                }
                Collections.sort(noteArrayList);
                noteAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                // removing each task from to-do list
                // adding a feedback message as a pop-up it an itemis deleted.
                Toast.makeText(context, "Item in list is removed", Toast.LENGTH_LONG).show();
                noteArrayList.remove(i);
                noteAdapter.notifyDataSetChanged();

                saveToDB();
                return true;
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            EditText input = findViewById(R.id.edittext);
            String itemText = input.getText().toString();

            if (!(itemText.equals(""))) {
                // adding each task to to-do list
                Note note = new Note();
                note.setId((long) (noteArrayList.size() + 1));
                note.setNote(itemText);
                noteAdapter.add(note);

                saveToDB();
                input.setText("");
            } else {
                // adding a feedback message as a alert if user tries to add an empty text
                Toast.makeText(getApplicationContext(), "Please enter text in list", Toast.LENGTH_LONG).show();
            }

        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("positionOfClickValue", position);
            startActivity(intent);
        });


    }
