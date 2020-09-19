package com.gothicvanitympc.portfolioplanner

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.amlinearlayout.*
import java.util.*
import kotlin.text.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.amlinearlayout)

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
            var lcV = invAmtS.toDouble() * (lcPec.toDouble() / 100)
            var mcV = invAmtS.toDouble() * (midPec.toDouble() / 100)
            var smV = invAmtS.toDouble() * (smPec.toDouble() / 100)
            var dmV = invAmtS.toDouble() * (dMPec.toDouble() / 100)
            var eMV = invAmtS.toDouble() * (eMPec.toDouble() / 100)
            var sV = invAmtS.toDouble() * (sPec.toDouble() / 100)
            var reV = invAmtS.toDouble() * (rePec.toDouble() / 100)
            var dfiV = invAmtS.toDouble() * (dfiPec.toDouble() / 100)
            var ifcV = invAmtS.toDouble() * (ifcPec.toDouble() / 100)

            //displays investments in hidden fields
            lcInvAmt.text= dollarForm(lcV)
            lcInvAmt.visibility = View.VISIBLE
            mcInvAmt.text= dollarForm(mcV)
            mcInvAmt.visibility = View.VISIBLE
            scInvAmt.text= dollarForm(smV)
            scInvAmt.visibility = View.VISIBLE
            dmInvAmt.text= dollarForm(dmV)
            dmInvAmt.visibility = View.VISIBLE
            emInvAmt.text= dollarForm(eMV)
            emInvAmt.visibility = View.VISIBLE
            sInvAmt.text= dollarForm(sV)
            sInvAmt.visibility = View.VISIBLE
            reInvAmt.text= dollarForm(reV)
            reInvAmt.visibility = View.VISIBLE
            dfiInvAmt.text= dollarForm(dfiV)
            dfiInvAmt.visibility = View.VISIBLE
            ifcInvAmt.text= dollarForm(ifcV)
            ifcInvAmt.visibility = View.VISIBLE
        }
        else {
            errorMsg.visibility = View.VISIBLE
        }


        }

    private fun dollarForm( dAmt: Double): String{
        var numb = dAmt
       return java.text.NumberFormat.getCurrencyInstance(Locale.US).format(numb)
    }
}