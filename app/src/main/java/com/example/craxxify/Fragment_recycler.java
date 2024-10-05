package com.example.craxxify;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.craxxify.Car.CotxeAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_recycler#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_recycler extends Fragment {



    public Fragment_recycler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        // Obtener referencia del RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.recyCar);

        // Obtener los datos de los cotxes
        ArrayList<Integer> cotxeImages = getCotxes();

        // Configurar el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CotxeAdapter adapter = new CotxeAdapter(getActivity(), cotxeImages);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
    private ArrayList<Integer> getCotxes() {
        ArrayList<Integer> cotxeImages = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.cotxe_images);
        for (int i = 0; i < imgs.length(); i++) {
            int id = imgs.getResourceId(i, -1);
            if (id != -1) {
                cotxeImages.add(id);
            }
        }
        imgs.recycle();
        return cotxeImages;
    }
}