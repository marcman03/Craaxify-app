package com.example.craxxify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.craxxify.Car.Cotxe;
import com.example.craxxify.Car.CotxeAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserAct extends AppCompatActivity implements ButtonsAct {

    private RecyclerView recyclerView;
    private CotxeAdapter adapter;
    private ArrayList<Integer> cotxeImages;
    private List<Cotxe> cotxeList;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;
    private UserMenu userMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragments = new Fragment[2];
        fragments[0]= new Fragment_recycler();
        fragments[1] = new FragmentLogout();


        setContentView(R.layout.activity_user);



    }

    public void getButton(){

    }
    public void changeFragment(int k){
        FragmentManager fgmng = getSupportFragmentManager();
        FragmentTransaction trans = fgmng.beginTransaction();
        switch (k){
            case 1:
                trans.replace(R.id.fragmentContainerView5,fragments[0]);

                break;
            case 2:
                trans.replace(R.id.fragmentContainerView5,fragments[1]);
                break;
        }
        trans.commit();
    }
}