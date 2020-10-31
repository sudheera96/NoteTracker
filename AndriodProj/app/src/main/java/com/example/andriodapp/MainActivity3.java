package com.example.andriodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlarmManager;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity3 extends AppCompatActivity {
    private Button homeButton;
    TextView textview1;

    Context mcontext = this;

    Calendar calendar = Calendar.getInstance();
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, MainActivity.class));
            }
        });
        textview1 = (TextView) findViewById(R.id.TV);
        Button AlaramButton = (Button) findViewById(R.id.startAlaram);


        AlaramButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mcontext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hoursOfDay, int minute) {
                        textview1.setText("Alaram set to" + hoursOfDay + ":" + minute);
                    }

                }, hour, minute, android.text.format.DateFormat.is24HourFormat(mcontext));
                timePickerDialog.show();
            }

        });

        CalendarView calendar_view1 = (CalendarView) findViewById(R.id.calendarView1);
        calendar_view1.setMinDate((new Date().getTime()));


        TextView TV2 = (TextView) findViewById(R.id.textView2);


        calendar_view1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                // TODO Auto-generated method stub

                TV2.setText("Selected Date is : " + dayOfMonth + " / " + (month + 1) + " / " + year);

            }
        });
    }

}
