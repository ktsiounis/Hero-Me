package com.example.ntinos.herome.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.ntinos.herome.Fragments.BackstoryFragment;
import com.example.ntinos.herome.Fragments.MainFragment;
import com.example.ntinos.herome.Fragments.PickPowersFragment;
import com.example.ntinos.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowersFragment.OnPickPowersFragmentInteractionListener, BackstoryFragment.OnBackstoryFragmentInteractionListener {
    public String heroe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    public void loadPickPowersScreen(){
        PickPowersFragment pickPowersFragment = new PickPowersFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowersFragment).addToBackStack(null).commit();
    }

    public  void loadBackstoryScreen(){
        BackstoryFragment backstoryFragment = new BackstoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, backstoryFragment).addToBackStack(null).commit();
    }

    public void loadMainFragment(){
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteractionListener(Uri uri) {

    }

    @Override
    public void onPickPowersFragmentInteraction(Uri uri) {

    }

    @Override
    public void OnBackstoryFragmentInteractionListener(Uri uri) {

    }
}
