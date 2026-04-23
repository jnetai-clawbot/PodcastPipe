package com.jnetai.podcastpipe.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.podcastpipe.PodcastPipe
import com.jnetai.podcastpipe.databinding.ActivityDetailBinding
import com.jnetai.podcastpipe.model.Episode
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val app get() = application as PodcastPipe
    private var item: Episode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        val itemId = intent.getLongExtra("item_id", -1)
        if (itemId == -1L) { finish(); return }
        
        lifecycleScope.launch {
            item = app.database.dao().getEpisode(itemId)
            item?.let { displayDetails(it) }
        }
    }
    
    private fun displayDetails(item: Episode) {
        binding.titleText.text = item.title
        binding.detailText.text = item.toString()
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}