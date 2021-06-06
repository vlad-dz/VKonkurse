package ru.iddqdpwn.vkonkurse.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.iddqdpwn.vkonkurse.local.db.model.Giveaway

@Dao
interface GiveawayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(giveaway: Giveaway)

    @Delete
    fun delete(giveaway: Giveaway)

    @Query("SELECT * FROM giveaway")
    fun getAllGiveaways(): List<Giveaway>

}