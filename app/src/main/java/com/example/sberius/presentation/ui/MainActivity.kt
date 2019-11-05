package com.example.sberius.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sberius.R
import com.example.sberius.data.api.ServiceGenerator
import kotlinx.android.synthetic.main.bottom_app_bar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private val job = Job()
    private val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomAppBar.replaceMenu(R.menu.bottom_menu)
        supportFragmentManager.beginTransaction()
                .replace(R.id.root,
                        OneFragment.newInstance())
                .commit()

        scope.launch {
            val responseToken = ServiceGenerator.getTokenApi().getToken()
            println(responseToken.access_token)
        }
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

