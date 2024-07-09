package com.example.mitorreonapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mitorreonapp.R
import com.example.mitorreonapp.data.Ubication
import com.example.mitorreonapp.data.listOfUbications
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun MapDetailUbication(
    ubication: Ubication,
    modifier: Modifier = Modifier,
) {
    val location = LatLng(ubication.latitude, ubication.longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 12f)
    }
    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = location),
            title = stringResource(R.string.ubication_maps_title),
            snippet = stringResource(R.string.marker_in_torreon_maps)
        )
    }
}


@Composable
fun DetailImageTablet(
    currentImage: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(500.dp)
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(14.dp))
    ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(14.dp))
        )
    }
}

@Composable
fun DetailImage(
    currentImage: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .aspectRatio(16f / 9f)
    ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(14.dp))
        )
    }
}


@Composable
fun DetailScreenComposable(
    ubication: Ubication,
    currentImage: Int,
    isTablet: Boolean,
    onNextImageClicked: () -> Unit,
    onLastImageClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = ubication.name,
            style = MaterialTheme.typography.titleLarge
        )
        if(isTablet)
        {
            DetailImageTablet(
                currentImage = currentImage,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
        else
        {
            DetailImage(
                currentImage = currentImage,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF665D4D)),
                onClick = { onLastImageClicked() },
            ) {
                Icon(
                    tint = Color(0xFFFFFFFF),
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                    contentDescription = stringResource(
                        R.string.slide_left_image
                    )
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF665D4D)),
                onClick = { onNextImageClicked() },
            ) {
                Icon(
                    tint = Color(0xFFFFFFFF),
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(
                        R.string.slide_left_image
                    )
                )
            }
        }
        Text(
            text = ubication.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        MapDetailUbication(ubication = ubication, modifier = Modifier
            .padding(8.dp)
            .height(500.dp))

    }
}


@Composable
fun DetailScreenTablet(
    listOfCurrentUbications: List<Ubication>,
    onUbicationClicked: (Ubication) -> Unit,
    ubication: Ubication,
    currentImage: Int,
    isTablet: Boolean,
    onNextImageClicked: () -> Unit,
    onLastImageClicked: () -> Unit,
    modifier: Modifier = Modifier
)
{
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        ListOfUbicationsTablet(
            ubications = listOfCurrentUbications,
            paddingValues = PaddingValues(0.dp),
            onUbicationClicked = onUbicationClicked,
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        DetailScreenComposable(
            ubication = ubication,
            currentImage = currentImage,
            onNextImageClicked = { onNextImageClicked() },
            onLastImageClicked = { onLastImageClicked()},
            isTablet = isTablet,
            modifier = Modifier
                .weight(2.5f)
                .padding(4.dp)
        )
    }
}

//@Composable
//@Preview
//fun DetailScreenComposablePreview() {
//
//    DetailScreenComposable(ubication = listOfUbications[12], onLastImageClicked = {}, onNextImageClicked = {})
//
//}

//@Composable
//@Preview
//fun MapDetailUbicationPreview()
//{
//    Surface {
//        MapDetailUbication(ubication = listOfUbications[0])
//    }
//}

@Composable
@Preview(widthDp = 700)
fun DetailScreenTabletPreview()
{
    DetailScreenTablet(
        listOfCurrentUbications = listOfUbications,
        onUbicationClicked = {},
        onNextImageClicked = {},
        onLastImageClicked = {},
        ubication = listOfUbications[0],
        currentImage = R.drawable.ritter2,
        isTablet = true
    )
}