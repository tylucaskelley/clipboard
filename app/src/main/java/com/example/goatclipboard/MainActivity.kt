package com.example.goatclipboard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                if (intent.type?.startsWith("image/") == true)  {
                    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val img = intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri
                    val data: ClipData = ClipData.newUri(contentResolver, "URI", img)

                    clipboard.setPrimaryClip(data);
                }
            }
        }
    }
}