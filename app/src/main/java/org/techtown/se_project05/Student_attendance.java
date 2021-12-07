package org.techtown.se_project05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Student_attendance extends RecyclerView.Adapter<calendar_header> {
    private final ArrayList<String> daysOfMonth;
    private final OnitemListener onitemListener;

    public Student_attendance(ArrayList<String> daysOfMonth, OnitemListener onitemListener) {
        this.daysOfMonth = daysOfMonth;
        this.onitemListener = onitemListener;
    }

    @NonNull
    @Override
    public calendar_header onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_header, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight()*0.166666666);
        return new calendar_header(view, onitemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull calendar_header holder, int position) {
        holder.dayOfMonth.setText(daysOfMonth.get(position));
    }

    @Override
    public int getItemCount() {
        return daysOfMonth.size();
    }
    public interface OnitemListener{
        void onItemClick(int position, String dayText);
    }
}