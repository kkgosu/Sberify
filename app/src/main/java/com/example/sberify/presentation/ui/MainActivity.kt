package com.example.sberify.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sberify.R
import com.example.sberify.presentation.ui.newreleases.NewReleasesFragment
import com.example.sberify.presentation.ui.search.SearchFragment
import kotlinx.android.synthetic.main.bottom_app_bar.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bottomAppBar.replaceMenu(R.menu.bottom_menu)

        supportFragmentManager.commit {
            replace(R.id.root, NewReleasesFragment.newInstance())
        }

        fab.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.root, SearchFragment.newInstance())
                addToBackStack(null)
            }
        }

        mViewModel = ViewModelProvider(this, ViewModelFactory()).get(SharedViewModel::class.java)
        mViewModel.token.observe(this, Observer {
            println("Token ${it.access_token}")
        })
        mViewModel.getData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> {
                supportFragmentManager.commit {
                    replace(R.id.root, FavoriteFragment.newInstance())
                    addToBackStack(null)
                }
            }
        }
        return true
    }

}



