package com.example.newsmart.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsmart.R
import com.example.newsmart.presentation.activity.MainActivity
import com.example.newsmart.presentation.adapter.ManufacturerAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentManufacturersBinding
import com.example.newsmart.data.network.NetworkService
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

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
    private lateinit var binding: FragmentManufacturersBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        println("CoroutineExceptionHandler got $exception")
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentManufacturersBinding.bind(view)
        val name = arguments?.getString(PhonesFragment.KEY_NAME)
        val descr = arguments?.getString(PhonesFragment.KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(PhonesFragment.KEY_ICON_RES_ID)

        binding.rvManufacturers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvManufacturers.adapter = ManufacturerAdapter(DataSource.manufacturers) {
            (activity as MainActivity).navigateToFragment(
                PhonesFragment.newInstance(name,descr, iconResId)
            )
        }
    }

    @ExperimentalSerializationApi
    private fun loadManufacturer() {
        scope.launch {
            val manufacturers = NetworkService.loadManufacturers()
            binding.rvManufacturers.layoutManager = LinearLayoutManager(context)
            binding.rvManufacturers.adapter = ManufacturerAdapter(manufacturers) {}
            binding.progressBar.visibility = View.GONE
            binding.swRefreshRW.isRefreshing = false
        }
    }

}