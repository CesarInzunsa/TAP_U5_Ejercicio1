package mx.edu.ittepic.tap_u5_ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

/**
 * El paradigma "Modelo-Vista-Controlador" es separar las partes de un proyecto
 * Modelo: Almacen de datos (MongoDB, MySQL, FILES)
 * Vista: Diseño grafico de la App, lo que ve el usuario (.XML)
 * Controlador:Codigo que no ve el usuario final, pero que hace que la App funcione (KOTLIN)
 */

/**
 * MainActivity -> Clase principal
 * : -> Herencia. Equivalente al "extends" de Java
 * AppCompatActivity -> Equivalente a la clase JFrame de Java, en este caso construye una activity
 *
 * override -> Sobre escribiendo un metodo
 * fun -> Metodo
 * onCreate -> Nombre del metodo
 *
 * El onCreate tiene dos lineas predeterminadas
 *
 * Para que una aplicacion se muestre en una orientacion y pueda cambiar al rotar el dispositivo,
 * es a traves de savedInstanceState.
 */

class MainActivity : AppCompatActivity() {

    //VARIABLES FORMA CORTA
    var numero = 9  //Variable de tipo int
    var sueldo = 1280.99 //Variable de tipo double
    var altura = 1.0f //Variable de tipo float
    var direccion = "Allende 280" //Variable de tipo String
    var resultado = true //Variable de tipo booleans

    //VARIABLES FORMA LARGA
    var nombreCompleto : String = ""
    var edad : Int = 0
    var nombreCampoTexto : EditText ?= null //Estoy construyendo una var EditText sin asociar XML aun
    var boton : Button ?= null //Estoy construyendo una var Button sin asociar XML aun

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)      //Manda a llamar el onCreate padre, en este caso es AppCompatActivity
        setContentView(R.layout.activity_main)  //

        /*
        //Asocio la variable nombreCampoTexto de Kotlin con un objeto XML a traves de su id
        nombreCampoTexto = findViewById(R.id.editTextTextPersonName)

        //Se asocio la variable boton de Kotlin con el objeto XML con id botonsaludador
        boton = findViewById(R.id.botonsaludar)
        */

        //camponombrepersona.setText("CARLOS RODRIGUEZ")

        //Asignar evento click al boton
        botonsaludar.setOnClickListener {
            var nombre = camponombrepersona.text.toString() //Equivalente a .getText() en Java

            //Si nombre esta vacio, entonces que muestre mensaje de error
            if (nombre.isEmpty()){
                AlertDialog.Builder(this).setTitle("ERROR")
                    .setMessage("DEBES PONER UN NOMBRE EN EL CAMPO DE TEXTO!!")
                    .setPositiveButton("OK",{d,i->d.dismiss()})
                    .show()
            }else {
                val alerta = AlertDialog.Builder(this,)

                alerta.setTitle("ALERTA")
                alerta.setMessage("Hola, ${nombre} como estas?") //${variable} -> Se llama precompilador

                //d: Dialog (Informa a android si el alertDialog se cerro de forma positiva o negativa)
                //i: Exception (Se ejecuta en caso de error; cuando no hay error esta en null)
                //->: Lambda
                alerta.setPositiveButton("ACEPTAR", { d, i -> d.dismiss() })

                alerta.setNegativeButton("CANCELAR", { d, i -> d.cancel() })

                alerta.setNeutralButton("CERRAR", { d, i -> })

                alerta.show()
            }
        }

        radioButton.setOnClickListener {
            Toast.makeText(this, "Ud es CASADO", Toast.LENGTH_LONG).show()
        }

        radioButton2.setOnClickListener {
            Toast.makeText(this, "Ud es SOLTERO", Toast.LENGTH_LONG).show()
        }

    }
}