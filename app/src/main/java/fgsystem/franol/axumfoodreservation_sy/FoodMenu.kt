package fgsystem.franol.axumfoodreservation_sy


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView


class FoodMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_food_menu, container, false)

        val Launch = view.findViewById<CardView>(R.id.launchMenu)
        Launch.setOnClickListener {
            val fr = fragmentManager!!.beginTransaction()
            fr.replace(R.id.relativelayout, LaunchMenu())
            fr.addToBackStack(null)
            fr.commit()
        }
        return view
    }


}
