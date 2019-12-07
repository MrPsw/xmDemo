package management.lxgdgj.com.xmcamera.listener;

import java.util.List;

import management.lxgdgj.com.xmcamera.config.AlarmInfo;
import management.lxgdgj.com.xmcamera.models.FunDevice;

public interface OnFunDeviceAlarmListener extends OnFunListener {

	// 设备状态发生变化
	void onDeviceAlarmReceived(final FunDevice funDevice, AlarmInfo alarmInfo);
	
	// 搜索历史报警消息成功
	void onDeviceAlarmSearchSuccess(final FunDevice funDevice, final List<AlarmInfo> infos);
	
	// 搜索历史报警消息失败
	void onDeviceAlarmSearchFailed(final FunDevice funDevice, final int errCode);
	
	// 接收到一个局域网报警信息
	void onDeviceLanAlarmReceived(final FunDevice funDevice, final AlarmInfo alarmInfo);
}
