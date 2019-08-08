package work.newproject.asus.schoolmanagement.MySharedPreferrance;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPrefereence {

    public static final int MOBILESTUDENT = 1;
    private static final String LOGINSTUDENT = "LOGINSTUDENT";
    private static final String USERSTUDENT = "USERSTUDENT";



    private SharedPreferences sharedPreferences;

    public MySharedPrefereence(Context context) {
        sharedPreferences = context.getSharedPreferences("SharedData", MODE_PRIVATE);
    }

    public int getLoginStudent() {
        return sharedPreferences.getInt(LOGINSTUDENT, -1);
    }


    public void saveLoginStudent(int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LOGINSTUDENT, value);
        editor.apply();
    }

    public void removeLoginStudent() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LOGINSTUDENT);
        editor.apply();
    }

    public void saveStudentID(String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERSTUDENT, value);
        editor.apply();
    }



    public String getSaveStudentID() {
        return sharedPreferences.getString(USERSTUDENT, "");
    }






}
