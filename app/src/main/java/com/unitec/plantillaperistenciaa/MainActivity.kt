package com.unitec.plantillaperistenciaa

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Con este evento  boton vamos a borrar o limpiar el contenido de USUARIO
          borrar.setOnClickListener {
             var preferencias=applicationContext.getSharedPreferences("USUARIO",Context.MODE_PRIVATE)
              var editar=preferencias.edit()
              editar.clear().commit()
             Toast.makeText(applicationContext, "Tu SESION se ha cerrado con exito", Toast.LENGTH_LONG).show()
          }


        //Programamos el evento del boton para guardar un usuario fake registrado
        //lacalmente
        guardar.setOnClickListener {
            //Las preferencias compartidas en un objeto que necesitamos
            //obtener del conetxto de la app
         var preferencias=      applicationContext.getSharedPreferences("USUARIO", Context.MODE_PRIVATE)
           var editor=       preferencias.edit()
            editor.putString("nombre", "Juan Carlos").commit()
            editor.putString("email","rapidclimate@gmail.com").commit()

            Toast.makeText(applicationContext, "sesion guardada", Toast.LENGTH_LONG).show()
        }

        //Antes de oprimir el boton guardar verificamos si ya existe el archivo guardado
        var pref2=  applicationContext.getSharedPreferences("USUARIO",Context.MODE_PRIVATE)
        //Vamos a leerlo
        var nombre=pref2.getString("nombre", null);
        //Cheamos que no sea null para ver si ya se guardo la sesion
        if(!nombre.isNullOrEmpty()){
            Toast.makeText(applicationContext, "la sesion ya se guardo", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "la sesion NO se ha guardado", Toast.LENGTH_LONG).show()
        }

    }
}