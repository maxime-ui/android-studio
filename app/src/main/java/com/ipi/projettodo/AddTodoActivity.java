package com.ipi.projettodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ipi.projettodo.TODO.TODO;

public class AddTodoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TODO todo = new TODO();
    private EditText tvTodos;
    private Button add;
    private Button cancel;
    private Spinner urgency;
    private String text = null;
    private Toast toast ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        tvTodos = findViewById(R.id.etTodo);
        cancel = findViewById(R.id.cancel);
        add=(Button)findViewById(R.id.add);

        urgency = findViewById(R.id.urgency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_Urgency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        urgency.setAdapter(adapter);
        urgency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                text = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if (tvTodos.getText().length()<3) {

                    toast = Toast.makeText(getApplicationContext(),"longueur du todo inférieur à 3",Toast.LENGTH_SHORT);
                    toast.show();
                }else {

                    String todoText = tvTodos.getText().toString();
                    todo.setName(todoText);
                    todo.setUrgency(text);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MESSAGE", todo);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(2, intent);
                    finish();
                }
            }


        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent= new  Intent(AddTodoActivity.this,MainActivity.class );
                startActivityForResult(intent,  2 );
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text = (String) adapterView.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
