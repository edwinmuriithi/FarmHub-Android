package com.farmtech.farmhub.ui.home;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.farmtech.farmhub.R;
import com.farmtech.farmhub.databinding.ActivityHomeBinding;
import com.farmtech.farmhub.storage.SharedPreferencesManager;
import com.farmtech.farmhub.ui.farmhelp.FarmHelp;
import com.farmtech.farmhub.ui.farmvideos.FarmVideo;
import com.farmtech.farmhub.ui.inbox.InboxActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class  HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},10);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        String token = SharedPreferencesManager.getInstance(this).getToken();
        Log.d(TAG, "Token is retrieved from home as " + token);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);

        //Set nav invisible
        bottomNavigationView.setVisibility(View.GONE);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));


        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
                switch(item.getItemId())
                {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_farm_help:
                        startActivity(new Intent(getApplicationContext(), FarmHelp.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_farm_videos:
                        startActivity(new Intent(getApplicationContext(), FarmVideo.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_inbox:
                        startActivity(new Intent(getApplicationContext(), InboxActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;

        });

        binding.farmHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FarmHelp.class);
                startActivity(i);

            }
        });

        binding.farmVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FarmVideo.class);
                startActivity(i);
            }
        });
    }

}