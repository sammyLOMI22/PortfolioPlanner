package com.gothicvanitympc.portfolioplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
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
        //checks to make sure percentage adds up to 100%
        var tPfAmt=lcPec.toDouble()+midPec.toDouble()+smPec.toDouble()+dMPec.toDouble()+eMPec.toDouble()+sPec.toDouble()+rePec.toDouble()+dfiPec.toDouble()+ifcPec.toDouble()
        if(tPfAmt == 100.00){
            //calculate investment totals
            var lcV = invAmtS.toDouble() * (lcPec.toDouble() *100)
            var mcV = invAmtS.toDouble() * (midPec.toDouble() *100)
            var smV = invAmtS.toDouble() * (smPec.toDouble() *100)
            var dmV = invAmtS.toDouble() * (dMPec.toDouble() *100)
            var eMV = invAmtS.toDouble() * (eMPec.toDouble() *100)
            var sV = invAmtS.toDouble() * (sPec.toDouble() *100)
            var reV = invAmtS.toDouble() * (rePec.toDouble() *100)
            var dfiV = invAmtS.toDouble() * (dfiPec.toDouble() *100)
            var ifcV = invAmtS.toDouble() * (ifcPec.toDouble() *100)

            //displays investments in hidden fields
            lcInvAmt.text= lcV.toString()
            mcInvAmt.text= mcV.toString()
            scInvAmt.text= smV.toString()
            dmInvAmt.text= dmV.toString()
            emInvAmt.text= eMV.toString()
            sInvAmt.text= sV.toString()
            reInvAmt.text= reV.toString()
            dfiInvAmt.text= dfiV.toString()
            ifcInvAmt.text= ifcV.toString()

        }
        else {
            errorMsg.visibility = View.VISIBLE
        }





    }
}