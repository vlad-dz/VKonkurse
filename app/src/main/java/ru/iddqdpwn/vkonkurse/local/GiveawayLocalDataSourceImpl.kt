package ru.iddqdpwn.vkonkurse.local

import ru.iddqdpwn.vkonkurse.core.data.giveaway.GiveawayLocalDataSource
import ru.iddqdpwn.vkonkurse.core.domain.Giveaway
import ru.iddqdpwn.vkonkurse.local.db.GiveawayDatabase

class GiveawayLocalDataSourceImpl(private val database: GiveawayDatabase) : GiveawayLocalDataSource {

    override suspend fun getAllGiveaways(): List<Giveaway> {
        return database.giveawayDao().getAllGiveaways().map {
            Giveaway(it.title, it.link, it.date, it.id)
        }
    }

}