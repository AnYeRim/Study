package com.example.kotlin.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlin.R

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // val 은 final 같은 역할, var 은 변경 가능
        val txtPrint : TextView = findViewById(R.id.txtPrint)
        val txtPrint2 : TextView = findViewById(R.id.txtPrint2)

        var text = "Hello World"

        txtPrint.text = text
        println("출력해보자 $text")

        txtPrint2.text = getHelloWorld2()
        println("출력해보자 ${getHelloWorld2()}")

        var person = Person()
        println(person.name)
        println(person.age)
        person.name = "hey"
        person.age = 32
        println(person.name)
        println(person.age)

        var person2 = Person("yerim",26)
        println(person2.name)
        println(person2.age)

    }

    private fun getHelloWorld2(): String {
        return "Hello World 2"
    }
}