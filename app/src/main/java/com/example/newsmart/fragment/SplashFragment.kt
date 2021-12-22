package com.example.newsmart.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsmart.R
import com.example.newsmart.activity.MainActivity
import com.example.newsmart.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    companion object{
        fun newInstance() = SplashFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSplashBinding.bind(view)

        (activity as MainActivity).navigateToFragment(
            RegisterFragment.newInstance()
        )
    }
}