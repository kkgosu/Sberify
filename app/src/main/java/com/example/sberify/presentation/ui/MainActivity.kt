package com.example.sberify.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sberify.R
import com.example.sberify.presentation.ui.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.bottom_nav_view.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: SharedViewModel
    private lateinit var navController: NavController

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            setupBottomNavBar()
        }

        mViewModel = ViewModelProvider(this, ViewModelFactory()).get(
                SharedViewModel::class.java)
        mViewModel.token.observe(this, Observer {
            println("Token ${it.access_token}")
        })
        mViewModel.getData()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavBar()
    }

    private fun setupBottomNavBar() {
        val bnv = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        val navGraphIds = listOf(R.navigation.new_releases, R.navigation.search,
                R.navigation.favorite)

        val controller = bnv.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.main_content,
                intent = intent)

        controller.observe(this, Observer {
            //setupActionBarWithNavController(it)
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.main_content)
        NavigationUI.setupWithNavController(bottom_nav_view, navController)

    }
}



