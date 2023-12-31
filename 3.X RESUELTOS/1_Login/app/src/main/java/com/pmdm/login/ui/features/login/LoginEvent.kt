package com.pmdm.login.ui.features.login

sealed interface LoginEvent {
    data class LoginChanged(val login: String) : LoginEvent
    data class PasswordChanged(val password: String) : LoginEvent
    object  OnClickLogearse:LoginEvent
}
