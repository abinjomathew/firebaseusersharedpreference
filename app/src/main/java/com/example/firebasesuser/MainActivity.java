package com.example.firebasesuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    String s1,s2;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        String name=sharedPreferences.getString("username",null);
        if(name!=null)
        {
            startActivity(new Intent(getApplicationContext(),Loginsuccess.class));
        }
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        reference= FirebaseDatabase.getInstance().getReference().child("members");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Query query=reference.orderByChild("emailid").equalTo(s1);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot data:dataSnapshot.getChildren())
                        {
                            SignupModule signupModule=data.getValue(SignupModule.class);
                            String pass=signupModule.password;
                            String name=signupModule.name;
                            String emailid=signupModule.emailid;
                            String phone=signupModule.phone;
                            if(pass.equals(s2))
                            {
                                Intent intent=new Intent(getApplicationContext(),Loginsuccess.class);
                                SharedPreferences.Editor editor=getSharedPreferences("Login",MODE_PRIVATE).edit();
                                editor.putString("username",signupModule.name);
                                editor.commit();
                                startActivity(intent);
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);

            }
        });
    }
}
