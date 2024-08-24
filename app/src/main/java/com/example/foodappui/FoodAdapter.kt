package com.example.foodappui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodappui.databinding.ItemFoodBinding


class FoodAdapter (val data: List<Food>,val foodClickListener: FoodClickListener)
    : ListAdapter<Food, FoodAdapter.MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val binding: ItemFoodBinding) : ViewHolder(binding.root) {
        companion object{
            fun from(parent: ViewGroup) : MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFoodBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    interface FoodClickListener {
        fun onFoodClicked(food : Food)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.foodName.text = data.get(position).title
        holder.binding.foodImage.setImageResource(data.get(position).imageId)
        holder.binding.root.setOnClickListener {
            foodClickListener.onFoodClicked(data.get(position))
        }
    }
}

class UserItemDiffCallback: DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

}