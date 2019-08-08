package work.newproject.asus.schoolmanagement.Teacher;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.felix.bottomnavygation.BottomNav;
import com.felix.bottomnavygation.ItemNav;

import work.newproject.asus.schoolmanagement.MySharedPreferrance.MySharedPrefereence;
import work.newproject.asus.schoolmanagement.R;
import work.newproject.asus.schoolmanagement.Student.StudentDashBoard;

public class TeacherDashBoard extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    BottomNav bottomNav;
    MySharedPrefereence mySharedPrefereence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dash_board);


        bottomNav  = findViewById(R.id.bottomNav);
        bottomNav.addItemNav(new ItemNav(this, R.drawable.ic_home_black_24dp).addColorAtive(R.color.colorAccent));
        bottomNav.build();


        BottomNav.OnTabSelectedListener listener = new BottomNav.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                if (position == 0) {

                } else if (position == 1){
                    Toast.makeText(TeacherDashBoard.this, "Click position " + position, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabLongSelected(int position) {
                Toast.makeText(TeacherDashBoard.this, "Long position " + position, Toast.LENGTH_SHORT).show();
            }
        };
        bottomNav.setTabSelectedListener(listener);

    }


    @Override
    public void onBackStackChanged() {

    }
}
