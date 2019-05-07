package com.mobitant.myhorizentalrecyclermodule.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mobitant.myhorizentalrecyclermodule.Model.EventData
import com.mobitant.myhorizentalrecyclermodule.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class EventAdapter (var context: Context, var dataList:ArrayList<EventData>):RecyclerView.Adapter<EventAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): EventAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item,p0,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: EventAdapter.Holder, p1: Int) {
        p0.title.text = dataList[p1].title
        p0.category.text = dataList[p1].category
        Glide.with(context)
            .load(dataList[p1].img)
            .into(p0.image)
    }

    inner class Holder(itemview: View):RecyclerView.ViewHolder(itemview){
        val title = itemview.eventtitle
        val category = itemview.eventcategory
        val image = itemview.eventimage
    }
}