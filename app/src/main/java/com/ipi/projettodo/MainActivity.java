package com.ipi.projettodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ipi.projettodo.TODO.TODO;

public class MainActivity extends AppCompatActivity {

    private TODO todo=new TODO();
    private TextView name;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // créé le menu
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // test l'id de litem qui a été sélectionné
        switch (item.getItemId()) {
            case R.id.cheat:

                // créer une intent
                Intent intent = new Intent(getApplicationContext(), AddTodoActivity.class);

                startActivityForResult(intent, 2);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.tvTodos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2) {
             todo = (TODO) data.getSerializableExtra("MESSAGE");
            String addtodo = String.format("\n%s | %s",todo.getName(),todo.getUrgency());
            name.append(addtodo);
        }
    }

}