package ui.features

import data.models.Usuario


fun usuarioScreen(usuarioEvent : (UsuarioEvent) -> Unit ){

    println("Introduce una opción")
    println(
        "1. Sing in\n" +
                "2. Log in\n" +
                "3. Change password\n" +
                "4. Log out\n" +
                "5. List\n" +
                "6. Exit\n"
    )
    var respuesta : String = readln()

    when(respuesta)
    {
        "1" ->{
            println("Usuario:")
            val usuario : String = readln()
            println("Contraseña")
            val contraseña : String = readln()
            usuarioEvent(UsuarioEvent.AñadeUsuario(usuario,contraseña))
        }
        "2" ->{
            println("Usuario:")
            val usuario : String = readln()
            println("Contraseña")
            val contraseña : String = readln()
            usuarioEvent(UsuarioEvent.EntraSistema(usuario,contraseña))
        }
        "3" ->{
            println("Contraseña")
            val contraseña : String = readln()
            usuarioEvent(UsuarioEvent.ModificaUsuario(contraseña))
        }
        "4"->{
            usuarioEvent(UsuarioEvent.SaleSistema)
        }
        "5"->{
            usuarioEvent(UsuarioEvent.MuestraUsuarios)
        }
        "6"->{
            System.exit(0)
        }
    }

}

