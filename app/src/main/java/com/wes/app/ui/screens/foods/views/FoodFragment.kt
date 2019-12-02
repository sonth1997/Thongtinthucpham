package com.wes.app.ui.screens.foods.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.wes.app.R
import com.wes.app.ui.screens.foods.model.Food
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_foods.*

class FoodFragment : BaseAppFragment(), FoodAdapter.OnClickItemFoods {
    override val layoutRes = R.layout.fragment_foods

    private lateinit var adapterFoodPopulars: FoodAdapter
    private lateinit var adapterFoodNews: FoodAdapter

    private var mdata:MutableList<Food> = mutableListOf(
            Food("First", "hohohooh", R.drawable.bitmap),
            Food("First", "hohohooh", R.drawable.bitmaptwo),
            Food("First", "hohohooh", R.drawable.bitmapthree),
            Food("First", "hohohooh", R.drawable.bitmaptwo),
            Food("First", "hohohooh", R.drawable.bitmapthree)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        adapterFoodPopulars = FoodAdapter(this, FoodAdapter.POPULARS)
        adapterFoodNews = FoodAdapter(this, FoodAdapter.NEWS)
        adapterFoodPopulars.setData(mdata)
        adapterFoodNews.setData(mdata)
        rvFoodPopulars.adapter = adapterFoodPopulars
        rvFoodNews.adapter = adapterFoodNews

        tvMore.setOnClickListener {
            findNavController().navigate(R.id.action_nav_food_to_fragmentDetailsFood)
        }

    }
    override fun OnClickItemFoods(foods: ArrayList<Food>, TAG: String) {
        when(TAG){
            FoodAdapter.POPULARS -> {
                findNavController().navigate(R.id.action_nav_food_to_detailsFragment)
            }

            FoodAdapter.NEWS -> {
                toast("NEWS")
            }
        }
    }

    fun toast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    companion object{
        const val FOOD_DATA = "FOOD_DATA"
    }
}