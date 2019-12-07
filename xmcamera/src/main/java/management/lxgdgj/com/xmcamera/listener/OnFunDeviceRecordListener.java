package management.lxgdgj.com.xmcamera.listener;

import java.util.List;

import management.lxgdgj.com.xmcamera.models.FunDevRecordFile;

public interface OnFunDeviceRecordListener extends OnFunListener {

    void onRequestRecordListSuccess(List<FunDevRecordFile> files);

    void onRequestRecordListFailed(final Integer errCode);

}
