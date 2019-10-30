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
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private lateinit var movies: List<DataModel>
    private lateinit var adapter: ListViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movies = DataDummy.generateMovie()

        adapter = ListViewAdapter(context, movies)
        lvMovie.adapter = adapter

        lvMovie.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val goDetail = Intent(context, DetailActivity::class.java)
            goDetail.putExtra(DetailActivity.DATA,movies[position])
            startActivity(goDetail)
        }
    }
}
