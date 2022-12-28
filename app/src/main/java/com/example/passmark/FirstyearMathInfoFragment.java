package com.example.passmark;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FirstyearMathInfoFragment extends Fragment {
    private View view;
    private ImageView Back;
    private EditText ExamenAnalyse,TdAnalyse,ExamenAlgebre,TdAlgebre,ExamenAlgo,TpAlgo,
            TdAlgo,ExamenStructure,Tdstructure,ExamenTSE,ExamenLangue,ExamenPhysique,TdPhysique,
            ExamenAnalyse2,TdAnalyse2,ExamenAlgebre2,TdAlgebre2,ExamenAlgo2,TpAlgo2,
            TdAlgo2,ExamenStructure2,Tdstructure2,ExamenTIC,ExamenOPM,TdOPM,TpOPM,ExamenProba,TdProba,ExamenPhysique2,TdPhysique2;
    private TextView MoyAnalyse,MoyAnalyse2,MoyAlgebre,MoyAlgebre2,MoyAlgo,MoyAlgo2,MoyStructure,MoyStructure2,
            MoyTSE,MoyTIC,MoyLangue,MoyOPM,MoyPhysique,MoyPhysique2,MoyProba,
            CoefAnalyse,CoefAnalyse2,CoefAlgebre,CoefAlgebre2,CoefAlgo,CoefAlgo2,CoefStructure,CoefStructure2,
            CoefTSE,CoefTIC,CoefLangue,CoefOPM,CoefPhysique,CoefPhysique2,CoefProba,
            CreditAnalyse,CreditAnalyse2,CreditAlgebre,CreditAlgebre2,CreditAlgo,CreditAlgo2,CreditStructure,CreditStructure2,
            CreditTSE,CreditTIC,CreditLangue,CreditOPM,CreditPhysique,CreditPhysique2,CreditProba,
            Moyfondamentale11,Moyfondamentale12,Moyfondamentale21,Moyfondamentale22,
            MoyMethodologie1,MoyMethodologie2,MoyDecouverte1,MoyDecouverte2,
            Creditfondamentale11,Creditfondamentale12,Creditfondamentale21,Creditfondamentale22,
            CreditMethodologie1,CreditMethodologie2,CreditDecouverte1,CreditDecouverte2,
            MoyS1,MoyS2,CreditS1,CreditS2,MoyGeneral,CreditGeneral;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_firstyear_math_info, container, false);
        InisializationOfFields();
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, new InfoDepartmentFragment())
                        .addToBackStack("tag");
                fragmentManager.popBackStack();
                fragmentTransaction.commit();


            }
        });

        //semestre1

        Moyenne(MoyAnalyse,ExamenAnalyse,TdAnalyse);
        Moyenne(MoyAlgebre,ExamenAlgebre,TdAlgebre);
        MoyenneUnite(Moyfondamentale11,MoyAnalyse,CoefAnalyse,MoyAlgebre,CoefAlgebre);
        CreditObtenu(Creditfondamentale11,MoyAnalyse,CreditAnalyse,MoyAlgebre,CreditAlgebre);

        Moyenne(MoyAlgo,ExamenAlgo,TdAlgo,TpAlgo);
        Moyenne(MoyStructure,ExamenStructure,Tdstructure);
        MoyenneUnite(Moyfondamentale21,MoyAlgo,CoefAlgo,MoyStructure,CoefStructure);
        CreditObtenu(Creditfondamentale21,MoyAlgo,CreditAlgo,MoyStructure,CreditStructure);

        Moyenne(MoyTSE,ExamenTSE);
        Moyenne(MoyLangue,ExamenLangue);
        MoyenneUnite(MoyMethodologie1,MoyTSE,CoefTSE,MoyLangue,CoefLangue);
        CreditObtenu(CreditMethodologie1,MoyTSE,CreditTSE,MoyLangue,CreditLangue);

        Moyenne(MoyPhysique,ExamenPhysique,TdPhysique);
        MoyenneUnite(MoyDecouverte1,MoyPhysique,CoefPhysique);
        CreditObtenu(CreditDecouverte1,MoyPhysique,CreditPhysique);

        CalcMoyenneS1();
        CalcCreditS1();

        //semestre2

        Moyenne(MoyAnalyse2,ExamenAnalyse2,TdAnalyse2);
        Moyenne(MoyAlgebre2,ExamenAlgebre2,TdAlgebre2);
        MoyenneUnite(Moyfondamentale12,MoyAnalyse2,CoefAnalyse2,MoyAlgebre2,CoefAlgebre2);
        CreditObtenu(Creditfondamentale12,MoyAnalyse2,CreditAnalyse2,MoyAlgebre2,CreditAlgebre2);

        Moyenne(MoyAlgo2,ExamenAlgo2,TdAlgo2,TpAlgo2);
        Moyenne(MoyStructure2,ExamenStructure2,Tdstructure2);
        MoyenneUnite(Moyfondamentale22,MoyAlgo2,CoefAlgo2,MoyStructure2,CoefStructure2);
        CreditObtenu(Creditfondamentale22,MoyAlgo2,CreditAlgo2,MoyStructure2,CreditStructure2);

        Moyenne(MoyProba,ExamenProba,TdProba);
        Moyenne(MoyOPM,ExamenOPM,TdOPM,TpOPM);
        Moyenne(MoyTIC,ExamenTIC);
        MoyenneUnite3(MoyMethodologie2,MoyTIC,CoefTIC,MoyOPM,CoefOPM,MoyProba,CoefProba);
        CreditObtenu(CreditMethodologie2,MoyTIC,CreditTIC,MoyOPM,CreditOPM,MoyProba,CreditProba);

        Moyenne(MoyPhysique2,ExamenPhysique2,TdPhysique2);
        MoyenneUnite(MoyDecouverte2,MoyPhysique2,CoefPhysique2);
        CreditObtenu(CreditDecouverte2,MoyPhysique2,CreditPhysique2);

        CalcMoyenneS2();
        CalcCreditS2();

        // moyenne general
        CalcMoyGeneral();

        // credit general
        CalcCreditGeneral();
        return view;
    }

    private void InisializationOfFields(){
        Back = view.findViewById(R.id.Back);
        ExamenAnalyse = view.findViewById(R.id.ExamenAnalyse);
        TdAnalyse = view.findViewById(R.id.TdAnalyse);
        ExamenAlgebre = view.findViewById(R.id.ExamenAlgebre);
        TdAlgebre = view.findViewById(R.id.TdAlgebre);
        ExamenAlgo = view.findViewById(R.id.ExamenAlgo);
        TpAlgo = view.findViewById(R.id.TpAlgo);
        TdAlgo = view.findViewById(R.id.TdAlgo);
        ExamenStructure = view.findViewById(R.id.ExamenStructure);
        Tdstructure = view.findViewById(R.id.Tdstructure);
        ExamenTSE = view.findViewById(R.id.ExamenTSE);
        ExamenLangue = view.findViewById(R.id.ExamenLangue);
        ExamenPhysique = view.findViewById(R.id.ExamenPhysique);
        TdPhysique = view.findViewById(R.id.TdPhysique);

        ExamenAnalyse2 = view.findViewById(R.id.ExamenAnalyse2);
        TdAnalyse2 = view.findViewById(R.id.TdAnalyse2);
        ExamenAlgebre2 = view.findViewById(R.id.ExamenAlgebre2);
        TdAlgebre2 = view.findViewById(R.id.TdAlgebre2);
        ExamenAlgo2 = view.findViewById(R.id.ExamenAlgo2);
        TpAlgo2 = view.findViewById(R.id.TpAlgo2);
        TdAlgo2 = view.findViewById(R.id.TdAlgo2);
        ExamenStructure2 = view.findViewById(R.id.ExamenStructure2);
        Tdstructure2 = view.findViewById(R.id.Tdstructure2);
        ExamenTIC = view.findViewById(R.id.ExamenTIC);
        ExamenOPM = view.findViewById(R.id.ExamenOPM);
        TdOPM = view.findViewById(R.id.TdOPM);
        TpOPM = view.findViewById(R.id.TpOPM);
        ExamenPhysique2 = view.findViewById(R.id.ExamenPhysique2);
        TdPhysique2 = view.findViewById(R.id.TdPhysique2);
        ExamenProba = view.findViewById(R.id.ExamenProba);
        TdProba = view.findViewById(R.id.TdProba);

        MoyAnalyse = view.findViewById(R.id.MoyAnalyse);
        MoyAnalyse2 = view.findViewById(R.id.MoyAnalyse2);
        MoyAlgebre = view.findViewById(R.id.MoyAlgebre);
        MoyAlgebre2 = view.findViewById(R.id.MoyAlgebre2);
        MoyAlgo = view.findViewById(R.id.MoyAlgo);
        MoyAlgo2 = view.findViewById(R.id.MoyAlgo2);
        MoyStructure = view.findViewById(R.id.MoyStructure);
        MoyStructure2 = view.findViewById(R.id.MoyStructure2);
        MoyTSE = view.findViewById(R.id.MoyTSE);
        MoyTIC = view.findViewById(R.id.MoyTIC);
        MoyOPM = view.findViewById(R.id.MoyOPM);
        MoyLangue = view.findViewById(R.id.MoyLangue);
        MoyPhysique = view.findViewById(R.id.MoyPhysique);
        MoyPhysique2 = view.findViewById(R.id.MoyPhysique2);
        MoyProba = view.findViewById(R.id.MoyProba);

        CoefAnalyse = view.findViewById(R.id.CoefAnalyse);
        CoefAnalyse2 = view.findViewById(R.id.CoefAnalyse2);
        CoefAlgebre = view.findViewById(R.id.CoefAlgebre);
        CoefAlgebre2 = view.findViewById(R.id.CoefAlgebre2);
        CoefAlgo = view.findViewById(R.id.CoefAlgo);
        CoefAlgo2 = view.findViewById(R.id.CoefAlgo2);
        CoefStructure = view.findViewById(R.id.CoefStructure);
        CoefStructure2 = view.findViewById(R.id.CoefStructure2);
        CoefTSE = view.findViewById(R.id.CoefTSE);
        CoefTIC = view.findViewById(R.id.CoefTIC);
        CoefOPM = view.findViewById(R.id.CoefOPM);
        CoefLangue = view.findViewById(R.id.CoefLangue);
        CoefPhysique = view.findViewById(R.id.CoefPhysique);
        CoefPhysique2 = view.findViewById(R.id.CoefPhysique2);
        CoefProba = view.findViewById(R.id.CoefProba);

        CreditAnalyse = view.findViewById(R.id.CreditAnalyse);
        CreditAnalyse2 = view.findViewById(R.id.CreditAnalyse2);
        CreditAlgebre = view.findViewById(R.id.CreditAlgebre);
        CreditAlgebre2 = view.findViewById(R.id.CreditAlgebre2);
        CreditAlgo = view.findViewById(R.id.CreditAlgo);
        CreditAlgo2 = view.findViewById(R.id.CreditAlgo2);
        CreditStructure = view.findViewById(R.id.CreditStructure);
        CreditStructure2 = view.findViewById(R.id.CreditStructure2);
        CreditTSE = view.findViewById(R.id.CreditTSE);
        CreditTIC = view.findViewById(R.id.CreditTIC);
        CreditOPM = view.findViewById(R.id.CreditOPM);
        CreditLangue = view.findViewById(R.id.CreditLangue);
        CreditPhysique = view.findViewById(R.id.CreditPhysique);
        CreditPhysique2 = view.findViewById(R.id.CreditPhysique2);
        CreditProba = view.findViewById(R.id.CreditProba);

        Moyfondamentale11 = view.findViewById(R.id.Moyfondamentale11);
        Moyfondamentale12 = view.findViewById(R.id.Moyfondamentale12);
        Moyfondamentale21 = view.findViewById(R.id.Moyfondamentale21);
        Moyfondamentale22 = view.findViewById(R.id.Moyfondamentale22);
        MoyMethodologie1 = view.findViewById(R.id.MoyMethodologie1);
        MoyMethodologie2 = view.findViewById(R.id.MoyMethodologie2);
        MoyDecouverte1 = view.findViewById(R.id.MoyDecouverte1);
        MoyDecouverte2 = view.findViewById(R.id.MoyDecouverte2);

        Creditfondamentale11 = view.findViewById(R.id.Creditfondamentale11);
        Creditfondamentale12 = view.findViewById(R.id.Creditfondamentale12);
        Creditfondamentale21 = view.findViewById(R.id.Creditfondamentale21);
        Creditfondamentale22 = view.findViewById(R.id.Creditfondamentale22);
        CreditMethodologie1 = view.findViewById(R.id.CreditMethodologie1);
        CreditMethodologie2 = view.findViewById(R.id.CreditMethodologie2);
        CreditDecouverte1 = view.findViewById(R.id.CreditDecouverte1);
        CreditDecouverte2 = view.findViewById(R.id.CreditDecouverte2);

        MoyS1 = view.findViewById(R.id.MoyS1);
        MoyS2 = view.findViewById(R.id.MoyS2);
        CreditS1 = view.findViewById(R.id.CreditS1);
        CreditS2 = view.findViewById(R.id.CreditS2);
        MoyGeneral = view.findViewById(R.id.MoyGeneral);
        CreditGeneral = view.findViewById(R.id.CreditGeneral);

    }
    private float CalcModuleMoy(Editable Examen,EditText Td){
        float ModuleMoy = 0.00F,examen,td;

        if ((!Examen.toString().isEmpty())
                && (!Td.getText().toString().isEmpty())) {
            examen = Float.parseFloat(Examen.toString());
            td = Float.parseFloat(Td.getText().toString());
            ModuleMoy = (float) ((td * 0.4) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((Examen.toString().isEmpty())
                && (!Td.getText().toString().isEmpty())) {
                examen = 0;
                td = Float.parseFloat(Td.getText().toString());
            ModuleMoy = (float) ((td * 0.4) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.toString().isEmpty())
                && (Td.getText().toString().isEmpty())) {
            examen = Float.parseFloat(Examen.toString());
            td = 0;
            ModuleMoy = (float) ((td * 0.4) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));

    }
    private float CalcModuleMoy(TextView Examen,Editable Td){
        float ModuleMoy = 0.00F,examen,td;

        if ((!Examen.getText().toString().isEmpty())
                && (!Td.toString().isEmpty())) {
            examen = Float.parseFloat(Examen.getText().toString());
            td = Float.parseFloat(Td.toString());
            ModuleMoy = (float) ((td * 0.4) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((Examen.getText().toString().isEmpty())
                && (!Td.toString().isEmpty())) {
            examen = 0;
            td = Float.parseFloat(Td.toString());
            ModuleMoy = (float) ((td * 0.4) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.getText().toString().isEmpty())
                && (Td.toString().isEmpty())) {
            examen = Float.parseFloat(Examen.getText().toString());
            td = 0;
            ModuleMoy = (float) ((td * 0.4) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else
            return ModuleMoy;

    }
    private float CalcModuleMoy(Editable Examen,EditText Td,EditText Tp){
        float ModuleMoy = 0.00F,td,tp,examen;
        if ((!Examen.toString().isEmpty())
                && (!Td.getText().toString().isEmpty())
                && (!Tp.getText().toString().isEmpty())) {
            td = Float.parseFloat(Td.getText().toString());
            tp = Float.parseFloat(Tp.getText().toString());
            examen = Float.parseFloat(Examen.toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((Examen.toString().isEmpty())
                && (!Td.getText().toString().isEmpty())
                && (!Tp.getText().toString().isEmpty())) {
            examen = 0;
            td = Float.parseFloat(Td.getText().toString());
            tp = Float.parseFloat(Tp.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.toString().isEmpty())
                && (Td.getText().toString().isEmpty())
                && (!Tp.getText().toString().isEmpty())) {
            td = 0;
            tp = Float.parseFloat(Tp.getText().toString());
            examen = Float.parseFloat(Examen.toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.toString().isEmpty())
                && (!Td.getText().toString().isEmpty())
                && (Tp.getText().toString().isEmpty())) {
            td = Float.parseFloat(Td.getText().toString());
            tp = 0;
            examen = Float.parseFloat(Examen.toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.toString().isEmpty())
                && (Td.getText().toString().isEmpty())
                && (Tp.getText().toString().isEmpty())) {
            td = 0;
            tp = 0;
            examen = Float.parseFloat(Examen.toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
    }
    private float CalcModuleMoy(EditText Examen,Editable Td,EditText Tp){
        float ModuleMoy = 0.00F,td,tp,examen;
        if ((!Examen.getText().toString().isEmpty())
                && (!Td.toString().isEmpty())
                && (!Tp.getText().toString().isEmpty())) {
            td = Float.parseFloat(Td.toString());
            tp = Float.parseFloat(Tp.getText().toString());
            examen = Float.parseFloat(Examen.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((Examen.getText().toString().isEmpty())
                && (!Td.toString().isEmpty())
                && (!Tp.getText().toString().isEmpty())) {
            examen = 0;
            td = Float.parseFloat(Td.toString());
            tp = Float.parseFloat(Tp.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.getText().toString().isEmpty())
                && (Td.toString().isEmpty())
                && (!Tp.getText().toString().isEmpty())) {
            td = 0;
            tp = Float.parseFloat(Tp.getText().toString());
            examen = Float.parseFloat(Examen.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.getText().toString().isEmpty())
                && (!Td.toString().isEmpty())
                && (Tp.getText().toString().isEmpty())) {
            td = Float.parseFloat(Td.toString());
            tp = 0;
            examen = Float.parseFloat(Examen.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
    }
    private float CalcModuleMoy(EditText Examen,EditText Td,Editable Tp){
        float ModuleMoy = 0.00F,td,tp,examen;
        if ((!Examen.getText().toString().isEmpty())
                && (!Td.getText().toString().isEmpty())
                && (!Tp.toString().isEmpty())) {
            td = Float.parseFloat(Td.getText().toString());
            tp = Float.parseFloat(Tp.toString());
            examen = Float.parseFloat(Examen.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((Examen.getText().toString().isEmpty())
                && (!Td.getText().toString().isEmpty())
                && (!Tp.toString().isEmpty())) {
            examen = 0;
            td = Float.parseFloat(Td.getText().toString());
            tp = Float.parseFloat(Tp.toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.getText().toString().isEmpty())
                && (Td.getText().toString().isEmpty())
                && (!Tp.toString().isEmpty())) {
            td = 0;
            tp = Float.parseFloat(Tp.toString());
            examen = Float.parseFloat(Examen.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else if ((!Examen.getText().toString().isEmpty())
                && (!Td.getText().toString().isEmpty())
                && (Tp.toString().isEmpty())) {
            td = Float.parseFloat(Td.getText().toString());
            tp = 0;
            examen = Float.parseFloat(Examen.getText().toString());
            ModuleMoy = (float) (((td+tp) * 0.2) + (examen * 0.6));
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
        }else
            return Float.parseFloat((new DecimalFormat("##.##").format(ModuleMoy)));
    }
    private void DisplayMoy(TextView Moy , Float result){
        if (result != null){
            Moy.setText(result.toString());
        }else
            Moy.setText("0.00");
    }
    private void Moyenne(TextView Moy,EditText A,EditText B,EditText C){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                DisplayMoy(Moy,CalcModuleMoy(s,B,C));
            }
        });
        B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DisplayMoy(Moy,CalcModuleMoy(A,s,C));
            }
        });
        C.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DisplayMoy(Moy,CalcModuleMoy(A,B,s));

            }
        });
    }
    private void Moyenne(TextView Moy,EditText A,EditText B){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                DisplayMoy(Moy,CalcModuleMoy(s,B));
            }
        });
        B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DisplayMoy(Moy,CalcModuleMoy(A,s));
            }
        });
    }
    private void Moyenne(TextView Moy,EditText A){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()){
                    Moy.setText(s.toString());
                }else
                    Moy.setText("0.00");
            }
        });

    }
    private void MoyenneUnite(TextView Moy,TextView A,TextView Ac){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                float a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                float moy = a / Integer.parseInt(Ac.getText().toString());
                Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
            }
        });
    }
    private void MoyenneUnite(TextView Moy,TextView A,TextView Ac,TextView B,TextView Bc){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int Coef = Integer.parseInt(Ac.getText().toString()) + Integer.parseInt(Bc.getText().toString());
                float b;
                float a;
                float moy = 0.00F;
                if ((!s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    a = Float.parseFloat(s.toString())*Integer.parseInt(Ac.getText().toString());
                    moy = (a + b)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    a = 0;
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    moy = (a + b)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString())*Integer.parseInt(Ac.getText().toString());
                    b = 0;
                    moy = (a + b)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
            }
        });
        B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                int Coef = Integer.parseInt(Ac.getText().toString()) + Integer.parseInt(Bc.getText().toString());
                float b;
                float a;
                float moy = 0.00F;
                if ((!A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    b = Float.parseFloat(s.toString())*Integer.parseInt(Bc.getText().toString());
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    moy = (a + b)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    a = 0;
                    b = Float.parseFloat(s.toString())*Integer.parseInt(Bc.getText().toString());
                    moy = (a + b)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!A.getText().toString().isEmpty())
                        && (s.toString().isEmpty())) {
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    b = 0;
                    moy = (a + b)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
            }
        });
    }
    private void MoyenneUnite3(TextView Moy,TextView A,TextView Ac,TextView B,TextView Bc,TextView C, TextView Cc){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int Coef = Integer.parseInt(Ac.getText().toString())
                        + Integer.parseInt(Bc.getText().toString())
                        + Integer.parseInt(Cc.getText().toString());
                float a;
                float b;
                float c;
                float moy = 0.00F;
                if ((!s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    a = Float.parseFloat(s.toString())*Integer.parseInt(Ac.getText().toString());
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    a = 0;
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString())*Integer.parseInt(Ac.getText().toString());
                    b = 0;
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString())*Integer.parseInt(Ac.getText().toString());
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    c = 0;
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString())*Integer.parseInt(Ac.getText().toString());
                    b = 0;
                    c = 0;
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    a = 0;
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    c = 0;
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    a = 0;
                    b = 0;
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
            }
        });
        B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                int Coef = Integer.parseInt(Ac.getText().toString())
                        + Integer.parseInt(Bc.getText().toString())
                        + Integer.parseInt(Cc.getText().toString());
                float a;
                float b;
                float c;
                float moy = 0.00F;
                if ((!A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    b = Float.parseFloat(s.toString())*Integer.parseInt(Bc.getText().toString());
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    a = 0;
                    b = Float.parseFloat(s.toString())*Integer.parseInt(Bc.getText().toString());
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!A.getText().toString().isEmpty())
                        && (s.toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    b = 0;
                    c = Float.parseFloat(C.getText().toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    b = Float.parseFloat(s.toString())*Integer.parseInt(Bc.getText().toString());
                    c = 0;
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
            }
        });
        C.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                int Coef = Integer.parseInt(Ac.getText().toString())
                        + Integer.parseInt(Bc.getText().toString())
                        + Integer.parseInt(Cc.getText().toString());
                float a;
                float b;
                float c;
                float moy = 0.00F;
                if ((!A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    c = Float.parseFloat(s.toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    a = 0;
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    c = Float.parseFloat(s.toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!A.getText().toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    b = 0;
                    c = Float.parseFloat(s.toString())*Integer.parseInt(Cc.getText().toString());
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else if ((!A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (s.toString().isEmpty())) {
                    a = Float.parseFloat(A.getText().toString())*Integer.parseInt(Ac.getText().toString());
                    b = Float.parseFloat(B.getText().toString())*Integer.parseInt(Bc.getText().toString());
                    c = 0;
                    moy = (a + b + c)/Coef;
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }else
                    Moy.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
            }

        });
    }
    private void CreditObtenu(TextView Credit,TextView A,TextView Acred){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int acred = Integer.parseInt(Acred.getText().toString());
                float a = Float.parseFloat(s.toString());
                if (!s.toString().isEmpty()){
                    if (a >= 10) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else
                    Credit.setText(String.valueOf(0));

            }
        });

    }
    private void CreditObtenu(TextView Credit,TextView A,TextView Acred,TextView B,TextView Bcred){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int acred = Integer.parseInt(Acred.getText().toString());
                int bcred = Integer.parseInt(Bcred.getText().toString());

                if ((!s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(s.toString());
                    float b = Float.parseFloat(B.getText().toString());

                    if ((a >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(acred + bcred));
                    } else if ((a >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));


                } else if ((s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(B.getText().toString());

                    if (b >= 10) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                } else if ((!s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())) {

                    float a = Float.parseFloat(s.toString());
                    if (a >= 10) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else
                    Credit.setText(String.valueOf(0));
            }
        });
        B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                int acred = Integer.parseInt(Acred.getText().toString());
                int bcred = Integer.parseInt(Bcred.getText().toString());
                if ((!A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    float b = Float.parseFloat(s.toString());
                    float a = Float.parseFloat(A.getText().toString());

                    if ((a >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(acred + bcred));
                    } else if ((a >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((A.getText().toString().isEmpty())
                        && (!s.toString().isEmpty())) {
                    float b = Float.parseFloat(s.toString());
                    if (b >= 10) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else if ((!A.getText().toString().isEmpty())
                        && (s.toString().isEmpty())) {
                    float a = Float.parseFloat(A.getText().toString());

                    if (a >= 10) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else
                    Credit.setText(String.valueOf(0));
            }
        });
    }
    private void CreditObtenu(TextView Credit,TextView A,TextView Acred,TextView B,TextView Bcred,TextView C, TextView Ccred){
        A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int acred = Integer.parseInt(Acred.getText().toString());
                int bcred = Integer.parseInt(Bcred.getText().toString());
                int ccred = Integer.parseInt(Ccred.getText().toString());
                if ((!s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(s.toString());
                    float b = Float.parseFloat(B.getText().toString());
                    float c = Float.parseFloat(C.getText().toString());

                    if ((a >= 10) && (b >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + bcred + ccred));
                    } else if ((a >= 10) && (b < 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else if ((a < 10) && (b < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((a >= 10) && (b >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred + bcred));
                    } else if ((a >= 10) && (b < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + ccred));
                    } else if ((a < 10) && (b >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(bcred + ccred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(B.getText().toString());
                    float c = Float.parseFloat(C.getText().toString());
                    if ((c >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(ccred + bcred));
                    } else if ((c >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((c < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(s.toString());
                    float c = Float.parseFloat(C.getText().toString());
                    if ((c >= 10) && (a >= 10)) {
                        Credit.setText(String.valueOf(ccred + bcred));
                    } else if ((c >= 10) && (a < 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((c < 10) && (a >= 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(B.getText().toString());
                    float a = Float.parseFloat(C.getText().toString());
                    if ((a >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(ccred + bcred));
                    } else if ((a >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(s.toString());
                    if (a >= 10) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else if ((s.toString().isEmpty())
                        && (!B.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(B.getText().toString());
                    if (b >= 10) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (B.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float c = Float.parseFloat(C.getText().toString());
                    if (c >= 10) {
                        Credit.setText(String.valueOf(ccred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else
                    Credit.setText(String.valueOf(0));
            }
        });
        B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                int acred = Integer.parseInt(Acred.getText().toString());
                int bcred = Integer.parseInt(Bcred.getText().toString());
                int ccred = Integer.parseInt(Ccred.getText().toString());
                if ((!s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(s.toString());
                    float a = Float.parseFloat(A.getText().toString());
                    float c = Float.parseFloat(C.getText().toString());

                    if ((a >= 10) && (b >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + bcred + ccred));
                    } else if ((a >= 10) && (b < 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else if ((a < 10) && (b < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((a >= 10) && (b >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred + bcred));
                    } else if ((a >= 10) && (b < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + ccred));
                    } else if ((a < 10) && (b >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(bcred + ccred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(A.getText().toString());
                    float c = Float.parseFloat(C.getText().toString());
                    if ((c >= 10) && (a >= 10)) {
                        Credit.setText(String.valueOf(ccred + acred));
                    } else if ((c >= 10) && (a < 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((c < 10) && (a >= 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (A.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(s.toString());
                    float c = Float.parseFloat(C.getText().toString());
                    if ((c >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(ccred + bcred));
                    } else if ((c >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((c < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(s.toString());
                    float a = Float.parseFloat(A.getText().toString());
                    if ((a >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(acred + bcred));
                    } else if ((a >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (A.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(s.toString());
                    if (b >= 10) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else if ((s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (C.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(A.getText().toString());
                    if (a >= 10) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (A.getText().toString().isEmpty())
                        && (!C.getText().toString().isEmpty())) {
                    float c = Float.parseFloat(C.getText().toString());
                    if (c >= 10) {
                        Credit.setText(String.valueOf(ccred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else
                    Credit.setText(String.valueOf(0));
            }
        });
        C.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                int acred = Integer.parseInt(Acred.getText().toString());
                int bcred = Integer.parseInt(Bcred.getText().toString());
                int ccred = Integer.parseInt(Ccred.getText().toString());
                if ((!s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    float c = Float.parseFloat(s.toString());
                    float a = Float.parseFloat(A.getText().toString());
                    float b = Float.parseFloat(B.getText().toString());

                    if ((a >= 10) && (b >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + bcred + ccred));
                    } else if ((a >= 10) && (b < 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (b >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else if ((a < 10) && (b < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((a >= 10) && (b >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred + bcred));
                    } else if ((a >= 10) && (b < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + ccred));
                    } else if ((a < 10) && (b >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(bcred + ccred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(A.getText().toString());
                    float b = Float.parseFloat(B.getText().toString());
                    if ((b >= 10) && (a >= 10)) {
                        Credit.setText(String.valueOf(bcred + acred));
                    } else if ((b >= 10) && (a < 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else if ((b < 10) && (a >= 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    float c = Float.parseFloat(s.toString());
                    float b = Float.parseFloat(B.getText().toString());
                    if ((c >= 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(ccred + bcred));
                    } else if ((c >= 10) && (b < 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else if ((c < 10) && (b >= 10)) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (B.getText().toString().isEmpty())) {
                    float c = Float.parseFloat(s.toString());
                    float a = Float.parseFloat(A.getText().toString());
                    if ((a >= 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(acred + ccred));
                    } else if ((a >= 10) && (c < 10)) {
                        Credit.setText(String.valueOf(acred));
                    } else if ((a < 10) && (c >= 10)) {
                        Credit.setText(String.valueOf(ccred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((!s.toString().isEmpty())
                        && (A.getText().toString().isEmpty())
                        && (B.getText().toString().isEmpty())) {
                    float c = Float.parseFloat(s.toString());
                    if (c >= 10) {
                        Credit.setText(String.valueOf(ccred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (!A.getText().toString().isEmpty())
                        && (B.getText().toString().isEmpty())) {
                    float a = Float.parseFloat(A.getText().toString());
                    if (a >= 10) {
                        Credit.setText(String.valueOf(acred));
                    } else
                        Credit.setText(String.valueOf(0));

                }else if ((s.toString().isEmpty())
                        && (A.getText().toString().isEmpty())
                        && (!B.getText().toString().isEmpty())) {
                    float b = Float.parseFloat(B.getText().toString());
                    if (b >= 10) {
                        Credit.setText(String.valueOf(bcred));
                    } else
                        Credit.setText(String.valueOf(0));
                }else
                    Credit.setText(String.valueOf(0));
            }
        });
    }
    private void CalcMoyenneS1(){
        /* Moyfondamentale11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                float Moyenne;
                if ((!s.toString().isEmpty())
                    &&(!Moyfondamentale21.getText().toString().isEmpty())
                        &&(!MoyMethodologie1.getText().toString().isEmpty())
                            &&(!MoyDecouverte1.getText().toString().isEmpty())) {
                    float moyfondamentale11 = Float.parseFloat(s.toString());
                    float moyfondamentale21 = Float.parseFloat(Moyfondamentale21.getText().toString());
                    float moyMethodologie1 = Float.parseFloat(MoyMethodologie1.getText().toString());
                    float moyDecouverte1 = Float.parseFloat(MoyDecouverte1.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }

            }
        });
        Moyfondamentale21.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale11.getText().toString().isEmpty())
                        &&(!MoyMethodologie1.getText().toString().isEmpty())
                        &&(!MoyDecouverte1.getText().toString().isEmpty())) {
                    float moyfondamentale21 = Float.parseFloat(s.toString());
                    float moyfondamentale11 = Float.parseFloat(Moyfondamentale11.getText().toString());
                    float moyMethodologie1 = Float.parseFloat(MoyMethodologie1.getText().toString());
                    float moyDecouverte1 = Float.parseFloat(MoyDecouverte1.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }
            }
        });
        MoyMethodologie1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale11.getText().toString().isEmpty())
                        &&(!Moyfondamentale21.getText().toString().isEmpty())
                        &&(!MoyDecouverte1.getText().toString().isEmpty())) {
                    float moyMethodologie1 = Float.parseFloat(s.toString());
                    float moyfondamentale11 = Float.parseFloat(Moyfondamentale11.getText().toString());
                    float moyfondamentale21 = Float.parseFloat(Moyfondamentale21.getText().toString());
                    float moyDecouverte1 = Float.parseFloat(MoyDecouverte1.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }
            }
        });
        MoyDecouverte1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale11.getText().toString().isEmpty())
                        &&(!Moyfondamentale21.getText().toString().isEmpty())
                        &&(!MoyDecouverte1.getText().toString().isEmpty())) {
                    float moyDecouverte1 = Float.parseFloat(s.toString());
                    float moyfondamentale11 = Float.parseFloat(Moyfondamentale11.getText().toString());
                    float moyfondamentale21 = Float.parseFloat(Moyfondamentale21.getText().toString());
                    float moyMethodologie1 = Float.parseFloat(MoyMethodologie1.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }
            }
        });*/
        MoyPhysique.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a,b,c,d,e,f,g;
                if ((!s.toString().isEmpty())
                     && (!MoyAlgebre.getText().toString().isEmpty())
                        && (!MoyAlgo.getText().toString().isEmpty())
                            && (!MoyStructure.getText().toString().isEmpty())
                                && (!MoyTSE.getText().toString().isEmpty())
                                    && (!MoyLangue.getText().toString().isEmpty())
                                        && (!MoyAnalyse.getText().toString().isEmpty())){
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre.getText().toString());
                    c = Float.parseFloat(MoyAlgo.getText().toString());
                    d = Float.parseFloat(MoyStructure.getText().toString());
                    e = Float.parseFloat(MoyTSE.getText().toString());
                    f = Float.parseFloat(MoyLangue.getText().toString());
                    g = Float.parseFloat(MoyAnalyse.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefStructure.getText().toString()))
                            + (e * Integer.parseInt(CoefTSE.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse.getText().toString()));
                    moyenne = moyenne/18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyLangue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre.getText().toString().isEmpty())
                        && (!MoyAlgo.getText().toString().isEmpty())
                        && (!MoyStructure.getText().toString().isEmpty())
                        && (!MoyTSE.getText().toString().isEmpty())
                        && (!MoyPhysique.getText().toString().isEmpty())
                        && (!MoyAnalyse.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre.getText().toString());
                    c = Float.parseFloat(MoyAlgo.getText().toString());
                    d = Float.parseFloat(MoyStructure.getText().toString());
                    e = Float.parseFloat(MoyTSE.getText().toString());
                    f = Float.parseFloat(MoyPhysique.getText().toString());
                    g = Float.parseFloat(MoyAnalyse.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefLangue.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefStructure.getText().toString()))
                            + (e * Integer.parseInt(CoefTSE.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyTSE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre.getText().toString().isEmpty())
                        && (!MoyAlgo.getText().toString().isEmpty())
                        && (!MoyStructure.getText().toString().isEmpty())
                        && (!MoyLangue.getText().toString().isEmpty())
                        && (!MoyPhysique.getText().toString().isEmpty())
                        && (!MoyAnalyse.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre.getText().toString());
                    c = Float.parseFloat(MoyAlgo.getText().toString());
                    d = Float.parseFloat(MoyStructure.getText().toString());
                    e = Float.parseFloat(MoyLangue.getText().toString());
                    f = Float.parseFloat(MoyPhysique.getText().toString());
                    g = Float.parseFloat(MoyAnalyse.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefTSE.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefStructure.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyStructure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre.getText().toString().isEmpty())
                        && (!MoyAlgo.getText().toString().isEmpty())
                        && (!MoyTSE.getText().toString().isEmpty())
                        && (!MoyLangue.getText().toString().isEmpty())
                        && (!MoyPhysique.getText().toString().isEmpty())
                        && (!MoyAnalyse.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre.getText().toString());
                    c = Float.parseFloat(MoyAlgo.getText().toString());
                    d = Float.parseFloat(MoyTSE.getText().toString());
                    e = Float.parseFloat(MoyLangue.getText().toString());
                    f = Float.parseFloat(MoyPhysique.getText().toString());
                    g = Float.parseFloat(MoyAnalyse.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefStructure.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefTSE.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyAlgo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre.getText().toString().isEmpty())
                        && (!MoyStructure.getText().toString().isEmpty())
                        && (!MoyTSE.getText().toString().isEmpty())
                        && (!MoyLangue.getText().toString().isEmpty())
                        && (!MoyPhysique.getText().toString().isEmpty())
                        && (!MoyAnalyse.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre.getText().toString());
                    c = Float.parseFloat(MoyStructure.getText().toString());
                    d = Float.parseFloat(MoyTSE.getText().toString());
                    e = Float.parseFloat(MoyLangue.getText().toString());
                    f = Float.parseFloat(MoyPhysique.getText().toString());
                    g = Float.parseFloat(MoyAnalyse.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure.getText().toString()))
                            + (d * Integer.parseInt(CoefTSE.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyAlgebre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgo.getText().toString().isEmpty())
                        && (!MoyStructure.getText().toString().isEmpty())
                        && (!MoyTSE.getText().toString().isEmpty())
                        && (!MoyLangue.getText().toString().isEmpty())
                        && (!MoyPhysique.getText().toString().isEmpty())
                        && (!MoyAnalyse.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo.getText().toString());
                    c = Float.parseFloat(MoyStructure.getText().toString());
                    d = Float.parseFloat(MoyTSE.getText().toString());
                    e = Float.parseFloat(MoyLangue.getText().toString());
                    f = Float.parseFloat(MoyPhysique.getText().toString());
                    g = Float.parseFloat(MoyAnalyse.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefAlgebre.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure.getText().toString()))
                            + (d * Integer.parseInt(CoefTSE.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyAnalyse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgo.getText().toString().isEmpty())
                        && (!MoyStructure.getText().toString().isEmpty())
                        && (!MoyTSE.getText().toString().isEmpty())
                        && (!MoyLangue.getText().toString().isEmpty())
                        && (!MoyPhysique.getText().toString().isEmpty())
                        && (!MoyAlgebre.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo.getText().toString());
                    c = Float.parseFloat(MoyStructure.getText().toString());
                    d = Float.parseFloat(MoyTSE.getText().toString());
                    e = Float.parseFloat(MoyLangue.getText().toString());
                    f = Float.parseFloat(MoyPhysique.getText().toString());
                    g = Float.parseFloat(MoyAlgebre.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefAnalyse.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure.getText().toString()))
                            + (d * Integer.parseInt(CoefTSE.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique.getText().toString()))
                            + (g * Integer.parseInt(CoefAlgebre.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS1.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
    }
    private void CalcMoyenneS2(){
        /*Moyfondamentale12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale22.getText().toString().isEmpty())
                        &&(!MoyMethodologie2.getText().toString().isEmpty())
                        &&(!MoyDecouverte2.getText().toString().isEmpty())) {
                    float moyfondamentale11 = Float.parseFloat(s.toString());
                    float moyfondamentale21 = Float.parseFloat(Moyfondamentale22.getText().toString());
                    float moyMethodologie1 = Float.parseFloat(MoyMethodologie2.getText().toString());
                    float moyDecouverte1 = Float.parseFloat(MoyDecouverte2.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }

            }
        });
        Moyfondamentale22.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale12.getText().toString().isEmpty())
                        &&(!MoyMethodologie2.getText().toString().isEmpty())
                        &&(!MoyDecouverte2.getText().toString().isEmpty())) {
                    float moyfondamentale21 = Float.parseFloat(s.toString());
                    float moyfondamentale11 = Float.parseFloat(Moyfondamentale12.getText().toString());
                    float moyMethodologie1 = Float.parseFloat(MoyMethodologie2.getText().toString());
                    float moyDecouverte1 = Float.parseFloat(MoyDecouverte2.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }
            }
        });
        MoyMethodologie2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale12.getText().toString().isEmpty())
                        &&(!Moyfondamentale22.getText().toString().isEmpty())
                        &&(!MoyDecouverte2.getText().toString().isEmpty())) {
                    float moyMethodologie1 = Float.parseFloat(s.toString());
                    float moyfondamentale11 = Float.parseFloat(Moyfondamentale12.getText().toString());
                    float moyfondamentale21 = Float.parseFloat(Moyfondamentale22.getText().toString());
                    float moyDecouverte1 = Float.parseFloat(MoyDecouverte2.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }
            }
        });
        MoyDecouverte2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                float Moyenne;
                if ((!s.toString().isEmpty())
                        &&(!Moyfondamentale12.getText().toString().isEmpty())
                        &&(!Moyfondamentale22.getText().toString().isEmpty())
                        &&(!MoyMethodologie2.getText().toString().isEmpty())) {
                    float moyDecouverte1 = Float.parseFloat(s.toString());
                    float moyfondamentale11 = Float.parseFloat(Moyfondamentale12.getText().toString());
                    float moyfondamentale21 = Float.parseFloat(Moyfondamentale22.getText().toString());
                    float moyMethodologie1 = Float.parseFloat(MoyMethodologie2.getText().toString());
                    Moyenne = (moyfondamentale11+moyfondamentale21+moyMethodologie1+moyDecouverte1)/4;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(Moyenne)))));
                }
            }
        });*/
        MoyPhysique2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a,b,c,d,e,f,g,h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())){
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyStructure2.getText().toString());
                    e = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyOPM.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h =Float.parseFloat(MoyProba.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (d * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (e * Integer.parseInt(CoefTIC.getText().toString()))
                            + (f * Integer.parseInt(CoefOPM.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));
                    moyenne = moyenne/18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyOPM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyStructure2.getText().toString());
                    e = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefOPM.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (d * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (e * Integer.parseInt(CoefTIC.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyTIC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyStructure2.getText().toString());
                    e = Float.parseFloat(MoyOPM.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefTIC.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (d * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (e * Integer.parseInt(CoefOPM.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));
                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyStructure2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    e = Float.parseFloat(MoyOPM.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (d * Integer.parseInt(CoefTIC.getText().toString()))
                            + (e * Integer.parseInt(CoefOPM.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));

                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyAlgo2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    e = Float.parseFloat(MoyOPM.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (d * Integer.parseInt(CoefTIC.getText().toString()))
                            + (e * Integer.parseInt(CoefOPM.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));

                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyAlgebre2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())){

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    e = Float.parseFloat(MoyOPM.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (d * Integer.parseInt(CoefTIC.getText().toString()))
                            + (e * Integer.parseInt(CoefOPM.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));

                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyAnalyse2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())){

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    e = Float.parseFloat(MoyOPM.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAlgebre2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefAnalyse2.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (d * Integer.parseInt(CoefTIC.getText().toString()))
                            + (e * Integer.parseInt(CoefOPM.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (h * Integer.parseInt(CoefProba.getText().toString()));

                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
        MoyProba.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moyenne;
                float a, b, c, d, e, f, g, h;
                if ((!s.toString().isEmpty())
                        && (!MoyAlgo2.getText().toString().isEmpty())
                        && (!MoyStructure2.getText().toString().isEmpty())
                        && (!MoyTIC.getText().toString().isEmpty())
                        && (!MoyOPM.getText().toString().isEmpty())
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())){

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    e = Float.parseFloat(MoyOPM.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAlgebre2.getText().toString());
                    h = Float.parseFloat(MoyAnalyse2.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefProba.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo2.getText().toString()))
                            + (c * Integer.parseInt(CoefStructure2.getText().toString()))
                            + (d * Integer.parseInt(CoefTIC.getText().toString()))
                            + (e * Integer.parseInt(CoefOPM.getText().toString()))
                            + (f * Integer.parseInt(CoefPhysique2.getText().toString()))
                            + (g * Integer.parseInt(CoefAlgebre2.getText().toString()))
                            + (h * Integer.parseInt(CoefAnalyse2.getText().toString()));

                    moyenne = moyenne / 18;
                    MoyS2.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moyenne)))));
                }
            }
        });
    }
    private void CalcCreditS1(){
        Creditfondamentale11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS1.getText().toString()) >= 10){
                    CreditS1.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale21.getText().toString().isEmpty())
                            &&(!CreditMethodologie1.getText().toString().isEmpty())
                            &&(!CreditDecouverte1.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale21.getText().toString());
                        int c = Integer.parseInt(CreditMethodologie1.getText().toString());
                        int d = Integer.parseInt(CreditDecouverte1.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS1.setText(String.valueOf(Credit));
                    }
                }
            }
        });
        Creditfondamentale21.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS1.getText().toString()) >= 10){
                    CreditS1.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale11.getText().toString().isEmpty())
                            &&(!CreditMethodologie1.getText().toString().isEmpty())
                            &&(!CreditDecouverte1.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale11.getText().toString());
                        int c = Integer.parseInt(CreditMethodologie1.getText().toString());
                        int d = Integer.parseInt(CreditDecouverte1.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS1.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        CreditMethodologie1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS1.getText().toString()) >= 10){
                    CreditS1.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale11.getText().toString().isEmpty())
                            &&(!Creditfondamentale21.getText().toString().isEmpty())
                            &&(!CreditDecouverte1.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale11.getText().toString());
                        int c = Integer.parseInt(Creditfondamentale21.getText().toString());
                        int d = Integer.parseInt(CreditDecouverte1.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS1.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        CreditDecouverte1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS1.getText().toString()) >= 10){
                    CreditS1.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale11.getText().toString().isEmpty())
                            &&(!Creditfondamentale21.getText().toString().isEmpty())
                            &&(!CreditMethodologie1.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale11.getText().toString());
                        int c = Integer.parseInt(Creditfondamentale21.getText().toString());
                        int d = Integer.parseInt(CreditMethodologie1.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS1.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        MoyS1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(s.toString()) >= 10){
                    CreditS1.setText("30");
                }
            }
        });
    }
    private void CalcCreditS2(){
        Creditfondamentale12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS2.getText().toString()) >= 10){
                    CreditS2.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale22.getText().toString().isEmpty())
                            &&(!CreditMethodologie2.getText().toString().isEmpty())
                            &&(!CreditDecouverte2.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale22.getText().toString());
                        int c = Integer.parseInt(CreditMethodologie2.getText().toString());
                        int d = Integer.parseInt(CreditDecouverte2.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS2.setText(String.valueOf(Credit));
                    }
                }
            }
        });
        Creditfondamentale22.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS2.getText().toString()) >= 10){
                    CreditS2.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale12.getText().toString().isEmpty())
                            &&(!CreditMethodologie2.getText().toString().isEmpty())
                            &&(!CreditDecouverte2.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale12.getText().toString());
                        int c = Integer.parseInt(CreditMethodologie2.getText().toString());
                        int d = Integer.parseInt(CreditDecouverte2.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS2.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        CreditMethodologie2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS2.getText().toString()) >= 10){
                    CreditS2.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale12.getText().toString().isEmpty())
                            &&(!Creditfondamentale22.getText().toString().isEmpty())
                            &&(!CreditDecouverte2.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale12.getText().toString());
                        int c = Integer.parseInt(Creditfondamentale22.getText().toString());
                        int d = Integer.parseInt(CreditDecouverte2.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS2.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        CreditDecouverte2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyS2.getText().toString()) >= 10){
                    CreditS2.setText("30");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!Creditfondamentale12.getText().toString().isEmpty())
                            &&(!Creditfondamentale22.getText().toString().isEmpty())
                            &&(!CreditMethodologie2.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(Creditfondamentale12.getText().toString());
                        int c = Integer.parseInt(Creditfondamentale22.getText().toString());
                        int d = Integer.parseInt(CreditMethodologie2.getText().toString());
                        Credit = (a + b + c + d);
                        CreditS2.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        MoyS2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(s.toString()) >= 10){
                    CreditS2.setText("30");
                }
            }
        });
    }
    private void CalcMoyGeneral(){
        MoyS1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moy;
                if ((!s.toString().isEmpty())
                        && (!MoyS2.getText().toString().isEmpty())) {
                    float moyenne1 = Float.parseFloat(s.toString());
                    float moyenne2 = Float.parseFloat(MoyS2.getText().toString());
                    moy = (moyenne1 + moyenne2) / 2;
                    MoyGeneral.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }
            }
        });
        MoyS2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                float moy;
                if ((!s.toString().isEmpty())
                    && (!MoyS1.getText().toString().isEmpty())) {
                    float moyenne1 = Float.parseFloat(s.toString());
                    float moyenne2 = Float.parseFloat(MoyS1.getText().toString());
                    moy = (moyenne1 + moyenne2) / 2;
                    MoyGeneral.setText(String.valueOf(Float.parseFloat((new DecimalFormat("##.##").format(moy)))));
                }
            }
        });
    }
    private void CalcCreditGeneral(){
        CreditS1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyGeneral.getText().toString()) >= 10){
                    CreditGeneral.setText("60");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!CreditS2.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(CreditS2.getText().toString());
                        Credit = (a + b);
                        CreditGeneral.setText(String.valueOf(Credit));
                    }
                }
            }
        });
        CreditS2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(MoyGeneral.getText().toString()) >= 10){
                    CreditGeneral.setText("60");
                }else{
                    int Credit;
                    if ((!s.toString().isEmpty())
                            &&(!CreditS1.getText().toString().isEmpty())) {
                        int a = Integer.parseInt(s.toString());
                        int b = Integer.parseInt(CreditS1.getText().toString());
                        Credit = (a + b);
                        CreditGeneral.setText(String.valueOf(Credit));
                    }
                }

            }
        });
        MoyGeneral.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (Float.parseFloat(s.toString()) >= 10){
                    CreditGeneral.setText("60");
                }
            }
        });
    }


}