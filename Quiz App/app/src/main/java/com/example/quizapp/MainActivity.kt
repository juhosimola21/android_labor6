package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

const val TAG_MAIN :String = "MainActivity"

const val EXTRA_MESSAGE :String = "userName"

class MainActivity : AppCompatActivity() {
    /*
    lateinit var userName:EditText

    lateinit var startButton: Button
    lateinit var choosebutton: Button
*/
    lateinit var topAppBar: MaterialToolbar
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    //onCreate eletciklus metodusa es ez feltetelenul kell
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG_MAIN, "onCreate() called")

        setContentView(R.layout.activity_main)
        topAppBar = findViewById(R.id.topAppBar)
        navigationView = findViewById(R.id.navigationView)
        drawerLayout = findViewById(R.id.drawerLayout)

        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()

        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected


            menuItem.isChecked = true

            when (menuItem.itemId) {
                R.id.homeFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)
                R.id.quizStartFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.quizStartFragment)
                R.id.profilFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.profilFragment)
                R.id.questionListFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.questionListFragment)

                R.id.questionAddFragment -> findNavController(R.id.nav_host_fragment).navigate(R.id.questionAddFragment)

            }





            drawerLayout.close()
            true
        }

        //initializeWiew()
        //resisterListeners()

    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG_MAIN, "onStart() called")

    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG_MAIN, "onResume() called")


    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG_MAIN, "onPause () called")


    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG_MAIN, "onStop() called")


    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG_MAIN, "onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG_MAIN, "onDestroy() called")


    }
}