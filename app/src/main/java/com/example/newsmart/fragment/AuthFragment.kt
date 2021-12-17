package com.example.newsmart.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsmart.R
import com.example.newsmart.databinding.FragmentAuthBinding

class AuthFragment : Fragment(R.layout.fragment_auth) {
    companion object {
        fun newInstance() = AuthFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAuthBinding.bind(view)
    }
}