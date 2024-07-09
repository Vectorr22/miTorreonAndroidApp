package com.example.mitorreonapp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mitorreonapp.data.Categories
import com.example.mitorreonapp.data.Ubication
import com.example.mitorreonapp.data.UbicationUiState
import com.example.mitorreonapp.data.listOfUbications
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UbicationViewModel : ViewModel() {

    //Declarar el uiState privado y publico
    private val _uiState = MutableStateFlow(UbicationUiState())
    val uiState: StateFlow<UbicationUiState> = _uiState.asStateFlow()
    private val imageStack = ArrayDeque<Int>()

    fun changeCategory(category: Categories) {
        _uiState.update { currentState ->
            imageStack.clear()
            currentState.copy(
                currentCategory = category,
                listOfCategorieUbications = getUbicationsFromCategory(category)
            )
        }
    }

    fun changeCurrentUbication(ubication: Ubication) {
        _uiState.update { currentState ->
            if (currentState.currentUbication == null) {
                imageStack.addLast(ubication.imageResource)
                currentState.copy(
                    currentUbication = ubication,
                    currentImageToDisplay = imageStack.last()
                )
            } else {
                currentState.copy(
                    currentUbication = ubication,
                    currentImageToDisplay = ubication.imageResource,

                )
            }

        }
    }

    fun changeToNextImage() {
        _uiState.update { currentState ->
            val currentUbication = currentState.currentUbication
            when (currentState.currentImageToDisplay) {
                currentUbication?.imageResource -> {
                    imageStack.addLast(currentUbication!!.imageResource2)
                    currentState.copy(
                        currentImageToDisplay = imageStack.last()
                    )
                }

                currentUbication?.imageResource2 -> {
                    imageStack.addLast(currentUbication!!.imageResource3)
                    currentState.copy(
                        currentImageToDisplay = imageStack.last()
                    )
                }

                currentUbication?.imageResource3 -> {
                    imageStack.addLast(currentUbication!!.imageResource)
                    currentState.copy(
                        currentImageToDisplay = imageStack.last()
                    )
                }

                else -> {
                    currentState.copy(
                        currentImageToDisplay = currentUbication?.imageResource
                    )
                }
            }
        }
    }

    fun changeToLastImage() {
        _uiState.update { currentState ->
            val currentUbication = currentState.currentUbication
            if(currentState.currentImageToDisplay != currentUbication!!.imageResource)
            {
                imageStack.removeLast()
                currentState.copy(
                    currentImageToDisplay = imageStack.last()
                )
            }
            else
            {
                currentState.copy()
            }
        }
    }

    private fun resetModel()
    {
        _uiState.update {
            currentState ->
            currentState.copy(
                currentCategory = null,
                currentUbication = null,
                listOfCategorieUbications = listOf(),
                currentImageToDisplay = null
            )
        }
    }


    private fun getUbicationsFromCategory(category: Categories): List<Ubication> {
        val ubications: MutableList<Ubication> = mutableListOf()
        listOfUbications.forEach {
            if (it.category == category)
                ubications.add(it)
        }
        return ubications.toList()
    }
}