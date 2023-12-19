package com.pmdm.tienda.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import com.pmdm.tienda.ui.theme.LoginTheme
import com.pmdm.tienda.ui.features.login.LoginScreen
import com.pmdm.tienda.ui.features.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel: LoginViewModel by viewModels()

        setContent {
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
    }
}
