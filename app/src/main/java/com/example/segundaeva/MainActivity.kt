package com.example.segundaeva

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.segundaeva.ui.theme.SegundaEvaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SegundaEvaTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Elementos()
                }
            }
        }
    }
}


@Composable
fun Elementos() {

    val mContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.small)
                .background(Color(0xFF004788))
                .border(4.dp, Color(0xFF004788))
        ) {

            Image(
                painter = painterResource(id = R.drawable.spiderman8),
                contentDescription = "Logo Spiderman",
                modifier = Modifier
                    .padding(7.dp)

            )

        }

        Text(
            text = "Spiderman Movies",
            color = Color(0xFF005236),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 48.sp,
        )
        Text(
            text = "Disfruta de los trailers!",
            fontSize = 25.sp,
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF005236),
            modifier = Modifier
                .padding(all = 10.dp)
        )

        Row {

            OutlinedButton(
                onClick = {

                    mContext.startActivity(Intent(mContext, ListActivity::class.java))


                }) {
                Text(
                    text = "Trailers",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF005236),
                    fontSize = 25.sp,
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ElementosPreview() {

    SegundaEvaTheme(darkTheme = false) {
        Elementos()
    }

}