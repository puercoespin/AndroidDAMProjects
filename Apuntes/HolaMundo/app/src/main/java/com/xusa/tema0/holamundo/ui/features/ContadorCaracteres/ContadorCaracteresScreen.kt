package com.xusa.tema0.holamundo.ui.features.ContadorCaracteres

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

/*
    En CuentaScreen definimos 2 variables, texto que será el texto que escribimos y cuenta el tamaño de dicho texto
    mutableStateOf: tipo estado "normal" que
    derivedStateOf: tipo estado autocalculado, es decir, podemos calcular dentro el valor

    En columna, mostramos nuestro composable (tendremos un composable con la interfaz(StateLess) y otro con la logica(StateFull))
    Cuando hacemos texto = it, estamos asignando a la variable texto, lo que recibe onCambioCadena

    En el composable de Interfaz, diseñamos la interfaz y definimos qué muestra. La función recibe 3 variables
    cuenta: variable tipo entero que usaremos para mostrar la cuenta de caracteres de lo escrito

    función: pediremos una función que reciba una variable de tipo String, que no devuelve nada.
        Nuestra función asignará a la variable texto, lo que escribamos en el textField.
        el flujo es: en IntroduceCadena tenemos un textfield el cual tiene una funcion que se ejecuta cada vez
        que su texto cambia(onValueChange), esa funcion se la definimos nosotros (le llega como parametro a la función IntroduceCadena)

        La función que se ejecuta es la que hemos hecho nosotros en CuentaScreen, lo que hacía es cambiar el valor de la variable texto  por
        el valor que recibe (en este caso el value de TextField)
        it será el propio objeto que recibimos, en este caso le pone el value


    Texto: variable tipo string que usaremos para mostrar el contenido de nuestro TextField
 */

@Composable
fun CuentaScreen()
{
    var texto by remember{ mutableStateOf("") }
    val cuenta by remember{ derivedStateOf { texto.length } }
    Column {
        IntroduceCadena(cuenta=cuenta,onCambioCadena = {texto = it},
            textoAMostrar = texto)

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroduceCadena(
    cuenta : Int,
    onCambioCadena:(String)->Unit
    , textoAMostrar : String
)
{
    Row {
        Text(
            modifier = Modifier.padding(12.dp),
            text = "cadena"
        )
        TextField(value = textoAMostrar, onValueChange = onCambioCadena)
        Text(
            text = cuenta.toString()
        )
    }
}

@Preview
@Composable
fun ContadorStart()
{
    CuentaScreen()
}