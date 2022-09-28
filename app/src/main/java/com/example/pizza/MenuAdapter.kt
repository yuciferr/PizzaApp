package com.example.pizza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.MenuAdapter.*

class MenuAdapter : RecyclerView.Adapter<ViewHolder>() {

    var pizzaList : ArrayList<Pizza> = pizzas

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title:TextView
        var price:TextView
        var image:ImageView

        init {
            title = itemView.findViewById(R.id.textView2)
            image = itemView.findViewById(R.id.pizzaImage)
            price = itemView.findViewById(R.id.price)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_pizza,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pizza = pizzaList[position]
        holder.image.setImageResource(pizza.img)
        holder.price.text = pizza.price.toString()
        holder.title.text = pizza.name.toString()

        holder.itemView.setOnClickListener{

            holder.itemView.findNavController().navigate(R.id.action_homeFragment_to_detailFragment)

        }
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}