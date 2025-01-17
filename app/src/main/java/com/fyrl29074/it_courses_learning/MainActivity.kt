package com.fyrl29074.it_courses_learning

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.fyrl29074.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Navigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment_container)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)

        bottomNavigationView.setupWithNavController(navController)
    }

    override fun navigateToCourseScreen(fragment: Fragment, course: Bundle) {
        findNavController(R.id.fragment_container)
            .navigate(
                R.id.action_mainFragment_to_courseFragment,
                course,
            )
    }

    override fun back() {
        findNavController(R.id.fragment_container).popBackStack()
    }
}