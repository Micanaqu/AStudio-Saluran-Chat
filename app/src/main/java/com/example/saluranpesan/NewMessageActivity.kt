package com.example.saluranpesan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mengatur padding untuk edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Temukan tombol "Buat Pesan Baru" dan atur listener
        val newMessageButton: Button = findViewById(R.id.button_new_message)
        newMessageButton.setOnClickListener {
            // Tampilkan pesan toast
            Toast.makeText(this, "Buat Pesan Baru diklik!", Toast.LENGTH_SHORT).show()

            // Buka NewMessageActivity
            val intent = Intent(this, NewMessageActivity::class.java)
            startActivity(intent)
        }
    }
}
