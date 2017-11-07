package com.apkbus.bbs

import android.app.Application
import com.mob.MobSDK
import com.mob.bbssdk.theme1.BBSTheme1


class BBSApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MobSDK.init(this, "", "")
        BBSTheme1.init()
    }
}