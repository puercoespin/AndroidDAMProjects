package com.login_v3_5.ui.features.login

sealed interface LoginEvent{
    data class LoginChanged(var cadena : String) : LoginEvent
    data class PasswordChanged(var cadena : String) : LoginEvent

    data class onCheckChanged(var checked : Boolean) : LoginEvent

    object OnClickLoguearse : LoginEvent

}