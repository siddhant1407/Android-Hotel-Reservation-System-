package com.example.hotelbk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Reservation extends AppCompatActivity {

    private TextView dateText;
    private TextView dateText2;
    private EditText mRoom, mAdult, mKids, mName, mNumber, mEmail;
    private Button mUpload;
    TextView mStartDate, mEndDate;

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mReference = mDatabase.getReference().child("rooms");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        dateText = findViewById(R.id.textView2);
        dateText2 = findViewById(R.id.textView3);

        mRoom = findViewById(R.id.editText);
        mAdult = findViewById(R.id.editText2);
        mKids = findViewById(R.id.editText3);
        mName = findViewById(R.id.editText4);
        mNumber = findViewById(R.id.editText5);
        mEmail = findViewById(R.id.editText6);
        mStartDate = findViewById(R.id.tv_startDate);
        mEndDate = findViewById(R.id.tv_endDate);
        mUpload = findViewById(R.id.button3);


        final DialogFragment dialogFragment = new DatePickerDialogTheme4();

        mStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialogTheme4.id = "start";
                dialogFragment.show(getSupportFragmentManager(), "theme 4");
            }
        });

        mEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialogTheme4.id = "end";
                dialogFragment.show(getSupportFragmentManager(), "theme 4");
            }
        });

        mUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myRoom = mRoom.getText().toString().trim();
                String myAdult = mAdult.getText().toString().trim();
                String myKids = mKids.getText().toString().trim();
                String myName = mName.getText().toString().trim();
                String myNumber = mNumber.getText().toString().trim();
                String myEmail = mEmail.getText().toString().trim();
                String myArrival = mStartDate.getText().toString().trim();
                String myDeparture = mEndDate.getText().toString().trim();
                UploadRoomBooking u = new UploadRoomBooking(myRoom, myAdult, myKids, myName, myNumber, myEmail, myArrival, myDeparture);
                mReference.child(myRoom).setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Reservation.this, "Successfull", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public static class DatePickerDialogTheme4 extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        public static String id = null;
        String date;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
            return datePickerDialog;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            int month2 = month + 1;
            String formattedMonth = "" + month2;
            String formattedDayOfMonth = "" + day;

            if (month2 < 10) {
                formattedMonth = "0" + month2;
            }
            if (day < 10) {
                formattedDayOfMonth = "0" + day;
            }
            if (id.equals("start")) {
                TextView textView = getActivity().findViewById(R.id.tv_startDate);
                textView.setText(formattedDayOfMonth + "/" + formattedMonth + "/" + year);
                date = textView.getText().toString().trim();
            } else if (id.equals("end")) {
                TextView textView2 = getActivity().findViewById(R.id.tv_endDate);
                textView2.setText(formattedDayOfMonth + "/" + formattedMonth + "/" + year);
                date = textView2.getText().toString().trim();
            }
        }
    }

}