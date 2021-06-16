package ru.iddqdpwn.vkonkurse.core.data.giveaway

import ru.iddqdpwn.vkonkurse.core.domain.Giveaway

interface GiveawayLocalDataSource {

    suspend fun getAllGiveaways(): List<Giveaway>

}