package com.example.andriodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private Button NEXT1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NEXT1 = findViewById(R.id.button4);
        CalendarView calendar_view = (CalendarView) findViewById(R.id.calendarView);
        calendar_view.setMinDate((new Date().getTime()));

        NEXT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });
    }
}
