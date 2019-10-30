package com.daffa.moviecatalogue.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.daffa.moviecatalogue.R
import com.daffa.moviecatalogue.data.DataModel

class ListViewAdapter(private val context: Context?,private val data: List<DataModel>): BaseAdapter() {


    override fun getCount(): Int = data.size

    override fun getItem(i: Int): Any = data[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false)
        }

        val viewHolder = DataHolder(itemView as View)

        val data = getItem(position) as DataModel
        viewHolder.bind(data,context!!)
        return itemView
    }

    private inner class DataHolder(itemView: View){
        private val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
        private val tvRate: TextView = itemView.findViewById(R.id.tvRate)
        val requestOptions = RequestOptions().transform(FitCenter(), RoundedCorners(10))
        fun bind(data: DataModel, context: Context){
            Glide.with(context)
                .load(data.poster)
                .error(R.drawable.err)
                .apply(requestOptions)
                .into(ivPoster)
            tvTitle.text = data.title
            tvDesc.text = data.overview
            tvRate.text = data.rating
        }
    }
}

