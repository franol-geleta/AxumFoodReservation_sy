package fgsystem.franol.axumfoodreservation_sy.repository

import androidx.lifecycle.LiveData
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import fgsystem.franol.axumfoodreservation_sy.data.AddtocartDao

class AddtocartRepository(private val addtocartDao: AddtocartDao){


    fun allFood(): LiveData<List<Addtocart>> = addtocartDao.getAllFood()

    fun insertFood(addtocart: Addtocart){
        addtocartDao.insertFood(addtocart)
    }
}