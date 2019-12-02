package com.wes.app.ui.screens.settingprofile.add

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.wes.app.R
import kotlinx.android.synthetic.main.item_configuration.view.*

class AddConfigurationAdapter (val mlistener : onClickItemAddConfiguration): RecyclerView.Adapter<AddConfigurationAdapter.ViewHolder>(){

    private var mData: MutableList<AddConfiguration> = mutableListOf()

    fun setData(mData:MutableList<AddConfiguration>){
        this.mData = mData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_configuration,parent,false))
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onbind(mData[position])
        holder.itemView.checkboxConfiguration.setOnClickListener {
            mlistener.onClickItemAddConfiguration(mData[position], (it as CheckBox).isChecked)
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onbind(addConfiguration: AddConfiguration){
            itemView.tvItemConfiguration.text = addConfiguration.check
        }
    }

    interface onClickItemAddConfiguration{
        fun onClickItemAddConfiguration(addConfiguration: AddConfiguration, isChecked: Boolean)
    }
}