package com.bangkit.myfruitapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFruit: RecyclerView
    private val list = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruit = findViewById(R.id.rv_fruits)
        rvFruit.setHasFixedSize(true)

        list.addAll(getListFruits())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about){
            val intentAbout = Intent(this, AboutActivity::class.java)
            startActivity(intentAbout)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFruits(): ArrayList<Fruit> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSeason = resources.getStringArray(R.array.data_season)
        val dataSave = resources.getStringArray(R.array.data_save)
        val listFruit = ArrayList<Fruit>()
        for (i in dataName.indices) {
            val fruit = Fruit(name = dataName[i], description = dataDescription[i], photo = dataPhoto.getResourceId(i, -1), season = dataSeason[i], save = dataSave[i])
            listFruit.add(fruit)
        }
        return listFruit
    }

    private fun showRecyclerList() {
        rvFruit.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        rvFruit.adapter = listFruitAdapter
    }
}