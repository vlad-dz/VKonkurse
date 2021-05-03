package ru.iddqdpwn.vkonkurse.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.iddqdpwn.vkonkurse.db.model.Giveaway

@Dao
interface GiveawayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(giveaway: Giveaway)

    @Delete
    fun delete(giveaway: Giveaway)

    @Query("SELECT * FROM giveaway")
    fun getAllGiveaways(): List<Giveaway>

}