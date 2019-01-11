package mt.com.mylc1.utils

import android.content.Context
import android.net.ConnectivityManager

class APPNetworkUtil {
    /**
     * Check the internet connection and return true or false
     *
     * @param aContext
     * @return
     */
    fun isInternetOn(aContext: Context):Boolean {
        try
        {
            if (aContext == null)
                return false
            val connectivityManager = aContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo()
            return activeNetworkInfo != null
        }
        catch (e:Exception) {
            e.printStackTrace()
            return false
        }
    }
    companion object {
        var TYPE_WIFI = 1
        var TYPE_MOBILENETWORK = 2
        var TYPE_NOT_CONNECTED = 0
        private val aResult:Boolean = false
        fun getConnectivityStatus(context:Context):Int {
            val cm = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.getActiveNetworkInfo()
            if (null != activeNetwork)
            {
                if (activeNetwork.getType() === ConnectivityManager.TYPE_WIFI)
                    return TYPE_WIFI
                if (activeNetwork.getType() === ConnectivityManager.TYPE_MOBILE)
                    return TYPE_MOBILENETWORK
            }
            return TYPE_NOT_CONNECTED
        }
    }
}