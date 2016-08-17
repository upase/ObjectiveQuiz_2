package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Quizactivityintent=new Intent(getApplicationContext(),QuizActivity.class);
                startActivity(Quizactivityintent);
                ActivitySplash.this.finish();
            }
        },2000);

    }
}
