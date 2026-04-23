package com.jnetai.podcastpipe.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jnetai.podcastpipe.PodcastPipe
import com.jnetai.podcastpipe.R
import com.jnetai.podcastpipe.binding.ActivityAddBinding
import com.jnetai.podcastpipe.model.Episode
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private val app get() = application as PodcastPipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Add New Episode"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.saveButton.setOnClickListener {
            val title = binding.editTitle.text.toString().trim()
            if (title.isEmpty()) {
                Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            lifecycleScope.launch {
                val item = Episode(title = title, description = binding.editSubtitle.text.toString().trim())
            app.database.dao().insertEpisode(item)
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean { finish(); return true }
}