package fgsystem.franol.axumfoodreservation_sy


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import kotlinx.android.synthetic.main.fragment_addtocart.*


class Addtocart : Fragment() {

    private lateinit var addtocartButton: Button
    private lateinit var nameoffood: EditText
    private lateinit var priceoffood: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        addtocartButton = addtocart_button
        nameoffood = name_detial_activity
        priceoffood = price_detail_activity


        addtocartButton.setOnClickListener {



        }




        return inflater.inflate(R.layout.fragment_addtocart, container, false)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_addtocart)



    }
    private fun readFields() = Addtocart(
        nameoffood.text.toString(),
        priceoffood.text.toString()
    )
}



