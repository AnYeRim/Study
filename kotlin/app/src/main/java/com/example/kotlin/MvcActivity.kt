package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.model.MvcModel
import kotlinx.android.synthetic.main.activity_mvc.*
import java.text.SimpleDateFormat
import java.util.*

class MvcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        val model = MvcModel()

        btnSave.setOnClickListener {
            model.name = getName()
            model.birthday = toDate(getBirthday())
        }

        btnLoad.setOnClickListener {
            showData(model.name, toString(model.birthday))
        }
    }

    private fun getName(): String {
        return edtName.text.toString()
    }

    private fun getBirthday(): String {
        return edtBirthday.text.toString()
    }

    private fun toDate(date:String): Date {
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        return dateFormat.parse(date)
    }

    private fun toString(date:Date?): String {
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        return dateFormat.format(date)
    }

    private fun showData(name: String? ="정보없음", birthday: String? ="정보없음") {
        txtName.text = name
        txtBirthday.text = birthday
    }

}