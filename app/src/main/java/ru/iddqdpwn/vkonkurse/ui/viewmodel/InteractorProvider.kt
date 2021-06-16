package ru.iddqdpwn.vkonkurse.ui.viewmodel

import android.app.Application
import ru.iddqdpwn.vkonkurse.core.data.giveaway.GiveawayRepository
import ru.iddqdpwn.vkonkurse.core.data.url_processing.UrlProcessingRepository
import ru.iddqdpwn.vkonkurse.core.interactor.GiveawayInteractor
import ru.iddqdpwn.vkonkurse.core.interactor.UrlProcessingInteractor
import ru.iddqdpwn.vkonkurse.local.GiveawayLocalDataSourceImpl
import ru.iddqdpwn.vkonkurse.local.UrlProcessingLocalDataSourceImpl
import ru.iddqdpwn.vkonkurse.local.db.GiveawayDatabase

class InteractorProvider(
    val urlProcessingInteractor: UrlProcessingInteractor,
    val giveawayInteractor: GiveawayInteractor
) {
    companion object {
        @Volatile
        private var instance: InteractorProvider? = null
        fun getInstance(application: Application): InteractorProvider {
            return instance ?: synchronized(this) {
                instance ?: get(application).also {
                    instance = it
                }
            }
        }

        private fun get(application: Application): InteractorProvider {

            val database = GiveawayDatabase.getDatabase(application)

            val urlProcessingLocalDataSource = UrlProcessingLocalDataSourceImpl(database)
            val urlProcessingRepository = UrlProcessingRepository(urlProcessingLocalDataSource)
            val urlProcessingInteractor = UrlProcessingInteractor(urlProcessingRepository)

            val giveawayLocalDataSource = GiveawayLocalDataSourceImpl(database)
            val giveawayRepository = GiveawayRepository(giveawayLocalDataSource)
            val giveawayInteractor = GiveawayInteractor(giveawayRepository)

            return InteractorProvider(
                urlProcessingInteractor,
                giveawayInteractor
            )
        }
    }
}