package com.example.home_task_611

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var txt: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (intent.getStringExtra(KEY) != null) {
            txt = intent.getStringExtra(KEY).toString()
            init(txt)
        } else init("")
    }

    private fun init(txt: String) {
        txt_view2.text = txt
        btn2.setOnClickListener {
            if (edt_txt2.text.isEmpty())
                Toast.makeText(applicationContext, "WRITE SOMETHING!!!", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(KEY, edt_txt2.text.toString())
                }
                startActivity(intent)
                finish()
            }
        }
    }

    companion object {
        const val KEY = "Key"
    }
}