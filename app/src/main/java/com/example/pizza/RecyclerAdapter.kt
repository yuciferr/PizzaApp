package com.example.pizza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza.RecyclerAdapter.*

class RecyclerAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var titles = arrayOf("Mushroom Pizza","Shrimp Pizza","Napoliten Pizza","Pepperoni Pizza"
        ,"Veggie Pizza","Four Cheese Pizza")
    private var prices = arrayOf("$9.00","$14.00","$8.00","$10.50"
        ,"$8.00","$11.50")
    private var images = intArrayOf(R.drawable.pizza1,R.drawable.pizza2,R.drawable.pizza3,
        R.drawable.pizza4,R.drawable.pizza5,R.drawable.pizza6)


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title:TextView
        var price:TextView
        var image:ImageView

        init {
            title = itemView.findViewById(R.id.textView2)
            image = itemView.findViewById(R.id.imageView)
            price = itemView.findViewById(R.id.price)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_pizza,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.price.text = prices[position]
        holder.image.setImageResource(images[position])

        holder.itemView.setOnClickListener{

            holder.itemView.findNavController().navigate(R.id.action_homeFragment_to_detailFragment)

        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}