package work.newproject.asus.schoolmanagement.Teacher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import work.newproject.asus.schoolmanagement.R;
import work.newproject.asus.schoolmanagement.Student.DashBoardFragment;
import work.newproject.asus.schoolmanagement.Student.ProfileFragment;

public class TeacherDashBoardFragment extends Fragment {

    private LinearLayout linerAttendence;

    public TeacherDashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_teacher_dash_board, container, false);

        linerAttendence = view.findViewById(R.id.linerAttendence);


        linerAttendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AttendenceFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, fragment, "terminal").addToBackStack(null).commit();

            }
        });

        return view;
    }


}
