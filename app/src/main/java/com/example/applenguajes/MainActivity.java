package com.example.applenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    ArrayList<String> listItem = new ArrayList<>();

    Button btnAñadir;

    EditText etTexto;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.lvLenguajes);

        etTexto=(EditText) findViewById(R.id.etTexto);

        btnAñadir=(Button) findViewById(R.id.btnAñadir);

        listItem.add("C++");

        //android.R.layout.simple_list_item_1
        adapter = new ArrayAdapter<String>(this,
                R.layout.item_custom_list, R.id.textView,listItem);
        listView.setAdapter(adapter);


        btnAñadir.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        listItem.add(etTexto.getText().toString());
        adapter.notifyDataSetChanged();

        Toast.makeText(v.getContext(),"Se ha introducido: "+etTexto.getText().toString()+" correctamente.", Toast.LENGTH_LONG).show();

    }


}