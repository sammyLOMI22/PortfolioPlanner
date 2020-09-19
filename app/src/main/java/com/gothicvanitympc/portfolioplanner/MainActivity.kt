package com.gothicvanitympc.portfolioplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mybutton: Button = findViewById(R.id.calcBtn)
        mybutton.setOnClickListener {  invCalc()}
    }

    private fun invCalc(){
        //get investment amount
        var invAmtS = invAmt.text.toString()

        //retrive portfolio percentage
        var lcPec = lgCapAmt.text.toString()
        var midPec = midCapAmt.text.toString()
        var smPec = smCapAmt.text.toString()
        var dMPec = dMrkAmt.text.toString()
        var eMPec = eMAmt.text.toString()
        var sPec = sAmt.text.toString()
        var rePec = reAmt.text.toString()
        var dfiPec = dfiAmt.text.toString()
        var ifcPec = ifcAmt.text.toString()

        //calculate investment totals



    }
}