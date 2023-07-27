package cl.awakelabs.kotlin12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
fun main(){
    var usuarios = mutableListOf<Usuario>()
    println("ingrese cantidad de usuarios")
    val cantUsuario = readln().toInt()

    for(i in 1.. cantUsuario) {
        println("ingrese nombre")
        var nombre = readln()

        while (!validarNombre(nombre)){
            println("el nombre no es valido")
            nombre = readln()
        }

        println("ingrese apellido")
        var apellido = readln()

        while (!validarApellido(apellido)){
            println("el apellido no es valido")
            apellido = readln()
        }
        println("ingrese edad")
        var edad = readln().toInt()

        while (!validarEdad(edad)){
            println("la edad no es numero valido")
            edad = readln().toInt()
        }
        println("ingrese correo electronico")
        var correo = readln()

        while (!validarEmail(correo)){
            println("el correo no es valido")
            correo = readln()
        }
        println("ingrese sistema de salud")
        var salud = readln()

        while (!validarSiSalud(salud)){
            println("no es valida la opcion ingresada")
            salud = readln()
        }

        var usuario = Usuario(nombre,apellido, edad, correo, salud)

        usuarios.add(usuario)
    }
    for (u in usuarios) {
        println(usuarios)
    }


}

fun validarNombre(nombre: String): Boolean {
     return nombre.length in 1 .. 20

}
fun validarApellido(apellido: String): Boolean {
    return apellido.length in 1..20 && apellido.all {
        it.isLetter() }
}
fun validarEdad(edad:Int):Boolean{
    return edad in 1..120 && edad.toString().all {
        it.isDigit() }
}
fun validarEmail(correo: String):Boolean{
    return correo.matches(Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))

}

fun validarSiSalud(sistemaSalud:String): Boolean {
    val options = listOf("fonasa","isapre","particular")
    return options.contains(sistemaSalud)

}

data class Usuario(var nombre: String, var apellido: String, var edad: Int, var correo: String, var salud:String)