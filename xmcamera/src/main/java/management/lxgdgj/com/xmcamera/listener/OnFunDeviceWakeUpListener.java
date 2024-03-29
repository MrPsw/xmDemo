package management.lxgdgj.com.xmcamera.listener;


import management.lxgdgj.com.xmcamera.models.FunDevStatus;

/**
 * @author hws
 * @name OldFunSdkDemo
 * @class name：com.com.lib.funsdk.support
 * @class 设备唤醒及状态
 * @time 2019-02-15 19:21
 * @change
 * @chang time
 * @class describe
 */
public interface OnFunDeviceWakeUpListener extends OnFunListener{
    void onDeviceState(FunDevStatus state);
    void onWakeUpResult(boolean isSuccess, FunDevStatus state);
    void onSleepResult(boolean isSuccess, FunDevStatus status);
}
