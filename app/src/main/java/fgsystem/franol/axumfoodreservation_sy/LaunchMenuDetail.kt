package fgsystem.franol.axumfoodreservation_sy


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import fgsystem.franol.axumfoodreservation_sy.data.Launch
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_launch_menu_detail.*
import kotlinx.android.synthetic.main.fragment_launch_menu_detail.view.*



class LaunchMenuDetail : Fragment() {

    val addtocartButton = addtocart
    val nameoffood = name_detial
    val priceoffood = price_detail

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_launch_menu_detail, container, false)

        val launch = arguments?.getSerializable("launch") as Launch

        view.name_detial.text = launch.foodname
        view.price_detail.text = launch.price
        // Inflate the layout for this fragment




        addtocartButton.setOnClickListener {


            Snackbar.make(rootLayout, "Please enter email address", Snackbar.LENGTH_SHORT).show()

//            val food = readFields()
//            val replayFoodIntent = Intent()
//            replayFoodIntent.putExtra("FOOD",food)
//            getActivity()!!.setResult(Activity.RESULT_OK,replayFoodIntent)
//            getActivity()?.finish()


        }
        return view


    }

    private fun readFields() = Addtocart(
        nameoffood.text.toString(),
        priceoffood.text.toString()
    )


}
