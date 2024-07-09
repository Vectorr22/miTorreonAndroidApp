package com.example.mitorreonapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mitorreonapp.R

enum class Categories(
    @StringRes val titleResource: Int,
    @DrawableRes val iconResource: Int
){
    TOURISM(R.string.category_tourism, R.drawable.castle),
    GASTRONOMY(R.string.category_gastronomy, R.drawable.restaurant),
    SHOPPING(R.string.category_shopping, R.drawable.mall),
    PARKS_AND_GARDENS(R.string.category_parks_and_gardens, R.drawable.mountain),
    NIGHT_LIFE(R.string.category_night_life, R.drawable.bar),
    HOTELS(R.string.category_hotels, R.drawable.hotel)
}

class Ubication(
    val category: Categories,
    val name: String,
    val description: String,
    @DrawableRes val imageResource: Int,
    @DrawableRes val imageResource2: Int,
    @DrawableRes val imageResource3: Int,
    val latitude: Double,
    val longitude: Double
)

val listOfUbications = listOf(
    Ubication(
        category = Categories.TOURISM,
        name = "Cristo de las Noas",
        description = "Una de las estatuas de Cristo más grandes de México, ofrece una vista panorámica de la ciudad.",
        imageResource = R.drawable.cristo_de_las_noas,
        imageResource2 = R.drawable.cristo2,
        imageResource3 = R.drawable.cristo3,
        latitude = 25.5217,
        longitude = -103.4538
    ),
    Ubication(
        category = Categories.TOURISM,
        name = "Museo Arocena",
        description = "Un museo con una impresionante colección de arte e historia.",
        imageResource = R.drawable.museo_arocena,
        imageResource2 = R.drawable.arocena2,
        imageResource3 = R.drawable.arocena3,
        latitude = 25.5379,
        longitude = -103.4622
    ),
    Ubication(
        category = Categories.TOURISM,
        name = "Canal de la Perla",
        description = "Un histórico canal subterráneo, ahora convertido en un paseo turístico.",
        imageResource = R.drawable.canal1,
        imageResource2 = R.drawable.canal2,
        imageResource3 = R.drawable.canal3,
        latitude = 25.5415,
        longitude = -103.4385
    ),
    Ubication(
        category = Categories.TOURISM,
        name = "Plaza de Armas",
        description = "La plaza principal de la ciudad, rodeada de importantes edificios históricos.",
        imageResource = R.drawable.plaza1,
        imageResource2 = R.drawable.plaza2,
        imageResource3 = R.drawable.plaza4,
        latitude = 25.5422,
        longitude = -103.4399
    ),
    Ubication(
        category = Categories.TOURISM,
        name = "Teatro Nazas",
        description = "Un teatro con una rica historia, sede de múltiples eventos culturales.",
        imageResource = R.drawable.teatro1,
        imageResource2 = R.drawable.teatro2,
        imageResource3 = R.drawable.teatro3,
        latitude = 25.5377,
        longitude = -103.4456
    ),
    Ubication(
        category = Categories.TOURISM,
        name = "Casa del Cerro",
        description = "Un museo ubicado en una casa histórica que muestra la vida en Torreón en el siglo XIX.",
        imageResource = R.drawable.casa_cerro1,
        imageResource2 = R.drawable.casa_cerro2,
        imageResource3 = R.drawable.casa_cerro3,
        latitude = 25.5325,
        longitude = -103.4505
    ),
    Ubication(
        category = Categories.TOURISM,
        name = "Estadio Revolución",
        description = "El estadio de béisbol de Torreón, hogar de los Algodoneros de Unión Laguna.",
        imageResource = R.drawable.estadio1,
        imageResource2 = R.drawable.estadio2,
        imageResource3 = R.drawable.estadio3,
        latitude = 25.5231,
        longitude = -103.4133
    ),
    // Examples for GASTRONOMY
    Ubication(
        category = Categories.GASTRONOMY,
        name = "Hamb&Fries",
        description = "Local de hamburguesas con temática retro y americana",
        imageResource = R.drawable.hamb_and_fries,
        imageResource2 = R.drawable.burguers2,
        imageResource3 = R.drawable.burguer3,
        latitude = 25.5460,
        longitude = -103.4050
    ),
    Ubication(
        category = Categories.GASTRONOMY,
        name = "Tacos de La Joya",
        description = "Un lugar popular para disfrutar de auténticos tacos mexicanos.",
        imageResource = R.drawable.tacos_de_la_joya,
        imageResource2 = R.drawable.tacos2,
        imageResource3 = R.drawable.tacos3,
        latitude = 25.5424,
        longitude = -103.4281
    ),
    // Examples for SHOPPING
    Ubication(
        category = Categories.SHOPPING,
        name = "Galerías Laguna",
        description = "Centro comercial con una gran variedad de tiendas, restaurantes y entretenimiento.",
        imageResource = R.drawable.galerias_laguna,
        imageResource2 = R.drawable.galerias2,
        imageResource3 = R.drawable.galerias3,
        latitude = 25.5813,
        longitude = -103.4045
    ),
    Ubication(
        category = Categories.SHOPPING,
        name = "Mercado Juárez",
        description = "Mercado tradicional donde puedes encontrar productos locales y artesanías.",
        imageResource = R.drawable.mercado_juarez,
        imageResource2 = R.drawable.mercado2,
        imageResource3 = R.drawable.mercado3,
        latitude = 25.5465,
        longitude = -103.4180
    ),
    // Examples for PARKS_AND_GARDENS
    Ubication(
        category = Categories.PARKS_AND_GARDENS,
        name = "Bosque Venustiano Carranza",
        description = "Parque popular para actividades al aire libre como correr y andar en bicicleta.",
        imageResource = R.drawable.bosque_venustiano_carranza,
        imageResource2 = R.drawable.bosque2,
        imageResource3 = R.drawable.bosque3,
        latitude = 25.5500,
        longitude = -103.4110
    ),
    Ubication(
        category = Categories.PARKS_AND_GARDENS,
        name = "Campestre La Rosita",
        description = "Un club con áreas verdes, ideal para eventos y actividades recreativas.",
        imageResource = R.drawable.campestre_la_rosita,
        imageResource2 = R.drawable.campestre2,
        imageResource3 = R.drawable.campestre3,
        latitude = 25.5194,
        longitude = -103.4280
    ),
    // Examples for NIGHT_LIFE
    Ubication(
        category = Categories.NIGHT_LIFE,
        name = "La Terraza Bar",
        description = "Bar con una excelente vista y un ambiente relajado.",
        imageResource = R.drawable.la_terraza_bar,
        imageResource2 = R.drawable.terraza2,
        imageResource3 = R.drawable.terraza3,
        latitude = 25.5420,
        longitude = -103.4125
    ),
    Ubication(
        category = Categories.NIGHT_LIFE,
        name = "Ritter",
        description = "Un popular club nocturno con música en vivo.",
        imageResource = R.drawable.ritter,
        imageResource2 = R.drawable.ritter2,
        imageResource3 = R.drawable.ritter3,
        latitude = 25.5418,
        longitude = -103.4170
    ),
    Ubication(
        category = Categories.NIGHT_LIFE,
        name = "Ramirov",
        description = "Un bar de moda conocido por su ambiente vibrante.",
        imageResource = R.drawable.ramirov,
        imageResource2 = R.drawable.ramirov2,
        imageResource3 = R.drawable.ramirov3,
        latitude = 25.5468,
        longitude = -103.4055
    ),
    // Examples for HOTELS
    Ubication(
        category = Categories.HOTELS,
        name = "Hotel Marriott Torreón",
        description = "Hotel de lujo con todas las comodidades modernas.",
        imageResource = R.drawable.hotel_marriot,
        imageResource2 = R.drawable.marriot2,
        imageResource3 = R.drawable.marriot3,
        latitude = 25.5465,
        longitude = -103.4098
    ),
    Ubication(
        category = Categories.HOTELS,
        name = "Hotel Crowne Plaza",
        description = "Un hotel moderno y elegante en el centro de la ciudad.",
        imageResource = R.drawable.hotel_chrome_plaza,
        imageResource2 = R.drawable.crowne2,
        imageResource3 = R.drawable.crowne3,
        latitude = 25.5412,
        longitude = -103.4228
    )
)
