package com.example.passmark;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.card.MaterialCardView;

public class InfoDepartmentFragment extends Fragment {
    private View view;
    private MaterialCardView L1mathinfo,L2info,L3info;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_department, container, false);
        InisializationOfFields();
        L1mathinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new FirstyearMathInfoFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        L2info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new SecondyearInfoFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        L3info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new ThirdyearInfoFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
    private void InisializationOfFields(){
        L1mathinfo = view.findViewById(R.id.L1mathinfo);
        L2info = view.findViewById(R.id.L2info);
        L3info = view.findViewById(R.id.L3info);
    }
}