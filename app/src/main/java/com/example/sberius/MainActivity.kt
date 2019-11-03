package com.example.sberius

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bottom_app_bar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomAppBar.replaceMenu(R.menu.bottom_menu)
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, OneFragment.newInstance())
            .commit()
    }

    override fun onResume() {
        super.onResume()
        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.root, SecondFragment.newInstance())
                .addToBackStack(null)
                .commit()
                
        }
    }

}

