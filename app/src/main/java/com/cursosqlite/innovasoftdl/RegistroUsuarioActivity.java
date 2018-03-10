package com.cursosqlite.innovasoftdl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cursosqlite.innovasoftdl.utilidades.Utilidades;

public class RegistroUsuarioActivity extends AppCompatActivity {

    EditText campoId, campoNombre, campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        campoId = findViewById(R.id.campoId);    //capturar información de los campos del usuario
        campoNombre = findViewById(R.id.campoNombre);
        campoTelefono = findViewById(R.id.campoTelefono);

    }

    public void onClick (View view){
        registrarUsuarios();
        //registrarUsuariosSql();
    }

    private void registrarUsuariosSql() {




    }

    private void registrarUsuarios() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1); //define cual es la BD
        SQLiteDatabase db = conn.getWritableDatabase(); //abre la base de datos para editar

        ContentValues values = new ContentValues(); //Se puede usar values o desde inser into y los valores con sqlite
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString()); //agregar con el put una clave y valor asociado a los diferentes campos de nuestra tabla.
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString()); //gettext obtiene el texto ingresado por el usuario
        values.put(Utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());

        //insertar tod en base de datos


        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values); //insertamos inicialmente el nombre de nuestra tabla y el campo a devolver y se le pasan los values

        Toast.makeText(getApplicationContext(), "id Registro: " +idResultante, Toast.LENGTH_SHORT).show();//devuelve resultado
        db.close(); //para evitar problemas mas adelante


        //IMPORTANTE ELIMINAR APP ANTERIOR Y VOLVER A EJECUTAR

    }

}
