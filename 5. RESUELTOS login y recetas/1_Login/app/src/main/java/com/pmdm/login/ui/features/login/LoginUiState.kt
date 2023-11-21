
package com.pmdm.login.ui.features.login

data class LoginUiState(
    val login: String,
    val password: String,
    val estaLogeado: Boolean
) {
    constructor() : this(
        login = "",
        password = "",
        estaLogeado=false
    )
}
