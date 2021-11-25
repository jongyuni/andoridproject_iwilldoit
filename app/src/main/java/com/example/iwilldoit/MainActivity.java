package com.example.iwilldoit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.iwilldoit.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        firebaseAuth = FirebaseAuth.getInstance();
        View view = binding.getRoot();
        setContentView(view);
    }

    public void loginClick(View view){
        String email = binding.editId.getText().toString().trim();
        String pwd = binding.editPwd.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(email,pwd)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this,"로그인 오류",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void signupClick(View view){
        Intent intent = new Intent(MainActivity.this,SignupActivity.class);
        startActivity(intent);
        finish();
    }
}