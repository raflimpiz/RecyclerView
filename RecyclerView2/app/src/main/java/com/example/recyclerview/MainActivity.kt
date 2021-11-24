package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.rafli,
                "rafli di rsm",
                "keren kan?"
            ),
            Superhero(
                R.drawable.rafli2,
                "rafli pulang solat jumat",
                "semoga berkah"
            ),
            Superhero(
                R.drawable.kucing,
                "kucing",
                "kucingku nih bos"
            ),
            Superhero(
                R.drawable.kucing2,
                "kucing satunya",
                "senggol dong"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager( this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter( this,superheroList){
            val intent = Intent (this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}