package com.login_v3_4.ui.features.login

sealed interface LoginEvent{
    data class LoginChanged(var cadena : String) : LoginEvent
    data class PasswordChanged(var cadena : String) : LoginEvent
    object OnClickLoguearse : LoginEvent

}