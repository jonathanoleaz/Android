package com.example.jonat.repeatejemplofragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {
    Button buttonOpcionUno;

    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=null;
        view=inflater.inflate(R.layout.fragment_left, container, false);
        buttonOpcionUno=view.findViewById(R.id.buttonOpcionUno);

        buttonOpcionUno.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){

            }
        });
        return view;
    }

}
