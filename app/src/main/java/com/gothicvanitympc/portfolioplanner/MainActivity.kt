package com.gothicvanitympc.portfolioplanner


import android.graphics.Color.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate.JOYFUL_COLORS
//import com.gothicvanitympc.portfolioplanner.R.id.idPieChartBtn
import com.gothicvanitympc.portfolioplanner.R.layout.piechart
import kotlinx.android.synthetic.main.amlinearlayout.*
import java.util.*
import kotlin.collections.ArrayList
import com.github.mikephil.charting.charts.PieChart

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.amlinearlayout)

        val mybutton: Button = findViewById(R.id.calcBtn)
        mybutton.setOnClickListener { invCalc()}

       // val button1: Button = findViewById(R.id.idPieChartBtn)
       // button1.setOnClickListener { setContentView(piechart)}


    }

    private fun invCalc(){
        //rest error message
        errorMsg.visibility = View.INVISIBLE
        //idPieChartBtn.visibility = View.INVISIBLE
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
            //create double array
            var invp: FloatArray = floatArrayOf(
                lcV.toFloat(),
                mcV.toFloat(),
                smV.toFloat(),
                dmV.toFloat(),
                eMV.toFloat(),
                sV.toFloat(),
                reV.toFloat(),
                dfiV.toFloat(),
                ifcV.toFloat()
            )
            val portfolioC = arrayOf(
                "Large Cap",
                "Mid Cap",
                "Small Cap",
                "Developed Market",
                "Emerging Markets",
                "Specialty",
                "Real Estate/REITs",
                "Domestic Fixed Income",
                "International Fixed Income"
            )
           //colors for piechart
            val color: MutableList<Int> = ArrayList()
            color.add(RED)
            color.add(BLUE)
            color.add(GREEN)
            color.add(YELLOW)
            color.add(CYAN)
            color.add(MAGENTA)
            color.add(DKGRAY)
            color.add(BLACK)
            color.add(LTGRAY)

            var pieEntries: ArrayList<PieEntry> = ArrayList()
            pieEntries.add(PieEntry(lcV.toFloat(), "Large Cap"))
            pieEntries.add(PieEntry(mcV.toFloat(), "Mid Cap"))
            pieEntries.add(PieEntry(smV.toFloat(), "Small Cap"))
            pieEntries.add(PieEntry(dmV.toFloat(), "Developed Markets"))
            pieEntries.add(PieEntry(eMV.toFloat(), "Emerging Markets"))
            pieEntries.add(PieEntry(sV.toFloat(), "Specialty"))
            pieEntries.add(PieEntry(reV.toFloat(), "Real Estate/REITs"))
            pieEntries.add(PieEntry(dfiV.toFloat(), "Domestic Fixed Income"))
            pieEntries.add(PieEntry(ifcV.toFloat(), "International Fixed Income"))


            /*
            var pieEntries: ArrayList<PieEntry> = ArrayList()
            pieEntries.add(PieEntry(lcPec.toFloat(), "Large Cap"))
            pieEntries.add(PieEntry(midPec.toFloat(), "Mid Cap"))
            pieEntries.add(PieEntry(smPec.toFloat(), "Small Cap"))
            pieEntries.add(PieEntry(dMPec.toFloat(), "Developed Markets"))
            pieEntries.add(PieEntry(eMPec.toFloat(), "Emerging Markets"))
            pieEntries.add(PieEntry(sPec.toFloat(), "Specialty"))
            pieEntries.add(PieEntry(rePec.toFloat(), "Real Estate/REITs"))
            pieEntries.add(PieEntry(dfiPec.toFloat(), "Domestic Fixed Income"))
            pieEntries.add(PieEntry(ifcPec.toFloat(), "International Fixed Income"))
            */

            var dataSet = PieDataSet(pieEntries, "Investment Portfolio")
            dataSet.setColors(*JOYFUL_COLORS)

            //dataSet.setColors(color)
            var data = PieData(dataSet)

            //PieChart chart = (PieChart)findViewById(R.id.idPieChart)

           //todo:fix null pointer ex
            var chart : PieChart = findViewById(R.id.idPieChart)
            chart.setData(data)
            //piechart styling
            chart.setHoleRadius(0f)
            chart.setTransparentCircleAlpha(0)
           

            //refreash pie chart
            chart.invalidate()
            //idPieChartBtn.visibility = View.VISIBLE

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

    private fun dollarForm(dAmt: Double): String{
        var numb = dAmt
        return java.text.NumberFormat.getCurrencyInstance(Locale.US).format(numb)
    }


    }


