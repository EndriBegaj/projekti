package com.example.projekti

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projekti.databinding.ItemPostBinding
import com.squareup.picasso.Picasso


class PostAdapter(
    private val posts: List<Post>,
    private val onPostClick: (Post) -> Unit // Add a listener to handle clicks
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = posts.size

    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.title.text = post.title      // Set title
            binding.body.text = post.body        // Set body
            Picasso.get().load(post.imageUrl).into(binding.imageView)  // Picasso for image loading

            // Set up the click listener
            binding.root.setOnClickListener {
                onPostClick(post) // Trigger the click listener when the item is clicked
            }
        }
    }
}

