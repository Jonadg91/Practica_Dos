package com.jonathanduque.operaciones;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNum1=(EditText) findViewById(R.id.eNum1);
        final EditText eNum2=(EditText) findViewById(R.id.eNum2);
        final TextView tResultado=(TextView) findViewById(R.id.tResultado);
        Button bCalcular= (Button) findViewById(R.id.bCalcular);
        final RadioButton rSuma=(RadioButton) findViewById(R.id.rSuma);
        final RadioButton rResta=(RadioButton) findViewById(R.id.rResta);
        final RadioButton rDivision=(RadioButton) findViewById(R.id.rDivision);
        final RadioButton rMultiplicaicion=(RadioButton) findViewById(R.id.rMultiplicacion);


        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor1= eNum1.getText().toString();
                String valor2= eNum2.getText().toString();

                String Resu="0";

                if (valor1.matches("") ||  valor2.matches("") ){
                    Resu=getResources().getString(R.string.campos_vacios);//para poner avisos solo referenciando el string, sin importar idioma
                }
                else {
                    float Num1=Float.parseFloat(valor1);
                    float Num2=Float.parseFloat(valor2);

                    if(rSuma.isChecked()){
                        Resu=String.valueOf(Num1+Num2);
                    }
                    else if (rResta.isChecked()){
                        Resu=String.valueOf(Num1-Num2);
                    }
                    else if (rDivision.isChecked()){
                        Resu=String.valueOf(Num1/Num2);
                    }
                    else if (rMultiplicaicion.isChecked()){
                        Resu=String.valueOf(Num1*Num2);
                    }
                    else
                        Resu=getResources().getString(R.string.sin_operacion);
                }
                tResultado.setText(Resu);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
