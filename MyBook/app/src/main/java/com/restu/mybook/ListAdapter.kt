package com.restu.mybook

    import android.content.Intent
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView
    import com.bumptech.glide.Glide
    import com.bumptech.glide.request.RequestOptions

    class ListAdapter(private val listbook: ArrayList<Book>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
            return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val book: Book = listbook[position]
            Glide.with(holder.itemView.context)
                    .load(book.photo)
                    .apply(RequestOptions().override(120, 160))
                    .into(holder.imgPhoto)
            holder.tvTitle.text = book.title
            holder.tvAuthor.text = book.author
            holder.tvDetail.text = book.detail


            val thisContext = holder.itemView.context
            holder.itemView.setOnClickListener {
                val intent = Intent(thisContext, DetailBookActivity::class.java)
                intent.putExtra(DetailBookActivity.KEY_BOOK, book)
                thisContext.startActivity(intent)
            }
        }

        override fun getItemCount(): Int {
            return listbook.size
        }

        class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
            var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author)
            var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
            var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        }
    }


