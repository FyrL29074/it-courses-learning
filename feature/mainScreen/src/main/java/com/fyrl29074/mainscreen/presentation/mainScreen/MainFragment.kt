package com.fyrl29074.mainscreen.presentation.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.fyrl29074.mainscreen.R
import com.fyrl29074.mainscreen.databinding.FragmentMainBinding
import com.fyrl29074.mainscreen.presentation.CourseUI
import com.fyrl29074.navigation.Navigation
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

    private val adapter: CourseAdapter by lazy {
        CourseAdapter(
            onFavouriteClick = viewModel::onFavouriteClick,
            onMoreDetailsClick = { course -> onMoreDetailsClick(course) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        setupFlow()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onMoreDetailsClick(course: CourseUI) {
        val bundle = bundleOf("course" to course)
        (requireActivity() as Navigation).navigateToCourseScreen(
            fragment = this,
            bundle,
        )
    }

    private fun initUI() {
        with(binding) {
            courseList.adapter = adapter

            sort.setOnClickListener {
                val popupMenu = PopupMenu(this@MainFragment.requireContext(), it)
                popupMenu.menuInflater.inflate(R.menu.menu_sort, popupMenu.menu)

                popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                    when (item.itemId) {
                        R.id.sort_by_date_ascending -> {
                            viewModel.sortByDateAscending()
                            binding.sort.text = getString(R.string.by_date_ascending)
                            true
                        }

                        R.id.sort_by_date_descending -> {
                            viewModel.sortByDateDescending()
                            binding.sort.text = getString(R.string.by_date_descending)
                            true
                        }

                        R.id.sort_by_rating -> {
                            viewModel.sortByRating()
                            binding.sort.text = getString(R.string.by_rating)
                            true
                        }

                        R.id.sort_by_price_ascending -> {
                            viewModel.sortByPriceAscending()
                            binding.sort.text = getString(R.string.by_price_ascending)
                            true
                        }

                        R.id.sort_by_price_descending -> {
                            viewModel.sortByPriceDescending()
                            binding.sort.text = getString(R.string.by_price_descending)
                            true
                        }

                        else -> false
                    }
                }

                popupMenu.show()
            }
        }
    }

    private fun setupFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    MainScreenState.Initializing -> {}
                    is MainScreenState.Content -> adapter.submitList(state.courses)
                }
            }
        }
    }
}