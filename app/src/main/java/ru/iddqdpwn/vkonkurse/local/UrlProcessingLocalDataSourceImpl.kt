package ru.iddqdpwn.vkonkurse.local

import ru.iddqdpwn.vkonkurse.core.data.url_processing.UrlProcessingLocalDataSource
import ru.iddqdpwn.vkonkurse.local.db.GiveawayDatabase
import ru.iddqdpwn.vkonkurse.local.db.model.Giveaway

class UrlProcessingLocalDataSourceImpl(private val database: GiveawayDatabase) :
    UrlProcessingLocalDataSource {

    override suspend fun saveGiveaway(giveaway: ru.iddqdpwn.vkonkurse.core.domain.Giveaway) {
        database.giveawayDao().insert(
            giveaway.let {
                Giveaway(
                    it.title,
                    it.link,
                    it.date,
                    it.id
                )
            }
        )
    }

}