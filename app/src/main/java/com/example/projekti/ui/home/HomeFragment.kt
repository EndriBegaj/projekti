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

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the adapter with an empty list and the click listener
        postAdapter = PostAdapter(emptyList()) { post ->
            // Navigate to DetailFragment
            navigateToDetailFragment(post)
        }

        binding.recyclerView.adapter = postAdapter

        // Observe LiveData for updates
        postViewModel.posts.observe(viewLifecycleOwner, { posts ->
            // Update the adapter with the new posts
            postAdapter = PostAdapter(posts) { post ->
                navigateToDetailFragment(post)
            }
            binding.recyclerView.adapter = postAdapter
        })

        // Fetch posts from the ViewModel
        postViewModel.fetchPosts()
    }

    // A method to navigate to the DetailFragment with the post details
    private fun navigateToDetailFragment(post: Post) {
        val bundle = Bundle().apply {
            putInt("userId", post.userId)
            putInt("id", post.id)
            putString("title", post.title)
            putString("body", post.body)

            // Check for null or empty imageUrl and handle accordingly
            if (!post.imageUrl.isNullOrEmpty()) {
                putString("imageUrl", post.imageUrl)
            } else {
                // Optionally handle the case where imageUrl is null or empty
                putString("imageUrl", "")  // Empty string or remove this line if you want to leave it empty
            }
        }

        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle) // Correct action ID
    }
}
