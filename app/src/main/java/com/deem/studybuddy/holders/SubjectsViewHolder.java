package com.deem.studybuddy.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.deem.studybuddy.R;
import com.deem.studybuddy.model.Subject;

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

    public void updateUI(Subject subject) {
        subjectTitle.setText(subject.getSubjectTitle());
        numberOfCardsStudied.setText(subject.getNumberOfCardsStudied());
        totalNumberOfCards.setText(subject.getTotalNumberOfCards());
    }

}
