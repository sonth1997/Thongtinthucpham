package com.wes.app.ui.screens.settingprofile.done

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import com.wes.app.ui.screens.settingprofile.add.AddConfiguration
import kotlinx.android.synthetic.main.item_setting.view.*
import android.graphics.drawable.GradientDrawable
import kotlinx.android.synthetic.main.item_configuration.view.tvItemConfiguration


class SettingProfileAdapter (val mlistener : onClickItemSettingProfile): RecyclerView.Adapter<SettingProfileAdapter.ViewHolder>(){
    private var mData: MutableList<SettingProfile> = mutableListOf()

    fun setData(mData:MutableList<SettingProfile>){
        this.mData = mData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_setting,parent,false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onbind(mData[position])
        holder.itemView.setOnClickListener {
            mlistener.onClickItemSettingProfile(mData[position])
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onbind(settingProfile: SettingProfile){
            itemView.tvMeal.text = String.format(itemView.context.getString(R.string.Meal), settingProfile.numberPeople)
            itemView.rvItemSetting.adapter = MealsAdapter(settingProfile.listFood)
        }
    }

    interface onClickItemSettingProfile{
        fun onClickItemSettingProfile(settingProfile: SettingProfile)
    }
}

class MealsAdapter(val mData: MutableList<AddConfiguration>) : RecyclerView.Adapter<MealsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(com.wes.app.R.layout.item_meals, parent, false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onbind(mData[position])

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onbind(configuration: AddConfiguration) {
            itemView.tvItemConfiguration.text = configuration.check
            val drawable = itemView.tvItemConfiguration.background as GradientDrawable
            drawable.setColor(configuration.color)
//            itemView.tvItemConfiguration.setBackgroundColor(configuration.color)
        }
    }
}