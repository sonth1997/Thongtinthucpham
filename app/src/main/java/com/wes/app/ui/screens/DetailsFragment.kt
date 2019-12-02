package com.wes.app.ui.screens


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wes.app.R
import com.wes.app.ui.screens.ingredient.FragmentIngredient
import com.wes.app.ui.screens.ingredient.Ingredient
import com.wes.app.ui.screens.ingredient.IngredientAdapter
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_ingredient.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : BaseAppFragment(), IngredientAdapter.onClickItemIngredient {

    override val layoutRes = R.layout.fragment_details

    lateinit var adapter: MyFragment

//    private lateinit var adapterIngredient: IngredientAdapter
    private var mdata: MutableList<Ingredient> = mutableListOf(
            Ingredient("First"),
            Ingredient("First"),
            Ingredient("First"),
            Ingredient("First"),
            Ingredient("First"),
            Ingredient("First"),
            Ingredient("First")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MyFragment(childFragmentManager)
        adapter.addFragment(FragmentIngredient(),"ingredient")
        adapter.addFragment(FragmentPreparation(),"preparation")
        adapter.addFragment(FragmentComment(),"ic_comment")
        visible.adapter = adapter
        tabMode.setupWithViewPager(visible)

//        adapterIngredient = IngredientAdapter(this)
//        adapterIngredient.setData(mdata)
//        rv_ingredient.adapter = adapterIngredient


    }
    class MyFragment(manager: FragmentManager): FragmentPagerAdapter(manager){
        val fragmentList: MutableList<Fragment> = ArrayList()
        val titleList: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment(fragment: Fragment,title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
    override fun onClickItemIngredient(ingredient: Ingredient) {

    }
}
