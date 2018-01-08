package com.home.cata.uclappandroid;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.actions.NoteIntents;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Catalin on 1/8/2018.
 */

public class BookTeam extends AppCompatActivity {

    EditText teamName;
    EditText date;
    DatePickerDialog datePickerDialog;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_team);
        teamName=(EditText) findViewById(R.id.teamName);
        date=(EditText) findViewById(R.id.date);
        setDate();
        date.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                datePickerDialog.show();
                return false;
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setDate() {
        Calendar calendar= Calendar.getInstance();
        datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month , int year) {
                Calendar newdate= Calendar.getInstance();
                newdate.set(day,month,year);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
                final Date startdate = newdate.getTime();
                String finaldate=simpleDateFormat.format(startdate);
                date.setText(finaldate);
            }
        },calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
    }

    public void bookTeam(View view){
        EditText nameEditText=(EditText) findViewById(R.id.teamName);
        EditText dateEditText=(EditText) findViewById(R.id.date);
        String text= nameEditText.getText().toString()+'\n'+dateEditText.getText().toString();

        Intent intent= new Intent(NoteIntents.ACTION_CREATE_NOTE).putExtra(NoteIntents.EXTRA_TEXT,text);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
