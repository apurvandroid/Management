package work.newproject.asus.schoolmanagement;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import work.newproject.asus.schoolmanagement.MySharedPreferrance.MySharedPrefereence;
import work.newproject.asus.schoolmanagement.Student.StudentDashBoard;

public class SplashScreen extends AppCompatActivity {

    MySharedPrefereence mysharedpreferrance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mysharedpreferrance = new MySharedPrefereence(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent i;


                if (mysharedpreferrance.getLoginStudent() == 1) {
                    i = new Intent(SplashScreen.this, StudentDashBoard.class);
                } else if (mysharedpreferrance.getLoginStudent()== 2) {
                    i = new Intent(SplashScreen.this, SplashScreen.class);
                } else {
                    i = new Intent(SplashScreen.this, LoginActiviy.class);

                }

                startActivity(i);
                finish();

            }
        }, 400);

    }

}

