package work.newproject.asus.schoolmanagement.Student;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import work.newproject.asus.schoolmanagement.Api.Api;
import work.newproject.asus.schoolmanagement.LoginActiviy;
import work.newproject.asus.schoolmanagement.MySharedPreferrance.MySharedPrefereence;
import work.newproject.asus.schoolmanagement.R;


public class ProfileFragment extends Fragment {

    private TextView txtName,txtstandard,txtsection,txtgender,txtdateofbirth,txtbloodgroup,txtadmssionno,txtaddress,txtcity,txtcontactmobilenumber;
    private MySharedPrefereence mySharedPrefereence;


    String data;
    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ExpandableCardView card = view.findViewById(R.id.profile);
        ExpandableCardView cardView = view.findViewById(R.id.profilee);
        mySharedPrefereence=new MySharedPrefereence(getContext());
        String sID=mySharedPrefereence.getSaveStudentID();
        txtName = view.findViewById(R.id.txtName);
        txtstandard=view.findViewById(R.id.txtstandard);
        txtsection=view.findViewById(R.id.txtsection);
        txtgender=view.findViewById(R.id.txtgender);
        txtdateofbirth=view.findViewById(R.id.txtdateofbirth);
        txtbloodgroup=view.findViewById(R.id.txtbloodgroup);
        txtadmssionno=view.findViewById(R.id.txtadmssionno);
        txtaddress=view.findViewById(R.id.txtaddress);
        txtcity=view.findViewById(R.id.txtcity);
        txtcontactmobilenumber=view.findViewById(R.id.txtcontactmobilenumber);


        data="23jheiufugfjiehhuh";
        studentDetails(sID);


        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
            }
        });

        cardView.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
            }
        });

        return view;
    }


    public void studentDetails(final String STUDENTid) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Api.studentProfile, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("name");
                        String student_standard=jsonObject.getString("student_standard");
                        String dob=jsonObject.getString("dob");
                        String addmisionno=jsonObject.getString("unique_no");
                        String student_address=jsonObject.getString("student_address");
                        String  city=jsonObject.getString("student_address");
                        String mob=jsonObject.getString("student_mobile");


                        txtName.setText(name);
                        txtstandard.setText(student_standard);
                        txtdateofbirth.setText(dob);
                        txtcity.setText(city);
                        txtadmssionno.setText(addmisionno);
                        txtaddress.setText(student_address);
                        txtcontactmobilenumber.setText(mob);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("student_id", STUDENTid);
                return map;
            }
        };
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}

