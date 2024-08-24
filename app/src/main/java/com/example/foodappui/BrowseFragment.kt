package com.example.foodappui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodappui.databinding.FragmentBrowseBinding

class BrowseFragment : Fragment(),FoodAdapter.FoodClickListener {

    lateinit var binding: FragmentBrowseBinding
    var Foods: MutableList<Food> = mutableListOf()
    lateinit var foodAdapter: FoodAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBrowseBinding.inflate(inflater,container,false)

        Foods= mutableListOf(Food(resources.getString(R.string.burger),R.drawable.burger),
            Food(resources.getString(R.string.steak),R.drawable.filletsteak),
            Food(resources.getString(R.string.pancakes),R.drawable.pancakes),
            Food(resources.getString(R.string.pizza),R.drawable.pizza),
            Food(resources.getString(R.string.shawerma),R.drawable.shawerma),
            Food(resources.getString(R.string.waffles),R.drawable.waffles)
           )


        foodAdapter=FoodAdapter(Foods,this)

        binding.foods.adapter=foodAdapter

        return binding.root
    }

    override fun onFoodClicked(food: Food) {
        val action = BrowseFragmentDirections.actionBrowseFragmentToBrowseDetailsFragment(food)
        findNavController().navigate(action)
    }
}