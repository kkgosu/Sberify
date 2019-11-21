package com.example.sberify.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.R
import kotlinx.android.synthetic.main.bottom_app_bar.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomAppBar.replaceMenu(R.menu.bottom_menu)

        supportFragmentManager.commit {
            replace(R.id.root, NewReleasesFragment.newInstance())
        }

        fab.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.root, SearchFragment.newInstance())
                addToBackStack(null)
                commit()
            }
        }

        mViewModel = ViewModelProvider(this, ViewModelFactory()).get(SharedViewModel::class.java)
        mViewModel.token.observe(this, Observer {
            println("Token ${it.access_token}")
        })
        mViewModel.getData()
    }
}


