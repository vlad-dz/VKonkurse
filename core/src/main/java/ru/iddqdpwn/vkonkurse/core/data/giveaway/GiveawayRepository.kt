package ru.iddqdpwn.vkonkurse.core.data.giveaway

class GiveawayRepository(val giveawayLocalDataSource: GiveawayLocalDataSource) {

    suspend fun getAllGiveaways() = giveawayLocalDataSource.getAllGiveaways()
}