package com.example.newsmart.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsmart.R
import com.example.newsmart.activity.MainActivity
import com.example.newsmart.adapter.ManufacturerAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentManufacturersBinding

class ManufacturersFragment : Fragment(R.layout.fragment_manufacturers) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argIcon : Int?) : ManufacturersFragment {
            val args = bundleOf(
                ManufacturersFragment.KEY_NAME to argName,
                ManufacturersFragment.KEY_ICON_RES_ID to argIcon
            )
            val fragment = ManufacturersFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentManufacturersBinding.bind(view)
        val name = arguments?.getString(PhonesFragment.KEY_NAME)
        val iconResId = arguments?.getInt(PhonesFragment.KEY_ICON_RES_ID)

        binding.rvManufacturers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvManufacturers.adapter = ManufacturerAdapter(DataSource.manufacturers) {
            (activity as MainActivity).navigateToFragment(
                ManufacturersFragment.newInstance(name, iconResId)
            )
        }
    }
}