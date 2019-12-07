package management.lxgdgj.com.surfaceviewdemo

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import management.lxgdgj.com.xmcamera.FunError
import management.lxgdgj.com.xmcamera.FunSupport
import management.lxgdgj.com.xmcamera.config.ChannelSystemFunction
import management.lxgdgj.com.xmcamera.config.OPPTZPreset
import management.lxgdgj.com.xmcamera.config.SystemInfo
import management.lxgdgj.com.xmcamera.listener.OnFunDeviceOptListener
import management.lxgdgj.com.xmcamera.models.FunDevType
import management.lxgdgj.com.xmcamera.models.FunDevice
import management.lxgdgj.com.xmcamera.sdk.struct.H264_DVR_FILE_DATA


class MainActivity : AppCompatActivity(), OnFunDeviceOptListener {

    private var mFunDevice: FunDevice? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_horizontal_switch.setOnClickListener {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
//        btn_switch.setOnClickListener {
//            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
//        }


        // 注册设备操作回调
        FunSupport.getInstance().registerOnFunDeviceOptListener(this)

        updateFunVideoViewSize()

        mFunDevice = FunDevice()
        mFunDevice?.devSn = "3b817715b67a7aae"
        mFunDevice?.let {
            // 如果设备未登录,先登录设备
            if (!it.hasLogin() || !it.hasConnected()) {
                FunSupport.getInstance().requestDeviceLogin(mFunDevice)
            } else {
                FunSupport.getInstance().requestDeviceConfig(mFunDevice, SystemInfo.CONFIG_NAME)
                val channelSystemFunction = ChannelSystemFunction()
                FunSupport.getInstance().requestDeviceCmdGeneral(mFunDevice, channelSystemFunction)
            }
        }
        initFunVideoView()
        initOperating()
    }

    private fun initOperating() {
        btn_screenshot.setOnClickListener {
            val filePath = mFunVideoView.captureImage(null)
            if (TextUtils.isEmpty(filePath)) {
                showToast("抓拍失败")
            } else {
                showToast("抓拍成功 存储:" + filePath)
            }
        }
        btn_talkback.setOnClickListener {
            val result = FunSupport.getInstance().requestDeviceStartTalk(mFunDevice)
            showToast("开启成功")
        }


    }

    private fun initFunVideoView() {
        if (mFunDevice?.devType == FunDevType.EE_DEV_LAMP_FISHEYE) {
            // 鱼眼灯泡,设置鱼眼效果
            mFunVideoView.setFishEye(true)
        }
        mFunVideoView.setRealDevice(mFunDevice?.devSn, mFunDevice!!.CurrChannel)

//  mFunVideoView.setOnTouchListener(OnVideoViewTouchListener())
//        mFunVideoView.setOnPreparedListener(this)
//        mFunVideoView.setOnErrorListener(this)
//        mFunVideoView.setOnInfoListener(this)
    }

    override fun onDeviceGetConfigFailed(funDevice: FunDevice?, errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
        if (errCode == -11406) {
            funDevice?.invalidConfig(OPPTZPreset.CONFIG_NAME)
        }
    }

    private fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDeviceChangeInfoFailed(funDevice: FunDevice?, errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }

    override fun onDeviceOptionFailed(funDevice: FunDevice?, option: String?, errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }

    override fun onDeviceChangeInfoSuccess(funDevice: FunDevice?) {
    }

    override fun onDeviceOptionSuccess(funDevice: FunDevice?, option: String?) {
    }

    override fun onDeviceSetConfigFailed(
        funDevice: FunDevice?,
        configName: String?,
        errCode: Int?
    ) {
        showToast(FunError.getErrorStr(errCode))
    }

    override fun onDeviceFileListGetFailed(funDevice: FunDevice?) {
    }

    override fun onDeviceFileListChanged(funDevice: FunDevice?) {
    }

    override fun onDeviceFileListChanged(
        funDevice: FunDevice?, datas: Array<out H264_DVR_FILE_DATA>?
    ) {
    }

    override fun onDeviceGetConfigSuccess(funDevice: FunDevice?, configName: String?, nSeq: Int) {
    }

    override fun onDeviceSetConfigSuccess(funDevice: FunDevice?, configName: String?) {
    }

    override fun onDeviceLoginSuccess(funDevice: FunDevice?) {
    }

    override fun onDeviceLoginFailed(funDevice: FunDevice?, errCode: Int?) {
        showToast(FunError.getErrorStr(errCode))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updateFunVideoViewSize()
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //当前为横屏， 在此处添加额外的处理代码
            runOnUiThread {
                //vertical_screen_operation.visibility = View.GONE
                horizontal_screen_operation.visibility = View.VISIBLE
                rl_video_content.layoutParams.apply {
                    height = RelativeLayout.LayoutParams.MATCH_PARENT
                }

            }
            Toast.makeText(this, "横屏", Toast.LENGTH_SHORT).show()
            Log.e("打印日志", "横屏")

        } else if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //当前为竖屏， 在此处添加额外的处理代码
            runOnUiThread {
                //vertical_screen_operation.visibility = View.VISIBLE
                horizontal_screen_operation.visibility = View.GONE
            }
            Toast.makeText(this, "竖屏", Toast.LENGTH_SHORT).show()
            Log.e("打印日志", "竖屏")
        }

    }


    private fun updateFunVideoViewSize() {

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //当前为横屏， 在此处添加额外的处理代码
            rl_video_content.layoutParams.apply {
                height = RelativeLayout.LayoutParams.MATCH_PARENT
            }
        } else if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //当前为竖屏， 在此处添加额外的处理代码
            rl_video_content.layoutParams.apply {
                height = getWidth()
            }
        }
    }

    private fun getWidth(): Int {
        return (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.width
    }


}
