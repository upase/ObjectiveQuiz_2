package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_splash);

        //handler runs in postdelay function so it waits for 2000 sec to execute line of codes inside it
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //an intent to main function and deletion of this activity from stack
                //so as to avoid reappearance of splash screen on pressing back button
                Intent Quizactivityintent=new Intent(getApplicationContext(),QuizActivity.class);
                startActivityForResult(Quizactivityintent,1);
                ActivitySplash.this.finish();
            }
        },2000);



    }


}
