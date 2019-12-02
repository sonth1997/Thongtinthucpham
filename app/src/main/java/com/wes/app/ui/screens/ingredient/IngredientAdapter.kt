package com.wes.app.ui.screens.ingredient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import kotlinx.android.synthetic.main.item_detail.view.*

class IngredientAdapter(val mlistener : onClickItemIngredient): RecyclerView.Adapter<IngredientAdapter.ViewHolder>(){

    private var mData: MutableList<Ingredient> = mutableListOf()

    fun setData(mData:MutableList<Ingredient>){
        this.mData = mData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_detail,parent,false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onbind(mData[position])
        holder.itemView.setOnClickListener {
            mlistener.onClickItemIngredient(mData[position])
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun onbind(ingredient: Ingredient){
                itemView.tv_item_detail.text = ingredient.check
            }
    }
    interface onClickItemIngredient{
        fun onClickItemIngredient(ingredient: Ingredient)
    }
}