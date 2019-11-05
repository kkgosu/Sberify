package com.example.sberius.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sberius.R
import kotlinx.android.synthetic.main.bottom_app_bar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomAppBar.replaceMenu(R.menu.bottom_menu)
        supportFragmentManager.beginTransaction()
                .replace(R.id.root, OneFragment.newInstance())
                .commit()

        mViewModel = ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
        mViewModel.token.observe(this, Observer {
            println(it.access_token)
        })
        mViewModel.getToken()
    }

    override fun onResume() {
        super.onResume()
        fab.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(
                            R.id.root,
                            SecondFragment.newInstance()
                    )
                    .addToBackStack(null)
                    .commit()

        }
    }
}

