package com.ipi.android_todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_POJO = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // test l'id de litem qui a été sélectionné
        switch (item.getItemId()) {
            case R.id.cheat:

                // créer une intent
                Intent intent = new Intent(getApplicationContext(), CheatActivity.class);

                // démarre l'activity
                startActivity(intent);

                return true;
        }

        return super.onOptionsItemSelected(item);

    }
}

