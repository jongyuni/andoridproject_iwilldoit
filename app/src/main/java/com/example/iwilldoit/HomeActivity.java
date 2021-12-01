package com.example.iwilldoit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.iwilldoit.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private YearFragment yearfragment = new YearFragment();
    private LifeFragment lifefragment = new LifeFragment();
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,yearfragment).commitAllowingStateLoss();
    }

    public void yearClick(View view){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,yearfragment).commitAllowingStateLoss();
    }

    public void lifeClick(View view){
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,lifefragment).commitAllowingStateLoss();
    }

    public void logoutClick(View view){
        SharedPreferences auto = getSharedPreferences("autoLogin", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = auto.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}