package com.deem.studybuddy.fragments.startCards;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.deem.studybuddy.R;
import com.deem.studybuddy.activities.MainActivity;
import com.deem.studybuddy.model.Question;
import com.deem.studybuddy.model.Subject;
import com.deem.studybuddy.services.DataService;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.button;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubjectFragment.OnSubjectFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubjectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubjectFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String SUBJECT = "subject";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static SubjectFragment subjectFragment;

    public Fragment getSubjectFragment(){
        return subjectFragment;
    }
    private OnSubjectFragmentInteractionListener mListener;

    public SubjectFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SubjectFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubjectFragment newInstance(String param1) {
        SubjectFragment fragment = new SubjectFragment();
        Bundle args = new Bundle();
        args.putString(SUBJECT,param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_subject, container, false);


        final String subjectname = getArguments().getString(SUBJECT);
        final TextView subjectTitle = v.findViewById(R.id.subjectTitle);
        final TextView question = v.findViewById(R.id.cardFrontTextView);
        final MainActivity mainActivity = MainActivity.getMainActivity();
        final TextView answer = v.findViewById(R.id.cardBackTextView);
        ArrayList<Question> questions;
        final Button reveal = v.findViewById(R.id.revealBtn);

        subjectTitle.setText(subjectname);

        if (mainActivity.getCurrentSubject() == null || !mainActivity.getCurrentSubject().matches(subjectname)) {
            Log.v("Test","First if");
            mainActivity.setCurrentSubjectDeck(DataService.getInstance().getQuestions(subjectname));
            mainActivity.setCurrentSubject(subjectname);
        }
        if (mainActivity.getCurrentSubjectDeck(subjectname) == null) {
            mainActivity.setCurrentSubjectDeck(DataService.getInstance().getQuestions(subjectname));
            questions = mainActivity.getCurrentSubjectDeck(subjectname);
        } else {
            questions = mainActivity.getCurrentSubjectDeck(subjectname);
        }

        final Pair<Question, ArrayList<Question>> randomQuestion = getRandomQuestion(questions);

        if (randomQuestion == null){
            mainActivity.setCurrentSubjectDeck(DataService.getInstance().getQuestions(subjectname));
            mainActivity.loadMoreCards(getArguments().getString(SUBJECT));
        } else {
            question.setText(randomQuestion.first.getQuestion());
            reveal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answer.setText(randomQuestion.first.getAnswer());
                    reveal.setBackgroundColor(0xFF01579b);
                    reveal.setText("Next Card");

                    reveal.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mainActivity.setCurrentSubjectDeck(randomQuestion.second);
                            mainActivity.loadMoreCards(getArguments().getString(SUBJECT));
                        }
                    });

                }
            });
        }

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSubjectFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSubjectFragmentInteractionListener) {
            mListener = (OnSubjectFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    public Pair<Question,ArrayList<Question>> getRandomQuestion(ArrayList<Question> questions) {

        Random randomGenerator = new Random();
        Pair<Question,ArrayList<Question>> quesPair;
        Question question;
        if (questions == null) {
            return null;
        } else if (questions.size() < 1) {
            return null;
        } else {
            int index = randomGenerator.nextInt(questions.size());
            question = questions.get(index);
            questions.remove(index);
        }
        quesPair = new Pair<>(question,questions);

        return quesPair;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSubjectFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSubjectFragmentInteraction(Uri uri);
    }
}
