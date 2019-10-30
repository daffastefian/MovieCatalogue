package com.daffa.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.daffa.moviecatalogue.R
import com.daffa.moviecatalogue.data.DataModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var data: DataModel

    companion object {
        const val DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        data = intent.getParcelableExtra(DATA)

        initLayout()
    }

    private fun initLayout(){
        toolbarDetail.apply {
            title = data.title
            setTitleTextColor(ContextCompat.getColor(context,R.color.white))
            navigationIcon = getDrawable(R.drawable.ic_left)
        }

        setSupportActionBar(toolbarDetail)

        toolbarDetail.setNavigationOnClickListener {
            onBackPressed()
        }

        tvTitle.text = data.title
        tvGenre.text = data.genres
        tvLanguage.text = data.language
        tvRunTime.text = data.runtime
        tvRate.text = data.rating
        tvYear.text = data.year
        tvBudget.text = data.budget
        tvRevenue.text = data.revenue
        tvStar.text = data.star
        tvOverview.text = data.overview
        Glide.with(this)
            .load(data.poster)
            .error(R.drawable.err)
            .into(ivPoster)
    }
}
