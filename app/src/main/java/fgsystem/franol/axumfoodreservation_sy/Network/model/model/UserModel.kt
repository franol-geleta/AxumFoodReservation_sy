package fgsystem.franol.axumfoodreservation_sy.Network.model

data class UserModel (
    val username:String,
    val password:String,
    val name:String,
    val email:String,
    val phone:String,
    val enabled:Int,
    val roles:Set<RoleModel>,
    val profilePicture:String


)