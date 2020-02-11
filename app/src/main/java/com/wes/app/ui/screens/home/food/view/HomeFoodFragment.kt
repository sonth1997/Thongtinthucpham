package com.wes.app.ui.screens.home.food.view


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wes.app.R
import com.wes.app.ui.screens.details.view.DetailsFragment
import com.wes.app.ui.screens.home.food.model.Favorite
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_home_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFoodFragment : BaseAppFragment(), HomeFoodAdapter.OnItemHomeClick {

    private lateinit var adapter: HomeFoodAdapter
    override val layoutRes = R.layout.fragment_home_favorite
    private var favorites = arrayListOf<Favorite>()

    companion object {
        private const val ARG_FAVORITES = "favorites.list"
        fun newInstance(favorites: ArrayList<Favorite>) = HomeFoodFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_FAVORITES, favorites)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favorites = arguments?.getParcelableArrayList(ARG_FAVORITES) ?: arrayListOf()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            adapter = HomeFoodAdapter(favorites, this)
            rvHomeFoodBreakFats.layoutManager = LinearLayoutManager(context)
            rvHomeFoodBreakFats.adapter = adapter

    }

    override fun onClickItemHome(favorite: Favorite) {
        findNavController().navigate(R.id.action_homes_to_details, Bundle().apply {
            putString(DetailsFragment.KEY_ID, favorite._id)
        })
    }
}

