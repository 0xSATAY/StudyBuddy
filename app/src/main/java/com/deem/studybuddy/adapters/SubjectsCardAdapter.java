package com.deem.studybuddy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deem.studybuddy.R;
import com.deem.studybuddy.activities.MainActivity;
import com.deem.studybuddy.holders.SubjectsViewHolder;
import com.deem.studybuddy.model.Subject;

import java.util.ArrayList;

/**
 * Created by wangdiam on 7/31/17.
 */

public class SubjectsCardAdapter extends RecyclerView.Adapter<SubjectsViewHolder> {

    private ArrayList<Subject> subjects;

    public SubjectsCardAdapter(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public SubjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View subjectsCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_subjects,parent,false);
        return new SubjectsViewHolder(subjectsCard);
    }

    @Override
    public void onBindViewHolder(SubjectsViewHolder holder, final int position) {
        final String SASubject = subjects.get(position).getSubjectTitle();
        final Subject subject = subjects.get(position);


        holder.updateUI(subject);

        int p = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int po = position;

                MainActivity.getMainActivity().loadSubjectCardsScreen(SASubject);
            }
        });

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
