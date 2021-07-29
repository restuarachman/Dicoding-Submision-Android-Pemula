package com.restu.mybook


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions



class DetailBookActivity : AppCompatActivity() {
    companion object {
        const val KEY_BOOK = ""
    }
    val setBtnText = mapOf(true to "Favorited", false to "Favorite")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Book"

        var keyBook: Book = intent.getParcelableExtra<Book>(KEY_BOOK) as Book
        val tvTitle: TextView = findViewById(R.id.tv_detail_title)
        val tvAuthor: TextView = findViewById(R.id.tv_detail_author)
        val tvPublisher: TextView = findViewById(R.id.tv_detail_publisher)
        val tvRelease: TextView = findViewById(R.id.tv_detail_release)
        val tvDescription: TextView = findViewById(R.id.tv_detail_detail)
        val imgBook: ImageView = findViewById(R.id.img_detail_photo)
        val btnFav: Button = findViewById(R.id.btn_favourite)
        val isFav: Boolean = BookData.bookFav[BookData.getIndex(keyBook)]
        btnFav.text = setBtnText[isFav]

        Glide.with(this)
            .load(keyBook.photo)
            .apply(RequestOptions())
            .into(imgBook)

        tvTitle.text = keyBook.title
        tvAuthor.text = keyBook.author
        tvPublisher.text = keyBook.publisher
        tvRelease.text = keyBook.release_date
        tvDescription.text = keyBook.detail
        Toast.makeText(this, "$keyBook.title", Toast.LENGTH_SHORT)


        btnFav.setOnClickListener {

            BookData.getFav(keyBook)
            if (!isFav) {
                Toast.makeText(this, "${keyBook.title} added to Favorite", Toast.LENGTH_SHORT).show()
                btnFav.setText("Favorited")
            } else {
                btnFav.setText("Favorite")
                Toast.makeText(this, "${keyBook.title} removed from Favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}