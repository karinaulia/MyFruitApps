package com.bangkit.myfruitapps

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val KEY_FRUIT = "key_fruit"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataFruit = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Fruit>(KEY_FRUIT, Fruit::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Fruit>(KEY_FRUIT)
        }

        if (dataFruit != null) {
            findViewById<ImageView>(R.id.img_item_photo).setImageResource(dataFruit.photo)
        }
        findViewById<TextView>(R.id.tv_item_name).text = dataFruit?.name
        findViewById<TextView>(R.id.tv_item_description).text = dataFruit?.description
        findViewById<TextView>(R.id.tv_item_season).text = dataFruit?.season
        findViewById<TextView>(R.id.tv_item_save).text = dataFruit?.save
    }
}
