package com.example.saluranpesan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChannelListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var channelAdapter: ChannelAdapter
    private val channels = mutableListOf<Channel>() // Menggunakan mutableListOf untuk menambah data saluran

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel_list)

        recyclerView = findViewById(R.id.recyclerViewChannels)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Tambahkan data dummy sebelum inisialisasi adapter
        getDummyChannels() // Memanggil metode untuk menambah data saluran dummy

        // Inisialisasi adapter dengan data saluran
        channelAdapter = ChannelAdapter(channels) { channel -> onChannelClick(channel) }
        recyclerView.adapter = channelAdapter

        // Notifikasi adapter bahwa data telah diubah
        channelAdapter.notifyDataSetChanged()
    }

    private fun getDummyChannels() {
        // Tambahkan data saluran dummy
        channels.add(Channel("1", "Saluran 1", "Deskripsi Saluran 1", null))
        channels.add(Channel("2", "Saluran 2", "Deskripsi Saluran 2", null))
        channels.add(Channel("3", "Saluran 3", "Deskripsi Saluran 3", null))
        // Tambahkan lebih banyak saluran jika diperlukan
    }

    private fun onChannelClick(channel: Channel) {
        val intent = Intent(this, ChannelDetailActivity::class.java)
        intent.putExtra("CHANNEL_ID", channel.id) // Kirim ID saluran ke detail
        startActivity(intent)
    }
}
