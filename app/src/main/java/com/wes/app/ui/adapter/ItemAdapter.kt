package com.wes.app.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.wes.app.R
import com.wes.app.extensions.inflate
import com.wes.base.adapters.AppRecycleAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

/**
 * @author HungHN on 3/15/2019.
 */
//class ItemAdapter : AppRecycleAdapter<String, ItemAdapter.ItemViewHolder, Any?>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        return ItemViewHolder(parent.inflate(R.layout.item_list))
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val item = getItem(position) ?: ""
//        holder.bindData(item)
//        bindItemClickListener(holder.itemView, position, item)
//    }
//
//    class ItemViewHolder(override val containerView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(containerView), LayoutContainer {
//
//        fun bindData(item: String) {
//            textView.text = item
//        }
//    }
//}