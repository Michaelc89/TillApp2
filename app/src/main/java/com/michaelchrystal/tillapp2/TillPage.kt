package com.michaelchrystal.tillapp2

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Debug
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_till_page.*


class TillPage : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_till_page)

        var Listposition = -1
        val textView : TextView = findViewById(R.id.textView_display) as TextView

        listView = findViewById<ListView>(R.id.recipe_list_view)

        val prod0 = Product(1,"Hammer",2.33,"233",5,"fd")
        val prod1 = Product(3,"screw",0.33,"2335",50,"fd")
        var entry = Product(-1,"placeholder",999.00,"999",999,"placeholder")
// 1
        val recipeList = ArrayList<Product>()//= Recipe.getRecipesFromFile("recipes.json", this)
        recipeList.add(prod0)
        recipeList.add(prod1)

        val adapter = ProductAdapter(this, recipeList)
        listView.adapter = adapter

        /*listView.setOnItemClickListener { adapterView, view, position: Int, id: Long ->
            //gets postiton of item in listview
            Log.d("here","boom" + position.toString())
        }*/

        listView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val message = "abc"
            intent.putExtra(EXTRA_MESSAGE, message)
            Listposition = position
            Log.d("postition","**"+Listposition)
            //listView.


        })




       // entry = listView.getItemAtPosition(Listposition) as Product
        //Log.d("prd",entry.productName.toString())
// 2
        val listItems = arrayOfNulls<String>(recipeList.size)
// 3
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.price.toString()
        }
// 4
        var display: MutableList<String> = mutableListOf<String>()//**** Display list

        var pressed:Int = 0//pressed is the counter for how many times the decimal point is pressed
        var point:Int = 0 // point is numbers after decimal point is <2

        button_total.setOnClickListener {
            var cost : Double
            cost = 0.00
            for (rec in recipeList){
                cost += rec.price
            }


            textView.text = cost.toString()

        }

        button_clear.setOnClickListener {
            textView.text = null
            display.clear()
            pressed=0
            point = 0
        }

        /*listView.onItemClickListener = AdapterView.OnItemClickListener {
                ProductAdapter, view, recipeList, l ->
            Toast.makeText(this,
                "you selected item " + (recipeList. + 1),
                Toast.LENGTH_LONG).show()
        }*/
buttonProduct.setOnClickListener{
    startActivity(Intent(this,ProductListPage::class.java))
}


