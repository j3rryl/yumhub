package com.example.yumhub

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.yumhub.databinding.ActivityMainBinding
import com.example.yumhub.fragments.ContactFragment
import com.example.yumhub.fragments.HomeFragment
import com.example.yumhub.fragments.RecipeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        loadFragment(HomeFragment())
        binding.bottomNavigationBar.setItemSelected(R.id.nav_home, true)
        binding.bottomNavigationBar.showBadge(R.id.nav_recipes, 15)

        setUpTabBar()
    }
    private fun setUpTabBar(){
        binding.bottomNavigationBar.setOnItemSelectedListener {
            var fragment: Fragment = HomeFragment()
            when(it){
                R.id.nav_home-> {
                    fragment= HomeFragment()
                }
                R.id.nav_recipes-> {
                    fragment= RecipeFragment()
                }
                R.id.nav_contact-> {
                    fragment= ContactFragment()
                }
            }
            loadFragment(fragment)
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}