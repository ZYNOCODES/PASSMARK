package com.example.passmark;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ThirdyearInfoSIQFragment extends Fragment {
    private View view;
    private EditText ExamenSE,TdSE,TpSE,ExamenCompil,TdCompil,TpCompil,ExamenGL,TpGL,TdGL
            ,ExamenIHM,TdIHM,TpIHM,ExamenPL,TdPL,ExamenProba,TdProba,ExamenECONUM
            ,ExamenAPP,TpAPP,ExamenSSI,TdSSI,ExamenAI,TpAI,ExamenDSS,TpDSS
            ,ExamenProjet,TdRS,ExamenStartup;
    private TextView MoyAnalyse,MoyAnalyse2,MoyAlgebre,MoyAlgebre2,MoyAlgo,MoyAlgo2,MoyStructure,MoyStructure2,
            MoyTSE,MoyTIC,MoyLangue,MoyPhysique,MoyPhysique2,MoyProba,
            CoefSE,CoefCompil,CoefGL,CoefIHM,CoefPL,CoefProba,CoefECONUM
            ,CoefAPP,CoefSSI,CoefAI,CoefDSS,CoefProjet,CoefRS,CoefStartup,
            CreditSE,CreditCompil,CreditGL,CreditIHM,CreditPL,CreditProba,CreditECONUM
            ,CreditAPP,CreditSSI,CreditAI,CreditDSS,CreditProjet,CreditRS,CreditStartup,
            Moyfondamentale11,Moyfondamentale12,Moyfondamentale21,Moyfondamentale22,
            MoyMethodologie1,MoyMethodologie2,MoyDecouverte1,MoyDecouverte2,
            Creditfondamentale11,Creditfondamentale12,Creditfondamentale21,Creditfondamentale22,
            CreditMethodologie1,CreditMethodologie2,CreditDecouverte1,CreditDecouverte2,
            MoyS1,MoyS2,CreditS1,CreditS2,MoyGeneral,CreditGeneral;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thirdyear_info_s_i_q, container, false);
        InisializationOfFields();

        //semestre 5

        Moyenne(MoyAnalyse,ExamenSE,TdSE,TpSE);
        Moyenne(MoyAlgo,ExamenCompil,TdCompil,TpCompil);
        MoyenneUnite(Moyfondamentale11,MoyAnalyse,CoefSE,MoyAlgo,CoefCompil);
        CreditObtenu(Creditfondamentale11,MoyAnalyse,CreditSE,MoyAlgo,CreditCompil);

        Moyenne(MoyAlgebre,ExamenGL,TdGL,TpGL);
        Moyenne(MoyStructure,ExamenIHM,TdIHM,TpIHM);
        MoyenneUnite(Moyfondamentale21,MoyAlgebre,CoefGL,MoyStructure,CoefIHM);
        CreditObtenu(Creditfondamentale21,MoyAlgebre,CreditGL,MoyStructure,CreditIHM);

        Moyenne(MoyTSE,ExamenPL,TdPL);
        Moyenne(MoyPhysique,ExamenProba,TdProba);
        MoyenneUnite(MoyMethodologie1,MoyTSE,CoefPL,MoyPhysique,CoefProba);
        CreditObtenu(CreditMethodologie1,MoyTSE,CreditPL,MoyPhysique,CreditProba);

        Moyenne(MoyLangue,ExamenECONUM);
        MoyenneUnite(MoyDecouverte1,MoyLangue,CoefECONUM);
        CreditObtenu(CreditDecouverte1,MoyLangue,CreditECONUM);

        CalcMoyenneS1();
        CalcCreditS1();

        //semestre 6

        Moyenne(MoyAnalyse2,ExamenAPP,TpAPP);
        Moyenne(MoyAlgebre2,ExamenSSI,TdSSI);
        MoyenneUnite(Moyfondamentale12,MoyAnalyse2,CoefAPP,MoyAlgebre2,CoefSSI);
        CreditObtenu(Creditfondamentale12,MoyAnalyse2,CreditAPP,MoyAlgebre2,CreditSSI);

        Moyenne(MoyAlgo2,ExamenAI,TpAI);
        Moyenne(MoyStructure2,ExamenDSS,TpDSS);
        MoyenneUnite(Moyfondamentale22,MoyAlgo2,CoefAI,MoyStructure2,CoefDSS);
        CreditObtenu(Creditfondamentale22,MoyAlgo2,CreditAI,MoyStructure2,CreditDSS);

        Moyenne(MoyProba,ExamenProjet);
        Moyenne(MoyTIC,TdRS);
        MoyenneUnite(MoyMethodologie2,MoyTIC,CoefProjet,MoyProba,CoefRS);
        CreditObtenu(CreditMethodologie2,MoyTIC,CreditProjet,MoyProba,CreditRS);

        Moyenne(MoyPhysique2,ExamenStartup);
        MoyenneUnite(MoyDecouverte2,MoyPhysique2,CoefStartup);
        CreditObtenu(CreditDecouverte2,MoyPhysique2,CreditStartup);

        CalcMoyenneS2();
        CalcCreditS2();

        // moyenne general
        CalcMoyGeneral();

        // credit general
        CalcCreditGeneral();
        return view;
    }
    private void InisializationOfFields(){
        ExamenSE = view.findViewById(R.id.ExamenSE);
        TdSE = view.findViewById(R.id.TdSE);
        TpSE = view.findViewById(R.id.TpSE);
        ExamenCompil = view.findViewById(R.id.ExamenCompil);
        TdCompil = view.findViewById(R.id.TdCompil);
        TpCompil = view.findViewById(R.id.TpCompil);
        ExamenGL = view.findViewById(R.id.ExamenGL);
        TpGL = view.findViewById(R.id.TpGL);
        TdGL = view.findViewById(R.id.TdGL);
        ExamenIHM = view.findViewById(R.id.ExamenIHM);
        TdIHM = view.findViewById(R.id.TdIHM);
        TpIHM = view.findViewById(R.id.TpIHM);
        ExamenPL = view.findViewById(R.id.ExamenPL);
        TdPL = view.findViewById(R.id.TdPL);
        ExamenProba = view.findViewById(R.id.ExamenProba);
        TdProba = view.findViewById(R.id.TdProba);
        ExamenECONUM = view.findViewById(R.id.ExamenECONUM);

        ExamenAPP = view.findViewById(R.id.ExamenAPP);
        TpAPP = view.findViewById(R.id.TpAPP);
        ExamenSSI = view.findViewById(R.id.ExamenSSI);
        TdSSI = view.findViewById(R.id.TdSSI);
        ExamenAI = view.findViewById(R.id.ExamenAI);
        TpAI = view.findViewById(R.id.TpAI);
        ExamenDSS = view.findViewById(R.id.ExamenDSS);
        TpDSS = view.findViewById(R.id.TpDSS);
        ExamenProjet = view.findViewById(R.id.ExamenProjet);
        TdRS = view.findViewById(R.id.TdRS);
        ExamenStartup = view.findViewById(R.id.ExamenStartup);

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

        CoefCompil = view.findViewById(R.id.CoefCompil);
        CoefGL = view.findViewById(R.id.CoefGL);
        CoefIHM = view.findViewById(R.id.CoefIHM);
        CoefProba = view.findViewById(R.id.CoefProba);
        CoefPL = view.findViewById(R.id.CoefPL);
        CoefECONUM = view.findViewById(R.id.CoefECONUM);
        CoefAPP = view.findViewById(R.id.CoefAPP);
        CoefSSI = view.findViewById(R.id.CoefSSI);
        CoefAI = view.findViewById(R.id.CoefAI);
        CoefDSS = view.findViewById(R.id.CoefDSS);
        CoefProjet = view.findViewById(R.id.CoefProjet);
        CoefRS = view.findViewById(R.id.CoefRS);
        CoefStartup = view.findViewById(R.id.CoefStartup);
        CoefSE = view.findViewById(R.id.CoefSE);

        CreditCompil = view.findViewById(R.id.CreditCompil);
        CreditGL = view.findViewById(R.id.CreditGL);
        CreditIHM = view.findViewById(R.id.CreditIHM);
        CreditSE = view.findViewById(R.id.CreditSE);
        CreditPL = view.findViewById(R.id.CreditPL);
        CreditProba = view.findViewById(R.id.CreditProba);
        CreditECONUM = view.findViewById(R.id.CreditECONUM);
        CreditAPP = view.findViewById(R.id.CreditAPP);
        CreditSSI = view.findViewById(R.id.CreditSSI);
        CreditAI = view.findViewById(R.id.CreditAI);
        CreditDSS = view.findViewById(R.id.CreditDSS);
        CreditProjet = view.findViewById(R.id.CreditProjet);
        CreditRS = view.findViewById(R.id.CreditRS);
        CreditStartup = view.findViewById(R.id.CreditStartup);

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
    private float CalcModuleMoy(TextView Examen, Editable Td){
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
                    moyenne = (a * Integer.parseInt(CoefProba.getText().toString()))
                            + (b * Integer.parseInt(CoefCompil.getText().toString()))
                            + (c * Integer.parseInt(CoefGL.getText().toString()))
                            + (d * Integer.parseInt(CoefIHM.getText().toString()))
                            + (e * Integer.parseInt(CoefPL.getText().toString()))
                            + (f * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()));
                    moyenne = moyenne/ 17;
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
                    moyenne = (a * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (b * Integer.parseInt(CoefCompil.getText().toString()))
                            + (c * Integer.parseInt(CoefGL.getText().toString()))
                            + (d * Integer.parseInt(CoefIHM.getText().toString()))
                            + (e * Integer.parseInt(CoefPL.getText().toString()))
                            + (f * Integer.parseInt(CoefProba.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()));
                    moyenne = moyenne / 17;
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
                    moyenne = (a * Integer.parseInt(CoefPL.getText().toString()))
                            + (b * Integer.parseInt(CoefCompil.getText().toString()))
                            + (c * Integer.parseInt(CoefGL.getText().toString()))
                            + (d * Integer.parseInt(CoefIHM.getText().toString()))
                            + (e * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (f * Integer.parseInt(CoefProba.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()));
                    moyenne = moyenne / 17;
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
                    moyenne = (a * Integer.parseInt(CoefIHM.getText().toString()))
                            + (b * Integer.parseInt(CoefCompil.getText().toString()))
                            + (c * Integer.parseInt(CoefGL.getText().toString()))
                            + (d * Integer.parseInt(CoefPL.getText().toString()))
                            + (e * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (f * Integer.parseInt(CoefProba.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()));
                    moyenne = moyenne / 17;
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
                    moyenne = (a * Integer.parseInt(CoefGL.getText().toString()))
                            + (b * Integer.parseInt(CoefCompil.getText().toString()))
                            + (c * Integer.parseInt(CoefIHM.getText().toString()))
                            + (d * Integer.parseInt(CoefPL.getText().toString()))
                            + (e * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (f * Integer.parseInt(CoefProba.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()));
                    moyenne = moyenne / 17;
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
                    moyenne = (a * Integer.parseInt(CoefCompil.getText().toString()))
                            + (b * Integer.parseInt(CoefGL.getText().toString()))
                            + (c * Integer.parseInt(CoefIHM.getText().toString()))
                            + (d * Integer.parseInt(CoefPL.getText().toString()))
                            + (e * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (f * Integer.parseInt(CoefProba.getText().toString()))
                            + (g * Integer.parseInt(CoefSE.getText().toString()));
                    moyenne = moyenne / 17;
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
                    moyenne = (a * Integer.parseInt(CoefSE.getText().toString()))
                            + (b * Integer.parseInt(CoefGL.getText().toString()))
                            + (c * Integer.parseInt(CoefIHM.getText().toString()))
                            + (d * Integer.parseInt(CoefPL.getText().toString()))
                            + (e * Integer.parseInt(CoefECONUM.getText().toString()))
                            + (f * Integer.parseInt(CoefProba.getText().toString()))
                            + (g * Integer.parseInt(CoefCompil.getText().toString()));
                    moyenne = moyenne / 17;
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
                float a,b,c,d,e,g,h;
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
                    moyenne = (a * Integer.parseInt(CoefStartup.getText().toString()))
                            + (b * Integer.parseInt(CoefSSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAI.getText().toString()))
                            + (d * Integer.parseInt(CoefDSS.getText().toString()))
                            + (e * Integer.parseInt(CoefRS.getText().toString()))
                            + (g * Integer.parseInt(CoefAPP.getText().toString()))
                            + (h * Integer.parseInt(CoefProjet.getText().toString()));
                    moyenne = moyenne/17;
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
                float a, b, c, d, f, g, h;
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
                    moyenne = (a * Integer.parseInt(CoefRS.getText().toString()))
                            + (b * Integer.parseInt(CoefSSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAI.getText().toString()))
                            + (d * Integer.parseInt(CoefDSS.getText().toString()))
                            + (f * Integer.parseInt(CoefStartup.getText().toString()))
                            + (g * Integer.parseInt(CoefAPP.getText().toString()))
                            + (h * Integer.parseInt(CoefProjet.getText().toString()));
                    moyenne = moyenne / 17;
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

                    moyenne = (a * Integer.parseInt(CoefDSS.getText().toString()))
                            + (b * Integer.parseInt(CoefSSI.getText().toString()))
                            + (c * Integer.parseInt(CoefAI.getText().toString()))
                            + (d * Integer.parseInt(CoefRS.getText().toString()))
                            + (f * Integer.parseInt(CoefStartup.getText().toString()))
                            + (g * Integer.parseInt(CoefAPP.getText().toString()))
                            + (h * Integer.parseInt(CoefProjet.getText().toString()));

                    moyenne = moyenne / 17;
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

                    moyenne = (a * Integer.parseInt(CoefAI.getText().toString()))
                            + (b * Integer.parseInt(CoefSSI.getText().toString()))
                            + (c * Integer.parseInt(CoefDSS.getText().toString()))
                            + (d * Integer.parseInt(CoefRS.getText().toString()))
                            + (f * Integer.parseInt(CoefStartup.getText().toString()))
                            + (g * Integer.parseInt(CoefAPP.getText().toString()))
                            + (h * Integer.parseInt(CoefProjet.getText().toString()));

                    moyenne = moyenne / 17;
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

                    moyenne = (a * Integer.parseInt(CoefSSI.getText().toString()))
                            + (b * Integer.parseInt(CoefAI.getText().toString()))
                            + (c * Integer.parseInt(CoefDSS.getText().toString()))
                            + (d * Integer.parseInt(CoefRS.getText().toString()))
                            + (f * Integer.parseInt(CoefStartup.getText().toString()))
                            + (g * Integer.parseInt(CoefAPP.getText().toString()))
                            + (h * Integer.parseInt(CoefProjet.getText().toString()));

                    moyenne = moyenne / 17;
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

                    moyenne = (a * Integer.parseInt(CoefAPP.getText().toString()))
                            + (b * Integer.parseInt(CoefAI.getText().toString()))
                            + (c * Integer.parseInt(CoefDSS.getText().toString()))
                            + (d * Integer.parseInt(CoefRS.getText().toString()))
                            + (f * Integer.parseInt(CoefStartup.getText().toString()))
                            + (g * Integer.parseInt(CoefSSI.getText().toString()))
                            + (h * Integer.parseInt(CoefProjet.getText().toString()));

                    moyenne = moyenne / 17;
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

                    moyenne = (a * Integer.parseInt(CoefProjet.getText().toString()))
                            + (b * Integer.parseInt(CoefAI.getText().toString()))
                            + (c * Integer.parseInt(CoefDSS.getText().toString()))
                            + (d * Integer.parseInt(CoefRS.getText().toString()))
                            + (f * Integer.parseInt(CoefStartup.getText().toString()))
                            + (g * Integer.parseInt(CoefSSI.getText().toString()))
                            + (h * Integer.parseInt(CoefAPP.getText().toString()));

                    moyenne = moyenne / 17;
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