package com.josue.sharedpreferencesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnnext = findViewById(R.id.btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EliminarSharedPreferencesActivity.class);
                startActivity(intent);
            }
        });



        et1 = (EditText)findViewById(R.id.txtTexto);

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("mail",""));
    }

    public void guardar(View view) {
        SharedPreferences preferences = getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferences.edit();
        Obj_editor.putString("mail",et1.getText().toString());
        Obj_editor.commit();
        finish();
    }
}
