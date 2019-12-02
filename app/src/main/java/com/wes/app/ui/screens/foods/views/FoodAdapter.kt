package com.wes.app.ui.screens.foods.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import com.wes.app.ui.screens.foods.model.Food
import kotlinx.android.synthetic.main.item_food_horizontal.view.*
import kotlinx.android.synthetic.main.item_food_vertical.view.*

class FoodAdapter (val mlistener: OnClickItemFoods, val TAG: String): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private var mData: MutableList<Food> = mutableListOf()
    fun setData(mData: MutableList<Food>) {
        this.mData = mData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when(TAG){
            POPULARS -> return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food_horizontal, parent, false))
            NEWS -> return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food_vertical, parent, false))
            else -> return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food_vertical, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mData[position], TAG)
        holder.itemView.setOnClickListener {
            mlistener.OnClickItemFoods(mData as ArrayList<Food>, TAG)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(foods: Food, TAG: String) {
            when(TAG){
                POPULARS -> {
                    itemView.imBitMapItemFoodHorizontal.setImageResource(foods.imageFood)
                    itemView.tvMenuFoodsHorizontal.text = foods.menuFood
                    itemView.tvFoodHorizontal.text = foods.food
                }

                NEWS -> {
                    itemView.imBitMapItemFoodVertical.setImageResource(foods.imageFood)
                    itemView.tvMenuFoodsVertical.text = foods.menuFood
                    itemView.tvMenuFoodsVertical.text = foods.food
                }
            }
        }
    }

    interface OnClickItemFoods {
        fun OnClickItemFoods(foods: ArrayList<Food>, TAG: String)
    }

    companion object{
        val POPULARS = "POPULARS"
        val NEWS = "NEWS"
    }
}
