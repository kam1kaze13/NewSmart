package com.example.newsmart.presentation.fragment


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsmart.R
import com.example.newsmart.presentation.activity.MainActivity
import com.example.newsmart.presentation.adapter.QuestionAdapter
import com.example.newsmart.data.DataSource
import com.example.newsmart.databinding.FragmentQuestionsBinding
import com.example.newsmart.data.network.NetworkService
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi

class QuestionsFragment : Fragment(R.layout.fragment_questions) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DATE = "date"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argDate : String?, argDescr : String?, argIcon : Int?) : QuestionsFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_DATE to argDate,
                KEY_DESCRIPTION to argDescr,
                KEY_ICON_RES_ID to argIcon
            )
            val fragment = QuestionsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var binding: FragmentQuestionsBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { context, exception ->
        binding.progressBar.visibility = View.GONE
        println("CoroutineExceptionHandler got $exception")
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job() + coroutineExceptionHandler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentQuestionsBinding.bind(view)
        val name = arguments?.getString(KEY_NAME)
        val date = arguments?.getString(KEY_DATE)
        val description = arguments?.getString(KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(KEY_ICON_RES_ID)

        binding.rvQuestions.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestions.adapter = QuestionAdapter(DataSource.questions) {
            (activity as MainActivity).navigateToFragment(
                newInstance(name, date, description, iconResId)
            )
        }
    }

    @ExperimentalSerializationApi
    private fun loadQuestions() {
        scope.launch {
            val questions = NetworkService.loadQuestions()
            binding.rvQuestions.layoutManager = LinearLayoutManager(context)
            binding.rvQuestions.adapter = QuestionAdapter(questions) {}
            binding.progressBar.visibility = View.GONE
            binding.swRefreshRW.isRefreshing = false
        }
    }
}