package com.apkbus.bbs

import android.os.Bundle
import com.mob.bbssdk.gui.BaseMainActivity
import com.mob.bbssdk.theme1.BBSTheme1


class MainActivity : BaseMainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        BBSTheme1.init()
        super.onCreate(savedInstanceState)

    }

}