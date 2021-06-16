package ru.iddqdpwn.vkonkurse.core.interactor

import ru.iddqdpwn.vkonkurse.core.data.giveaway.GiveawayRepository
import ru.iddqdpwn.vkonkurse.core.domain.Giveaway

class GiveawayInteractor(val giveawayRepository: GiveawayRepository) {

    suspend fun getAllGiveaways(): List<Giveaway> = giveawayRepository.getAllGiveaways()

}