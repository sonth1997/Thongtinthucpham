package com.wes.app.ui.screens.details.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wes.app.R
import com.wes.app.ui.screens.FragmentComment
import com.wes.app.ui.screens.FragmentPreparation
import com.wes.app.ui.screens.details.model.DishDetails
import com.wes.app.ui.screens.details.model.Ingredient
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_details.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : BaseAppFragment(), IngredientAdapter.onClickItemIngredient {

    override val layoutRes = R.layout.fragment_details
    lateinit var adapter: MyFragment
      var dishDetails : DishDetails ?= null
    private var idCourse = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MyFragment(childFragmentManager)
        adapter.addFragment(IngredientFragment(),"Ingredient")
        adapter.addFragment(FragmentPreparation(),"Preparation")
        adapter.addFragment(FragmentComment(),"Comment")
        visible.adapter = adapter
        tabMode.setupWithViewPager(visible)
    }
    companion object {
        const val KEY_ID = "key.type"
        fun newInstance(id: Int): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_ID, id)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idCourse = arguments?.getString(KEY_ID) ?: ""
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mealDishDetails(idCourse)
    }

    private fun mealDishDetails(id : String){
        api?.mealDishDetails("",id,error = {_,err ->
            Log.e("log err",err.message.toString())
        },success = { _,response ->
            if (response.isSuccess){
                dishDetails = response.data
                response.data?.let {data ->
                    tvAuthor.text = data.objc?.get(0)?.urlName
                    tvFoodDetail.text = data.objc?.get(0)?.name
                }
                adapter.notifyDataSetChanged()
            } else {
                Log.e("log err",response.message.toString())
            }
        })
    }

   inner class MyFragment(manager: FragmentManager): FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()

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
