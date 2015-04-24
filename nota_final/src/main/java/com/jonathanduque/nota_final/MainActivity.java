package com.jonathanduque.nota_final;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eQuices=(EditText) findViewById(R.id.eQuices);
        final EditText eExpo=(EditText) findViewById(R.id.eExpo);
        final EditText eLab=(EditText) findViewById(R.id.eLab);
        final EditText eProyec=(EditText) findViewById(R.id.eProyec);
        final TextView tNotaFinal=(TextView) findViewById(R.id.tNotaFinal);
        Button bBoton = (Button) findViewById(R.id.boton);

        bBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota1= eQuices.getText().toString();
                String nota4= eExpo.getText().toString();
                String nota2= eLab.getText().toString();
                String nota3= eProyec.getText().toString();

                String NotaFinal;

                if (nota1.matches("") || nota2.matches("") || nota3.matches("") || nota4.matches("") ){
                    NotaFinal= getResources().getString(R.string.campos_vacios);
                }
                else {
                    float n1=Float.parseFloat(nota1);
                    float n2=Float.parseFloat(nota2);
                    float n3=Float.parseFloat(nota3);
                    float n4=Float.parseFloat(nota4);
                    NotaFinal=String.valueOf(n1*0.15+n2*0.1+n3*0.4+n4*0.35);
                }
                tNotaFinal.setText(NotaFinal);

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
