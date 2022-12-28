package com.example.passmark;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondyearInfoFragment extends Fragment {
    private View view;
    private EditText ExamenArchi,TdArchi,TpArchi,ExamenSI,TdSI,TpSI,ExamenAlgo,TpAlgo,
            TdAlgo,ExamenTG,TdTG,ExamenANUM,TpANUM,ExamenLangue,ExamenLM,TdLM,
            ExamenTL,TdTL,TpTL,ExamenSE,TdSE,TpSE,ExamenBD,TpBD,
            TdBD,ExamenReseaux,TdReseaux,TpReseaux,ExamenDEVWEB,TdDEVWEB,ExamenPOO,TdPOO,ExamenLangue2;
    private TextView MoyAnalyse,MoyAnalyse2,MoyAlgebre,MoyAlgebre2,MoyAlgo,MoyAlgo2,MoyStructure,MoyStructure2,
            MoyTSE,MoyTIC,MoyLangue,MoyPhysique,MoyPhysique2,MoyProba,
            CoefArchi,CoefTL,CoefSI,CoefSE,CoefAlgo,CoefBD,CoefTG,CoefReseaux,
            CoefANUM,CoefDEVWEB,CoefLangue,CoefLangue2,CoefLM,CoefPOO,
            CreditArchi,CreditTL,CreditSI,CreditSE,CreditAlgo,CreditBD,CreditTG,CreditReseaux,
            CreditANUM,CreditDEVWEB,CreditLangue,CreditLM,CreditLangue2,CreditPOO,
            Moyfondamentale11,Moyfondamentale12,Moyfondamentale21,Moyfondamentale22,
            MoyMethodologie1,MoyMethodologie2,MoyDecouverte1,MoyDecouverte2,
            Creditfondamentale11,Creditfondamentale12,Creditfondamentale21,Creditfondamentale22,
            CreditMethodologie1,CreditMethodologie2,CreditDecouverte1,CreditDecouverte2,
            MoyS1,MoyS2,CreditS1,CreditS2,MoyGeneral,CreditGeneral;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_secondyear_info, container, false);
        InisializationOfFields();

        //semestre 3

        Moyenne(MoyAnalyse,ExamenArchi,TdArchi,TpArchi);
        Moyenne(MoyAlgo,ExamenAlgo,TdAlgo,TpAlgo);
        MoyenneUnite(Moyfondamentale11,MoyAnalyse,CoefArchi,MoyAlgo,CoefAlgo);
        CreditObtenu(Creditfondamentale11,MoyAnalyse,CreditArchi,MoyAlgo,CreditAlgo);

        Moyenne(MoyAlgebre,ExamenSI,TdSI,TpSI);
        Moyenne(MoyStructure,ExamenTG,TdTG);
        MoyenneUnite(Moyfondamentale21,MoyAlgebre,CoefSI,MoyStructure,CoefTG);
        CreditObtenu(Creditfondamentale21,MoyAlgebre,CreditSI,MoyStructure,CreditTG);

        Moyenne(MoyTSE,ExamenANUM,TpANUM);
        Moyenne(MoyPhysique,ExamenLM,TdLM);
        MoyenneUnite(MoyMethodologie1,MoyTSE,CoefANUM,MoyPhysique,CoefLM);
        CreditObtenu(CreditMethodologie1,MoyTSE,CreditANUM,MoyPhysique,CreditLM);

        Moyenne(MoyLangue,ExamenLangue);
        MoyenneUnite(MoyDecouverte1,MoyLangue,CoefLangue);
        CreditObtenu(CreditDecouverte1,MoyLangue,CreditLangue);

        CalcMoyenneS1();
        CalcCreditS1();

        //semestre 4

        Moyenne(MoyAnalyse2,ExamenTL,TdTL,TpTL);
        Moyenne(MoyAlgebre2,ExamenSE,TdSE,TpSE);
        MoyenneUnite(Moyfondamentale12,MoyAnalyse2,CoefTL,MoyAlgebre2,CoefSE);
        CreditObtenu(Creditfondamentale12,MoyAnalyse2,CreditTL,MoyAlgebre2,CreditSE);

        Moyenne(MoyAlgo2,ExamenBD,TdBD,TpBD);
        Moyenne(MoyStructure2,ExamenReseaux,TdReseaux,TpReseaux);
        MoyenneUnite(Moyfondamentale22,MoyAlgo2,CoefBD,MoyStructure2,CoefReseaux);
        CreditObtenu(Creditfondamentale22,MoyAlgo2,CreditBD,MoyStructure2,CreditReseaux);

        Moyenne(MoyProba,ExamenPOO,TdPOO);
        Moyenne(MoyTIC,ExamenDEVWEB,TdDEVWEB);
        MoyenneUnite(MoyMethodologie2,MoyTIC,CoefDEVWEB,MoyProba,CoefPOO);
        CreditObtenu(CreditMethodologie2,MoyTIC,CreditDEVWEB,MoyProba,CreditPOO);

        Moyenne(MoyPhysique2,ExamenLangue2);
        MoyenneUnite(MoyDecouverte2,MoyPhysique2,CoefLangue2);
        CreditObtenu(CreditDecouverte2,MoyPhysique2,CreditLangue2);

        CalcMoyenneS2();
        CalcCreditS2();

        // moyenne general
        CalcMoyGeneral();

        // credit general
        CalcCreditGeneral();
        return view;
    }
    private void InisializationOfFields(){
        ExamenArchi = view.findViewById(R.id.ExamenArchi);
        TdArchi = view.findViewById(R.id.TdArchi);
        TpArchi = view.findViewById(R.id.TpArchi);
        ExamenSI = view.findViewById(R.id.ExamenSI);
        TdSI = view.findViewById(R.id.TdSI);
        TpSI = view.findViewById(R.id.TpSI);
        ExamenAlgo = view.findViewById(R.id.ExamenAlgo);
        TpAlgo = view.findViewById(R.id.TpAlgo);
        TdAlgo = view.findViewById(R.id.TdAlgo);
        ExamenTG = view.findViewById(R.id.ExamenTG);
        TdTG = view.findViewById(R.id.TdTG);
        ExamenANUM = view.findViewById(R.id.ExamenANUM);
        TpANUM = view.findViewById(R.id.TpANUM);
        ExamenLangue = view.findViewById(R.id.ExamenLangue);
        ExamenLM = view.findViewById(R.id.ExamenLM);
        TdLM = view.findViewById(R.id.TdLM);

        ExamenTL = view.findViewById(R.id.ExamenTL);
        TdTL = view.findViewById(R.id.TdTL);
        TpTL = view.findViewById(R.id.TpTL);
        ExamenSE = view.findViewById(R.id.ExamenSE);
        TdSE = view.findViewById(R.id.TdSE);
        TpSE = view.findViewById(R.id.TpSE);
        ExamenBD = view.findViewById(R.id.ExamenBD);
        TpBD = view.findViewById(R.id.TpBD);
        TdBD = view.findViewById(R.id.TdBD);
        ExamenReseaux = view.findViewById(R.id.ExamenReseaux);
        TdReseaux = view.findViewById(R.id.TdReseaux);
        TpReseaux = view.findViewById(R.id.TpReseaux);
        ExamenDEVWEB = view.findViewById(R.id.ExamenDEVWEB);
        TdDEVWEB = view.findViewById(R.id.TdDEVWEB);
        ExamenLangue2 = view.findViewById(R.id.ExamenLangue2);
        ExamenPOO = view.findViewById(R.id.ExamenPOO);
        TdPOO = view.findViewById(R.id.TdPOO);

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
        MoyLangue = view.findViewById(R.id.MoyLangue);
        MoyPhysique = view.findViewById(R.id.MoyPhysique);
        MoyPhysique2 = view.findViewById(R.id.MoyPhysique2);
        MoyProba = view.findViewById(R.id.MoyProba);

        CoefArchi = view.findViewById(R.id.CoefArchi);
        CoefTL = view.findViewById(R.id.CoefTL);
        CoefSI = view.findViewById(R.id.CoefSI);
        CoefSE = view.findViewById(R.id.CoefSE);
        CoefAlgo = view.findViewById(R.id.CoefAlgo);
        CoefBD = view.findViewById(R.id.CoefBD);
        CoefTG = view.findViewById(R.id.CoefTG);
        CoefReseaux = view.findViewById(R.id.CoefReseaux);
        CoefANUM = view.findViewById(R.id.CoefANUM);
        CoefDEVWEB = view.findViewById(R.id.CoefDEVWEB);
        CoefLangue = view.findViewById(R.id.CoefLangue);
        CoefLM = view.findViewById(R.id.CoefLM);
        CoefLangue2 = view.findViewById(R.id.CoefLangue2);
        CoefPOO = view.findViewById(R.id.CoefPOO);

        CreditArchi = view.findViewById(R.id.CreditArchi);
        CreditTL = view.findViewById(R.id.CreditTL);
        CreditSI = view.findViewById(R.id.CreditSI);
        CreditSE = view.findViewById(R.id.CreditSE);
        CreditAlgo = view.findViewById(R.id.CreditAlgo);
        CreditBD = view.findViewById(R.id.CreditBD);
        CreditTG = view.findViewById(R.id.CreditTG);
        CreditReseaux = view.findViewById(R.id.CreditReseaux);
        CreditANUM = view.findViewById(R.id.CreditANUM);
        CreditDEVWEB = view.findViewById(R.id.CreditDEVWEB);
        CreditLangue = view.findViewById(R.id.CreditLangue);
        CreditLM = view.findViewById(R.id.CreditLM);
        CreditLangue2 = view.findViewById(R.id.CreditLangue2);
        CreditPOO = view.findViewById(R.id.CreditPOO);

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
    private float CalcModuleMoy(Editable Examen, EditText Td){
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
                    moyenne = (a * Integer.parseInt(CoefLM.getText().toString()))
                            + (b * Integer.parseInt(CoefSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefTG.getText().toString()))
                            + (e * Integer.parseInt(CoefANUM.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue.getText().toString()))
                            + (g * Integer.parseInt(CoefArchi.getText().toString()));
                    moyenne = moyenne/ 16;
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
                            + (b * Integer.parseInt(CoefSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefTG.getText().toString()))
                            + (e * Integer.parseInt(CoefANUM.getText().toString()))
                            + (f * Integer.parseInt(CoefLM.getText().toString()))
                            + (g * Integer.parseInt(CoefArchi.getText().toString()));
                    moyenne = moyenne / 16;
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
                    moyenne = (a * Integer.parseInt(CoefANUM.getText().toString()))
                            + (b * Integer.parseInt(CoefSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefTG.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefLM.getText().toString()))
                            + (g * Integer.parseInt(CoefArchi.getText().toString()));
                    moyenne = moyenne / 16;
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
                    moyenne = (a * Integer.parseInt(CoefTG.getText().toString()))
                            + (b * Integer.parseInt(CoefSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (d * Integer.parseInt(CoefANUM.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefLM.getText().toString()))
                            + (g * Integer.parseInt(CoefArchi.getText().toString()));
                    moyenne = moyenne / 16;
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
                            + (b * Integer.parseInt(CoefSI.getText().toString()))
                            + (c * Integer.parseInt(CoefTG.getText().toString()))
                            + (d * Integer.parseInt(CoefANUM.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefLM.getText().toString()))
                            + (g * Integer.parseInt(CoefArchi.getText().toString()));
                    moyenne = moyenne / 16;
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
                    moyenne = (a * Integer.parseInt(CoefSI.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (c * Integer.parseInt(CoefTG.getText().toString()))
                            + (d * Integer.parseInt(CoefANUM.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefLM.getText().toString()))
                            + (g * Integer.parseInt(CoefArchi.getText().toString()));
                    moyenne = moyenne / 16;
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
                    moyenne = (a * Integer.parseInt(CoefArchi.getText().toString()))
                            + (b * Integer.parseInt(CoefAlgo.getText().toString()))
                            + (c * Integer.parseInt(CoefTG.getText().toString()))
                            + (d * Integer.parseInt(CoefANUM.getText().toString()))
                            + (e * Integer.parseInt(CoefLangue.getText().toString()))
                            + (f * Integer.parseInt(CoefLM.getText().toString()))
                            + (g * Integer.parseInt(CoefSI.getText().toString()));
                    moyenne = moyenne / 16;
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
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())){
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyStructure2.getText().toString());
                    e = Float.parseFloat(MoyTIC.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h =Float.parseFloat(MoyProba.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (b * Integer.parseInt(CoefSE.getText().toString()))
                            + (c * Integer.parseInt(CoefBD.getText().toString()))
                            + (d * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (e * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (g * Integer.parseInt(CoefTL.getText().toString()))
                            + (h * Integer.parseInt(CoefPOO.getText().toString()));
                    moyenne = moyenne/16;
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
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {
                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyStructure2.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());
                    moyenne = (a * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (b * Integer.parseInt(CoefSE.getText().toString()))
                            + (c * Integer.parseInt(CoefBD.getText().toString()))
                            + (d * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (g * Integer.parseInt(CoefTL.getText().toString()))
                            + (h * Integer.parseInt(CoefPOO.getText().toString()));
                    moyenne = moyenne / 16;
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
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyAlgo2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (b * Integer.parseInt(CoefSE.getText().toString()))
                            + (c * Integer.parseInt(CoefBD.getText().toString()))
                            + (d * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (g * Integer.parseInt(CoefTL.getText().toString()))
                            + (h * Integer.parseInt(CoefPOO.getText().toString()));

                    moyenne = moyenne / 16;
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
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())) {

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgebre2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefBD.getText().toString()))
                            + (b * Integer.parseInt(CoefSE.getText().toString()))
                            + (c * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (d * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (g * Integer.parseInt(CoefTL.getText().toString()))
                            + (h * Integer.parseInt(CoefPOO.getText().toString()));

                    moyenne = moyenne / 16;
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
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())){

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAnalyse2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefSE.getText().toString()))
                            + (b * Integer.parseInt(CoefBD.getText().toString()))
                            + (c * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (d * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (g * Integer.parseInt(CoefTL.getText().toString()))
                            + (h * Integer.parseInt(CoefPOO.getText().toString()));

                    moyenne = moyenne / 16;
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
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyProba.getText().toString().isEmpty())){

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAlgebre2.getText().toString());
                    h = Float.parseFloat(MoyProba.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefTL.getText().toString()))
                            + (b * Integer.parseInt(CoefBD.getText().toString()))
                            + (c * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (d * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()))
                            + (h * Integer.parseInt(CoefPOO.getText().toString()));

                    moyenne = moyenne / 16;
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
                        && (!MoyPhysique2.getText().toString().isEmpty())
                        && (!MoyAlgebre2.getText().toString().isEmpty())
                        && (!MoyAnalyse2.getText().toString().isEmpty())){

                    a = Float.parseFloat(s.toString());
                    b = Float.parseFloat(MoyAlgo2.getText().toString());
                    c = Float.parseFloat(MoyStructure2.getText().toString());
                    d = Float.parseFloat(MoyTIC.getText().toString());
                    f = Float.parseFloat(MoyPhysique2.getText().toString());
                    g = Float.parseFloat(MoyAlgebre2.getText().toString());
                    h = Float.parseFloat(MoyAnalyse2.getText().toString());

                    moyenne = (a * Integer.parseInt(CoefPOO.getText().toString()))
                            + (b * Integer.parseInt(CoefBD.getText().toString()))
                            + (c * Integer.parseInt(CoefReseaux.getText().toString()))
                            + (d * Integer.parseInt(CoefDEVWEB.getText().toString()))
                            + (f * Integer.parseInt(CoefLangue2.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()))
                            + (h * Integer.parseInt(CoefTL.getText().toString()));

                    moyenne = moyenne / 16;
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