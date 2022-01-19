package com.ipi.android_todo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CheatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

            // récupère l'intent qui a servi à appeler l'activity
            Intent intent = getIntent();



            // récupère l'action bar
            ActionBar actionBar = getSupportActionBar();
            // fait apparetre le go Back dans l'action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

        @Override
        public boolean onSupportNavigateUp() {
            finish();

            return true;
        }
    }
