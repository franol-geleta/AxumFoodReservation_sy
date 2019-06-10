package fgsystem.franol.axumfoodreservation_sy.data

import androidx.room.Entity
import java.io.Serializable


@Entity(tableName = "users")
class User(
    val id: Int,
    val email: String,
    val name: String,
    val school: String):Serializable