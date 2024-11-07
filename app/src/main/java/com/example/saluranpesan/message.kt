package com.example.saluranpesan

data class Message(
    val id: String,
    val channelId: String,
    val content: String,
    val timestamp: Long // Waktu pengiriman pesan
)
