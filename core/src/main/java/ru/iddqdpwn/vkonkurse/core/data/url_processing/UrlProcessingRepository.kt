package ru.iddqdpwn.vkonkurse.core.data.url_processing

import ru.iddqdpwn.vkonkurse.core.domain.Giveaway

class UrlProcessingRepository(private val urlProcessingLocalDataSource: UrlProcessingLocalDataSource) {

    suspend fun saveGiveaway(giveaway: Giveaway) = urlProcessingLocalDataSource.saveGiveaway(giveaway)
}