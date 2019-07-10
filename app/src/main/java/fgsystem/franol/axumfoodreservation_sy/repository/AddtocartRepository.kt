package fgsystem.franol.axumfoodreservation_sy.repository

import androidx.lifecycle.LiveData
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import fgsystem.franol.axumfoodreservation_sy.data.AddtocartDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import java.net.ConnectException
import java.util.ArrayList

class AddtocartRepository(private val addtocartDao: AddtocartDao){


    fun allFood(): LiveData<List<Addtocart>> = addtocartDao.getAllFood()

    fun insertFood(addtocart: Addtocart){
        addtocartDao.insertFood(addtocart)
    }
}


