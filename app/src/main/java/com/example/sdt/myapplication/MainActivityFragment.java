package com.example.sdt.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexo, R.layout.spinner_item_actionbar );

        adapter.setDropDownViewResource(R.layout.spinner_item_dropdown);

        spinner.setAdapter(adapter);
        return rootView;
    }
}
