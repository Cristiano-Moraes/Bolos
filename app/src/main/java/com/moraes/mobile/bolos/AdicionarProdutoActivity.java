package com.moraes.mobile.bolos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class AdicionarProdutoActivity extends AppCompatActivity {
    private String[] produtos1 = {"BOLOS SIMPLES","BOLOS RECHEADOS","MINI DOCES","MINI SALGADOS","SOBREMESAS","TORTAS SALGADAS","CEIA DE NATAL"};
    private ListView listvProdutos1;
    private CustomProductAdapter adapterListvProdutos1;
    int tipoProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        listvProdutos1 = findViewById(R.id.listvProdutos);
        adapterListvProdutos1 = new CustomProductAdapter(getApplicationContext(),produtos1);
        listvProdutos1.setAdapter(adapterListvProdutos1);
        listvProdutos1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tipoProduto = position;
                Intent selecionaProduto = new Intent(getApplicationContext(),SelecionaProdutoActivity.class);
                selecionaProduto.putExtra("produtoKey",tipoProduto);
                startActivityForResult(selecionaProduto,0);
            }
        });

    }


}
