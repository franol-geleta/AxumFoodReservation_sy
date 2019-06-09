package fgsystem.franol.axumfoodreservation_sy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fgsystem.franol.axumfoodreservation_sy.R
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import kotlinx.android.synthetic.main.addtocart_recycler_view_item.view.*

class AddtocartListAdapter(context: Context):RecyclerView.Adapter<AddtocartListAdapter.AddtoCartViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var addtocarts : List<Addtocart> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddtoCartViewHolder {
        val recyclerView = inflater.inflate(R.layout.addtocart_recycler_view_item,parent,false)
        return AddtoCartViewHolder(recyclerView)
    }

    override fun getItemCount() = addtocarts.size

    override fun onBindViewHolder(holder: AddtoCartViewHolder, position: Int) {
        val addtocart = addtocarts[position]
        holder.nameoffood.text = addtocart.name
        holder.priceoffood.text = addtocart.price
    }


    inner class AddtoCartViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        val nameoffood = itemView.nameoffood
        val priceoffood = itemView.priceoffood
    }

    internal fun setFood(addtocart : List<Addtocart>){
        this.addtocarts = addtocart
        notifyDataSetChanged()
    }


}