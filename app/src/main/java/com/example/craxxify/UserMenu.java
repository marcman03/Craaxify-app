package com.example.craxxify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.craxxify.LogSign.SignUpActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserMenu extends Fragment {

    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    public UserMenu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user_menu, container, false);

        imageButton = rootView.findViewById(R.id.imageButton);
        imageButton2 = rootView.findViewById(R.id.imageButton2);
        imageButton3 = rootView.findViewById(R.id.imageButton3);
        imageButton4 = rootView.findViewById(R.id.imageButton4);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof ButtonsAct) {
                    ((ButtonsAct) getActivity()).changeFragment(1);
                }
            }
        });

        // Configurar OnClickListener para el botón 2
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof ButtonsAct) {
                    ((ButtonsAct) getActivity()).changeFragment(2);
                }
            }
        });


        return rootView;
    }
}