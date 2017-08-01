package com.deem.studybuddy.fragments.addCards;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.deem.studybuddy.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddCardsFragment.OnAddCardsFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddCardsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCardsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText front,back;
    private Spinner chooseSubject;
    private Button addCardBtn;

    private OnAddCardsFragmentInteractionListener mListener;

    public AddCardsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCardsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCardsFragment newInstance(String param1, String param2) {
        AddCardsFragment fragment = new AddCardsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        final View v = inflater.inflate(R.layout.fragment_add_cards, container, false);

        chooseSubject = v.findViewById(R.id.subjectsDropDown);
        addCardBtn = v.findViewById(R.id.addCardBtn);
        front = v.findViewById(R.id.frontTextField);
        back = v.findViewById(R.id.backTextField);

        addCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (front.getText() != null && back.getText() != null && chooseSubject.getSelectedItem() != null) {
                    String frontText = front.getText().toString();
                    String backText = back.getText().toString();
                    String chosenOption = chooseSubject.getSelectedItem().toString();
                } else {
                    Toast.makeText(getActivity(),"Please enter all fields!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //TODO create adapter for spinner
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onAddCardsFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAddCardsFragmentInteractionListener) {
            mListener = (OnAddCardsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
    public interface OnAddCardsFragmentInteractionListener {
        // TODO: Update argument type and name
        void onAddCardsFragmentInteraction(Uri uri);
    }
}
