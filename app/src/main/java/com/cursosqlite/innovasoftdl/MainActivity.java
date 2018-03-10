package com.cursosqlite.innovasoftdl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

    }

    public void onClick(View view){
        Intent miintent=null;
        switch (view.getId()) {
            case R.id.btnRegistro:
                miintent = new Intent(MainActivity.this, RegistroUsuarioActivity.class);
                break;
        }
        if (miintent!=null){

            startActivity(miintent);

        }
    }

}
