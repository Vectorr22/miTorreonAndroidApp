package com.example.mitorreonapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitorreonapp.R
import com.example.mitorreonapp.UbicationViewModel
import com.example.mitorreonapp.data.Categories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    currentNav: DESTINATIONS,
    isFirstScreen: Boolean,
    onBackArrowPressed: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            if (!isFirstScreen) {
                IconButton(onClick = onBackArrowPressed)
                {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        title = {
            Text(
                text = stringResource(currentNav.destinationId),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFFD2B48C), navigationIconContentColor = Color.Black),
        modifier = modifier
    )
}

@Composable
fun MyBottomAppBar(
    onHomeClicked: () -> Unit,
    onListClicked: () -> Unit,
    onInfoClicked: () -> Unit,
    isFirstScreen: Boolean,
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        actions = {
            IconButton(onClick = { onHomeClicked() }, modifier = Modifier.weight(0.33f)) {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = stringResource(R.string.home_bottom_button)
                )
            }
            if (!isFirstScreen) {
                IconButton(onClick = { onListClicked() }, modifier = Modifier.weight(0.33f)) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.List,
                        contentDescription = stringResource(R.string.list_bottom_icon)
                    )
                }
            }
            IconButton(onClick = { onInfoClicked() }, modifier = Modifier.weight(0.33f)) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = stringResource(R.string.info_bottom_icon)
                )
            }
        },
        containerColor = Color(0xFFD2B48C),
        modifier = modifier
    )
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    listOfCategories: Array<Categories>,
    onCategoryPressed: (Categories) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
    )
    {
        items(listOfCategories)
        {
            UbicationGrid(
                topic = it,
                onSectionClicked = { onCategoryPressed(it) },
                modifier = modifier.padding(horizontal = 4.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun UbicationGrid(
    topic: Categories,
    onSectionClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier
            .background(Color.White)
            .clickable { onSectionClicked() }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(height = 200.dp, width = 400.dp)
                .background(Color.White)
                .border(width = 4.dp, color = Color.Black, RoundedCornerShape(16.dp))
                .padding(horizontal = 26.dp, vertical = 14.dp)

        )
        {
            Image(
                painter = painterResource(id = topic.iconResource),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )
            Text(
                text = stringResource(topic.titleResource),
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )

        }
    }

}


@Composable
fun CategoryScreenTablet(
    modifier: Modifier = Modifier,
    listOfCategories: Array<Categories>,
    onCategoryPressed: (Categories) -> Unit,
) {
    Box(modifier = modifier.fillMaxSize())
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(12.dp)
                .align(Alignment.Center)
        ) {
            CategoryRowTablet(
                listOfCategories = listOfCategories,
                onCategoryPressed = onCategoryPressed
            )
        }
    }

}

@Composable
fun CategoryRowTablet(
    modifier: Modifier = Modifier,
    listOfCategories: Array<Categories>,
    onCategoryPressed: (Categories) -> Unit,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        items(listOfCategories) { category ->
            CategoryItemTablet(topic = category, onSectionClicked = { onCategoryPressed(category) })
        }
    }
}

@Composable
fun CategoryItemTablet(
    topic: Categories,
    onSectionClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(height = 400.dp, width = 200.dp)
            .border(width = 4.dp, color = Color.Black, RoundedCornerShape(16.dp))
            .padding(horizontal = 26.dp, vertical = 14.dp)
            .clickable { onSectionClicked() }
    )
    {
        Image(
            painter = painterResource(id = topic.iconResource),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
        )
        Text(
            text = stringResource(topic.titleResource),
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.W600,
        )

    }
}


//@Composable
//@Preview(showBackground = true)
//fun MainScreenPreview() {
//    MainScreen(
//        listOfCategories = Categories.entries.toTypedArray(),
//        isFirstScreen = true,
//        currentNav = R.string.mi_torreon_home,
//    )
//
//}

//@Composable
//@Preview
//fun PreviewTopAppBar() {
//    MyTopAppBar()
//}

//@Composable
//@Preview(widthDp = 700)
//fun UbicationGridTabletPreview() {
//    Scaffold(
//    ) { innerPadding ->
//        CategoryScreenTablet(listOfCategories = Categories.entries.toTypedArray(), onCategoryPressed = {})
//    }
//}