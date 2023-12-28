package com.AGENDABASE.ui.features.formcontacto.seleccioncategorias

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.AGENDABASE.R
import com.AGENDABASE.ui.features.components.ImagenContacto
import com.AGENDABASE.ui.features.vercontactos.CatergoriaUiState
import com.pmdm.agenda.ui.composables.OutlinedTextFieldEmail
import com.pmdm.agenda.ui.features.formcontacto.seleccioncategorias.SeleccionCategoriasConCheckBox
import com.pmdm.utilities.validacion.Validacion
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable
fun FormContactoScreen()
{
    var c : CatergoriaUiState = CatergoriaUiState() //prueba
    var validacionState : Validacion = Validacion(false,"Error") //prueba

    Column(
        modifier = Modifier
    ) {

        Box(
            Modifier.fillMaxWidth()
        )
        {

            Image(
                modifier = Modifier
                    .height(200.dp),
                painter = if(isSystemInDarkTheme()){
                    painterResource(id = R.drawable.bg_dark)
                }else{
                    painterResource(id = R.drawable.bg_light)
                },
                contentDescription = "Fondo de la imágen",
                contentScale = ContentScale.FillBounds
            )

            Box(modifier = Modifier.align(Alignment.Center))
            {
                ImagenContacto(foto = null)
                OutlinedIconButton(onClick = { /*TODO*/ }) {
                }
            }
        }

        SeleccionCategoriasConCheckBox(
            etiquetaGrupoState = "etiqueta1",
            categoriaState = c,
            onCategoriaChanged = {}
        )
        val textfieldModifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
        OutlinedTextField(modifier = textfieldModifier, value = "Nombre", onValueChange = {})
        OutlinedTextField(modifier = textfieldModifier, value = "Apellidos", onValueChange = {})
        OutlinedTextFieldEmail(modifier = textfieldModifier, emailState = "Email", validacionState = validacionState, onValueChange = {})
        FloatingActionButton(modifier = Modifier.padding(5.dp), onClick = { /*TODO*/ }) {
            Row(modifier = Modifier.padding(), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.AddBox, "Floating action button.")
                Text(text = "Guardar")
            }
        }
    }
}