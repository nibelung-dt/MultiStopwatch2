package com.example.multistopwatch2

import android.content.Context
import android.content.Intent
// import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.multistopwatch2.Model.SingletonServiceManager
import com.example.multistopwatch2.Model.StopwatchService
import com.example.multistopwatch2.Model.StopwatchService.Companion.count
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceClass = StopwatchService::class.java
        val serviceClass2 = StopwatchService::class.java
        val intent = Intent(this, serviceClass)
        val intent2 = Intent(this, serviceClass2)

        val timer1 = findViewById<TextView>(R.id.timer1)
        val timer2 = findViewById<TextView>(R.id.timer2)

        val button = findViewById<TextView>(R.id.button)
        val button2 = findViewById<TextView>(R.id.button2)


        button.setOnClickListener {
            if (SingletonServiceManager.isServiceRunning == false) {
                startService(intent)
                timer1.setText(count.toString())
            } else {
                stopService(intent)
                // Toast.makeText(this, "Сервис уже запущен", Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            if (SingletonServiceManager.isServiceRunning == false) {
                startService(intent2)
                timer2.setText(count.toString())
            } else {
                stopService(intent2)
                // Toast.makeText(this, "Сервис уже запущен", Toast.LENGTH_SHORT).show()
            }
        }




    }


}
// , crossinline action: () -> Unit
/*
inline fun startCoroutineTimer(delayMillis: Long = 0, repeatMillis: Long = 0, crossinline action: () -> Unit) = GlobalScope.launch {
    delay(delayMillis)
    if (repeatMillis > 0) {
        while (true) {
           action()
            delay(repeatMillis)
        }
    } else {
        action()
    }
}
*/