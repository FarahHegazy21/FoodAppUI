package com.example.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodappui.databinding.FragmentMealplanBinding

class MealPlansFragment : Fragment() {

    lateinit var binding: FragmentMealplanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMealplanBinding.inflate(inflater,container,false)


        return binding.root
    }
}