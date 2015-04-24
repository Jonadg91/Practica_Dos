package com.jonathanduque.formulario_registro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText eNombre =(EditText)findViewById(R.id.eName);
        final EditText eCorreo = (EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono=(EditText) findViewById(R.id.eTelefono);
        final TextView tNombre= (TextView) findViewById(R.id.tName);
        final TextView tCorreo = (TextView) findViewById(R.id.tCorreo);
        final TextView tTelefono = (TextView) findViewById(R.id.tTelefono);
        final TextView tGenero=(TextView) findViewById(R.id.tGenero);
        final TextView tCuidad=(TextView) findViewById(R.id.tCuidad);
        final TextView tHobbies=(TextView) findViewById(R.id.tHobbies);
        final TextView tFecha=(TextView) findViewById(R.id.tFecha);

        final RadioButton rFemenino=(RadioButton) findViewById(R.id.rFemenino);
        final RadioButton rMasculino=(RadioButton) findViewById(R.id.rMasculino);
        final Spinner sCities= (Spinner) findViewById(R.id.scities);

        final CheckBox cEstudiar= (CheckBox) findViewById(R.id.cEstudiar);
        final CheckBox cDeporte= (CheckBox) findViewById(R.id.cDeporte);
        final CheckBox cRumbiar= (CheckBox) findViewById(R.id.cRumbiar);
        final CheckBox cComer= (CheckBox) findViewById(R.id.cComer);

        final DatePicker date=(DatePicker) findViewById(R.id.date);

        Button boton= (Button) findViewById(R.id.boton);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Hobbies="";
                tNombre.setText(eNombre.getText());
                tCorreo.setText(eCorreo.getText());
                tTelefono.setText(eTelefono.getText());

                int year = date.getYear();//solo con esot basta para obteer la fecha
                int month = date.getMonth();
                int day = date.getDayOfMonth();

                if(rFemenino.isChecked())
                    tGenero.setText("Femenino");
                else if (rMasculino.isChecked())
                    tGenero.setText("Masculino");
                else
                    tGenero.setText("Seleccione Genero");

                tCuidad.setText(sCities.getSelectedItem().toString());

                if (cEstudiar.isChecked()){
                   Hobbies="Estudiar ";
                }
                if (cDeporte.isChecked()){
                    Hobbies+="Deporte ";
                }
                if (cRumbiar.isChecked()){
                    Hobbies+="Rumbiar ";
                }
                if (cComer.isChecked()){
                    Hobbies+="Comer ";
                }

                tHobbies.setText(Hobbies);
                tFecha.setText(year+" "+month+" "+day);

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
