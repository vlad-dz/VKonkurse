package ru.iddqdpwn.vkonkurse.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.iddqdpwn.vkonkurse.ui.model.Giveaway
import ru.iddqdpwn.vkonkurse.ui.viewmodel.livedata.GiveawaysState

class GiveawaysViewModel(val interactorProvider: InteractorProvider) : ViewModel() {

    private val _giveaways = MutableLiveData<GiveawaysState>()
    val giveaways: LiveData<GiveawaysState> = _giveaways

    fun fetchAllGiveaways() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _giveaways.postValue(GiveawaysState.Loading)
            val giveaways = interactorProvider.giveawayInteractor.getAllGiveaways()
            _giveaways.postValue(GiveawaysState.LoadedSuccessfully(giveaways.map {
                Giveaway(it.title, it.link, it.date, it.id)
            }))
        } catch (ex: Exception) {
            _giveaways.postValue(GiveawaysState.Error(ex))
        }
    }
}