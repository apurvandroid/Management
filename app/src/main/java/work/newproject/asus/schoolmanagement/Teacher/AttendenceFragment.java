package work.newproject.asus.schoolmanagement.Teacher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.newproject.asus.schoolmanagement.R;


public class AttendenceFragment extends Fragment {
    private android.support.v7.widget.Toolbar toolbar;


    public AttendenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_attendence, container, false);

        toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolcheck);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("Attendance");


        return view;
    }


}
