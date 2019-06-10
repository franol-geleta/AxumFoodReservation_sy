package fgsystem.franol.axumfoodreservation_sy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Addtocart::class), version = 1)
abstract class AllDatabase : RoomDatabase(){

    abstract fun AddtocartDao() : AddtocartDao
    abstract fun FoodDao() : FoodDao
    abstract fun UserDao() : UserDao


    companion object {
        @Volatile
        private var INSTANCE: AllDatabase? = null

        fun getDatabase(context: Context): AllDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AllDatabase::class.java, "addtocart_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}