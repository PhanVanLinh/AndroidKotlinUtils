package toong.com.androidkotlinutils

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var textDate: TextView
    lateinit var currentDate: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textDate = findViewById(R.id.text_date)
        currentDate = getCurrentDateTime()

        textDate.text = currentDate.toString("yyyy/MM/dd HH:mm:ss")

        findViewById<Button>(R.id.button_previous).setOnClickListener {
            currentDate = currentDate.getPreviousDateTime()
            textDate.text = currentDate.toString("yyyy/MM/dd HH:mm:ss")
        }

        findViewById<Button>(R.id.button_next).setOnClickListener {
            currentDate = currentDate.getNextDateTime()
            textDate.text = currentDate.toString("yyyy/MM/dd HH:mm:ss")
        }

    }
}
