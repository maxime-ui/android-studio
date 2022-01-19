    package com.ipi.myapplication;

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

    import com.ipi.myapplication.Package.Question;

    import java.util.ArrayList;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        private TextView tvquestion;
        private TextView tvScore;
        private Button btnTrue;
        private Button btnFalse;
        private Button btnRejouer;
        private List<Question> question = new ArrayList<Question>();
        private Integer index = 0;
        private Integer score = 0;
        private final String TAG = "QUIZ ACTIVITY";
        private static final String KEY_INDEX="index";
        private static final String KEY_SCORE="score";
        private static final String KEY_REPLAY= "replay";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.filmquestion);

            Log.d(TAG, "onCreate() called ");

            tvquestion =  findViewById(R.id.tvQuestion);
            tvScore = findViewById(R.id.tvScore);
            btnTrue = findViewById(R.id.btnTrue);
            btnFalse = findViewById(R.id.btnFalse);
            btnRejouer = findViewById(R.id.btnFalse);

            question.add(new Question(getString(R.string.question_a),true));
            question.add(new Question(getString(R.string.question_b),false));
            question.add(new Question(getString(R.string.question_ai),false));
            question.add(new Question(getString(R.string.question_taxi_driver),true));
            question.add(new Question(getString(R.string.question_2001),true));
            question.add(new Question(getString(R.string.question_reservoir_dogs),true));
            question.add(new Question(getString(R.string.question_citizen_kane),false));

            btnRejouer.setVisibility(View.INVISIBLE);

            //recupère valeur du bundle
            if(savedInstanceState!= null){
                index = savedInstanceState.getInt(KEY_INDEX);
                score = savedInstanceState.getInt(KEY_SCORE);

            }


            tvquestion.setText(question.get(0).getText());
            tvScore.setText("score "+score);



            btnTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (question.get(index).isAnswer()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "VRAI", Toast.LENGTH_LONG);
                        score++;
                        if(index < question.size()-1) {

                        }else {
                            tvquestion.setText(question.get(index).getText());
                            toast.show();
                        }
                        tvScore.setText("score " + score);
                        tvquestion.setText(question.get(index).getText());
                        toast.show();
                    }
                    else{
                        //si la bonne réponse est false
                    }
                }});
            btnFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!question.get(index).isAnswer()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "FAUX", Toast.LENGTH_LONG);
                        index++;
                        if(index < question.size()-1) {

                        }else {
                            tvquestion.setText(question.get(index).getText());
                            toast.show();
                            btnRejouer.setVisibility(View.VISIBLE);
                        }
                    }
                }
            });

            btnRejouer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index=1;
                    score=0;
                    tvquestion.setText(question.get(0).getText());
                    tvScore.setText("score "+score);
                }
            });
        }
        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);

            Log.d(TAG, "onSaveInstanceState() called ");

            outState.putInt(KEY_INDEX,index);
            outState.putInt(KEY_SCORE,score);
            outState.putBoolean(KEY_REPLAY,btnRejouer.getVisibility()==View.VISIBLE ? true : false);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            //crée le menu
            getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.cheat:
                    Intent intent = new Intent(getApplicationContext(),CheatActivity.class) ;
                    startActivity(intent);
                    return true;

            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onStart() {

            super.onStart();
            Log.d(TAG, "onStart: ");
        }

        @Override
        protected void onPause() {

            super.onPause();
            Log.d(TAG, "onPause: ");
        }

        @Override
        protected void onStop() {

            super.onStop();
            Log.d(TAG, "onStop: ");
        }

        @Override
        protected void onRestart() {

            super.onRestart();
            Log.d(TAG, "onRestart: ");
        }

        @Override
        protected void onDestroy() {

            super.onDestroy();
            Log.d(TAG, "onDestroy: ");
        }



    }
