package mt.com.mylc1.activities

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SwitchCompat
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import mt.com.mylc1.R
import mt.com.mylc1.helper.AppHelper
import mt.com.mylc1.utils.APPNetworkUtil
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var myLoginId_EDT: EditText
    lateinit var myPassword_EDT: EditText;
    lateinit var myFirstName_EDT: EditText;
    lateinit var mySecondName_EDT: EditText;
    lateinit var myEmail_EDT: EditText;
    lateinit var myMobile_EDT: EditText;
    lateinit var myAddress_EDT: EditText;

    lateinit var myDOB_TXT: TextView;
    lateinit var myGender_RG: RadioGroup;
    lateinit var myAge_Spin: Spinner;
    lateinit var myNotify_Switch: SwitchCompat;

    lateinit var mySubmit_BUT: Button;
    var cal = Calendar.getInstance();

    var myLoginId: String = "";
    val myFormat = "dd-MM-yyyy" // mention the format you need

    val mySpinnerList = ArrayList<String>()
    lateinit var myAppNetworkUtil: APPNetworkUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        myLoginId_EDT = findViewById<EditText>(R.id.loginid)
        myPassword_EDT = findViewById(R.id.password) as EditText
        myFirstName_EDT = findViewById(R.id.first_name) as EditText
        mySecondName_EDT = findViewById(R.id.second_name) as EditText

        myEmail_EDT = findViewById(R.id.email_id) as EditText
        myMobile_EDT = findViewById(R.id.mobile_number) as EditText
        myAddress_EDT = findViewById(R.id.address) as EditText

        myDOB_TXT = findViewById(R.id.date_of_birth) as TextView
        myGender_RG = findViewById(R.id.gender_RG) as RadioGroup
        myAge_Spin = findViewById(R.id.age_spinner) as Spinner
        myNotify_Switch = findViewById(R.id.push_nitfy_switch) as SwitchCompat

        mySubmit_BUT = findViewById(R.id.submit_but) as Button

        myAppNetworkUtil = APPNetworkUtil()

        if (myAppNetworkUtil.isInternetOn(this)) {
            Log.e("Network", "True")
        } else {
            Log.e("Network", "False")
        }

        clickListener()



        datePicker()

        radioGroup()

        spinner()

        switchCompact()

    }

    private fun clickListener() {

        mySubmit_BUT.setOnClickListener() {
            validation()

            // Toast.makeText(this, myLoginId, Toast.LENGTH_SHORT).show()
        }
    }

    private fun validation(): Boolean {

        if (myLoginId_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter Login id", Toast.LENGTH_SHORT).show()
            return false
        } else if (myPassword_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            return false
        } else if (myFirstName_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter first name", Toast.LENGTH_SHORT).show()
            return false
        } else if (mySecondName_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter second name", Toast.LENGTH_SHORT).show()
            return false
        } else if (myEmail_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show()
            return false
        } else if (!AppHelper.isEmailValid(myEmail_EDT.text.toString())) {
            Toast.makeText(this, "Please enter valid email address", Toast.LENGTH_SHORT).show()
            return false
        } else if (myMobile_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT).show()
            return false
        } else if (!AppHelper.isMobileValid(myMobile_EDT.text.toString())) {
            Toast.makeText(this, "Please enter valid mobile number", Toast.LENGTH_SHORT).show()
            return false
        } else if (myAddress_EDT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter address", Toast.LENGTH_SHORT).show()
            return false
        } else if (myDOB_TXT.text.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your DOB", Toast.LENGTH_SHORT).show()
            return false
        } else {
            Toast.makeText(this, "User Successfully Register", Toast.LENGTH_SHORT).show()
            return true
        }

    }


    private fun spinner() {
        for (i in 15..50) {
            mySpinnerList.add("" + i)
        }

        myAge_Spin.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mySpinnerList)


        myAge_Spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // Toast.makeText(this@MainActivity, mySpinnerList.get(p2), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun radioGroup() {

        // Get radio group selected item using on checked change listener
        myGender_RG.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(
                    applicationContext, " On checked change : ${radio.text}",
                    Toast.LENGTH_SHORT
                ).show()
            })
    }

    private fun datePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            // cal.

            val sdf = SimpleDateFormat(myFormat, Locale.UK)
            myDOB_TXT.text = sdf.format(cal.time)

        }

        myDOB_TXT.setOnClickListener {

            DatePickerDialog(
                this@MainActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

    }

    private fun switchCompact() {

        myNotify_Switch.setOnCheckedChangeListener { compoundButton, ischecked ->

            if (ischecked) {
                Toast.makeText(this, "" + ischecked, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "" + ischecked, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
