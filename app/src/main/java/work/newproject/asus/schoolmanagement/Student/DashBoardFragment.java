package work.newproject.asus.schoolmanagement.Student;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.felix.bottomnavygation.BottomNav;
import com.felix.bottomnavygation.ItemNav;

import work.newproject.asus.schoolmanagement.R;

public class DashBoardFragment extends Fragment {
    LinearLayout linerAttendence, linerProfilee;
    BottomNav bottomNav;

    private HitAgain hitAgain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        linerAttendence = view.findViewById(R.id.linerAttendence);
        linerProfilee = view.findViewById(R.id.linerProfilee);

        hitAgain = (HitAgain) getContext();

        linerAttendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitAgain.addValue(0);
                Toast.makeText(getContext(), "777", Toast.LENGTH_LONG).show();

            }
        });
        linerProfilee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ProfileFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, fragment, "terminal").addToBackStack(null).commit();

            }
        });

        return view;
    }

    public interface HitAgain {
        boolean addValue(int id);

    }

}
