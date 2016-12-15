package com.example.ntinos.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ntinos.herome.Activities.MainActivity;
import com.example.ntinos.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackstoryFragment.OnBackstoryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackstoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackstoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button startOverBtn;

    private OnBackstoryFragmentInteractionListener mListener;

    public BackstoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackstoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackstoryFragment newInstance(String param1, String param2) {
        BackstoryFragment fragment = new BackstoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_backstory, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView story = (TextView) view.findViewById(R.id.story);
        ImageView logo = (ImageView) view.findViewById(R.id.logo);

        startOverBtn = (Button)view.findViewById(R.id.startOverBtn);
        startOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadMainFragment();
            }
        });

        if(mainActivity.heroe == "SPIDERMAN"){
            title.setText(this.getResources().getString(R.string.spiderman));
            story.setText(this.getResources().getString(R.string.spiderman_story));
            logo.setImageResource(R.drawable.spider_web);
        }
        else if(mainActivity.heroe == "SUPERMAN") {
            title.setText(this.getResources().getString(R.string.superman));
            story.setText(this.getResources().getString(R.string.superman_story));
            logo.setImageResource(R.drawable.big_superman_logo);
        }
        else if(mainActivity.heroe == "THOR") {
            title.setText(this.getResources().getString(R.string.thor));
            story.setText(this.getResources().getString(R.string.thor_story));
            logo.setImageResource(R.drawable.thors_hammer);
        }
        else if(mainActivity.heroe == "TURTLE") {
            title.setText(this.getResources().getString(R.string.turtles));
            story.setText(this.getResources().getString(R.string.turtles_story));
            logo.setImageResource(R.drawable.turtle_power);
        }
        else if(mainActivity.heroe == "LAZERMAN") {
            title.setText(this.getResources().getString(R.string.lazer));
            story.setText(this.getResources().getString(R.string.lazer_story));
            logo.setImageResource(R.drawable.laser_vision);
        }
        else if(mainActivity.heroe == "HULK") {
            title.setText(this.getResources().getString(R.string.hulk));
            story.setText(this.getResources().getString(R.string.hulk_story));
            logo.setImageResource(R.drawable.super_strength);
        }


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.OnBackstoryFragmentInteractionListener(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackstoryFragmentInteractionListener) {
            mListener = (OnBackstoryFragmentInteractionListener) context;
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
    public interface OnBackstoryFragmentInteractionListener {
        // TODO: Update argument type and name
        void OnBackstoryFragmentInteractionListener(Uri uri);
    }
}
