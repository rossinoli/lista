package com.example.exmplolista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private EditText txtItem;
private Button btAdicionar;
private ListView lista;
ArrayAdapter<String> adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtItem = findViewById(R.id.txtItem);
        btAdicionar= findViewById(R.id.btAdicionar);
        lista = findViewById(R.id.lista);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        itens = new ArrayList<>();
        itens.add("Notebook");
        itens.add("Mouse");
        itens.add("Teclado");

        adapter = new MenuAdapter(this, item);
        lista.setAdapter(adapter);


        btAdicionar.setOnClickListener(v->{
            String novoItem = txtItem.getText().toString().trim();
            if (!novoItem.isEmpty()){
                itens.add(novoItem);
                adapter.notifyDataSetChanged();
                txtItem.setText("");
            }
        });
    }
}