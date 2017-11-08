package com.apkbus.bbs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.mob.bbssdk.gui.BaseMainActivity
import com.mob.bbssdk.model.ForumThreadAttachment
import com.mob.moblink.RestoreSceneListener
import java.util.HashMap
import com.mob.bbssdk.gui.BBSViewBuilder
import com.mob.bbssdk.utils.StringUtils
import com.mob.moblink.MobLink


class MainActivity : BaseMainActivity() {
    var strUrl: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobLink.setRestoreSceneListener(object : RestoreSceneListener {
            override fun onBeginCheckScene() {

            }

            override fun onFinishCheckScene() {

            }

            override fun onReturnSceneIntent(s: String, intent: Intent): Boolean {
                return false
            }

            override fun onReturnSceneData(activity: Activity, hashMap: HashMap<String, Any>) {
                val urlvalue = hashMap["ulurl"]
                if (urlvalue != null && urlvalue is String) {
                    strUrl = urlvalue
                }
                //open web link page if valid
                if (!StringUtils.isEmpty(strUrl)) {
                    val web = BBSViewBuilder.getInstance().buildPageWeb()
                    web.setLink(strUrl)
                    web.show(this@MainActivity)
                }
            }
        })
    }

    override fun OnAttachmentClick(attachment: ForumThreadAttachment) {
        super.OnAttachmentClick(attachment)
    }
}