package ru.iddqdpwn.vkonkurse.local.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import ru.iddqdpwn.vkonkurse.local.db.dao.GiveawayDao
import ru.iddqdpwn.vkonkurse.local.db.model.Giveaway

@Database(
    entities = [Giveaway::class],
    version = 1
)
abstract class GiveawayDatabase : RoomDatabase() {
    abstract fun giveawayDao(): GiveawayDao

    companion object {
        @Volatile
        private var instance: GiveawayDatabase? = null
        private val LOCK = Any()

        fun getDatabase(context: Context): GiveawayDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, GiveawayDatabase::class.java, "giveaway.db")
                    .build().also {
                        instance = it
                    }
            }
        }

//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: buildDatabase(context).also { instance = it }
//        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            GiveawayDatabase::class.java, "giveaway.db"
        ).build()
    }
}