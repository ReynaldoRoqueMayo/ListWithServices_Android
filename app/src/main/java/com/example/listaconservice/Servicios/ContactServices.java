package com.example.listaconservice.Servicios;

import com.example.listaconservice.entidades.Contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ContactServices {


    //url sin el dominio
    @GET("v3/6db1ba36-ff2a-4672-8d4b-9aab2832defe")          //metodo que voy a usar puede ser GET,PUT,POST,DELETE
    Call<List<Contacto>> obtenerTodo();
    //Call es el metodo generico de retrofit,en este caso vamos a obtener una lista de objetos con datos que en nuestro
    //caso es recibido en una clase llamada Contacto,tambien podriamos solo recibir un objeto.
    //luego creamos el metodo con un nombre en este caso obtenerTodo y sin ninguna parametro,pero si desearamos
    //podriamos agregar un paramatro que nos permita regresar un especifico objeto

//con este metodo enviaremos parametros get por la url

    @GET("5733dec5-a156-464d-8b98-0356991e53e7")
    Call<Void> enviarNombre(@Query("nombre") String nombre);



    @POST("5733dec5-a156-464d-8b98-0356991e53e7")          //decorados con POST al metodo para eviar datos,tambien con @Body en este caso no recibimos nada
    Call<Void> enviarContacto(@Body Contacto contacto);

}
