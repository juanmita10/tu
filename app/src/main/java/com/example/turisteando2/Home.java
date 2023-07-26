package com.example.turisteando2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Home extends AppCompatActivity {

    Button buttonhoteles;
    Button buttonrestaurantes;
    Button buttonturismo;

    TextView nombreCliente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String nombre = getIntent().getStringExtra("nombre");

        buttonhoteles=findViewById(R.id.botonhoteles);
        buttonrestaurantes=findViewById(R.id.botonrestaurantes);
        buttonturismo=findViewById(R.id.botonsitios);
        nombreCliente =findViewById(R.id.cliente);

        nombreCliente.setText(nombre);

        buttonhoteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,HotelesHome.class);
                startActivity(intent);
            }
        });
        buttonrestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,RestaurantesHome.class);
                startActivity(intent);
            }
        });

        buttonturismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,TurismoHome.class);
                startActivity(intent);
            }
        });



    }

    public void cambiarIdioma(String idioma){
        Locale lenguaje = new Locale(idioma);
        Locale.setDefault(lenguaje);

        Configuration configuracionTelefono = getResources().getConfiguration();
        configuracionTelefono.locale=lenguaje;

        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());
        


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int itemSelecionado=item.getItemId();
        switch (itemSelecionado){

            case (R.id.opcion1):
                this.cambiarIdioma("en");
                Intent intentIngles=new Intent(Home.this,Home.class);
                startActivity(intentIngles);
                break;
            case (R.id.opcion2):
                this.cambiarIdioma("es");
                Intent intentEspanol=new Intent(Home.this,Home.class);
                startActivity(intentEspanol);

                break;
            case (R.id.opcion3):
            Intent intent = new Intent(Home.this, Acerca.class);
            startActivity(intent);
                break;

            case (R.id.opcion4):
                Intent intent1= new Intent(Home.this, Home.class);
                startActivity(intent1);

        }
        return super.onOptionsItemSelected(item);
    }

    public void cambiarIdioma (){


    }

}