package com.example.saluranpesan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChannelDetailActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private val messages = mutableListOf<Message>() // Menggunakan mutableListOf untuk bisa menambah data pesan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel_detail)

        recyclerView = findViewById(R.id.recyclerViewMessages)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inisialisasi adapter dengan data pesan
        messageAdapter = MessageAdapter(messages)
        recyclerView.adapter = messageAdapter

        // Ambil ID saluran dari Intent
        val channelId = intent.getStringExtra("CHANNEL_ID")

        // Ambil data pesan sesuai channelId
        if (channelId != null) {
            getDummyMessages(channelId)
            messageAdapter.notifyDataSetChanged() // Notifikasi perubahan pada adapter
        }
    }

    private fun getDummyMessages(channelId: String) {
        // Menambahkan data pesan dummy berdasarkan channelId
        when (channelId) {
            "1" -> {
                messages.add(Message("1", "1", "Pesan pertama di Saluran 1", System.currentTimeMillis()))
                messages.add(Message("2", "1", "Pesan kedua di Saluran 1", System.currentTimeMillis()))
            }
            "2" -> {
                messages.add(Message("3", "2", "Pesan pertama di Saluran 2", System.currentTimeMillis()))
                messages.add(Message("4", "2", "Pesan kedua di Saluran 2", System.currentTimeMillis()))
            }
            "3" -> {
                messages.add(Message("5", "3", "Pesan pertama di Saluran 3", System.currentTimeMillis()))
            }
            // Tambahkan lebih banyak pesan untuk saluran lain jika diperlukan
        }
    }
}
