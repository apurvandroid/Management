package work.newproject.asus.schoolmanagement.Teacher.Adepter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AttendenceAdepter extends RecyclerView.Adapter<AttendenceAdepter.ViewHolder> {
    @NonNull
    @Override
    public AttendenceAdepter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendenceAdepter.ViewHolder viewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
