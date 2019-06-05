package fgsystem.franol.axumfoodreservation_sy.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "addtocart")
data class Addtocart (
    @PrimaryKey @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "price")val price : String
):Serializable