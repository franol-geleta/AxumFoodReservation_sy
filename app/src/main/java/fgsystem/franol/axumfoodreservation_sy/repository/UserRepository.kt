package fgsystem.franol.axumfoodreservation_sy.repository

import androidx.lifecycle.LiveData
import com.google.android.gms.common.api.Api
import fgsystem.franol.axumfoodreservation_sy.Network.ApiServices
import fgsystem.franol.axumfoodreservation_sy.data.Food
import fgsystem.franol.axumfoodreservation_sy.data.FoodDao
import fgsystem.franol.axumfoodreservation_sy.data.User
import fgsystem.franol.axumfoodreservation_sy.data.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.internal.userAgent
import retrofit2.Response
import java.net.ConnectException

@Singleton
class UserRepository constructor(private val userDao: UserDao, private val userApiService: ApiServices) {

    suspend fun login(authBody: AuthBody): Response<LoginResponse> =
        withContext(Dispatchers.IO){
            userApiService.Login(authBody.username,authBody.password).await()
        }
    suspend fun getLoggedInUserInfoAPI(token:String): Response<UserInfo> =
        withContext(Dispatchers.IO){
            userApiService.getLoggedInUserInfo(token).await()
        }
    suspend fun getLoggedInUserInfo(token: String, username:String):User? =
        withContext(Dispatchers.IO){
            try{
                val res = getLoggedInUserInfoAPI(token).body()
                if (res!=null){
                    val user = User(res.username,res.name,res.phone,res.email,res.profilePicture,res.numberOfPosts)
                    userDao.insertuser(user)
                    return@withContext user
                }
            }
            catch (e: ConnectException){
                if (username != DEFAULT_VALUE_SHARED_PREF){
                    return@withContext userDao.getById(username)
                }
                //if there is no saved username in shared pref
                return@withContext null

            }
            //some error case
            return@withContext null
        }

    fun allUsers(): LiveData<List<User>> = userDao.getById()
    fun insertUser(product: User) = userDao.insertuser(product)
    fun updateUser(product: User) = userDao.getusers(product)
    fun deleteUser(product: User) = userDao.deletallusers(product)
}