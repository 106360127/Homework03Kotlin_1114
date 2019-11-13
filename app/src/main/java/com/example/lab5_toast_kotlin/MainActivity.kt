package com.example.lab5_toast_kotlin

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")

                .setNeutralButton("取消"){_,_->
                    Toast.makeText(this,"dialog關閉",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("自訂義Toast"){_,_->
                    showToast()
                }
                .setPositiveButton("顯示List"){_,_->
                    showList()
                }
                .show()
        }
    }
    private fun showToast(){
        val toast=Toast(this)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration=Toast.LENGTH_SHORT
        toast.view=layoutInflater.inflate(R.layout.custom_toast,custom_toast_root)
        toast.show()
    }
    private fun showList(){
        val List= arrayOf("message1","message2","message3","message4","message5")
        AlertDialog.Builder(this)
            .setTitle("使用List呈現")
            .setItems(List){_,i->
                Toast.makeText(this,"你選擇的是"+List[i],Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}
