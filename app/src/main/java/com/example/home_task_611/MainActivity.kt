package com.example.home_task_611

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var txt: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        txt = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { txt ->
            if (txt.resultCode == Activity.RESULT_OK) {
                txt_view1.text = txt.data?.getStringExtra(MainActivity2.KEY).toString()
                edt_txt1.text = null
            }
        }
        btn1.setOnClickListener {
            if (edt_txt1.text.isEmpty())
                Toast.makeText(applicationContext, R.string.write_some, Toast.LENGTH_SHORT).show()
            else {
                txt.launch(
                    Intent(this, MainActivity2::class.java).putExtra(
                        MainActivity2.KEY,
                        edt_txt1.text.toString()
                    )
                )
            }
        }
    }
}