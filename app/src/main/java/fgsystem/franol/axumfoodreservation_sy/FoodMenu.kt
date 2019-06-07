package fgsystem.franol.axumfoodreservation_sy


import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions


class FoodMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_food_menu, container, false)

        setHasOptionsMenu(true)
        val Launch = view.findViewById<CardView>(R.id.launchMenu)
        Launch.setOnClickListener {
            val fr = fragmentManager!!.beginTransaction()
            fr.replace(R.id.relativelayout, LaunchMenu())
            fr.addToBackStack(null)
            fr.commit()
        }

//        view.findViewById<Button>(R.id.launchMenu)?.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.next_action, null)
//        )



        return view
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        val options = navOptions {
//            anim {
//                enter = R.anim.slide_in_right
//                exit = R.anim.slide_out_left
//                popEnter = R.anim.slide_in_left
//                popExit = R.anim.slide_out_right
//            }
//        }
//        view.findViewById<Button>(R.id.launchMenu)?.setOnClickListener {
////            NavHostFragment.findNavController().navigate(R.id.flow_step_one_dest, null, options)
//        }

//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.activity_main_drawer, menu)
//    }
//

}
