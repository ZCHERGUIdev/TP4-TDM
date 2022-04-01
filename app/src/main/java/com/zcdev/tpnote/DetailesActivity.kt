package com.zcdev.tpnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detailes.*
import java.util.*

class DetailesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailes)
       // get date
       var n=  intent.getStringExtra("name")
       var d=  intent.getStringExtra("desc")

        // fill data
        txtTiwitName.text=n
        txtTiwitDesc.text=d
        imageLogo.setImageResource(R.drawable.logo)
        //get current time
        txtTime.text=Calendar.getInstance().time.toString()

    }
}