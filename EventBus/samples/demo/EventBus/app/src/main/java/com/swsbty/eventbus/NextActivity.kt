package com.swsbty.eventbus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.next_activity)
    }

    /* 点击按钮，发布事件 */
    fun onSend(v: View) {
        EventBus.getDefault().postSticky(MessageEvent("我好帅啊"))
    }

}