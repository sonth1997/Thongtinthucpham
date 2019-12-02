package com.wes.app.ui.screens.favorites

import android.os.Bundle
import android.view.View
import com.wes.app.R
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoriteFragment: BaseAppFragment(),FavoriteAdapter.onClickItemFavorite {

    override val layoutRes = R.layout.fragment_favorites
    private lateinit var adapterFavorite: FavoriteAdapter

    private var mdata:MutableList<Favorite> = mutableListOf(
            Favorite("First","hohohooh",R.drawable.bitmap),
            Favorite("First","hohohooh",R.drawable.bitmap),
            Favorite("First","hohohooh",R.drawable.bitmap),
            Favorite("First","hohohooh",R.drawable.bitmap),
            Favorite("First","hohohooh",R.drawable.bitmap)

    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterFavorite = FavoriteAdapter(this)
        adapterFavorite.setData(mdata)
        rcvFavorite.adapter = adapterFavorite
    }
    override fun onClickItemFavorite(favorite: Favorite) {
    }

}