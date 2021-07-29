package com.restu.mybook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridAdapter(private val listBook: ArrayList<Book>):RecyclerView.Adapter<GridAdapter.GridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_book, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridAdapter.GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
                .load(listBook[position].photo)
                .apply(RequestOptions().override(350,550))
                .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_grid_photo)
    }
}
