package com.pmdm.login.ui.composables

import android.telephony.PhoneNumberUtils
import android.util.Range
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.pmdm.login.utilities.validacion.Validacion



@Composable
fun TextFieldWithErrorState(
    modifier: Modifier = Modifier,
    label: String,
    textoState: String,
    textoPista: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    validacionState: Validacion,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = textoState,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = leadingIcon,
        placeholder = {
            Text(
                text = textoPista,
                style = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f))
            )
        },
        label = { Text(if (validacionState.hayError) "${label}*" else label) },
        keyboardOptions = keyboardOptions,
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!)
            }
        },
        isError = validacionState.hayError,
        keyboardActions = keyboardActions
    )
}

@Composable
fun OutlinedTextFieldWithErrorState(
    modifier: Modifier = Modifier,
    label: String,
    textoState: String,
    textoPista: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    validacionState: Validacion,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = textoState,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = leadingIcon,
        placeholder = {
            Text(
                text = textoPista,
                style = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f))
            )
        },
        label = { Text(if (validacionState.hayError) "${label}*" else label) },
        keyboardOptions = keyboardOptions,
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!)
            }
        },
        isError = validacionState.hayError,
        keyboardActions = keyboardActions
    )
}

@Composable
fun TextFieldPassword(
    modifier: Modifier = Modifier,
    passwordState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit,
    label: String = "Clave",
    labelShow: String = "Muestra clave",
    labelHide: String = "Oculta clave",
    iconoInformativo: Painter = rememberVectorPainter(image = Icons.Filled.Lock),
) {
    var passwordHidden by remember { mutableStateOf(true) }
    TextField(
        modifier = modifier,
        value = passwordState,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(if (validacionState.hayError) "${label}*" else label) },
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!)
            }
        },
        isError = validacionState.hayError,
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                painter = iconoInformativo,
                contentDescription = label
            )
        },
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordHidden) labelShow else labelHide
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}

@Composable
fun OutlinedTextFieldPassword(
    modifier: Modifier = Modifier,
    passwordState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit,
    label: String = "Clave",
    labelShow: String = "Muestra clave",
    labelHide: String = "Oculta clave",
    iconoInformativo: Painter = rememberVectorPainter(image = Icons.Filled.Lock),
) {
    var passwordHidden by remember { mutableStateOf(true) }
    OutlinedTextField(
        modifier = modifier,
        value = passwordState,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(if (validacionState.hayError) "${label}*" else label) },
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!)
            }
        },
        isError = validacionState.hayError,
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                painter = iconoInformativo,
                contentDescription = label
            )
        },
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordHidden) labelShow else labelHide
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}

@Composable
fun TextFieldPhone(
    modifier: Modifier = Modifier,
    label: String = "Teléfono",
    telefonoState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
) {
    TextFieldWithErrorState(
        modifier = modifier,
        label = label,
        textoState = telefonoState,
        textoPista = "999 99 99 99",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Teléfono"
            )
        },
        validacionState = validacionState,
        onValueChange = {
            var text = it
            if (!validacionState.hayError) {
                try {
                    text = PhoneNumberUtils.formatNumber(it, "ES")
                } catch (e: Exception) {

                }
            }
            onValueChange(text)
        }
    )
}

@Composable
fun OutlinedTextFieldPhone(
    modifier: Modifier = Modifier,
    label: String = "Teléfono",
    telefonoState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
) {
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        textoState = telefonoState,
        textoPista = "999999999",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Teléfono"
            )
        },
        validacionState = validacionState,
        onValueChange = {
            var text = it
            if (!validacionState.hayError) {
                try {
                    text = PhoneNumberUtils.formatNumber(it, "ES")
                } catch (e: Exception) {

                }
            }
            onValueChange(text)
        }
    )
}

@Composable
fun TextFieldEmail(
    modifier: Modifier = Modifier,
    label: String = "Email",
    emailState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
) {

    TextFieldWithErrorState(
        modifier = modifier,
        label = label,
        textoState = emailState,
        textoPista = "ejemplo@correo.com",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email"
            )
        },
        validacionState = validacionState,
        onValueChange = { onValueChange(it) }
    )
}

@Composable
fun OutlinedTextFieldEmail(
    modifier: Modifier = Modifier,
    label: String = "Email",
    emailState: String,
    validacionState: Validacion,
    onValueChange: (String) -> Unit
) {
    OutlinedTextFieldWithErrorState(
        modifier = modifier,
        label = label,
        textoState = emailState,
        textoPista = "ejemplo@correo.com",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email"
            )
        },
        validacionState = validacionState,
        onValueChange = onValueChange
    )
}



