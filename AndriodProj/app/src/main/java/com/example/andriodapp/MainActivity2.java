package com.example.andriodapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private Button NEXT1;
    private Button NEXT2;
    TextView calenderdate;

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
    }
}
