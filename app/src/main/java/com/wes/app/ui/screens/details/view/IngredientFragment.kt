package com.wes.app.ui.screens.details.view


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.wes.app.R
import com.wes.app.ui.screens.details.model.DishDetails
import com.wes.app.ui.screens.details.model.Ingredient
import com.wes.app.ui.screens.home.food.model.Favorite
import com.wes.app.ui.screens.home.food.view.HomeFoodAdapter
import com.wes.app.ui.screens.home.food.view.HomeFoodFragment
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_home_favorite.*
import kotlinx.android.synthetic.main.fragment_ingredient.*

class IngredientFragment : BaseAppFragment(), IngredientAdapter.onClickItemIngredient {

    override val layoutRes = R.layout.fragment_ingredient
    private lateinit var adapterIngredient: IngredientAdapter
    private var ingredients = arrayListOf<Ingredient>()

    companion object {
         const val ARG_FAVORITES = "ingredients.list"
        fun newInstance(ingredients: ArrayList<Ingredient>?) = IngredientFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_FAVORITES, ingredients)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ingredients = arguments?.getParcelableArrayList(ARG_FAVORITES) ?: arrayListOf()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterIngredient = IngredientAdapter(ingredients, this)
        rvIngredient.layoutManager = LinearLayoutManager(context)
        rvIngredient.adapter = adapterIngredient
    }
    override fun onClickItemIngredient(ingredient: Ingredient) {
    }
}



