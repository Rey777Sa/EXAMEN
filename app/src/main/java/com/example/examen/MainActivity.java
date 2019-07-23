package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
        Button calcular, borrar;
        Switch suma, resta, multiplicacion, division;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            calcular = (Button) findViewById(R.id.b1);
            borrar = (Button) findViewById(R.id.b2);
            suma = (Switch) findViewById(R.id.sw1);
            resta = (Switch) findViewById(R.id.sw2);
            multiplicacion = (Switch) findViewById(R.id.sw3);
            division = (Switch) findViewById(R.id.sw4);
            final EditText valoruno = (EditText) findViewById(R.id.et1);
            final EditText valordos = (EditText) findViewById(R.id.et2);

            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String num1 = valoruno.getText().toString();
                    String num2 = valordos.getText().toString();
                    Double resultado;
                    String mostrar;

                    if (valoruno.length() == 0 && valordos.length() != 0) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                        alerta.setMessage("Introducir valor 1").setNegativeButton("Aceptar", null).create().show();

                    }
                    if (valordos.length() == 0 && valoruno.length() != 0) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                        alerta.setMessage("Introducir valor 2").setNegativeButton("Aceptar", null).create().show();

                    }
                    if (valordos.length() == 0 && valoruno.length() == 0) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                        alerta.setMessage("Introducir los valores").setNegativeButton("Aceptar", null).create().show();

                    }


                    if (valoruno.length() != 0 && valordos.length() != 0) {
                        Double numero1 = Double.parseDouble(num1);
                        Double numero2 = Double.parseDouble(num2);
                        if (suma.isChecked() == true) {
                            resultado = numero1 + numero2;
                            mostrar = resultado.toString();
                            Toast.makeText(getApplicationContext(), "La suma es " + mostrar, Toast.LENGTH_LONG).show();
                        }
                        if (resta.isChecked() == true) {
                            resultado = numero1 - numero2;
                            mostrar = resultado.toString();
                            Toast.makeText(getApplicationContext(), "La resta es " + mostrar, Toast.LENGTH_LONG).show();
                        }
                        if (multiplicacion.isChecked() == true) {
                            resultado = numero1 * numero2;
                            mostrar = resultado.toString();
                            Toast.makeText(getApplicationContext(), "La multiplicacion es " + mostrar, Toast.LENGTH_LONG).show();
                        }
                        if (division.isChecked() == true) {
                            resultado = numero1 / numero2;
                            mostrar = resultado.toString();
                            Toast.makeText(getApplicationContext(), "La division es " + mostrar, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valordos.setText("");
                    valoruno.setText("");
                    suma.setChecked(false);
                    resta.setChecked(false);
                    multiplicacion.setChecked(false);
                    division.setChecked(false);
                }
            });

        }
    }

