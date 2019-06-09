package fgsystem.franol.axumfoodreservation_sy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import fgsystem.franol.axumfoodreservation_sy.R
import fgsystem.franol.axumfoodreservation_sy.data.User

class UsersAdapter(private val mCtx: Context, private val userList: List<User>) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: UsersViewHolder, position: Int) {
        val user = userList[position]

        holder.textViewName.text = user.name
        holder.textViewEmail.text = user.email
        holder.textViewSchool.text = user.school
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    internal inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewName: TextView
        var textViewEmail: TextView
        var textViewSchool: TextView

        init {

            textViewName = itemView.findViewById(R.id.textViewName)
            textViewEmail = itemView.findViewById(R.id.textViewEmail)
            textViewSchool = itemView.findViewById(R.id.textViewSchool)
        }
    }
}
