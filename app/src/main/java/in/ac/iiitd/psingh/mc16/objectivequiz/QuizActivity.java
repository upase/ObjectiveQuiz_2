package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class QuizActivity extends AppCompatActivity {


    int randnum=0;
    Random rand=new Random();
    private TextView questext;
    static final String STATE_NUM = "NOthing";



    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button mTrueButton;
        Button mFalseButton;
        Button mNextButton;
        Button mHintButton;
        Button mCheatButton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Check if there is a saved state
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

                if(isprime(randnum))
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

                if(!isprime(randnum))
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
                //on next creates a random number a shows it in Text view
                randnum=rand.nextInt(1000 - 1) + 1;
                questext.setText("Is "+randnum+" a prime number?");

            }
        });

        mHintButton=(Button)findViewById(R.id.hint_button);
        mHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hintactivityintent=new Intent(getApplicationContext(),HintActivity.class);
                startActivity(hintactivityintent);
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
        //function to check if number is prime or not
        float limit=(float)Math.sqrt(num);
        if(num==1)
        {return false;}
        if(num==2)
        {return true;}
        else
        {
            //runs till root of the given number and checks if divisible by each one
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



}
