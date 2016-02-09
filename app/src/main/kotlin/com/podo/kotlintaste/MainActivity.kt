// Top of the source you find your package.
package com.podo.kotlintaste

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    val view = v<TextView>(this) {
        layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        text = "Hello"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        // Variables
        //Assign once read only variables
        val z : Int = 1
        val y = 1  // type can be inferred
        val s : Int // Type required when no initialization
        s = 10
        // mutable variables
        var x = 1
        x++





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    inline fun <reified TV : View> v (context: Context, init: TV.() -> Unit) : TV{
        val constr = TV::class.java.getConstructor(Context::class.java)
        val view = constr.newInstance(context)
        view.init()
        return view
    }

    /**
     * Some Function Fun
     * **/

    //function with parameters and return type.
    fun sum(a : Int, b: Int) : Int {
        return a+b
    }

    // function with body and inferred return
    fun mul(a :Int, b: Int) = a*b

    // function returns no meaningful value.
    fun printNum(a : Int,b:Int) : Unit { print(a + b)}

    // I can throw the unit away
    fun printNumV2(a : Int,b:Int)  { print(a + b)}

    // String templates
    fun stringTemplate1(args :Array <String>){
        if(args.size  == 0 ) return
        print("First : $args[0]")
    }

    //Conditions
    fun whoIsOlder(age1 : Int, age2: Int){
        if(age1 > age2)
            print("age1 : $age1")
        else
            print("age2 : $age2")
    }
    // use if as an expression.
    fun max (arg1: Int, arg2: Int) =if(arg1 > arg2) arg1 else arg2

    //nullable values
    fun findLength(str : String) : Int?{
        return str.length
    }

    // type checks and automatic cast
    fun getStringLength(obj : Any) : Int?{
//        if (obj is String)
//            // automatic cast to string
//            return obj.length
//        // outside if it is still of type any.
//        return null
        if (obj !is String)
            return null

        // auto cast to String.
        return obj.length
    }

    fun testLoop(args: Array<String>) {
        for (arg in args)
            print(arg)

        for( i in args.indices){
            print(args[i])
        }

    }

    fun testWhile(args: Array<String>) {
        var i = 0
        while (i < args.size)
            print(args[i++])
    }

    // using when
    fun testWhen(obj :Any){
        when (obj) {
            1 -> print(1)
            "Hi" -> print("Hello")
            else -> print("unknown")
        }
    }

    fun rangesFun(){
        for ( x in 1..10){
            print(x)
        }


    }



}
