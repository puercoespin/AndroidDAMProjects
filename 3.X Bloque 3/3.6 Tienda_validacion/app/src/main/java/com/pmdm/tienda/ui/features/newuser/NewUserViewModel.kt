package com.pmdm.tienda.ui.features.newuser

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.agenda.utilities.validacion.validadores.ValidaTelefono
import com.pmdm.tienda.data.ClienteRepository
import com.pmdm.tienda.data.UsuarioRepository
import com.pmdm.tienda.ui.features.login.LoginEvent
import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesEvent
import com.pmdm.tienda.ui.features.newuser.datospersonales.DatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.datospersonales.ValidacionDatosPersonalesUiState
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionEvent
import com.pmdm.tienda.ui.features.newuser.direccion.DireccionUiState
import com.pmdm.tienda.ui.features.newuser.direccion.ValidacionDireccionUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordEvent
import com.pmdm.tienda.ui.features.newuser.newuserpassword.NewUserPasswordUiState
import com.pmdm.tienda.ui.features.newuser.newuserpassword.ValidacionNewUserPasswordUiState
import com.pmdm.utilities.validacion.ValidadorCompuesto
import com.pmdm.utilities.validacion.validadores.ValidaCorreo
import com.pmdm.utilities.validacion.validadores.ValidaLongitudMaximaTexto
import com.pmdm.utilities.validacion.validadores.ValidaTextoVacio
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewUserViewModel @Inject constructor(
    private val clienteRepository: ClienteRepository,
    private val usuarioRepository: UsuarioRepository

) : ViewModel() {

    var newUserUiState by mutableStateOf(NewUserUiState())

    var datosPersonalesUiState by mutableStateOf(DatosPersonalesUiState())
    var direccionUiState by mutableStateOf(DireccionUiState())
    var newUserPasswordUiState by mutableStateOf(NewUserPasswordUiState())


    var validadorCompuestoLogin : ValidadorCompuesto = ValidadorCompuesto(ValidaCorreo(
        "Debes introducir un correo válido")).add(ValidaTextoVacio())
    var validadorCompuestoPassword : ValidadorCompuesto =
        ValidadorCompuesto(ValidaTextoVacio("El texto no puede estar vacío")).add(ValidaLongitudMaximaTexto(8))

    var validadorCompuestoNombre : ValidadorCompuesto = ValidadorCompuesto(ValidaTextoVacio())
    var validadorCompuestoDni : ValidadorCompuesto = ValidadorCompuesto(ValidaTextoVacio())
    var validadorCompuestoTelefono : ValidadorCompuesto = ValidadorCompuesto(ValidaTelefono("Formato no válido"))
    var validadorCompuestoCalle : ValidadorCompuesto = ValidadorCompuesto(ValidaTextoVacio())
    var validadorCompuestoCiudad : ValidadorCompuesto = ValidadorCompuesto(ValidaTextoVacio())
    var validadorCompuestoCodPostal : ValidadorCompuesto = ValidadorCompuesto(ValidaTextoVacio())
    fun onDatosPersonalesEvent(datosPersonalesEvent: DatosPersonalesEvent)
    {
        when(datosPersonalesEvent)
        {
            is DatosPersonalesEvent.NombreChanged ->{
                newUserUiState = newUserUiState.copy(
                    datosPersonalesUiState = newUserUiState.datosPersonalesUiState.copy(nombre = datosPersonalesEvent.nombre))

                newUserUiState = newUserUiState.copy(
                    validadorDatosPersonalesUiState = newUserUiState.validadorDatosPersonalesUiState.copy(
                        validacionNombre = validadorCompuestoNombre.valida(datosPersonalesEvent.nombre)))

                //tenemos el newuseruistate que representa el usuario que intenta ser añadido,
                // dentro tenemos cada uistate correspondiente a los datos, creamos variables para cada dato y
                //hacemos un doble copy

                // para los validadores lo mismo, creando los validadores compuestos de cada uno
            }
            is DatosPersonalesEvent.DniChanged -> {
                newUserUiState = newUserUiState.copy(
                    datosPersonalesUiState = newUserUiState.datosPersonalesUiState.copy(dni = datosPersonalesEvent.dni))

                newUserUiState = newUserUiState.copy(
                    validadorDatosPersonalesUiState = newUserUiState.validadorDatosPersonalesUiState.copy(
                        validacionDni = validadorCompuestoDni.valida(datosPersonalesEvent.dni)))
            }
            is DatosPersonalesEvent.TelefonoChanged -> {
                newUserUiState = newUserUiState.copy(
                    datosPersonalesUiState = newUserUiState.datosPersonalesUiState.copy(telefono = datosPersonalesEvent.telefono))

                newUserUiState = newUserUiState.copy(
                    validadorDatosPersonalesUiState = newUserUiState.validadorDatosPersonalesUiState.copy(
                        validacionTelefono = validadorCompuestoTelefono.valida(datosPersonalesEvent.telefono)))
            }
            is DatosPersonalesEvent.OnClickSiguiente->{

            }
        }
    }

    fun onDireccionEvent(direccionEvent : DireccionEvent)
    {
        when(direccionEvent)
        {
            is DireccionEvent.CalleChanged ->{
                newUserUiState = newUserUiState.copy(
                    direccionUiState = newUserUiState.direccionUiState.copy(calle = direccionEvent.calle))

                newUserUiState = newUserUiState.copy(
                    validadorDireccionUiState = newUserUiState.validadorDireccionUiState.copy(
                        validacionCalle = validadorCompuestoCalle.valida(direccionEvent.calle)))

            }
            is DireccionEvent.CiudadChanged ->{
                newUserUiState = newUserUiState.copy(
                    direccionUiState = newUserUiState.direccionUiState.copy(ciudad = direccionEvent.ciudad))

                newUserUiState = newUserUiState.copy(
                    validadorDireccionUiState = newUserUiState.validadorDireccionUiState.copy(
                        validacionCiudad = validadorCompuestoCiudad.valida(direccionEvent.ciudad)))

            }
            is DireccionEvent.CodigoPostalChanged -> {
                newUserUiState = newUserUiState.copy(
                    direccionUiState = newUserUiState.direccionUiState.copy(codigoPostal = direccionEvent.codigoPostal))

                newUserUiState = newUserUiState.copy(
                    validadorDireccionUiState = newUserUiState.validadorDireccionUiState.copy(
                        validacionCodigoPostal = validadorCompuestoCodPostal.valida(direccionEvent.codigoPostal)))

            }
            is DireccionEvent.OnClickSiguiente ->
            {

            }
        }
    }

    fun onLoginEvent(event: NewUserPasswordEvent)
    {
        when(event)
        {
            is NewUserPasswordEvent.LoginChanged->{
                newUserUiState = newUserUiState.copy(
                    newUserPasswordUiState = newUserUiState.newUserPasswordUiState.copy(login = event.login))

                newUserUiState = newUserUiState.copy(
                    validadorNewUserPasswordUiState = newUserUiState.validadorNewUserPasswordUiState.copy(
                        validacionLogin = validadorCompuestoLogin.valida(event.login)
                    )
                )


            }
            is NewUserPasswordEvent.PasswordChanged->{
                newUserUiState = newUserUiState.copy(
                    newUserPasswordUiState = newUserUiState.newUserPasswordUiState.copy(password = event.password))

                newUserUiState = newUserUiState.copy(
                    validadorNewUserPasswordUiState = newUserUiState.validadorNewUserPasswordUiState.copy(
                        validacionPassword = validadorCompuestoPassword.valida(event.password)
                    )
                )

            }
            is NewUserPasswordEvent.onClickCrearCliente->
            {


            }
        }

    }


}