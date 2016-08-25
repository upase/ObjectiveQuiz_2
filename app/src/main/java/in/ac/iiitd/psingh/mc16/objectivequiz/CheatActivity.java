package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {
    int randomnumber;
    private TextView cheatText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheatText=(TextView)findViewById(R.id.CheatText);
        randomnumber=getIntent().getIntExtra("Randnumber",1);

        try {
            if (isprime(randomnumber)) {
                cheatText.setText(""+randomnumber + " is a prime number");
            } else {
                cheatText.setText(""+randomnumber + " is not a prime number");
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();}


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


    @Override
    public void onBackPressed() {
        Intent MainActivityIntent=new Intent(getApplicationContext(),QuizActivity.class);
        MainActivityIntent.putExtra("CheatUsed",true);
        setResult(1,MainActivityIntent);
        super.onBackPressed();
    }
}
