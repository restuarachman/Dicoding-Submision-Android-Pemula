package com.restu.mybook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBook: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()
    private var title: String = "List Book"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "List Book"

        rvBook = findViewById(R.id.rv_book)
        rvBook.setHasFixedSize(true)

        list.addAll(BookData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBook.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListAdapter(list)
        rvBook.adapter = listHeroAdapter
    }
    private fun showRecyclerGrid() {
        rvBook.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridAdapter(list)
        rvBook.adapter = gridHeroAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.list_book -> {
                supportActionBar?.title = "List Book"
                list = BookData.listData
                showRecyclerList()
            }

            R.id.list_favorite -> {
                supportActionBar?.title = "Favorite Book"
                list = BookData.listFavData
                showRecyclerGrid()
            }

            R.id.about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }
}