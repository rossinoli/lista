package com.example.exmplolista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MeuAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayAdapter<String> itens;

    public MeuAdapter(@NonNull Context context, int resource) {
        super(context, resource:0, itens);
        this.context = context;
        this.itens = itens;
    }

    public View getView(int position, view convertView, View parent){
        View linha = convertView;
        if(linha == null){
            linha = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, attachToRoot false);
        }
        String item = itens.getItem(position);

        TextView txtItem = linha.findViewById(R.id.txtItem);
        ImageView btnExcluir = linha.findViewById(R.id.btnExcluir);

        View.OnClickListener(View v -> {
        itens.remove(position);
        notifyDataSetChanged();
            Toast.makeText(context, text"remove" + item, Toast.LENGTH_SHORT).show();       });
return linha;
}
}