package com.apkbus.bbs

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.LinearLayout
import com.mob.MobSDK
import com.mob.bbssdk.gui.BaseMainActivity
import com.mob.bbssdk.theme1.BBSTheme1
import com.mob.bbssdk.utils.StringUtils
import com.mob.tools.utils.UIHandler
import com.mob.bbssdk.gui.BBSViewBuilder
import com.mob.moblink.Scene
import com.mob.moblink.SceneRestorable
import com.mob.tools.utils.ResHelper


class MainActivity : BaseMainActivity(), SceneRestorable {

    private var layoutParamsContainer: LinearLayout? = null
    private var strFid: String? = null
    private var strTid: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        BBSTheme1.init()
        super.onCreate(savedInstanceState)

        layoutParamsContainer = findViewById(ResHelper.getIdRes(this, "layoutParamsContainer")) as LinearLayout

        val intent = intent
        if (intent != null && intent.data != null && !StringUtils.isEmpty(
                intent.data.getQueryParameter("params"))) {
            //			String params = intent.getData().getQueryParameter("params");
//            val key = getStringByResName("BBS_APPKEY")
//            val secret = getStringByRame("BBS_APPKEY")
            val key = "215d567c806fa"
            val secret = "70d65618dbd258834a3c05ea49df878c"
            if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(secret)) {
//                textHint.setText(getStringByResName("bbs_init_restorefromurl"))
                MobSDK.init(this@MainActivity, key, secret)
                layoutParamsContainer!!.setVisibility(View.GONE)
            }
        }

        //open web link page if valid
        if (!StringUtils.isEmpty(strFid) && !StringUtils.isEmpty(strTid)) {
            val details = BBSViewBuilder.getInstance().buildPageForumThreadDetail()
            details.setForumThread(java.lang.Long.parseLong(strFid), java.lang.Long.parseLong(strTid), "")
            UIHandler.sendMessageDelayed(null, 300, object : Handler.Callback {
                override fun handleMessage(msg: Message): Boolean {
                    details.show(this@MainActivity)
                    return false
                }
            })
        }
    }

    override fun onReturnSceneData(scene: Scene?) {
        strFid = scene!!.params.get("fid") as String
        strTid = scene.params.get("fid") as String
    }

}