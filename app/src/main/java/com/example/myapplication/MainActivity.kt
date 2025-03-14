package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BusinessItem("Negocios de la Nave 1", Color(0xFF6650a4)) // Purple40
            BusinessItem("Negocios de la Nave 2", Color(0xFF6650a4)) // Purple40
            BusinessItem("Negocios de la Nave 3", Color(0xFF6650a4)) // Purple40
            BusinessItem("Atracciones y Conciertos", Color(0xFFD0BCFF)) // Purple80

            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Fechas importantes",
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

@Composable
fun BusinessItem(text: String, cardColor: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Text(
                text = text,
                modifier = Modifier.padding(8.dp),
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(onNavigateToSecondActivity = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessItem() {
    BusinessItem(text = "Negocios de la Nave 1", cardColor = Color(0xFF6650a4))
}