//**************** NUMBER BUTTONS****************************************************************************
        buttonOne.setOnClickListener {
            if ( pressed<1)
            {
                display.add("1")
                textView.text = display.joinToString("")

                /*val builder = AlertDialog.Builder(this)
                builder.setTitle("Androidly Alert")
                builder.setMessage("We have a message"+selItem.toString())
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    Toast.makeText(applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT).show()
                }

                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(applicationContext,
                        android.R.string.no, Toast.LENGTH_SHORT).show()
                }

                builder.setNeutralButton("Maybe") { dialog, which ->
                    Toast.makeText(applicationContext,
                        "Maybe", Toast.LENGTH_SHORT).show()
                }
                builder.show()*/
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("1")
                textView.text = display.joinToString("")
            }
        }

        buttonTwo.setOnClickListener {
            if ( pressed<1)
            {
                display.add("2")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("2")
                textView.text = display.joinToString("")
            }
        }
        buttonThree.setOnClickListener {
            if ( pressed<1)
            {
                display.add("3")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("3")
                textView.text = display.joinToString("")
            }
        }
        buttonFour.setOnClickListener {
            if ( pressed<1)
            {
                display.add("4")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("4")
                textView.text = display.joinToString("")
            }
        }
        buttonFive.setOnClickListener {
            if ( pressed<1)
            {
                display.add("5")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("5")
                textView.text = display.joinToString("")
            }
        }
        buttonSix.setOnClickListener {
            if ( pressed<1)
            {
                display.add("6")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("6")
                textView.text = display.joinToString("")
            }
        }
        buttonSeven.setOnClickListener {
            if ( pressed<1)
            {
                display.add("7")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("7")
                textView.text = display.joinToString("")
            }
        }
        buttonEight.setOnClickListener {
            if ( pressed<1)
            {
                display.add("8")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("8")
                textView.text = display.joinToString("")
            }
        }
        buttonNine.setOnClickListener {
            if ( pressed<1)
            {
                display.add("9")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("9")
                textView.text = display.joinToString("")
            }
        }
        buttonZeroZero.setOnClickListener {
            if ( pressed != 1)
            {
                display.add(".00")
                textView.text = display.joinToString("")
            }
            else
            {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("You have selected .00 twice")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                   /* .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                            dialog, id -> finish()
                    })*/
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })
                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Invalid Number Pressed!")
                // show alert dialog
                alert.show()


            }
        }
        buttonZero.setOnClickListener {
            if ( pressed<1)
            {
                display.add("0")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("0")
                textView.text = display.joinToString("")
            }
        }
    buttonPoint.setOnClickListener {
            if ( pressed!= 1)
            {
                display.add(".")
                textView.text = display.joinToString("")
                pressed+=1
            }
            else
            {
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("Please select number before point")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    /*.setPositiveButton("Proceed", DialogInterface.OnClickListener {
                            dialog, id -> finish()
                    })*/
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Invalid Number Pressed!")
                // show alert dialog
                alert.show()
            }
        }

        buttonVoid.setOnClickListener{
            val dialogBuilder = AlertDialog.Builder(this)


             entry = listView.getItemAtPosition(Listposition) as Product
            Log.d("prd",entry.productName.toString())


            // set message of alert dialog
            dialogBuilder.setMessage("Would you like to VOID "+ entry.productName.toString()+"?")
                // if the dialog is cancelable
                .setCancelable(true)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {

                       // dialog, id -> finish()
                        dialog, id -> dialog.cancel()
                    for (p in recipeList)
                        if ( p.id == entry.id )
                        { //if id from product and entry match remove the item from the list and update the view
                            recipeList.remove(p)
                            Log.d("TAG", "message: " + p.productName.toString())
                            Log.d("","blah@~"+ recipeList.toString())
                            listView.adapter = adapter
                        }

                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("VOID ITEM?")
            // show alert dialog
            alert.show()


        }

        buttonFifty.setOnClickListener {
            if ( pressed<1)
            {
                display.add("50.00")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("50.00")
                textView.text = display.joinToString("")
            }
        }
        buttonTwenty.setOnClickListener {
            if ( pressed<1)
            {
                display.add("20.00")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("20.00")
                textView.text = display.joinToString("")
            }
        }
        buttonTen.setOnClickListener {
            if ( pressed<1)
            {
                display.add("10.00")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("10.00")
                textView.text = display.joinToString("")
            }
        }
        buttonFiver.setOnClickListener {
            if ( pressed<1)
            {
                display.add("5.00")
                textView.text = display.joinToString("")
            }
            else if(pressed >0 && point<2)
            {
                point++
                display.add("5.00")
                textView.text = display.joinToString("")
            }
        }
        buttonMisc.setOnClickListener {
            if ( textView.text == null)
            {
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("Please input price before MISC ITEM")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    /*.setPositiveButton("Proceed", DialogInterface.OnClickListener {
                            dialog, id -> finish()
                    })*/
                    // negative button text and action
                    .setNegativeButton("OK", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Invalid Number Pressed!")
                // show alert dialog
                alert.show()
            }
            else
            {
                val d:String =""
                d == textView.text
                d.toDouble()

                textView.text = display.joinToString("")
                val prodMisc = Product(999,"MISC PRODUCT",d.toDouble(),"99",1,"fd")
                recipeList.add(prodMisc)
                point++
                display.add("5.00")
                textView.text = display.joinToString("")
            }
        }

    }




}
