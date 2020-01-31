package com.moraes.mobile.bolos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
Button buttonSair, buttonImprimir, buttonCliente, buttonEndereco, buttonData,btnDatePicker,btnTimePicker, btnAddProduto;
Calendar c;
String dataAtual;
private Toolbar toolbarMain;
private Menu menuMain;


DatePickerDialog dpd;
TimePickerDialog tpd;
int dia, mes, ano, horaAtual,minutoAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        toolbarMain = findViewById(R.id.toolbar_main);
        //toolbarMain.setb
        //menuMain = findViewById(R.menu.menu_main);
        setSupportActionBar(toolbarMain);

        btnAddProduto = findViewById(R.id.btn_add_produto);
        btnAddProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddProduto= new Intent(getApplicationContext(),AdicionarProdutoActivity.class);
                startActivity(intentAddProduto);
            }
        });

        buttonEndereco = findViewById(R.id.btn_endereco);
        buttonEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEndereco= new Intent(getApplicationContext(),EnderecoActivity.class);
                startActivity(intentEndereco);
            }
        });
        buttonSair = findViewById(R.id.btn_sair);
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDatePicker = findViewById(R.id.btn_data);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dp = new DatePickerFragment();
                dp.show(getSupportFragmentManager(),"teste calendario");
            }
        });

        btnTimePicker = findViewById(R.id.btn_hora);
        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                horaAtual = c.get(Calendar.HOUR_OF_DAY);
                minutoAtual = c.get(Calendar.MINUTE);
                tpd = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btnTimePicker.setText(String.format("às  %02d : %02d",hourOfDay,minute));
                    }
                },horaAtual,minutoAtual,true);
                tpd.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String dataAtual = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        btnDatePicker.setText(dataAtual);
    }
}
