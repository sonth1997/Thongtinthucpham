package com.wes.app.ui.screens.foods.foodsdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import com.wes.app.ui.screens.foods.model.Food
import kotlinx.android.synthetic.main.item_food_vertical.view.*

class DetailsFoodsAdapter  (val mlistener: OnClickItemFoods): RecyclerView.Adapter<DetailsFoodsAdapter.ViewHolder>() {

    private var mData: MutableList<Food> = mutableListOf()
    fun setData(mData: MutableList<Food>) {
        this.mData = mData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food_vertical, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mData[position])
        holder.itemView.setOnClickListener {
            mlistener.OnClickItemFoods(mData[position])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(foods: Food) {
            itemView.imBitMapItemFoodVertical.setImageResource(foods.imageFood)
            itemView.tvMenuFoodsVertical.text = foods.menuFood
            itemView.tvMenuFoodsVertical.text = foods.food
        }
    }

    interface OnClickItemFoods {
        fun OnClickItemFoods(foods: Food)
    }
}
