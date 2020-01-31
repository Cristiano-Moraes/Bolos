package com.moraes.mobile.bolos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import java.util.Calendar;

public class CustomCalendar extends AppCompatActivity {
CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_calendar);
        calendarView = findViewById(R.id.calendarView2);

    }
}
