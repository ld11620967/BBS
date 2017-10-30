package com.apkbus.bbs

import com.mob.MobApplication
import com.mob.MobSDK
import com.mob.bbssdk.theme1.BBSTheme1


class BBSApplication : MobApplication() {

    override fun onCreate() {
        super.onCreate()
        MobSDK.init(this)
        BBSTheme1.init()
    }
}