package com.wes.app.ui.screens.details.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import com.wes.app.ui.screens.details.model.Ingredient
import kotlinx.android.synthetic.main.item_detail.view.*

class IngredientAdapter(val foodss : ArrayList<Ingredient>,private val listener : onClickItemIngredient): RecyclerView.Adapter<IngredientAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_detail,parent,false))
    }

    override fun getItemCount(): Int {
        return foodss.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(foodss[position])
        holder.itemView.setOnClickListener {
            listener.onClickItemIngredient(foodss[position])
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun bindData(ingredient: Ingredient){
                itemView.tvItemDetail.text = ingredient.ingredient
            }
    }
    interface onClickItemIngredient{
        fun onClickItemIngredient(ingredient: Ingredient)
    }
}