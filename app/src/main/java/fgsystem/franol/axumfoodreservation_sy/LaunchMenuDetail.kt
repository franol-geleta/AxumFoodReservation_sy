package fgsystem.franol.axumfoodreservation_sy


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import fgsystem.franol.axumfoodreservation_sy.data.Launch
import kotlinx.android.synthetic.main.fragment_launch_menu_detail.view.*



class LaunchMenuDetail : Fragment() {

//    private lateinit var addtocartButton : Button
    private lateinit var  nameoffood : TextView
    private lateinit var  priceoffood : TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_launch_menu_detail, container, false)

        val launch = arguments?.getSerializable("launch") as Launch

        view.name_detial_activity.text = launch.foodname
        view.price_detail_activity.text = launch.price
        // Inflate the layout for this fragment


//        addtocartButton = addtocart
//        nameoffood = name_detial
//        priceoffood = price_detail


        val addtocart = view.findViewById<Button>(R.id.addtocart)
        addtocart.setOnClickListener {
           val intent = Intent(this@LaunchMenuDetail.context, Login_fragment::class.java)
            startActivity(intent)

//            val food = readFields()
//            val replayFoodIntent = Intent()
//            replayFoodIntent.putExtra("FOOD",food)
//            activity?.setResult(Activity.RESULT_OK,replayFoodIntent)
//            activity?.finish()
        }

//        addtocartButton.setOnClickListener {
//            val food = readFields()
//            val replayFoodIntent = Intent()
//            replayFoodIntent.putExtra("FOOD",food)
//            activity?.setResult(Activity.RESULT_OK,replayFoodIntent)
//            activity?.finish()
//
//        }
        return view


    }

    private fun readFields() = Addtocart(
        nameoffood.text.toString(),
        priceoffood.text.toString()
    )

    interface OnAddtoChartSelected {
        fun OnAddtoChartSelected(addtocart: Addtocart)
    }



}
