package org.techtown.se_project05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Student_schedule extends AppCompatActivity {

    private Spinner sch_year,sch_month,sch_day;
    private Button btn_add,btn_back,btn_look;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_schedule);

        sch_year = (Spinner)findViewById(R.id.sch_year);
        sch_month = (Spinner)findViewById(R.id.sch_month);
        sch_day = (Spinner)findViewById(R.id.sch_day);

        btn_add = findViewById(R.id.btn_schedule_add);

        btn_look = findViewById(R.id.btn_schedule_look);

        btn_back = findViewById(R.id.btn_schedule_back);




    }
}