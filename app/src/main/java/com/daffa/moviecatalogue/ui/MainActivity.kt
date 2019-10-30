package com.daffa.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.daffa.moviecatalogue.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(applicationContext,R.color.white))

        navigation.setOnNavigationItemSelectedListener(mNavigationListener)

        commitFragment(MovieFragment())
    }

    private val mNavigationListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        var fragment: Fragment? = null
        if (menuItem.itemId == R.id.movie){
            fragment = MovieFragment()
        }else if (menuItem.itemId == R.id.tvShow){
            fragment = TvFragment()
        }

        if (fragment != null) {
            commitFragment(fragment)
        }

        true
    }

    private fun commitFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.container, fragment)
            .commit()
    }


}
