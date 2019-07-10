package fgsystem.franol.axumfoodreservation_sy.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import fgsystem.franol.axumfoodreservation_sy.Network.ApiServices
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import fgsystem.franol.axumfoodreservation_sy.data.AllDatabase
import fgsystem.franol.axumfoodreservation_sy.repository.AddtocartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

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

class AddtocartViewModel(application: Application): AndroidViewModel(application) {

    val firstname = "Yabii"
    val lastname = "Biruk"



    private val addtocartRepository: AddtocartRepository

    init {
        val apiServices = ApiServices.getInstance()
        addtocartRepository = AddtocartRepository(apiServices)
    }
    private val _getResponse = MutableLiveData<Response<Addtocart>>()
    val getResponse:LiveData<Response<Addtocart>>
        get() = _getResponse
    private val _updateResponse = MutableLiveData<Response<Addtocart>>()
    val updateResponse: LiveData<Response<Addtocart>>
        get() = _updateResponse
    private val _insertResponse = MutableLiveData<Response<Addtocart>>()
    val insertResponse: LiveData<Response<Addtocart>>
        get() = _insertResponse
    private val _deleteResponse = MutableLiveData<Response<Addtocart>>()
    val deleteResponse: MutableLiveData<Response<Addtocart>>
        get() = _deleteResponse

    fun insertMedical(addtocart: Addtocart) = viewModelScope.launch(Dispatchers.IO) {
        addtocartRepository.insertFood(addtocart)
    }
    fun deleteMedical(addtocart: Addtocart) = viewModelScope.launch {

        addtocartRepository.deleteFood(addtocart)
    }
    fun updateMedical(addtocart: Addtocart) = viewModelScope.launch {
        addtocartRepository.updateMedical(addtocart)
    }
}