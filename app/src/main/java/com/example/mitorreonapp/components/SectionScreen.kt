package com.example.mitorreonapp.components

import androidx.annotation.ColorInt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mitorreonapp.R
import com.example.mitorreonapp.data.Ubication
import com.example.mitorreonapp.data.listOfUbications

@Composable
fun UbicationDisplay(
    ubication: Ubication,
    onUbicationClicked: (Ubication) -> Unit,
    onIconClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val gradient =
        Brush.verticalGradient(
            colors = listOf(Color.Black, Color.Transparent),
            startY = Float.POSITIVE_INFINITY,
            endY = 0f
        )
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        modifier = modifier
            .wrapContentHeight()
            .height(100.dp)
            .width(500.dp)
    ) {
        Row(
            modifier = Modifier.background(Color(0xFF665D4D))
        ) {
            Box(
                modifier = Modifier
                    .weight(0.80f)
            ) {
                Image(
                    painter = painterResource(id = ubication.imageResource),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .blur(3.dp)
                        .fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .background(brush = gradient)
                        .align(Alignment.BottomStart)
                )
                {
                    Text(
                        text = ubication.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 8.dp, bottom = 4.dp)
                    )
                }

            }
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(Color(0xFF665D4D)),
                onClick = {
                    onUbicationClicked(ubication)
                    onIconClicked()
                },
                modifier = Modifier
                    .weight(0.20f)
                    .fillMaxHeight()
            ) {
                Icon(
                    tint = Color(0xFFFFFFFF),
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = stringResource(R.string.ubication_click),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
fun UbicationDisplayTablet(
    ubication: Ubication,
    onUbicationClicked: (Ubication) -> Unit,
    modifier: Modifier = Modifier,
) {
    val gradient =
        Brush.verticalGradient(
            colors = listOf(Color.Black, Color.Transparent),
            startY = Float.POSITIVE_INFINITY,
            endY = 0f
        )
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        modifier = modifier
            .wrapContentHeight()
            .height(100.dp)
            .width(500.dp)
    ) {
        Row(
            modifier = modifier.clickable {
                onUbicationClicked(ubication)
            }
        ) {
            Box(
                modifier = Modifier
                    .weight(0.80f)
            ) {
                Image(
                    painter = painterResource(id = ubication.imageResource),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .blur(3.dp)
                        .fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .background(brush = gradient)
                        .align(Alignment.BottomStart)
                )
                {
                    Text(
                        text = ubication.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 8.dp, bottom = 4.dp)
                    )
                }

            }
        }
    }
}


@Composable
fun ListOfUbications(
    ubications: List<Ubication>,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onUbicationClicked: (Ubication) -> Unit,
    onIconClicked: () -> Unit,
) {
    LazyColumn(
        modifier = modifier.padding(paddingValues),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        items(ubications) {
            UbicationDisplay(
                ubication = it,
                onUbicationClicked = onUbicationClicked,
                onIconClicked = onIconClicked
            )

        }
    }
}

@Composable
fun ListOfUbicationsTablet(
    ubications: List<Ubication>,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    onUbicationClicked: (Ubication) -> Unit,
) {
    LazyColumn(
        modifier = modifier.padding(paddingValues),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        items(ubications) {
            UbicationDisplayTablet(
                ubication = it,
                onUbicationClicked = onUbicationClicked,
            )

        }
    }
}


@Composable
fun MainSectionScreen(
    modifier: Modifier = Modifier,
    listOfCurrentUbications: List<Ubication>,
    onUbicationClicked: (Ubication) -> Unit,
    onIconClicked: () -> Unit,
) {
    ListOfUbications(
        ubications = listOfCurrentUbications,
        paddingValues = PaddingValues(0.dp),
        onUbicationClicked = onUbicationClicked,
        onIconClicked = onIconClicked,
        modifier = modifier
    )
}


//@Composable
//@Preview(showBackground = true)
//fun UbicationDisplayPreview() {
//    Surface(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(4.dp)
//    ) {
//        UbicationDisplay(listOfUbications[9])
//    }
//}
//
//@Composable
//@Preview
//fun ListOfUbicationsPreview()
//{
//    ListOfUbications(ubications = listOfUbications, paddingValues = PaddingValues(8.dp))
//}
@Composable
@Preview
fun MainSelectionScreenPreview() {
    //MainSectionScreen()
}