package com.pmdm.login.ui.features.login

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.login.R
import com.pmdm.login.ui.composables.CircularImageFromResource
import com.pmdm.login.ui.composables.TextNewAccount
import com.pmdm.login.ui.features.login.components.UsuarioPassword
import com.pmdm.login.ui.theme.LoginTheme
import com.pmdm.login.ui.theme.Purple40
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    usuarioUiState: LoginUiState,
    validadorLoginUiState: ValidadorLoginUiState,
    onLoginEvent: (LoginEvent) -> Unit
) {
    val contexto = LocalContext.current
    var mostrarSnack by remember {
        mutableStateOf(false)
    };
    var mensaje by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    var recordarmeState by remember { mutableStateOf(false) }

    Box(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        CircularImageFromResource(
            idImageResource = R.drawable.login, contentDescription = "Imagen Login"
        )


        UsuarioPassword(modifier = Modifier.fillMaxWidth(),
            loginState = usuarioUiState.login,
            passwordState = usuarioUiState.password,
            validacionLogin = validadorLoginUiState.validacionLogin,
            validacionPassword = validadorLoginUiState.validacionPassword,
            recordarmeState = recordarmeState,
            onValueChangeLogin = {
                onLoginEvent(LoginEvent.LoginChanged(it))
            },
            onValueChangePassword = {
                onLoginEvent(LoginEvent.PasswordChanged(it))
            },
            onCheckedChanged = { recordarmeState = it },
            onClickLogearse = {

                onLoginEvent(LoginEvent.OnClickLogearse)
                if (validadorLoginUiState.validacionUsuario.hayError) mostrarSnack = false
                else {
                    mostrarSnack = true
                    scope.launch() {
                        delay(4000)
                        mostrarSnack = false
                    }
                }
            })
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            "Olvidaste Password?", fontSize = 15.sp, fontStyle = FontStyle.Italic,
            color = Purple40
        )
        Text("ó")
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                alignment = Alignment.Center,
                modifier = Modifier.size(35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.gmail),
                contentDescription = "Gmail",
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .padding(3.dp)

            )
        }
        TextNewAccount(onClick = {
            Toast.makeText(contexto, "Nueva Cuenta", Toast.LENGTH_LONG).show()
        })
    }
        if (mostrarSnack) {
            if(validadorLoginUiState.validacionLogin.hayError || validadorLoginUiState.validacionPassword.hayError)
                mensaje="Comprueba los datos, tienen formato erroneo"
            else if (usuarioUiState.estaLogeado) mensaje =
                "Entrando a la APP con usuario ${usuarioUiState.login}"
            else mensaje = "Error, no existe el usuario o contraseña incorrecta"
            Snackbar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = mensaje)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val loginViewModel: LoginViewModel= viewModel()
    LoginTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            LoginScreen(
                usuarioUiState = loginViewModel.usuarioUiState,
                validadorLoginUiState = loginViewModel.validadorLoginUiState,
                onLoginEvent = loginViewModel::onLoginEvent,
            )
        }
    }
}