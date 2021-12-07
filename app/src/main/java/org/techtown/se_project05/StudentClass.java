package org.techtown.se_project05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentClass extends AppCompatActivity {
    private TextView tv_id;
    private Button btn_class1, btn_class2;
    private ArrayList<String> classes;
    LinearLayout linear1;
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView(R.layout.student_class);
        tv_id = findViewById(R.id.tv_id);
        linear1 = findViewById(R.id.btn_layout);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        classes = intent.getStringArrayListExtra("classes");
        tv_id.setText(userID);

        for(int i = 0; i< classes.size(); i++){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.width = 800;
            Button btn = new Button(this);
            btn.setLayoutParams(lp);
            btn.setText(classes.get(i));
            btn.setId(i);
            linear1.addView(btn);
        }

        }
}
