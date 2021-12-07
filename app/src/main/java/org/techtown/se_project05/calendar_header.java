package org.techtown.se_project05;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class calendar_header extends RecyclerView.ViewHolder implements View.OnClickListener{
    public final TextView dayOfMonth;
    private final Student_attendance.OnitemListener onitemListener;
    public calendar_header(@NonNull View itemView, Student_attendance.OnitemListener onitemListener) {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.calendar_header);
        this.onitemListener = onitemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onitemListener.onItemClick(getAdapterPosition(),(String) dayOfMonth.getText());
    }
}
