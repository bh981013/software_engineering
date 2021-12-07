package org.techtown.se_project05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Student_schedule_add extends AppCompatActivity {

    private Spinner sch_year,sch_month,sch_day;
    private Button btn_add,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_schedule_add);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        sch_year = (Spinner)findViewById(R.id.sch_year_add);
        sch_month = (Spinner)findViewById(R.id.sch_month_add);
        sch_day = (Spinner)findViewById(R.id.sch_day_add);

        btn_add = findViewById(R.id.btn_stuBull_details);

        btn_back = findViewById(R.id.btn_stuBull_detail_back);
        btn_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Student_schedule.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }

        });
    }
}