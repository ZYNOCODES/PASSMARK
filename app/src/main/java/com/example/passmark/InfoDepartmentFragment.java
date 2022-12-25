package com.example.passmark;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoDepartmentFragment extends Fragment {
    private View view;
    private CardView L1mathinfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_department, container, false);

        L1mathinfo = view.findViewById(R.id.L1mathinfo);
        L1mathinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.navHostFragment, new FirstyearMathInfoFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });





        return view;
    }
}