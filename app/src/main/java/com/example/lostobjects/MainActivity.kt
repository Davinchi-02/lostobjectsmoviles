package com.example.lostobjects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lostobjects.ui.theme.LOSTOBJECTSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LOSTOBJECTSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            Formulario()
        }
    }
}

@Composable
fun Formulario (){
    var usuario by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var hidden by remember {
        mutableStateOf(true)
    }
    val image = painterResource(R.drawable.brands)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF002366).copy(alpha = 0.8f), // Azul oscuro semi-transparente
                        Color(0xFF003399).copy(alpha = 0.2f)  // Azul más claro con mayor transparencia
                    ),
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(
                        1000f,
                        1000f
                    ) // Dirección del degradado
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )


        TextField(
            modifier = Modifier.background(Color.White),
            value = usuario,
            onValueChange = {usuario= it},
            label = { Text("Usuario",color = Color.Black)},
            placeholder = { Text("Ingresa tu Usuario", color = Color.Black)}
        )

        TextField(
            modifier = Modifier.background(Color.White),
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña", color = Color.Black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),//2
            singleLine = true,
            visualTransformation =
            if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3
            trailingIcon = {// 4
                IconButton(onClick = { hidden = !hidden }) {
                    val vector = painterResource(//5
                        if (hidden) R.drawable.ic_visibility
                        else R.drawable.ic_visibility_off
                    )
                    val description = if (hidden) "Ocultar contraseña" else "Revelar contraseña" //6
                    Icon(painter = vector, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { }, border = BorderStroke(
                width = 4.dp,
                brush = Brush.horizontalGradient(

                    listOf(
                        Color(0xFF42A5F5),
                        Color(0xFF42A5F5)
                    )
                )
            )
        ) {
            Text("Iniciar sesion", color = Color.White)
        }

        OutlinedButton(
            onClick = { }, border = BorderStroke(
                width = 4.dp,
                brush = Brush.horizontalGradient(

                    listOf(
                        Color(0xFF42A5F5),
                        Color(0xFF42A5F5)
                    )
                )
            )
        ) {
            Text("Registrarse", color = Color.White)
        }
    }


    

}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(

            text = "LOGIN",
            modifier = modifier
        )


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LOSTOBJECTSTheme {
        Greeting("Android")
    }
}