package com.example.exmplolista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Variáveis globais
    private EditText txtItem;
    private Button btAdicionar;
    private ListView lista;

    // Lista de dados e o nosso Adapter customizado
    private ArrayList<String> itens;
    private MeuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Inicializa os componentes do XML
        txtItem = findViewById(R.id.txtItem);
        btAdicionar = findViewById(R.id.btAdicionar);
        lista = findViewById(R.id.lista);

        // Ajuste automático de bordas (System Bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. Prepara os dados iniciais
        itens = new ArrayList<>();
        itens.add("Notebook");
        itens.add("Mouse");
        itens.add("Teclado");

        // 3. Configura o NOSSO adapter (MeuAdapter)
        adapter = new MeuAdapter(this, itens);
        lista.setAdapter(adapter);

        // 4. Lógica do botão adicionar
        btAdicionar.setOnClickListener(v -> {
            String novoItem = txtItem.getText().toString().trim();

            if (!novoItem.isEmpty()) {
                itens.add(novoItem);          // Adiciona na lista
                adapter.notifyDataSetChanged(); // Atualiza o visual
                txtItem.setText("");          // Limpa o campo
                txtItem.requestFocus();       // Volta o teclado para o campo
            } else {
                Toast.makeText(this, "Digite algo primeiro!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}