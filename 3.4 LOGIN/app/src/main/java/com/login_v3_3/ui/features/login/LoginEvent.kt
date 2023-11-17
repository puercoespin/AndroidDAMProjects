package com.login_v3_3.ui.features.login

sealed interface LoginEvent{
    object LoginChanged : LoginEvent
    object PasswordChanged : LoginEvent
    object OnClickLoguearse : LoginEvent

}