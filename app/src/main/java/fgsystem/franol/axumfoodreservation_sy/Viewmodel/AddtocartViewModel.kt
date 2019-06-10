package fgsystem.franol.axumfoodreservation_sy.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import fgsystem.franol.axumfoodreservation_sy.data.AllDatabase
import fgsystem.franol.axumfoodreservation_sy.repository.AddtocartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddtocartViewModel(application: Application):AndroidViewModel(application) {

    private val addtocartRepository : AddtocartRepository

    val allFood : LiveData<List<Addtocart>>

    init {
        val addtocartDao = AllDatabase.getDatabase(application).AddtocartDao()
        addtocartRepository = AddtocartRepository(addtocartDao)
        allFood = addtocartRepository.allFood()
    }

    fun insertFood(addtocart: Addtocart) = viewModelScope.launch(Dispatchers.IO){addtocartRepository.insertFood(addtocart)}
}