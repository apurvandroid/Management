package work.newproject.asus.schoolmanagement.Student;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.felix.bottomnavygation.BottomNav;
import com.felix.bottomnavygation.ItemNav;

import work.newproject.asus.schoolmanagement.MySharedPreferrance.MySharedPrefereence;
import work.newproject.asus.schoolmanagement.R;

public class StudentDashBoard extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener , DashBoardFragment.HitAgain{
    BottomNav bottomNav;
    MySharedPrefereence mySharedPrefereence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dash_board);
        mySharedPrefereence=new MySharedPrefereence(this);
        String jj=mySharedPrefereence.getSaveStudentID();
        System.out.println(jj);
        loadBatMatch();

        bottomNav  = findViewById(R.id.bottomNav);
        bottomNav.addItemNav(new ItemNav(this, R.drawable.ic_home_black_24dp).addColorAtive(R.color.colorAccent));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.ic_assignment_turned_in_black_24dp).addColorAtive(R.color.colorAccent));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.ic_person_black_24dp).addColorAtive(R.color.colorAccent));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.ic_arrow_forward_black_24dp).addColorAtive(R.color.colorAccent));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.ic_notifications_none_black_24dp).addColorAtive(R.color.colorAccent));
        bottomNav.build();


        BottomNav.OnTabSelectedListener listener = new BottomNav.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                if (position == 0) {
                    loadBatMatch();
                } else if (position == 1){
                    Toast.makeText(StudentDashBoard.this, "Click position " + position, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTabLongSelected(int position) {
                Toast.makeText(StudentDashBoard.this, "Long position " + position, Toast.LENGTH_SHORT).show();
            }
        };
        bottomNav.setTabSelectedListener(listener);
    }

    @Override
    public void onBackStackChanged() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;

    }

    private void loadBatMatch() {
        Bundle args = new Bundle();
        Fragment fragmentt = new DashBoardFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // transaction.replace(R.id.fragment, fragmentt).addToBackStack(null).commit();
        transaction.replace(R.id.fragment, fragmentt);
        transaction.commit();
    }

    @Override
    public boolean addValue(int id) {
        if (id==0){
            bottomNav.selectTab(0);
            return true;
        }

        return false;
    }
}
