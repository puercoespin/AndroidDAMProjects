package com.login_v3_4.ui.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grade
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.login3_3.R
import com.login_v3_4.ui.composables.CheckboxWithText
import com.login_v3_4.ui.theme.ProyectoBaseTheme
import com.login_v3_4.utilities.validacion.Validacion
import com.pmdm.login.ui.composables.CircularImageFromResource
import com.pmdm.login.ui.composables.OutlinedTextFieldEmail
import com.pmdm.login.ui.composables.OutlinedTextFieldPassword
import kotlin.reflect.KFunction1


@Composable
fun BotonFlotante(onClick: () -> Unit,texto:String) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Grade, "Extended floating action button.") },
        text = { Text(text = texto) },
    )
}

@Composable
fun LoginScreen(
    loginUiState: LoginUiState,

    validacionEmailState: Validacion,
    validacionPasswordState: Validacion,

    loginEvent: (LoginEvent)->Unit,
    hayErrores:Boolean,
    mensajeErrorAñadido: String

) {
    ProyectoBaseTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CircularImageFromResource(R.drawable.usuario,"usuario")

            OutlinedTextFieldEmail(emailState = loginUiState.login, validacionState = validacionEmailState,
                onValueChange = {loginEvent(LoginEvent.LoginChanged(it))})

            OutlinedTextFieldPassword(passwordState = loginUiState.password, validacionState = validacionPasswordState,
                onValueChange = {loginEvent(LoginEvent.PasswordChanged(it))})

            if(hayErrores)
            {
                Text(text = mensajeErrorAñadido)
            }
            CheckboxWithText(label = "Recordar contraseña", checkedState = loginUiState.recordarPass,
                onCheckedChange = {loginEvent(LoginEvent.onCheckChanged(it))})
            BotonFlotante(onClick = { loginEvent(LoginEvent.OnClickLoguearse) },texto="Entrar")
        }
    }
}


/*
@Preview
@Composable
fun LoginScreenPreview()
{

    var emailState by remember { mutableStateOf("") } // contenido del textfield (text)
    var validacionEmailState by remember { mutableStateOf(Validacion("Error en el email",false)) }

    var passwordState by remember { mutableStateOf("") } // contenido del textfield (text)
    var validacionPasswordState by remember { mutableStateOf(Validacion("La contraseña debe ser de 6 caracteres o más",false)) }


    var checkboxValue by remember { mutableStateOf(false) }

    var hayErrores by remember { mutableStateOf(false) }
    var errorMensaje by remember { mutableStateOf("") }

    if(validacionEmailState.hayError){errorMensaje="El email introducido no es correcto!"}
    if(validacionPasswordState.hayError){errorMensaje="La contraseña introducida no es correcta!"}
    if(validacionEmailState.hayError && validacionPasswordState.hayError){errorMensaje="El email y la contraseña son incorrectos"}


    LoginScreen(emailState,validacionEmailState,
        {
            emailState=it
            validacionEmailState.hayError = !Patterns.EMAIL_ADDRESS.matcher(it).matches()
        },
        passwordState,validacionPasswordState,
        {
            passwordState=it
            validacionPasswordState.hayError = passwordState .length <= 6
        },checkboxValue,
        {
            checkboxValue=it
        },
        {
            hayErrores = validacionEmailState.hayError || validacionPasswordState.hayError
        },
        hayErrores,errorMensaje)



}
*/