package com.example.userinputdeleteupdate
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userinputdeleteupdate.databinding.UsersListLayoutBinding


class UsersAdapter(var usersList: MutableList<User>) : RecyclerView.Adapter<UsersViewHolder>() {


    private lateinit var itemClickListener: (User, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            UsersListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }


    fun setOnDeleteClickListener(clickListener: (User,Int) -> Unit) {
        this.itemClickListener = clickListener
    }


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        val user = usersList[position]
        holder.binding.tvEmail.text = user.email
        holder.binding.tvLastname.text = user.lastName
        holder.binding.tvFirstname.text = user.firstName



        holder.binding.btnDeleteUser.setOnClickListener{
            itemClickListener.invoke(user,position)
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}


data class User(
    var email : String,
    var lastName : String,
    var firstName: String,
)


class UsersViewHolder(val binding: UsersListLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

}