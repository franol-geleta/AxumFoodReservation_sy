package fgsystem.franol.axumfoodreservation_sy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import fgsystem.franol.axumfoodreservation_sy.Viewmodel.AddtocartViewModel
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import kotlinx.android.synthetic.main.activity_addtocartmain.*

const val NEW_COURSE_ACTIVITY_REQUEST_CODE = 1

class Addtocartmain : AppCompatActivity() {

    lateinit var addtocartViewModel: AddtocartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtocartmain)


        val addtocartListAdapter = AddtocartListAdapter(this)
        recycler_view.adapter = addtocartListAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)



        feb.setOnClickListener{
            val intent = Intent(this,Login_fragment::class.java)
            startActivityForResult(intent,NEW_COURSE_ACTIVITY_REQUEST_CODE)
        }
        addtocartViewModel = ViewModelProviders.of(this).get(AddtocartViewModel::class.java)
        addtocartViewModel.allFood.observe(this, Observer {
                foods -> foods?.let { addtocartListAdapter.setFood(foods) }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_COURSE_ACTIVITY_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK
        ) {
            val addtocart: Addtocart = data?.getSerializableExtra("FOOD") as Addtocart
            addtocartViewModel.insertFood(addtocart)
        }
    }


}

