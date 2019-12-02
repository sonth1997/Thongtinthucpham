package com.wes.app.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import com.wes.app.ui.models.Food
import kotlinx.android.synthetic.main.item_home.view.*

class CustomAdapter(val mlistener: onClickItemFood) : RecyclerView.Adapter<CustomAdapter.VH>(){
    private var mData: MutableList<Food> = mutableListOf()
    fun setData(mData: MutableList<Food>){
        this.mData = mData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(mData[position])
        holder.itemView.setOnClickListener{
            mlistener.OnClickItemFood(mData[position])
        }
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(food: Food){
            itemView.im_bitmap_item_home.setImageResource(food.imageFood)
            itemView.tv_menu_food.text = food.menuFood
            itemView.tv_food.text = food.food
        }
    }

    interface onClickItemFood{
        fun OnClickItemFood(food: Food)
    }
}