package org.techtown.se_project05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ManagerFunc extends AppCompatActivity {
    private ArrayList<String> classes = new ArrayList<>();
    private ArrayList<Integer> classesID = new ArrayList<>();
    private String curClass, userID;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_func);
        Intent intent = getIntent();
        userID = intent.getStringExtra("userID");
        classes = intent.getStringArrayListExtra("classes");
        classesID = intent.getIntegerArrayListExtra("classesID");
        curClass = intent.getStringExtra("curClass");

        TextView tv_id = findViewById(R.id.tv_id);
        TextView tv_class = findViewById(R.id.tv_class);
        tv_id.setText("관리자 ID: " + userID);
        tv_class.setText("수업명: "+ curClass);

    }
}
