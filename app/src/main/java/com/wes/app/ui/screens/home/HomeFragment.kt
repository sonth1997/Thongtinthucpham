package com.wes.app.ui.screens.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wes.app.R
import com.wes.app.ui.screens.home.food.model.Favorite
import com.wes.app.ui.screens.home.food.model.Suggestion
import com.wes.app.ui.screens.home.food.view.HomeFoodAdapter
import com.wes.app.ui.screens.home.food.view.HomeFoodFragment
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_homes.*

class HomeFragment : BaseAppFragment(),HomeFoodAdapter.OnItemHomeClick {


    override val layoutRes = R.layout.fragment_homes
    lateinit var adapter: HomePageAdapter
     var suggestion: ArrayList<Suggestion> =  arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomePageAdapter(childFragmentManager)
        visibleHome.adapter = adapter
        indicator.setViewPager(visibleHome)
        adapter.registerDataSetObserver(indicator.dataSetObserver)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mealSuggestions()
    }

    private fun mealSuggestions(){
        api?.mealSuggestions("",error = {_,err ->
                Log.e("log err",err.message.toString())
        },success = { _,response ->
            if (response.isSuccess){
                suggestion = response.data ?: arrayListOf()
                response.data?.let {data ->
                tvTime.text = data[0].day
                    tvMealFoodHome.text = data[0].meal
                }
                adapter.notifyDataSetChanged()
            } else {
                Log.e("log err",response.message.toString())
            }
        })
    }
    inner  class HomePageAdapter(manager: FragmentManager): FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

        override fun getItem(position: Int): Fragment {
            return HomeFoodFragment.newInstance(suggestion[position].favorite)
        }

        override fun getCount(): Int {
            return suggestion.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return suggestion[position].meal
        }
    }
    override fun onClickItemHome(favorite: Favorite) {
    }

}