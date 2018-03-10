package com.cursosqlite.innovasoftdl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cursosqlite.innovasoftdl.utilidades.Utilidades;

/**
 * Created by didie on 09/03/2018.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) { //se instanciara a Mainactivity estos valores
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //este metodo genera las tablas o scripts correspondientes de la entidad
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO); //ejecutar sentencias de creación
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) { //verifica si existe una version antigua de la BD (se modifico dos variables)
        db.execSQL("DROP TABLE IF EXISTS usuarios"); //si se instala la app y encuentra una version antigua la eliminara
        onCreate(db); //vuelve a crear
    }
}
