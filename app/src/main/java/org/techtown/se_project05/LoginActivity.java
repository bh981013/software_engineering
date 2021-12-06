package org.techtown.se_project05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_pass;
    private Button btn_login, btn_register;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        final boolean[] checked = {false};
        String type = "";
        et_id = findViewById( R.id.et_id );
        et_pass = findViewById( R.id.et_pass );
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(R.id.radioButton2);

        btn_register = findViewById( R.id.btn_register );
        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivity( intent );
            }
        });


        btn_login = findViewById( R.id.btn_login );
        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                int userType = 1;
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton){
                    userType = 2;
                    Toast.makeText( getApplicationContext(), "수업관리자", Toast.LENGTH_SHORT ).show();
                }
                else{
                    Toast.makeText( getApplicationContext(), "학생", Toast.LENGTH_SHORT ).show();
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Toast.makeText( getApplicationContext(), "로그인 시도중", Toast.LENGTH_SHORT ).show();
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//로그인 성공시

                                String userID = jsonObject.getString( "userID" );
                                String userPass = jsonObject.getString( "userPassword" );
                                int userType = jsonObject.getInt("userType");
                                Toast.makeText( getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT ).show();
                                Intent intent = new Intent( LoginActivity.this, MainActivity.class );
                                intent.putExtra( "userID", userID );

                                intent.putExtra("type", userType);

                                startActivity( intent );

                            } else {//로그인 실패시
                                Toast.makeText( getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT ).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest( userID, userPass, userType,responseListener );
                RequestQueue queue = Volley.newRequestQueue( LoginActivity.this );
                queue.add( loginRequest );

            }
        });
    }
}
