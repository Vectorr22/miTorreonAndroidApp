package com.example.mitorreonapp.data

data class UbicationUiState(

    val currentCategory: Categories? = null,

    val listOfCategorieUbications: List<Ubication> = listOf(),

    val currentUbication: Ubication? = null,

    val currentImageToDisplay: Int? = currentUbication?.imageResource
)
