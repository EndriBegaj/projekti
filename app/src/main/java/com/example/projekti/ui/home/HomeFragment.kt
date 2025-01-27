package com.example.projekti.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projekti.Post
import com.example.projekti.PostAdapter
import com.example.projekti.PostViewModel
import com.example.projekti.R
import com.example.projekti.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)
        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)


        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        postAdapter = PostAdapter(emptyList()) { post ->

            navigateToDetailFragment(post)
        }

        binding.recyclerView.adapter = postAdapter


        postViewModel.posts.observe(viewLifecycleOwner, { posts ->

            postAdapter = PostAdapter(posts) { post ->
                navigateToDetailFragment(post)
            }
            binding.recyclerView.adapter = postAdapter
        })


        postViewModel.fetchPosts()
    }


    private fun navigateToDetailFragment(post: Post) {
        val bundle = Bundle().apply {
            putInt("userId", post.userId)
            putInt("id", post.id)
            putString("title", post.title)
            putString("body", post.body)


            if (!post.imageUrl.isNullOrEmpty()) {
                putString("imageUrl", post.imageUrl)
            } else {

                putString("imageUrl", "")
            }
        }

        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}
