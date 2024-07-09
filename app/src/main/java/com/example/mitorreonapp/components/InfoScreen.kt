package com.example.mitorreonapp.components

import android.content.Context
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.mitorreonapp.R

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.firstText_info),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(id = R.string.secondText_info),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.my_socials),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(100.dp)
                .height(200.dp)

        ) {

            MySocialButton(
                text = "https://www.linkedin.com/in/victor-manuel-tijerina-garnica-103a44302/",
                context = LocalContext.current,
                imageId = R.drawable.linkedin,
                contentId = R.string.my_linkedin
            )
            MySocialButton(
                text = "https://github.com/Vectorr22?tab=repositories",
                context = LocalContext.current,
                imageId = R.drawable.github,
                contentId = R.string.my_github
            )

        }

        Text(
            text = stringResource(R.string.greetings),
            //fontStyle = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp,
            modifier = Modifier
        )

    }
}


@Composable
fun MySocialButton(
    text: String,
    context: Context,
    @DrawableRes imageId: Int,
    @StringRes contentId: Int,
    modifier: Modifier = Modifier,
) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    IconButton(
        onClick = {
            startActivity(context, shareIntent, null)
        },
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = contentId)
        )
    }
}

@Composable
@Preview(widthDp = 700)
fun InfoScreenPreview() {
    Surface {
        InfoScreen()
    }
}