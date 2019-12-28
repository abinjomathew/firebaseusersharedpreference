package com.example.firebasesuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Loginsuccess extends AppCompatActivity {



    TextView t1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsuccess);
        final SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        String name=sharedPreferences.getString("username",null);
        t1=(TextView)findViewById(R.id.tname);

        t1.setText(name);

        b=(Button)findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("Login",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }


}
