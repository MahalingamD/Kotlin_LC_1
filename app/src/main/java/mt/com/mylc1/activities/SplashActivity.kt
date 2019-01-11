package mt.com.mylc1.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import mt.com.mylc1.R

class SplashActivity : Activity() {

    private val DELAY_TIME_FOR_SPLASH_SCREEN: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val aHoldScreen = Handler()
        aHoldScreen.postDelayed(object : Runnable {
            public override fun run() {
                try {
                    val aIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                    aIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    aIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(aIntent)
                    this@SplashActivity.finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }, DELAY_TIME_FOR_SPLASH_SCREEN)
    }
}
