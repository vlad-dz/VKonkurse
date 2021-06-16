package ru.iddqdpwn.vkonkurse.ui.viewmodel.livedata

import ru.iddqdpwn.vkonkurse.ui.model.Giveaway

sealed class GiveawaysState {
    object Loading: GiveawaysState()
    data class LoadedSuccessfully(val giveaways: List<Giveaway>): GiveawaysState()
    data class Error(val error: Throwable): GiveawaysState()
}