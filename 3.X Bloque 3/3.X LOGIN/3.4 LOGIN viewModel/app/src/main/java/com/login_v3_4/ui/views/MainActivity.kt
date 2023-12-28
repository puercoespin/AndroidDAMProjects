package com.login_v3_4.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.login_v3_4.ui.features.login.LoginEvent
import com.login_v3_4.ui.features.login.LoginScreen
import com.login_v3_4.ui.features.login.LoginViewModel
import com.login_v3_4.ui.theme.ProyectoBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : LoginViewModel by viewModels()
        setContent {
            ProyectoBaseTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   
                    LoginScreen(
                        loginUiState = viewModel.loginUiState,
                        validacionEmailState = viewModel.validacionEmailState,
                        validacionPasswordState = viewModel.validacionPasswordState,
                        loginEvent = viewModel::onLoginEvent,
                        hayErrores = viewModel.hayErrores,
                        mensajeErrorAñadido = viewModel.errorMensaje
                    )
                    
                }
            }
        }
    }
}