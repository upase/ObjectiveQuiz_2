package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    int randnum=0;
    Random rand=new Random();
    private TextView questext;
    static final String STATE_NUM = "NOthing";
//checking for commi


    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            randnum = savedInstanceState.getInt(STATE_NUM);
        }
        else
        {
            randnum=rand.nextInt(1000 - 1) + 1;
        }
        questext=(TextView)findViewById(R.id.textViewer);
        questext.setText("Is "+randnum+" a prime number?");



        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "Clicked True");
                boolean val=isprime(randnum);
                if(val==true)
                {
                    Toast.makeText(getApplicationContext(),"Your Answer is Right",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Your Answer is Wrong",Toast.LENGTH_SHORT).show();
                }


            }
        });

        mFalseButton=(Button)findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked False");
                boolean val=isprime(randnum);
                if(val==false)
                {
                    Toast.makeText(getApplicationContext(),"Your Answer is Right",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Your Answer is Wrong",Toast.LENGTH_SHORT).show();
                }

            }
        });

         mNextButton=(Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randnum=rand.nextInt(1000 - 1) + 1;
                questext.setText("Is "+randnum+" a prime number?");

            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(STATE_NUM, randnum);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    public boolean isprime(int num)
    {
        float limit=(float)Math.sqrt(num);
        if(num==1)
        {return false;}
        if(num==2)
        {return true;}
        else
        {
            for (int i = 2; i <= limit; i++)
            {
                if (num % i == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       // randnum = savedInstanceState.getInt(STATE_SCORE);

    }
}
