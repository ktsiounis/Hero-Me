package com.example.ntinos.herome;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowersFragment.OnPickPowersFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowersFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button turtleBtn;
    private Button webBtn;
    private Button supermanBtn;
    private Button strengthBtn;
    private Button backstoryBtn;
    private Button lazerBtn;
    private Button thorBtn;

    private OnPickPowersFragmentInteractionListener mListener;

    public PickPowersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowersFragment newInstance(String param1, String param2) {
        PickPowersFragment fragment = new PickPowersFragment();
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
        View view = inflater.inflate(R.layout.fragment_pick_powers, container, false);
        thorBtn = (Button) view.findViewById(R.id.thorBtn);
        supermanBtn = (Button) view.findViewById(R.id.supermanBtn);
        lazerBtn = (Button) view.findViewById(R.id.lazerBtn);
        backstoryBtn = (Button) view.findViewById(R.id.backstoryBtn);
        strengthBtn = (Button) view.findViewById(R.id.strengthBtn);
        webBtn = (Button) view.findViewById(R.id.webBtn);
        turtleBtn = (Button) view.findViewById(R.id.turtleBtn);

        thorBtn.setOnClickListener(this);
        supermanBtn.setOnClickListener(this);
        lazerBtn.setOnClickListener(this);
        turtleBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowersFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        thorBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,0,0);
        lazerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        supermanBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
        turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        strengthBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.super_strength,0,0,0);
        webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spider_web,0,0,0);

        Button currentBtn = (Button)v;
        int leftDrawable = 0;

        if (currentBtn == thorBtn) {
            leftDrawable = R.drawable.thors_hammer;
        } else if (currentBtn == lazerBtn) {
            leftDrawable = R.drawable.laser_vision;
        } else if (currentBtn == supermanBtn) {
            leftDrawable = R.drawable.super_man_crest;
        } else if (currentBtn == turtleBtn) {
            leftDrawable = R.drawable.turtle_power;
        } else if (currentBtn == strengthBtn) {
            leftDrawable = R.drawable.super_strength;
        } else if (currentBtn == webBtn) {
            leftDrawable = R.drawable.spider_web;
        }

        currentBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPickPowersFragmentInteractionListener) {
            mListener = (OnPickPowersFragmentInteractionListener) context;
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
    public interface OnPickPowersFragmentInteractionListener {
        // TODO: Update argument type and name
        void onPickPowersFragmentInteraction(Uri uri);
    }
}
