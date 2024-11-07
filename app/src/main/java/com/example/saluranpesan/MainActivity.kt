package com.example.saluranpesan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Mengatur padding agar layout tidak tertutup oleh status bar atau navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Temukan tombol "Buat Pesan Baru" dan atur listener
        val newMessageButton: Button = findViewById(R.id.button_new_message)
        newMessageButton.setOnClickListener {
            // Tampilkan pesan atau buka activity baru
            Toast.makeText(this, "Buat Pesan Baru diklik!", Toast.LENGTH_SHORT).show()

            // Contoh membuka activity baru (jika ada)
            // val intent = Intent(this, NewMessageActivity::class.java)
            // startActivity(intent)
        }
    }
}
