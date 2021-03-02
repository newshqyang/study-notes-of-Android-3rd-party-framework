import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {

    /* 点击界面上的按钮，跳转到下一个界面 */
    fun onNavigate(v: View) {
        startActivity(Intent(this, NextActivity::class.java))
    }

    /* 在onCreate()方法内执行 register */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EventBus.getDefault().register(this)
    }

    /* 订阅事件 */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetMessage(me: MessageEvent) {
        findViewById<Button>(R.id.button).text = me.msg
    }

    /* 在onDestroy()方法内执行 unregister */
    override fun onDestroy() {
        super.onDestroy()

        EventBus.getDefault().unregister(this)
    }

}