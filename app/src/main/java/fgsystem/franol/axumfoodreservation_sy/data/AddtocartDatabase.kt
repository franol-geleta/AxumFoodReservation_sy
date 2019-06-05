package fgsystem.franol.axumfoodreservation_sy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Addtocart::class), version = 1)
abstract class AddtocartDatabase : RoomDatabase(){

    abstract fun AddtocartDao() : AddtocartDao

    companion object {
        @Volatile
        private var INSTANCE: AddtocartDatabase? = null

        fun getDatabase(context: Context): AddtocartDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AddtocartDatabase::class.java, "addtochart_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}