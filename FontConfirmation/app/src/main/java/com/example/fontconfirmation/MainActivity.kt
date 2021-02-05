package com.example.fontconfirmation

import android.content.Intent
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "フォント確認アプリ"

        val systemFontsFiles = File("/system/fonts").listFiles()
        val systemFontFiles = File("/system/font").listFiles()
        val dataFontsFiles = File("/data/fonts").listFiles()

        val fontFiles = ArrayList<File>()

        systemFontsFiles?.let {files -> for (file in files) { fontFiles.add(file) } }
        systemFontFiles?.let {files -> for (file in files) { fontFiles.add(file) } }
        dataFontsFiles?.let {files -> for (file in files) { fontFiles.add(file) } }
        fontFiles.sort()

        val fonts = ArrayList<String>()
        for (file in fontFiles) {
            Log.d("fonts", file.absolutePath)
            fonts.add(file.name)
        }

        listView.setOnItemClickListener { _, view, position, _ ->
            val fontPath = fontFiles[position].absolutePath
            Log.d("tap", fontPath)

            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("fontPath", fontPath)
            startActivity(intent)
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fonts)
        listView.adapter = adapter
    }
}