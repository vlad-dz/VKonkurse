package ru.iddqdpwn.vkonkurse.core.data.url_processing

import ru.iddqdpwn.vkonkurse.core.domain.Giveaway

interface UrlProcessingLocalDataSource {
    suspend fun saveGiveaway(giveaway: Giveaway)
}