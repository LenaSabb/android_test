package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.chip.Chip
import com.sirius.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val dataTest = DataModel()

        // Game
        binding.tvName.text = dataTest.name
        binding.ReviewCountSmall.text = dataTest.gradeCnt
        binding.tvDescription.text = dataTest.description

        // Genres addition
        with(binding.TagsList) {
            removeAllViews()
            addView(Chip(this@MainActivity, null, R.attr.tagChipStyle).also {
                it.text = dataTest.tags[0]
            })
            addView(Chip(this@MainActivity, null, R.attr.tagChipStyle).also {
                it.text = dataTest.tags[1]
            })
            addView(Chip(this@MainActivity, null, R.attr.tagChipStyle).also {
                it.text = dataTest.tags[2]
            })
        }

        // Rating
        binding.tvRating.text = dataTest.rating.toString()
        val reviews = "${dataTest.gradeCnt} Reviews"
        binding.ReviewCount.text = reviews

        // Review 1
        binding.AuthorReview1.text = dataTest.reviews[0].userName
        binding.ReviewDate1.text = dataTest.reviews[0].date
        binding.Review1.text = dataTest.reviews[0].message
        // Review 2
        binding.AuthorReview2.text = dataTest.reviews[1].userName
        binding.ReviewDate2.text = dataTest.reviews[1].date
        binding.Review2.text = dataTest.reviews[1].message
    }
}