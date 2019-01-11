package mt.com.mylc1.helper

import android.util.Patterns


class AppHelper {
    companion object {
        private val TAG = AppHelper::class.java.getSimpleName()

        fun isEmailValid(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.toRegex().matches(email);
        }

        fun isMobileValid(mobile: String): Boolean {
            return if (mobile.length == 10) true else false
        }
    }
}
