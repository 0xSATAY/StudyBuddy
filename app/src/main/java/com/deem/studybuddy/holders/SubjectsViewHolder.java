package com.deem.studybuddy.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.deem.studybuddy.R;
import com.deem.studybuddy.model.Subjects;

/**
 * Created by wangdiam on 7/31/17.
 */

public class SubjectsViewHolder extends RecyclerView.ViewHolder {

    private TextView subjectTitle,numberOfCardsStudied,totalNumberOfCards;

    public SubjectsViewHolder(View itemView) {

        super(itemView);

        this.subjectTitle = (TextView)itemView.findViewById(R.id.subjectName);
        this.numberOfCardsStudied = (TextView)itemView.findViewById(R.id.numberOfCardsStudied);
        this.totalNumberOfCards = (TextView)itemView.findViewById(R.id.totalNumberOfCards);
    }

    public void updateUI(Subjects subjects) {
        subjectTitle.setText(subjects.getSubjectTitle());
        numberOfCardsStudied.setText(subjects.getNumberOfCardsStudied());
        totalNumberOfCards.setText(subjects.getTotalNumberOfCards());
    }

}
