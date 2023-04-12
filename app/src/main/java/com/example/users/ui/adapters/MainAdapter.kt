package com.example.users.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.users.R
import com.example.users.databinding.ResItemUserBinding
import com.example.users.model.User
import java.util.*

class MainAdapter(private val onItemClicked: (User) -> Unit) : RecyclerView.Adapter<MainViewHolder>(){

    private var users = mutableListOf<User>()

    fun setUserList(users: List<User>){
        this.users = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemUserBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, onItemClicked)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}

class MainViewHolder(val binding: ResItemUserBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(user: User, onItemClicked: (User) -> Unit) {

        binding.tvNameUser.text = user.login.replaceFirstChar(Char::uppercase)
        binding.tvType.text = user.type

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(user.avatar_url)
            .into(binding.ivAvatar)

        itemView.setOnClickListener{
            onItemClicked(user)
        }
    }
}