package com.moraes.mobile.bolos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;

public class SelecionaProdutoActivity extends AppCompatActivity {
    private String[] produtos1 = {"BOLOS SIMPLES","BOLOS RECHEADOS","MINI DOCES","MINI SALGADOS","TORTAS SALGADAS","SOBREMESAS","CEIA DE NATAL"};
    private String[] listaBolo = {"BOLO DE CENOURA C/ CHOCOLATE","BOLO DE LARANJA","BOLO DE FUBÁ","BOLO FORMIGUEIRO"};
    private String[] listaBoloRecheado = {"FLORESTA NEGRA","SENSAÇÃO","BRIGADEIRO","NOZES","PRESTÍGIO","ABACAXI C/ CHANTILLY","PÊSSEGO C/CHANTILLY",
            "MORANGO C/ CHANTILLY","AMEIXA C/ DOCE DE LEITE E RUN"};
    private String[] listaMiniDoce = {"BRIGADEIRO","BEIJINHO","BRIGADEIRO DE PAÇOCA","BRIGADEIRO DE LEITE NINHO","BICHO DE PÉ","OLHO DE SOGRA"};
    private String[] listaMiniSalgado = {"EMPADA DE FRANGO E PALMITO","ESFIHA DE CARNE","CROQUETE DE CARNE","BOLINHO DE QUEIJO","RISOLES DE QUEIJO","QUIBES",
            "ENROLADINHO DE PRESUNTO E QUEIJO","COXINHA DE FRANGO","CROQUETE DE CARNE"};
    private String[] listaSobremesas = {"TORTA DE BANANA CARAMELIZADA","QUINDÃO","PUDIM DE MARIA MOLE","PUDIM DE LEITE CONDENSADO","ROCAMBOLE DE CENOURA",
            "TORTA DE MORANGO E GELATINA","TORTA DE MOUSSE DE LIMÃO","TORTA DE MOUSSE DE MARACUJA","ARROZ DOCE C/ DOCE DE LEITE","CURAL DE MILHO",
            "SAGÚ C/ VINHO E SUCO DE UVA"};
    private String[] listaTortaSalgada = {"TORTA DE FRANGO E PALMITO","QUICHE DE ALHO PORÓ","QUICHE 4 QUEIJOS"};
    private String[] listaCeia = {"PERU / CHESTER / FIESTA ASSADO","TENDER ASSADO","MAIONESE COM FRUTAS","ARROZ COM FRUTAS","LENTILHA"};

    private ListView listSelProdutos1;
    private CustomItemAdapter adapterListSelProdutos1;
    private CustomPesoAdapter adapterListSelProdutos2;
    Bundle dadosProduto;
    int produtoID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleciona_produto);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        dadosProduto = getIntent().getExtras();
        produtoID = dadosProduto.getInt("produtoKey");
        boolean peso = false;


        listSelProdutos1 = findViewById(R.id.list_Sel_Produtos);
        switch (produtoID) {
            case 0:
                adapterListSelProdutos2 = new CustomPesoAdapter(this, listaBolo);
                peso = true;
                break;
            case 1:
                adapterListSelProdutos2 = new CustomPesoAdapter(this, listaBoloRecheado);
                peso = true;
                break;
            case 2:
                adapterListSelProdutos1 = new CustomItemAdapter(this, listaMiniDoce);
                break;
            case 3:
                adapterListSelProdutos1 = new CustomItemAdapter(this, listaMiniSalgado);
                break;
            case 4:
                adapterListSelProdutos2 = new CustomPesoAdapter(this, listaSobremesas);
                peso = true;
                break;
            case 5:
                adapterListSelProdutos2 = new CustomPesoAdapter(this, listaTortaSalgada);
                peso = true;
                break;
            case 6:
                adapterListSelProdutos2 = new CustomPesoAdapter(this, listaCeia);
                peso = true;
                break;
            default:
                adapterListSelProdutos2 = new CustomPesoAdapter(this, produtos1);
                break;
        }
        if (peso) {
        listSelProdutos1.setAdapter(adapterListSelProdutos2);
        } else {
            listSelProdutos1.setAdapter(adapterListSelProdutos1);
        }
        // falta iniciar atvidades "startActivityForResult"
    }
}
