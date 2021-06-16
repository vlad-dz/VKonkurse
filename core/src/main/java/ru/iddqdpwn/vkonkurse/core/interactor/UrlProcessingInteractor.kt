package ru.iddqdpwn.vkonkurse.core.interactor

import ru.iddqdpwn.vkonkurse.core.data.url_processing.UrlProcessingRepository
import ru.iddqdpwn.vkonkurse.core.domain.Giveaway

class UrlProcessingInteractor(private val urlProcessingRepository: UrlProcessingRepository) {

    suspend fun saveGiveaway(giveaway: Giveaway) = urlProcessingRepository.saveGiveaway(giveaway)

}