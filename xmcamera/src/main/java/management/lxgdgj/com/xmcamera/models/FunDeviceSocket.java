package management.lxgdgj.com.xmcamera.models;


import management.lxgdgj.com.xmcamera.config.BaseConfig;
import management.lxgdgj.com.xmcamera.config.OPPowerSocketGet;
import management.lxgdgj.com.xmcamera.config.PowerSocketArm;
import management.lxgdgj.com.xmcamera.config.PowerSocketAutoLight;
import management.lxgdgj.com.xmcamera.config.PowerSocketAutoSwitch;
import management.lxgdgj.com.xmcamera.config.PowerSocketAutoUsb;
import management.lxgdgj.com.xmcamera.config.PowerSocketBanLed;
import management.lxgdgj.com.xmcamera.config.PowerSocketDelayLight;
import management.lxgdgj.com.xmcamera.config.PowerSocketDelaySwitch;
import management.lxgdgj.com.xmcamera.config.PowerSocketDelayUsbPower;
import management.lxgdgj.com.xmcamera.config.PowerSocketImage;
import management.lxgdgj.com.xmcamera.config.PowerSocketSensitive;
import management.lxgdgj.com.xmcamera.config.PowerSocketWorkRecord;

public class FunDeviceSocket extends FunDevice {

	private boolean mIsSupportLight;	// 是否有灯
	private boolean mIsSupportCamera;	// 是否有摄像头
	
	public FunDeviceSocket() {
		super();
	}
	
	// 智能插座主要配置,电源/USB/灯光开关等
	public OPPowerSocketGet getOPPowerSocketGet() {
		BaseConfig baseJson = getConfig(OPPowerSocketGet.CONFIG_NAME);
		if ( null != baseJson ) {
			return (OPPowerSocketGet)baseJson;
		}
		return null;
	}
	
	// 插座更多的配置信息
	public PowerSocketAutoSwitch getPowerSocketAutoSwitch() {
		BaseConfig baseJson = getConfig(PowerSocketAutoSwitch.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketAutoSwitch)baseJson;
		}
		return null;
	}
	
	public PowerSocketAutoUsb getPowerSocketAutoUsb() {
		BaseConfig baseJson = getConfig(PowerSocketAutoUsb.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketAutoUsb)baseJson;
		}
		return null;
	}
	
	public PowerSocketAutoLight getPowerSocketAutoLight() {
		BaseConfig baseJson = getConfig(PowerSocketAutoLight.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketAutoLight)baseJson;
		}
		return null;
	}
	
	public PowerSocketDelaySwitch getPowerSocketDelaySwitch() {
		BaseConfig baseJson = getConfig(PowerSocketDelaySwitch.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketDelaySwitch)baseJson;
		}
		return null;
	}
	
	public PowerSocketDelayUsbPower getPowerSocketDelayUsbPower() {
		BaseConfig baseJson = getConfig(PowerSocketDelayUsbPower.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketDelayUsbPower)baseJson;
		}
		return null;
	}
	
	public PowerSocketDelayLight getPowerSocketDelayLight() {
		BaseConfig baseJson = getConfig(PowerSocketDelayLight.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketDelayLight)baseJson;
		}
		return null;
	}
	
	public PowerSocketArm getPowerSocketArm() {
		BaseConfig baseJson = getConfig(PowerSocketArm.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketArm)baseJson;
		}
		return null;
	}
	
	public PowerSocketBanLed getPowerSocketBanLed() {
		BaseConfig baseJson = getConfig(PowerSocketBanLed.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketBanLed)baseJson;
		}
		return null;
	}
	
	public PowerSocketImage getPowerSocketImage() {
		BaseConfig baseJson = getConfig(PowerSocketImage.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketImage)baseJson;
		}
		return null;
	}
	
	public PowerSocketSensitive getPowerSocketSensitive() {
		BaseConfig baseJson = getConfig(PowerSocketSensitive.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketSensitive)baseJson;
		}
		return null;
	}
	
	public PowerSocketWorkRecord getPowerSocketWorkRecord() {
		BaseConfig baseJson = getConfig(PowerSocketWorkRecord.CONFIG_NAME);
		if ( null != baseJson ) {
			return (PowerSocketWorkRecord)baseJson;
		}
		return null;
	}
	
	/**
	 * 是否带有情景灯
	 * @return
	 */
	public boolean isSupportLight() {
		return mIsSupportLight;
	}
	
	/**
	 * 是否带有摄像头
	 * @return
	 */
	public boolean isSupportCamera() {
		return mIsSupportCamera;
	}
}
