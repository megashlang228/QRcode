package com.example.qrcode

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var txtEdit: EditText
    var btn: Button? = null
    var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEdit = findViewById<EditText>(R.id.txtEdit)
        btn = findViewById(R.id.btnQR)
        imageView = findViewById(R.id.imageView)
        btn?.setOnClickListener{
            val txt: String = txtEdit.text.toString()
            GenerateQR(txt)
        }
    }

    private fun GenerateQR(txt: String){
        try {
            val barcodeEncoder = BarcodeEncoder()
            val hints: Hashtable<EncodeHintType, Any> = Hashtable<EncodeHintType, Any>()
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8")
            hints.put(EncodeHintType.ERROR_CORRECTION, "H")
            val bitmap = barcodeEncoder.encodeBitmap(txt, BarcodeFormat.QR_CODE, 512, 512, hints)
            imageView?.setImageBitmap(bitmap)
        } catch(e: WriterException) {

        }
    }
}