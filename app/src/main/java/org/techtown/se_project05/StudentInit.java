package org.techtown.se_project05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentInit extends AppCompatActivity {

    private TextView tv_id;
    private Button btn_class, btn_plan;
    private ArrayList<String> classes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.student_main);


        tv_id = findViewById(R.id.tv_id);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        classes = intent.getStringArrayListExtra("classes");
        tv_id.setText(userID);

        btn_class = findViewById(R.id.stud_init_button1);
        btn_class.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentClass.class);
                intent.putExtra("userID", userID);
                intent.putExtra("classes", classes);
                startActivity(intent);
            }
        });
        btn_plan = findViewById(R.id.stud_init_button2);
    }
}