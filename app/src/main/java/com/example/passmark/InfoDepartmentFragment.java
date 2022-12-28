package com.example.passmark;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.card.MaterialCardView;

public class InfoDepartmentFragment extends Fragment {
    private View view;
    private MaterialCardView L1mathinfo,L2info,L3info,L3infoSIQ,L3infoISIL;
    private Animation scaleUp,scaleDown,show,hide;
    private boolean clickable;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_department, container, false);
        InisializationOfFields();
        ButtonAnimation();

        L1mathinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, new FirstyearMathInfoFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        L2info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, new SecondyearInfoFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        L3info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickable){
                    clickable = false;
                    setSIQHide();
                    setISILHide();
                }else {
                    clickable = true;
                    setSIQShow();
                    setISILShow();
                }
            }
        });
        L3infoSIQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, new ThirdyearInfoSIQFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        L3infoISIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, new ThirdyearInfoISILFragment())
                        .addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void InisializationOfFields(){
        clickable = false;
        L1mathinfo = view.findViewById(R.id.L1mathinfo);
        L2info = view.findViewById(R.id.L2info);
        L3info = view.findViewById(R.id.L3info);
        scaleUp = AnimationUtils.loadAnimation(getActivity(),R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(getActivity(),R.anim.scale_down);
        L3infoSIQ = view.findViewById(R.id.L3infoSIQ);
        L3infoSIQ.setVisibility(View.INVISIBLE);
        L3infoISIL = view.findViewById(R.id.L3infoISIL);
        L3infoISIL.setVisibility(View.INVISIBLE);
        show = AnimationUtils.loadAnimation(getActivity(), R.anim.show);
        hide = AnimationUtils.loadAnimation(getActivity(), R.anim.hide);

    }
    private void ButtonAnimation(){
        L1mathinfo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    L1mathinfo.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    L1mathinfo.startAnimation(scaleDown);
                }
                return false;
            }
        });
        L2info.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    L2info.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    L2info.startAnimation(scaleDown);
                }
                return false;
            }
        });
        L3info.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    L3info.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    L3info.startAnimation(scaleDown);
                }
                return false;
            }
        });
        L3infoSIQ.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    L3infoSIQ.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    L3infoSIQ.startAnimation(scaleDown);
                }
                return false;
            }
        });
        L3infoISIL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    L3infoISIL.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    L3infoISIL.startAnimation(scaleDown);
                }
                return false;
            }
        });
    }
    public void setSIQHide() {
        L3infoSIQ.startAnimation(hide);
        L3infoSIQ.setClickable(false);
        L3infoSIQ.setVisibility(View.INVISIBLE);
    }
    public void setISILHide() {
        L3infoISIL.startAnimation(hide);
        L3infoISIL.setClickable(false);
        L3infoISIL.setVisibility(View.GONE);
    }
    public void setSIQShow() {
        L3infoSIQ.startAnimation(show);
        L3infoSIQ.setClickable(true);
        L3infoSIQ.setVisibility(View.VISIBLE);
    }
    public void setISILShow() {
        L3infoISIL.startAnimation(show);
        L3infoISIL.setClickable(true);
        L3infoISIL.setVisibility(View.VISIBLE);
    }
}