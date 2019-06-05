package fgsystem.franol.axumfoodreservation_sy.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AddtocartDao {


    @Query("SELECT * FROM addtocart ORDER BY name")
    fun getAllFood(): LiveData<List<Addtocart>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(addtocart: Addtocart):Long
}