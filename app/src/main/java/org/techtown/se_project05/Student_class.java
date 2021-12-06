package org.techtown.se_project05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Student_class extends AppCompatActivity {
    private TextView tv_id;
    private Button btn_class1, btn_class2;
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView(R.layout.student_class);

        tv_id = findViewById(R.id.tv_id);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        tv_id.setText(userID);

        }
}
