package com.rohit.sqliteexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohit.sqliteexample.R;
import com.rohit.sqliteexample.model.Student;

import java.util.List;

/**
 * StudentAdapter class to present the student list in the RecyclerView
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.studentViewHolder> {


    private Context context;
    /**
     * StudentAdapter class constructor
     */
    private List<Student> studentsList;


    public StudentAdapter(List<Student> studentsList, Context context) {
        this.studentsList = studentsList;
        this.context = context;
    }

    /**
     * onCreateViewHolder method is used to create view at run time. This method is responsible
     * for creating the view as per the screen size.
     * @param parent
     * @param viewType
     * @return
     */

    @NonNull
    @Override
    public studentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list, parent, false);

        return new studentViewHolder(v);
    }

    /**
     * This method is used map the data to view from the data source.
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull studentViewHolder holder, int position) {

        holder.mTextviewName.setText(studentsList.get(position).getmStudentName());
        holder.mTextviewEmail.setText(studentsList.get(position).getmStudentEmail());
        holder.mTextviewMobile.setText(studentsList.get(position).getmStudentMobile());
        holder.mTextviewPassword.setText(studentsList.get(position).getmStudentPassword());


    }

    /**
     * This method is used to return the list item count.
     * @return
     */

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    /**
     * This is the inner ViewHolder class to getting the reference of the xml view.
     */

    class studentViewHolder extends RecyclerView.ViewHolder {

        TextView mTextviewName, mTextviewEmail, mTextviewMobile, mTextviewPassword;

        studentViewHolder(View itemView) {
            super(itemView);

            mTextviewName = itemView.findViewById(R.id.textview_name);
            mTextviewEmail = itemView.findViewById(R.id.textview_email);
            mTextviewMobile = itemView.findViewById(R.id.textview_mobile);
            mTextviewPassword = itemView.findViewById(R.id.textview_password);

        }
    }
}
