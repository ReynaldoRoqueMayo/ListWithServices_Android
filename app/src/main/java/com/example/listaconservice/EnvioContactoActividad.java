package com.example.listaconservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listaconservice.Servicios.ContactServices;
import com.example.listaconservice.adapters.adapterContactos;
import com.example.listaconservice.entidades.Contacto;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EnvioContactoActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_contacto_actividad);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://webhook.site/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactServices servicio = retrofit.create(ContactServices.class);

        //Enviar nombre de un contacto  al solo iniciar la app

        Call<Void> enviarParametro= servicio.enviarNombre("Alexito");

        enviarParametro.enqueue(new Callback<Void>()

                               {
                                   @Override
                                   public void onResponse(Call<Void> call, Response<Void> response) {


                                   }

                                   @Override
                                   public void onFailure(Call<Void> call, Throwable t) {

                                   }
                               }
        );











        //Enviar contacto al hacer click con los datos del form




        Button btn = findViewById(R.id.btnEnviar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtname=findViewById(R.id.edtNombre);
                EditText edtnumero=findViewById(R.id.edtNumero);


                int num=Integer.parseInt(edtnumero.getText().toString());

                Contacto contacto= new Contacto(edtname.getText().toString(), num);
                Call<Void> enviarContacto= servicio.enviarContacto(contacto);

                enviarContacto.enqueue(new Callback<Void>()

                                       {
                                           @Override
                                           public void onResponse(Call<Void> call, Response<Void> response) {

                                           }

                                           @Override
                                           public void onFailure(Call<Void> call, Throwable t) {

                                           }
                                       }
                );


            }
        });





    }
}