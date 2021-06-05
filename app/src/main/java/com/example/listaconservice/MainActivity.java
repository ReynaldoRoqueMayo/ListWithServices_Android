package com.example.listaconservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


import com.example.listaconservice.Servicios.ContactServices;
import com.example.listaconservice.adapters.adapterContactos;
import com.example.listaconservice.entidades.Contacto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //INSTANCIAMOS RETROFIT
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //con retrofit generamos una implementacion de nuestro interfaz de la API
        ContactServices servicio = retrofit.create(ContactServices.class);


        //con cada Call podemos generar una solicitud HTTP asincronica(no interrumpimos funcionalidad) o sincronica
        Call<List<Contacto>> llamadoContactos= servicio.obtenerTodo();

        //indicamos que nuestro llamado es sincrona,lo indicamos con enqueue el cual recibe
        //un interfaz que pide la implementacion de un interfaz,en el cual indicaremos lo que
        //queremos que suceda luego de la espera del llamado del service,y tambien se podra
        //hacer algo cuando algo falle
        llamadoContactos.enqueue(new Callback<List<Contacto>>() {
            @Override
            public void onResponse(Call<List<Contacto>> call, Response<List<Contacto>> response) {

                if(response.code()!=200){
                    return;
                }

                    RecyclerView rv = findViewById(R.id.rvContactos);

                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                    adapterContactos contactoAdapter = new adapterContactos(response.body());

                    rv.setAdapter(contactoAdapter);


            }

            @Override
            public void onFailure(Call<List<Contacto>> call, Throwable t) {

            }
        });





    }
    public List<Contacto> obtenerLista(){

        List<Contacto> contactos= new ArrayList<>();

        Contacto contacto1 = new Contacto("Rey",991619194);
        Contacto contacto2 = new Contacto("Juan",995815478);
        Contacto contacto3 = new Contacto("Maria",784578452);
        Contacto contacto4 = new Contacto("Rosa",987412364);
        Contacto contacto5 = new Contacto("Estefan",984562145);

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);
        contactos.add(contacto4);
        contactos.add(contacto5);



        return contactos;
    }

}