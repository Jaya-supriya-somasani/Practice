package com.example.practice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import com.example.practice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewHome) as NavHostFragment
        navHostFragment.navController
    }

    private lateinit var actionBarToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
            if (id == R.id.nav_profile) {
                Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
            }
            //This is for maintaining the behavior of the Navigation view
            onNavDestinationSelected(menuItem, navController)
            //This is for closing the drawer after acting on it
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(binding.navView)
        }
        return true
    }
//
//    override fun onBackPressed() {
//        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
}