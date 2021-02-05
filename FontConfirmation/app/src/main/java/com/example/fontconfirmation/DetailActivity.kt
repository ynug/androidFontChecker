package com.example.fontconfirmation

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.jaredrummler.fontreader.truetype.FontFileReader
import com.jaredrummler.fontreader.truetype.TTFFile
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.lang.Exception


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val fontPath = intent.getStringExtra("fontPath") ?: ""
        val fontName = fontPath.replace("/system/fonts/", "")

        title = fontName

        val file = File(fontPath)

        var info = ArrayList<String>()
        if (file.extension == "ttc") {
            info = getTtc(file)
        } else {
            info = getTtfOrOtf(file)
        }

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, info)
        listView.adapter = adapter
    }

    fun getTtfOrOtf(file: File): ArrayList<String> {
        val ttfFile = TTFFile.open(file)

        val postScriptName = ttfFile.postScriptName
        val familyNames = ttfFile.familyNames
        val subFamilyName = ttfFile.subFamilyName
        val fullName = ttfFile.fullName
        val copyrightNotice = ttfFile.copyrightNotice
        Log.d("FontInfo", postScriptName)
        Log.d("FontInfo", familyNames.toString())
        Log.d("FontInfo", subFamilyName)
        Log.d("FontInfo", fullName)
        Log.d("FontInfo", copyrightNotice)

        val info = ArrayList<String>()
        info.add("filePath:\n${file.absoluteFile}")
        info.add("postScriptName:\n${postScriptName}")
        info.add("familyNames:\n${familyNames.toString()}")
        info.add("subFamilyName:\n${subFamilyName}")
        info.add("fullName:\n${fullName}")
        info.add("copyrightNotice:\n${copyrightNotice}")

        return info
    }

    fun getTtc(file: File): ArrayList<String> {
        val fontFileReader = FontFileReader(FileInputStream(file))
        val ttfFile = TTFFile()
        val fontInfoList = ttfFile.getTTCFontInfo(fontFileReader)

        val info = ArrayList<String>()

        info.add("filePath:\n${file.absoluteFile}")
        for (fontInfo in fontInfoList) {

            val postScriptName = fontInfo.postScriptName
            val familyNames = fontInfo.familyNames
            val subFamilyName = fontInfo.subFamilyName
            val fullName = fontInfo.fullName
            val copyrightNotice = fontInfo.copyrightNotice
            Log.d("FontInfo", postScriptName)
            Log.d("FontInfo", familyNames.toString())
            Log.d("FontInfo", subFamilyName)
            Log.d("FontInfo", fullName)
            Log.d("FontInfo", copyrightNotice)

            info.add("postScriptName:\n${postScriptName}")
            info.add("familyNames:\n${familyNames.toString()}")
            info.add("subFamilyName:\n${subFamilyName}")
            info.add("fullName:\n${fullName}")
            info.add("copyrightNotice:\n${copyrightNotice}")
            info.add("")
        }

        return info
    }
}