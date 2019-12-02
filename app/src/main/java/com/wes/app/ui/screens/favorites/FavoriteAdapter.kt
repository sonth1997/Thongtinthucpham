package com.wes.app.ui.screens.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import kotlinx.android.synthetic.main.item_favorite.view.*
import kotlinx.android.synthetic.main.item_home.view.*

class FavoriteAdapter (val mlistener:onClickItemFavorite):RecyclerView.Adapter<FavoriteAdapter.ViewHolder>(){

    private var mData: MutableList<Favorite> = mutableListOf()
    fun setData(mData:MutableList<Favorite>){
        this.mData = mData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_favorite,parent,false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mData[position])
            holder.itemView.setOnClickListener {
                mlistener.onClickItemFavorite(mData[position])
        }
    }

    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
      fun onBind(favorite: Favorite){
          itemView.imBitMapItemFavorite.setImageResource(favorite.imageFood)
          itemView.tvItemMenuFoodFavorite.text = favorite.menuFood
          itemView.tvItemFoodFavorite.text = favorite.food
      }
    }
    interface onClickItemFavorite{
        fun onClickItemFavorite(favorite: Favorite)
    }
}
