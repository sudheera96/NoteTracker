package com.example.andriodapp;


import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    TextView timeEditText;
    TextView alarmEditText;
    TextView dateEditText;
    int hour, minute;
    int day, month, year;
    FirebaseDatabase rootNode;
    Chronometer chronometer;
    ImageButton btStart, btStop;
    private ArrayList<Note> noteArrayList;
    private long pauseOffset;
    private boolean running;
    int positionOfClickValue;
    int priorityColor;
    String prioritySelected;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rootNode = FirebaseDatabase.getInstance();

        TextView textView = (TextView) findViewById(R.id.noteText);
        positionOfClickValue = getIntent().getIntExtra("positionOfClickValue", 0);
        noteArrayList = NotesList.getSingleton().getNotesList();
        textView.setText(noteArrayList.get(positionOfClickValue).getNote());

        Calendar mCalender = Calendar.getInstance();
        year = mCalender.get(Calendar.YEAR);
        month = mCalender.get(Calendar.MONTH);
        day = mCalender.get(Calendar.DAY_OF_MONTH);

        dateEditText = findViewById(R.id.due_date);
        timeEditText = findViewById(R.id.due_time);
        alarmEditText = findViewById(R.id.alarm);

        btStart = findViewById(R.id.bt_start);
        btStop = findViewById(R.id.bt_stop);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());

        priorityColor = getResources().getColor(R.color.priority_background);

        if (noteArrayList.get(positionOfClickValue).getDueDate() != null) {
            dateEditText.setText(noteArrayList.get(positionOfClickValue).getDueDate());
        }

        if (noteArrayList.get(positionOfClickValue).getDueTime() != null) {
            timeEditText.setText(noteArrayList.get(positionOfClickValue).getDueTime());
        }

        if (noteArrayList.get(positionOfClickValue).getAlarmTime() != null) {
            alarmEditText.setText(noteArrayList.get(positionOfClickValue).getAlarmTime());
        }

        if (noteArrayList.get(positionOfClickValue).getBaseTime() != null) {
            pauseOffset = noteArrayList.get(positionOfClickValue).getBaseTime();
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
        }

        if (noteArrayList.get(positionOfClickValue).getPriority() != null) {
            if (noteArrayList.get(positionOfClickValue).getPriority().equals("p1")) {
                ((TextView) findViewById(R.id.p1)).setBackgroundColor(priorityColor);
            }
            if (noteArrayList.get(positionOfClickValue).getPriority().equals("p2")) {
                ((TextView) findViewById(R.id.p2)).setBackgroundColor(priorityColor);
            }
            if (noteArrayList.get(positionOfClickValue).getPriority().equals("p3")) {
                ((TextView) findViewById(R.id.p3)).setBackgroundColor(priorityColor);
            }

        }

        timeEditText.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    (view, hh, mm) -> {
                        hour = hh;
                        minute = mm;
                        String time = hour + ":" + minute;
                        try {
                            SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");
                            Date date = f24Hours.parse(time);
                            SimpleDateFormat f12Hours = new SimpleDateFormat("hh:mm aa");
                            String dueTime = f12Hours.format(date);
                            timeEditText.setText(dueTime);
                            noteArrayList.get(positionOfClickValue).setDueTime(dueTime);
                            setSaveVisible();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }, 12, 0, false);
            timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            timePickerDialog.updateTime(hour, minute);
            timePickerDialog.show();
        });

        alarmEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlarmDate(v);
            }

            private void createAlarmDate(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        (datePicker, yy, mm, dd) -> {
                            Calendar cal = Calendar.getInstance();
                            cal.set(Calendar.YEAR, yy);
                            cal.set(Calendar.MONTH, mm);
                            cal.set(Calendar.DAY_OF_MONTH, dd);

                            createAlarmTime(v, cal);

                        }, year, month, day);

                datePickerDialog.getDatePicker().setMinDate(new Date().getTime() - 10000);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }

            private void createAlarmTime(View v, Calendar cal) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                            @Override
                            public void onTimeSet(TimePicker view, int hh, int mm) {
                                hour = hh;
                                minute = mm;
                                cal.set(Calendar.HOUR_OF_DAY, hour);
                                cal.set(Calendar.MINUTE, minute);
                                cal.set(Calendar.SECOND, 0);

                                int am_pm = cal.get(Calendar.AM_PM);
                                String ampm = "ampm";
                                if (am_pm == 0) {
                                    ampm = "AM";
                                } else {
                                    ampm = "PM";
                                }

                                Toast.makeText(getApplicationContext(), "Alarm set to: " + cal.getTime(), Toast.LENGTH_LONG).show();
                                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm");
                                String alarmTime = formatter.format(cal.getTime()) + " " + ampm;
                                alarmEditText.setText(alarmTime);
                                noteArrayList.get(positionOfClickValue).setAlarmTime(alarmTime);
                                setSaveVisible();
                                MainActivity2.this.startAlarm(cal);
                            }
                        }, 12, 0, false);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(hour, minute);
                timePickerDialog.show();
            }
        });

        dateEditText.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    (datePicker, yy, mm, dd) -> {
                        year = yy;
                        month = mm + 1;
                        day = dd;
                        String dueDate = month + "-" + day + "-" + year;
                        dateEditText.setText(dueDate);
                        noteArrayList.get(positionOfClickValue).setDueDate(dueDate);
                        setSaveVisible();
                    }, year, month, day);

            datePickerDialog.getDatePicker().setMinDate(new Date().getTime() - 10000);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            datePickerDialog.show();

        });

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NotificationPublisher.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String selectedNoteAsString = null;
        try {
            selectedNoteAsString = objectMapper.writeValueAsString(noteArrayList.get(positionOfClickValue));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        intent.putExtra("selectedNote", selectedNoteAsString);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        Objects.requireNonNull(alarmManager).setExact(AlarmManager.RTC_WAKEUP,
                c.getTimeInMillis(), pendingIntent);
    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
            btStop.setVisibility(View.GONE);
            btStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause));
        } else {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            btStop.setVisibility(View.VISIBLE);
            btStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_play));
            noteArrayList.get(positionOfClickValue).setBaseTime(pauseOffset);
            setSaveVisible();
        }
    }

    public void resetChronometer(View v) {
        btStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_play));
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }