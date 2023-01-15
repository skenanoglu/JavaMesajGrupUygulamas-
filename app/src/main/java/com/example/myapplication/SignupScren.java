package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupScren extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    Button login;
    Button signup;

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_scren);

        login = (Button)findViewById(R.id.btn_signup_login);
        email = (EditText) findViewById(R.id.et_signup_email);
        signup = (Button)findViewById(R.id.btn_signup_signup);
        password = (EditText) findViewById(R.id.et_signup_passwd);
        firebaseAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupScren.this , LoginScreen.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string_email = email.getText().toString();
                String string_password = password.getText().toString();

                if(string_email.isEmpty() || string_password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Email veya şifre boş olamaz", Toast.LENGTH_LONG).show();
                }
                else{
                    firebaseAuth.createUserWithEmailAndPassword(string_email,string_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "Doğrulama Başarılı", Toast.LENGTH_LONG).show();

                                startActivity(new Intent( SignupScren.this , LoginScreen.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Doğrulama Başarısız", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });

    }
}