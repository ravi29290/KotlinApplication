package com.ukkoteknik.kotilinapplication

import android.graphics.Color
import android.nfc.tech.NfcA
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {

            textView {
                text = "Please Enter Name"
                textSize = 20f
            }
            val name = editText()

            var check = verticalLayout {
                checkBox {
                    text = "Checkbox text"
                }.lparams() { topMargin = dip(6);bottomMargin = dip(6) }

                checkBox {
                    text = "Hello"
                }.lparams() { topMargin = dip(6);bottomMargin = dip(6) }

                checkBox {
                    text = "Time"
                }.lparams() { topMargin = dip(6);bottomMargin = dip(6) }

            }

            button("hello") {
                onClick {
                    getValues(check)
                }
            }

        }

    }

    private fun getValues(check: LinearLayout) {
        val count = check.childCount;
        for (value in 0..count) {
            var child = check.getChildAt(value)
            if (child is CheckBox) {
                if (child.isChecked)
                    toast("${child.text.toString()}")
            }
        }


    }


}
