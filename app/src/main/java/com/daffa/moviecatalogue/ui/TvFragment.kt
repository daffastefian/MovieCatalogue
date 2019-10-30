package com.daffa.moviecatalogue.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import com.daffa.moviecatalogue.R
import com.daffa.moviecatalogue.data.DataModel
import com.daffa.moviecatalogue.util.DataDummy
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment() {
    private lateinit var serial: List<DataModel>
    private lateinit var adapter: ListViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        serial = DataDummy.generateSerial()

        adapter = ListViewAdapter(context, serial)
        lvTvShow.adapter = adapter

        lvTvShow.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val goDetail = Intent(context, DetailActivity::class.java)
            goDetail.putExtra(DetailActivity.DATA,serial[position])
            startActivity(goDetail)
        }
    }
}
