package com.example.andriodapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private Button NEXT1;
    private Button NEXT2;
    TextView calenderdate;
    TextView tvTimer2;
    int t2Hour,t2Minute;

    Calendar calendar = Calendar.getInstance();
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NEXT1 = findViewById(R.id.button4);
        NEXT2 = findViewById(R.id.TIMER);
        CalendarView calendar_view = (CalendarView) findViewById(R.id.calendarView);
        calendar_view.setMinDate((new Date().getTime()));

        NEXT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
        NEXT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity4.class));
            }
        });

        TextView TV2 = (TextView) findViewById(R.id.calenderdate);


        calendar_view.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                // TODO Auto-generated method stub

                TV2.setText("Due Date: "+ (month + 1) + "/"+dayOfMonth + "/" + year);

            }
        });
        tvTimer2 = findViewById(R.id.tv_timer2);
        tvTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t2Hour = hourOfDay;
                        t2Minute = minute;
                        String time = t2Hour + ":" + t2Minute;
                        SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = f24Hours.parse(time);
                            SimpleDateFormat f12Hours = new SimpleDateFormat("hh:mm aa");
                            tvTimer2.setText(f12Hours.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                },12,0,false);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t2Hour,t2Minute);
                timePickerDialog.show();
            }
        });

    }
}
