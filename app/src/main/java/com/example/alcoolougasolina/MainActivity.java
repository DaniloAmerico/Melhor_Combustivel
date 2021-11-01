package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool      = findViewById(R.id.editAlcool);
        editGasolina    = findViewById(R.id.editGasolina);
        textResultado   = findViewById(R.id.textResultado);


    }
    public void calcularPreco(View view){
    String precoAlcool = editAlcool.getText().toString();
    String precoGasolina = editGasolina.getText().toString();

    //Validar dados
        boolean camposValidados = validarCampos(precoAlcool,precoGasolina);
        if ( camposValidados ){
            //Converter String para int
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            if((valorAlcool/valorGasolina) >= 0.7){
                textResultado.setText("Melhor utilizar gasolina");
            }else {textResultado.setText("Melhor utilizar álcool");}


        }else {
            textResultado.setText("Preencha os campos primeiro!");
        }

    }
    public boolean validarCampos(String pAlcool, String pGasolina){
    boolean camposValidados = true;
    String campo = "Preenchido";

    if (pAlcool == null || pAlcool.equals("")){
        camposValidados = false;

    }else if (pGasolina == null || pAlcool.equals("")){
        camposValidados = false;
    }

    return camposValidados;

    }
}
