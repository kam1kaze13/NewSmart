package com.example.newsmart.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.newsmart.R
import com.example.newsmart.databinding.ActivityMainBinding
import com.example.newsmart.fragment.AuthFragment
import com.example.newsmart.fragment.PhonesFragment

class MainActivity : FragmentActivity() {
    fun navigateToFragment(fmt : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fmt)
            .addToBackStack(fmt.javaClass.name)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigateToFragment(AuthFragment.newInstance())
        }
    }
}