package org.techtown.se_project05;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ManagerInit extends AppCompatActivity{
    private TextView tv_id;
    private Button add_class, log_out;
    private ArrayList<String> classes = new ArrayList<>();
    LinearLayout linear1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.manager_main);
        tv_id = findViewById(R.id.tv_id);
        linear1 = findViewById(R.id.btn_layout);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        classes = intent.getStringArrayListExtra("classes");
        for(String c:classes){
            System.out.println(c);
        }

        tv_id.setText(userID);          //id를 표시
        System.out.println("size"+ classes.size());
        for(int i = 0; i< classes.size(); i++){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.width = 800;
            Button btn = new Button(ManagerInit.this);
            btn.setLayoutParams(lp);
            btn.setText(classes.get(i));
            btn.setId(i);
            linear1.addView(btn);
        }
        add_class = findViewById(R.id.add_class);
        add_class.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManagerAddClass.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }

        });
    }

}
