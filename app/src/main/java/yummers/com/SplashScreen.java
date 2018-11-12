package yummers.com;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {


    //kung ilang interval ng splash screen bago mag redirect sa home
    private static int SPLASH_TIME_OUT = 2000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //Logic of Splash screen
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){
                Intent homeIntent = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();


            }
        },SPLASH_TIME_OUT);
    }
}
