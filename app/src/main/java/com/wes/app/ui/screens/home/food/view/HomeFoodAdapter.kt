package com.wes.app.ui.screens.home.food.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import com.wes.app.extensions.toImageUrl
import com.wes.app.ui.screens.home.food.model.Favorite
import com.wes.base.util.ImageUtil
import kotlinx.android.synthetic.main.item_home.view.*

class HomeFoodAdapter(val foods: ArrayList<Favorite>,private val listener : OnItemHomeClick): RecyclerView.Adapter<HomeFoodAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false))
    }

    override fun getItemCount(): Int {
        return foods.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(foods[position])
        holder.itemView.setOnClickListener {
            listener.onClickItemHome(foods[position])
        }
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindData(favorite: Favorite){
            ImageUtil.loadImage(favorite.food?.image?.toImageUrl() ?: "", imageView = itemView.imBitmapitemhome)
            itemView.tvMenufood.text = favorite.food?.name
            itemView.tvFood.text = favorite.food?.description
        }
    }
    interface OnItemHomeClick{
        fun onClickItemHome(favorite: Favorite)
    }
}