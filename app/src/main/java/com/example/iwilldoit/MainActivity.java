package com.example.iwilldoit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

        String email;
        String pwd;
        // 기기에 저장되어있는 아이디 비밀번호 정보를 가져온다.
        SharedPreferences auto = getSharedPreferences("autoLogin", Activity.MODE_PRIVATE);
        email = auto.getString("email", null);
        pwd = auto.getString("pwd", null);

        // 아이디와 비밀번호가 저장되어 있으면 자동 로그인이 된다.
        if(email != null && pwd != null){
            Toast.makeText(MainActivity.this,"자동로그인 되었습니다!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    // 로그인 버튼 클릭시
    public void loginClick(View view){
        String email = binding.editId.getText().toString().trim();
        String pwd = binding.editPwd.getText().toString().trim();

        firebaseAuth.signInWithEmailAndPassword(email,pwd)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            SharedPreferences auto = getSharedPreferences("autoLogin", Activity.MODE_PRIVATE);
                            SharedPreferences.Editor autoLoginEdit = auto.edit();
                            autoLoginEdit.putString("email", email);
                            autoLoginEdit.putString("pwd", pwd);
                            autoLoginEdit.commit();
                            Toast.makeText(MainActivity.this,"환영합니다!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this,"로그인 오류",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // 회원가입 버튼 클릭시
    public void signupClick(View view){
        Intent intent = new Intent(MainActivity.this,SignupActivity.class);
        startActivity(intent);
    }
}