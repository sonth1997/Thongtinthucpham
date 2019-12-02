package com.wes.app.ui.screens.foods.foodsdetails


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.wes.app.R
import com.wes.app.ui.screens.foods.model.Food
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_details_food.*
/**
 * A simple [Fragment] subclass.
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailsFoodsFragment : BaseAppFragment(), DetailsFoodsAdapter.OnClickItemFoods {
    override val layoutRes = R.layout.fragment_details_food

    private lateinit var adapterFoods: DetailsFoodsAdapter

    private var mdata:MutableList<Food> = mutableListOf(
            Food("First","hohohooh",R.drawable.bitmap),
            Food("First","hohohooh",R.drawable.bitmap),
            Food("First","hohohooh",R.drawable.bitmap),
            Food("First","hohohooh",R.drawable.bitmap),
            Food("First","hohohooh",R.drawable.bitmap)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterFoods = DetailsFoodsAdapter(this)
        adapterFoods.setData(mdata)
        rcvFoodDetail.adapter = adapterFoods
    }
    override fun OnClickItemFoods(foods: Food) {
    }
}
