package ru.serguun42.android.ats.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import ru.serguun42.android.ats.model.BusinessDetails
import ru.serguun42.android.ats.model.PersonalDetails

@Database(
    entities = [BusinessDetails::class, PersonalDetails::class], version = 1
)
abstract class RoomDatabase : androidx.room.RoomDatabase() {
    abstract fun detailsDAO(): DetailsDAO

    companion object {
        private var instance: RoomDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): RoomDatabase {
            if (instance == null) instance = Room.databaseBuilder(
                ctx.applicationContext, RoomDatabase::class.java, "ats_app_database"
            ).fallbackToDestructiveMigration().build()

            return instance!!
        }
    }
}