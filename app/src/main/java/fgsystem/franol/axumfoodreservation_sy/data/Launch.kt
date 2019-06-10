package fgsystem.franol.axumfoodreservation_sy.data

import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "launch")
data class Launch(
    val foodname: String,
    val price : String):Serializable