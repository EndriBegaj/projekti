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

        val userId = arguments?.getInt("userId")
        val id = arguments?.getInt("id")
        val title = arguments?.getString("title")
        val body = arguments?.getString("body")
        val imageUrl = arguments?.getString("imageUrl")


        binding.titleText.text = title
        binding.bodyText.text = body


        if (!imageUrl.isNullOrEmpty()) {

            Picasso.get().load(imageUrl).into(binding.imageView)
        } else {

            Picasso.get().load(R.drawable.baseline_photo_24).into(binding.imageView)
        }
    }
}
