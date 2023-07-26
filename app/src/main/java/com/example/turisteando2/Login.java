package com.example.turisteando2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //atributos clase
    EditText cajaNombreUsuario;
    EditText cajaContrasena;

    Button botonIngreso;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        cajaNombreUsuario = findViewById(R.id.usuariocaja);
        cajaContrasena = findViewById(R.id.paswordcaja);
        botonIngreso = findViewById(R.id.botoningresar);

        botonIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //capturando datos de las cajas
                String nombreUsuario = cajaNombreUsuario.getText().toString();
                String contaseñaUsuario = cajaContrasena.getText().toString();

                Intent intent = new Intent(Login.this,Home.class );
                intent.putExtra("nombre",nombreUsuario);
                intent.putExtra("contraseña",contaseñaUsuario);

                startActivity(intent);
            }
        });




    }
}