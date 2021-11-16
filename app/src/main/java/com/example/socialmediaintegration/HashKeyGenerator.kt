package com.example.socialmediaintegration

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.security.MessageDigest
import java.util.*

class HashKeyGenerator {
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateSSHKey(context: Context){
        try {
            val info = context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey = String(Base64.getEncoder().encode(md.digest()))
                Log.i("AppLog", "key:$hashKey=")
            }
        } catch (e: Exception) {
            Log.e("AppLog", "error:", e)
        }

    }

}
