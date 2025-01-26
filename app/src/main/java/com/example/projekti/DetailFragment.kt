package com.example.projekti.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.projekti.R
import com.example.projekti.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)

        // Get the arguments passed from the HomeFragment
        val userId = arguments?.getInt("userId")
        val id = arguments?.getInt("id")
        val title = arguments?.getString("title")
        val body = arguments?.getString("body")
        val imageUrl = arguments?.getString("imageUrl")

        // Set the data to your UI components
        binding.titleText.text = title
        binding.bodyText.text = body

        // Check if the imageUrl is not empty or null
        if (!imageUrl.isNullOrEmpty()) {
            // Load the image using Picasso
            Picasso.get().load(imageUrl).into(binding.imageView)
        } else {
            // Use a placeholder image if imageUrl is empty or null
            Picasso.get().load(R.drawable.baseline_photo_24).into(binding.imageView) // Replace with your actual placeholder image resource
        }
    }
}
