package mt.com.mylc1.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import mt.com.mylc1.R

class LoginActivity : Activity() {

    lateinit var myLogin_But: Button
    lateinit var mySignup_But: Button

    lateinit var myEmail_EDT: EditText
    lateinit var myPassword_EDT: EditText

    var myEmail_STR: String? = null   //String Allow Null if using ?
    var myPassword_STR: String = ""   // String Not allow null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
     //   myPassword_STR = null

    }

    private fun init() {
        myEmail_EDT = findViewById(R.id.login_email_id) as EditText
        myPassword_EDT = findViewById(R.id.login_password) as EditText

        myLogin_But = findViewById(R.id.login_btn) as Button
        mySignup_But = findViewById(R.id.signup_but) as Button


        clickListener()
    }

    private fun clickListener() {

        mySignup_But.setOnClickListener {
            val aIntent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(aIntent)
        }

        myLogin_But.setOnClickListener() {

            myEmail_STR = myEmail_EDT.text.toString()
            myPassword_STR = myPassword_EDT.text.toString()

            if (!myEmail_STR.isNullOrEmpty()) {
                //  print("CHECK = > Null")
                Log.e("Check", "Not Null")
            }else{
                Log.e("Check", "Null")
            }
        }
    }
}
