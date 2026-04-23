package com.jnetai.podcastpipe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jnetai.podcastpipe.binding.ItemMainBinding
import com.jnetai.podcastpipe.model.Episode

class EpisodeAdapter(private val onClick: (Episode) -> Unit) : RecyclerView.Adapter<EpisodeAdapter.VH>() {
    var items: List<Episode> = emptyList()
    inner class VH(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = items[pos]
        h.binding.titleText.text = item.title
        h.binding.subtitleText.text = item.status + " · " + (item.guestName.ifEmpty { "No guest" })
        h.binding.root.setOnClickListener { onClick(item) }
    }
}