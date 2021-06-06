package ru.iddqdpwn.vkonkurse.local

import ru.iddqdpwn.vkonkurse.core.data.url_processing.UrlProcessingLocalDataSource
import ru.iddqdpwn.vkonkurse.local.db.GiveawayDatabase

class UrlProcessingLocalDataSourceImpl(private val database: GiveawayDatabase): UrlProcessingLocalDataSource {
}