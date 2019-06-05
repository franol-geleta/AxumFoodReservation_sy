package fgsystem.franol.axumfoodreservation_sy


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fgsystem.franol.axumfoodreservation_sy.data.Launch
import kotlinx.android.synthetic.main.fragment_launch.view.*
import kotlinx.android.synthetic.main.launch_recycler_view.view.*


class LaunchMenu : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var listener: OnFoodSelected


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFoodSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnCourseSelected")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_launch, container, false)

        val activity = activity as Context
        recyclerView = view.recycler_view
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = LaunchAdapter(activity)
        recyclerView.setHasFixedSize(true)

        // Inflate the layout for this fragment
        return view
    }

    inner class LaunchAdapter(activity: Context) : RecyclerView.Adapter<LaunchAdapter.LaunchViewHolder>() {
        private val launchs = listOf(
            Launch("food 1","$ 34.3"),
            Launch("food 2","$ 55.6"),
            Launch("food 3","$ 31.33"),
            Launch("food 4","$ 89.4"),
            Launch("food 5","$ 43.2"),
            Launch("food 6","$ 66.3"),
            Launch("food 7","$ 99.1")
        )


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchAdapter.LaunchViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val recyclerViewItem = inflater.inflate(R.layout.launch_recycler_view,parent,false)

            return LaunchViewHolder(recyclerViewItem)
        }

        override fun getItemCount(): Int {
                return launchs.size
        }

        override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {

            val launch = launchs[position]

            holder.itemView.name.text = launch.foodname
            holder.itemView.price.text = launch.price

            holder.itemView.setOnClickListener {
                listener.OnFoodSelected(launch)
            }
               }

        inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    }


    interface OnFoodSelected {
        fun OnFoodSelected(launch: Launch)
    }

}

