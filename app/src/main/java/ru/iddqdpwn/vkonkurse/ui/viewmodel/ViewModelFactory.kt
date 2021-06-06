package ru.iddqdpwn.vkonkurse.ui.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(activity: AppCompatActivity) :
    AbstractSavedStateViewModelFactory(activity, null) {

    val interactorProvider = InteractorProvider.getInstance(activity.application)

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when {
            UrlProcessingViewModel::class.java.isAssignableFrom(modelClass) -> {
                UrlProcessingViewModel(interactorProvider) as T
            }
            else -> {
                throw IllegalArgumentException("$modelClass - is unknown ViewModel ")
            }
        }
    }
}