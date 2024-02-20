package com.example.segundaeva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.segundaeva.ui.theme.SegundaEvaTheme
import android.content.Intent
import android.net.Uri
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.platform.LocalContext

class ListActivity : ComponentActivity() {

    private val peliculas: List<Articulo> = listOf(
        Articulo(
            R.drawable.sp1,
            "Spiderman 1",
            "https://youtu.be/t06RUxPbp_c?feature=shared"
        ),
        Articulo(
            R.drawable.sp2,
            "Spiderman 2",
            "https://youtu.be/1s9Yln0YwCw?feature=shared"
        ),
        Articulo(
            R.drawable.sp3,
            "Spiderman 3",
            "https://youtu.be/e5wUilOeOmg?feature=shared"
        ),
        Articulo(
            R.drawable.tsp1,
            "The Amazing Spiderman",
            "https://youtu.be/XmR5HlEPYiw?feature=shared"
        ),
        Articulo(
            R.drawable.tsp2,
            "The Amazing Spiderman 2",
            "https://youtu.be/nbp3Ra3Yp74?feature=shared"
        ),
        Articulo(
            R.drawable.homecoming,
            "Spiderman Homecoming",
            "https://youtu.be/grusgXCahH8?feature=shared"
        ),
        Articulo(
            R.drawable.far_from_home,
            "Spiderman Far From Home",
            "https://youtu.be/nbp3Ra3Yp74?feature=shared"
        ),
        Articulo(
            R.drawable.no_way_home,
            "Spiderman No Way Home",
            "https://youtu.be/nbp3Ra3Yp74?feature=shared"
        ),
        Articulo(
            R.drawable.spiderverse1,
            "Spiderman Into The Spiderverse",
            "https://youtu.be/g4Hbz2jLxvQ?feature=shared"
        ),
        Articulo(
            R.drawable.spiderverse2,
            "Spiderman Across The Spiderverse",
            "https://youtu.be/cqGjhVJWtEg?feature=shared"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SegundaEvaTheme(true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla(peliculas)
                }
            }
        }
    }
}


@Composable
fun Pantalla(peliculas: List<Articulo>) {

    LazyColumn(
        contentPadding = PaddingValues(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(peliculas) { item ->
            ListItemRow(item)
        }


    }

}

@Composable
fun ListItemRow(item: Articulo) {

    val mContext = LocalContext.current

    var masInformacion = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = Color(0xFF004788))
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Poster Pelicula"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(70, 0, LinearEasing)
                    )
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 15.sp
                )
                if (masInformacion.value) {
                    val context = LocalContext.current
                    val trailerIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.trailerUrl))
                    context.startActivity(trailerIntent)
                }
            }

            IconButton(onClick = {
                masInformacion.value = !masInformacion.value
            }) {
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Icono expandir o colapsar",
                    Modifier.rotate(
                        if (masInformacion.value) 180f else 360f
                    )
                )

            }

            OutlinedButton(onClick = {
                mContext.startActivity(Intent(mContext, MainActivity::class.java))
            }) {
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 15.sp

                )
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun PantallaPreview() {
    val peliculas: List<Articulo> = listOf(
        Articulo(R.drawable.sp1, "Spiderman 1", "https://youtu.be/t06RUxPbp_c?feature=shared"),
        Articulo(R.drawable.sp2, "Spiderman 2", "https://youtu.be/1s9Yln0YwCw?feature=shared"),
        Articulo(R.drawable.sp3, "Spiderman 3", "https://youtu.be/e5wUilOeOmg?feature=shared"),
        Articulo(
            R.drawable.tsp1,
            "The Amazing Spiderman",
            "https://youtu.be/XmR5HlEPYiw?feature=shared"
        ),
        Articulo(
            R.drawable.tsp2,
            "The Amazing Spiderman 2",
            "https://youtu.be/nbp3Ra3Yp74?feature=shared"
        ),
        Articulo(
            R.drawable.homecoming,
            "Spiderman Homecoming",
            "https://youtu.be/grusgXCahH8?feature=shared"
        ),
        Articulo(
            R.drawable.far_from_home,
            "Spiderman Far From Home",
            "https://youtu.be/Nt9L1jCKGnE?feature=shared"
        ),
        Articulo(
            R.drawable.no_way_home,
            "Spiderman No Way Home",
            "https://youtu.be/ldMn-1iQzKE?feature=shared"
        ),
        Articulo(
            R.drawable.spiderverse1,
            "Spiderman Into The Spiderverse",
            "https://youtu.be/g4Hbz2jLxvQ?feature=shared"
        ),
        Articulo(
            R.drawable.spiderverse2,
            "Spiderman Across The Spiderverse",
            "https://youtu.be/cqGjhVJWtEg?feature=shared"
        )
    )
    SegundaEvaTheme(true) {
        Pantalla(peliculas)
    }

}
