package com.example.sdt.myapplication;

import android.app.Service;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Spinner typeSpinner;
    private LayoutInflater mInflator;
    private boolean selected;


    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        selected = false;
        typeSpinner = (Spinner) rootView.findViewById(R.id.spinner);
        typeSpinner.setAdapter(typeSpinnerAdapter);
        typeSpinner.setOnItemSelectedListener(typeSpinnerSelectedListener);
        typeSpinner.setOnTouchListener(typeSpinnerTouchListener);
        mInflator = getLayoutInflater(savedInstanceState);

//        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
//
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexo, R.layout.spinner_item_actionbar );
//
//        adapter.setDropDownViewResource(R.layout.spinner_item_dropdown);
//
//        spinner.setAdapter(adapter);

        return rootView;
    }

    private SpinnerAdapter typeSpinnerAdapter = new BaseAdapter() {
        private TextView text;
        private String[] data = {"Feminino", "Masculino", "Outros"};
        private int count = 3;

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflator.inflate(R.layout.spinner_item_actionbar, null);
            }
            text = (TextView) convertView.findViewById(R.id.target);
            if (!selected) {
                text.setText("please select a value");
            } else {
                text.setText(data[position]);
            }
            return convertView;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflator.inflate(R.layout.spinner_item_dropdown, null);

            }
            text = (TextView) convertView.findViewById(R.id.dropdown_target);
            text.setText(data[position]);
            return convertView;
        }

        ;
    };

    private AdapterView.OnItemSelectedListener typeSpinnerSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.d("LOG", "Clicked");
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnTouchListener typeSpinnerTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            selected = true;
            return false;
        }
    };
}


