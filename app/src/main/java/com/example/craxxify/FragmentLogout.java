package com.example.craxxify;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogout extends Fragment {

    private Button logout;
    public FragmentLogout() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_logout, container, false);

        // Obtener referencia del botón de logout
        logout = v.findViewById(R.id.logout3);

        // Configurar OnClickListener para el botón de logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                // Agregar flags para limpiar el backstack y crear una nueva tarea
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Iniciar la actividad
                startActivity(intent);
                // Finalizar la actividad actual (UserAct)
                getActivity().finish();
            }
        });

        return v;
    }
}