package com.example.exmplolista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; // Importante para o parent
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MeuAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> itens; // Usamos ArrayList em vez de ArrayAdapter aqui dentro

    public MeuAdapter(@NonNull Context context, ArrayList<String> itens) {
        // R.layout.item_lista é o arquivo que você criou antes
        super(context, R.layout.item_lista, itens);
        this.context = context;
        this.itens = itens;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View linha = convertView;

        // 1. Infla o layout apenas se a linha ainda não existir
        if (linha == null) {
            linha = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        }

        // 2. Pega o texto da tarefa atual
        String item = itens.get(position);

        // 3. Liga os componentes do XML (item_lista.xml)
        // Nota: Use o ID exato que colocamos no seu XML anterior
        TextView txtItem = linha.findViewById(R.id.txtTarefaTitulo);
        TextView txtSubtitulo = linha.findViewById(R.id.txtTarefaSubtitulo);

        // 4. Define o texto na tela
        txtItem.setText(item);
        txtSubtitulo.setText("Toque para remover");

        // 5. Lógica para remover o item ao clicar na linha
        linha.setOnClickListener(v -> {
            itens.remove(position);
            notifyDataSetChanged(); // Avisa a lista que os dados mudaram
            Toast.makeText(context, "Removido: " + item, Toast.LENGTH_SHORT).show();
        });

        return linha;
    }
}