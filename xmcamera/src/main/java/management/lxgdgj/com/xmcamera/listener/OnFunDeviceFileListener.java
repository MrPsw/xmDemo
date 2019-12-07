package management.lxgdgj.com.xmcamera.listener;

import management.lxgdgj.com.xmcamera.models.FunDevice;

public interface OnFunDeviceFileListener extends OnFunListener {

	//  文件下载成功
    void onDeviceFileDownCompleted(final FunDevice funDevice, final String path, final int nSeq);

    void onDeviceFileDownProgress(final int totalSize, final int progress, final int nSeq);

    void onDeviceFileDownStart(final boolean isStartSuccess, final int nSeq);
}
