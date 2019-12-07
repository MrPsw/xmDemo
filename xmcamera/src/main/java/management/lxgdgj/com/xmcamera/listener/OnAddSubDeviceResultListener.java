package management.lxgdgj.com.xmcamera.listener;

import com.lib.MsgContent;

import management.lxgdgj.com.xmcamera.models.FunDevice;

/**
 * Created by zhangyongyong on 2017-07-25-08:55.
 */

public interface OnAddSubDeviceResultListener extends OnFunListener {
    /***子设备添加成功
     * @param funDevice
     * @param msgContent
     */
    void onAddSubDeviceFailed(FunDevice funDevice, MsgContent msgContent);

    /****子设备添加失败
     *
     * @param funDevice
     * @param msgContent
     */
    void onAddSubDeviceSuccess(FunDevice funDevice, MsgContent msgContent);

}
