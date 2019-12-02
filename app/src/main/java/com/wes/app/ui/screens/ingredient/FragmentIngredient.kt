package com.wes.app.ui.screens.ingredient


import android.os.Bundle
import android.view.View
import com.wes.app.R
import com.wes.base.fragments.BaseAppFragment
import kotlinx.android.synthetic.main.fragment_ingredient.*

class FragmentIngredient : BaseAppFragment(),IngredientAdapter.onClickItemIngredient {

    override val layoutRes = R.layout.fragment_ingredient
    private lateinit var adapterIngredient: IngredientAdapter
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
        adapterIngredient = IngredientAdapter(this)
        adapterIngredient.setData(mdata)
        rv_ingredient.adapter = adapterIngredient
    }
    override fun onClickItemIngredient(ingredient: Ingredient) {
    }
}



