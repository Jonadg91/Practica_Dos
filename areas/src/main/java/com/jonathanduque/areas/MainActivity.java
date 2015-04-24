package com.jonathanduque.areas;

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

        final EditText eLado= (EditText) findViewById(R.id.eLado);
        final EditText eAltura= (EditText) findViewById(R.id.eAltura);
        final EditText eBase= (EditText) findViewById(R.id.eBase);
        final EditText eRadio= (EditText) findViewById(R.id.eRadio);

        final RadioButton rCuadro=(RadioButton) findViewById(R.id.rCuadro);
        final RadioButton rTriangulo=(RadioButton) findViewById(R.id.rTriangulo);
        final RadioButton rRectangulo=(RadioButton) findViewById(R.id.rRectangulo);
        final RadioButton rCirculo=(RadioButton) findViewById(R.id.rCirculo);

        Button bArea=(Button) findViewById(R.id.boton);

        final TextView tFigura=(TextView) findViewById(R.id.tFigura);
        final TextView tArea=(TextView) findViewById(R.id.tArea);

        bArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lado= eLado.getText().toString();
                String altura= eAltura.getText().toString();
                String base= eBase.getText().toString();
                String radio= eRadio.getText().toString();
                String Figura, Area;

                if (rCuadro.isChecked() && !lado.matches("") ){
                    float l=Float.parseFloat(lado);
                    Figura="Area Cuadro";
                    Area=String.valueOf(l*l);
                }
                else if (rTriangulo.isChecked() && !altura.matches("") && !base.matches("")){
                    float b=Float.parseFloat(base);
                    float h=Float.parseFloat(altura);
                    Figura="Area Triandulo";
                    Area=String.valueOf(b*h/2);
                }
                else if (rRectangulo.isChecked() && !altura.matches("") && !base.matches("")){
                    float b=Float.parseFloat(base);
                    float h=Float.parseFloat(altura);
                    Figura="Area Rectangulo";
                    Area=String.valueOf(b*h);
                }
                else if (rCirculo.isChecked() && !radio.matches("") ){
                    float r=Float.parseFloat(radio);
                    Figura="Area Circulo";
                    Area=String.valueOf(r*r*3.1416);
                }
                else if(!rCuadro.isChecked() && !rTriangulo.isChecked()&& !rRectangulo.isChecked() && !rCirculo.isChecked()){
                    Figura = "No Ha Seleccionado Figura";
                    Area="";
                }
                else{
                    Figura = "Campos Vacios de la Figura Seleccionada";
                    Area="";
                }

                tFigura.setText(Figura);
                tArea.setText(Area);




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
