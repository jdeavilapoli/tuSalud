package com.tusalud

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UrlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_url)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnUrlWeb = findViewById<Button>(R.id.btnUrlWeb)
        var txtUrlWeb = findViewById<EditText>(R.id.txtUrlWeb)

        // Asigna un OnClickListener al botón
        btnUrlWeb.setOnClickListener {
            // Obtiene el texto del EditText
            val url = txtUrlWeb.text.toString().trim()

            // Verifica si la URL no está vacía
            if (url.isNotEmpty()) {
                // Crea un Intent para realizar una búsqueda en Google
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com/search?q=$url")
                startActivity(intent)
            }
        }
    }
}