package com.example.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        //set content view
        setContentView(view)

        //set menu_toolbar as actionbar
        val toolbar=binding.toolbar
        setSupportActionBar(toolbar)

        //get nav controller
        val navHostFragment1=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navcontroller1=navHostFragment1.navController

        //to Configure backbutton
        val builder1= AppBarConfiguration.Builder(navcontroller1.graph)
        val appbarconfiguration1=builder1.build()

        //setup/link navigation controller and backbutton configuration
        toolbar.setupWithNavController(navcontroller1, appbarconfiguration1)

        //link/setup bottom navigation bar with navigation controller
        val bottomNavView=binding.bottomNavigationView
        bottomNavView.setupWithNavController(navcontroller1)
    }

    //inflate menu_toolbar at MainActivity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //on clicking toolbar item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navcontroller2: NavController =findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navcontroller2) || super.onOptionsItemSelected(item)
    }

}