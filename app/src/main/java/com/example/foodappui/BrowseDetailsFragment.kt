package com.example.foodappui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.foodappui.databinding.FragmentBrowseDetailsBinding

class BrowseDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBrowseDetailsBinding
    private val args : BrowseDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrowseDetailsBinding.inflate(inflater, container, false)

        val food = args.food

        binding.foodImage.setImageResource(food.imageId)
        binding.foodName.text = food.title

        return binding.root
    }
}
