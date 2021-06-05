package com.example.listaconservice.adapters;




import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import androidx.recyclerview.widget.RecyclerView;


import com.example.listaconservice.R;
import com.example.listaconservice.entidades.Contacto;

import java.util.List;


public class adapterContactos  extends RecyclerView.Adapter<adapterContactos.adapterContactosHolder> {


    List<Contacto> listaContact;


    public adapterContactos(List<Contacto> listaContact) {
        this.listaContact = listaContact;
    }

    @Override
    public adapterContactosHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false);


        return new adapterContactosHolder(view);
    }

    @Override
    public void onBindViewHolder( adapterContactos.adapterContactosHolder holder, int position) {
        View view =holder.itemView;

        Contacto contacto= listaContact.get(position);

        TextView tvNom=view.findViewById(R.id.tvNombre);
        Log.i("Contacto",tvNom.getText().toString());
        tvNom.setText(contacto.nombre);

        TextView tvNum=view.findViewById((R.id.tvNumero));

        tvNum.setText( String.valueOf(contacto.numero));

        ImageView imv=view.findViewById(R.id.imgContacto);

        imv.setImageResource(R.drawable.sapito);
    }


    @Override
    public int getItemCount() {
        return listaContact.size();
    }


    public class adapterContactosHolder extends RecyclerView.ViewHolder {

        public adapterContactosHolder( View itemView) {
            super(itemView);
        }
    }
}
