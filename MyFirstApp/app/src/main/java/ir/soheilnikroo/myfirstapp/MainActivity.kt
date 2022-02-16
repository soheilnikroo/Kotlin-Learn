package ir.soheilnikroo.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView=findViewById<TextView>(R.id.textView2)
        val btnClickMe = findViewById<Button>(R.id.mybutton)
        var timesClicked = 0;
        btnClickMe.setOnClickListener {
            myTextView.text=timesClicked++.toString()
            Toast.makeText(this,"Hey I'm toast",Toast.LENGTH_LONG).show()
        }

    }
}