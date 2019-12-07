package management.lxgdgj.com.xmcamera.models;


import management.lxgdgj.com.xmcamera.R;

public enum FunDevType {
	// 0, 监控设备
	EE_DEV_NORMAL_MONITOR(0, 
			R.string.dev_type_monitor,
			0),
	// 1, 智能插座
	EE_DEV_INTELLIGENTSOCKET(1, 
			R.string.dev_type_intelligentsocket,
			0),
	// 2, 情景灯泡
	EE_DEV_SCENELAMP(2, 
			R.string.dev_type_scenelamp,
			0),
	// 3, 智能灯座
	EE_DEV_LAMPHOLDER(3, 
			R.string.dev_type_lampholder,
			0),
	// 4, 汽车伴侣
	EE_DEV_CARMATE(4, 
			R.string.dev_type_carmate,
			0),
	// 5, 大眼睛行车记录仪
	EE_DEV_BIGEYE(5, 
			R.string.dev_type_bigeye,
			0),
	// 6, 小雨点
	EE_DEV_SMALLEYE(6, 
			R.string.dev_type_smalleye,
			0),
	// 7, 雄迈摇头机
	EE_DEV_BOUTIQUEROTOT(7, 
			R.string.dev_type_boutiquerotot,
			0),
	// 8, 运动摄像机
	EE_DEV_SPORTCAMERA(8, 
			R.string.dev_type_sportcamera,
			0),
	// 9, 鱼眼小雨点
	EE_DEV_SMALLRAINDROPS_FISHEYE(9, 
			R.string.dev_type_smallraindrops_fisheye,
			0),
	// 10, 鱼眼灯泡/全景智能灯泡
	EE_DEV_LAMP_FISHEYE(10, 
			R.string.dev_type_lamp_fisheye,
			0),
	// 11, 小黄人
	EE_DEV_MINIONS(11, 
			R.string.dev_type_minions,
			0),
	// 12, WiFi音乐盒
	EE_DEV_MUSICBOX(12, 
			R.string.dev_type_musicbox,
			0),
	// 13, WiFi音响
	EE_DEV_SPEAKER(13, 
			R.string.dev_type_speaker,
			0),

	// 14, 智联中心
    EE_DEV_LINKCENTER(14,
            R.string.dev_type_linkcenter,
			0),

    // 15, 勇士行车记录仪
    EE_DEV_DASH_CAMERA(15,
            R.string.dev_type_dash_camera,
			0),

    // 16, 智能插排
    EE_DEV_POWER_STRIP(16,
            R.string.dev_type_powerstarip,
			0),

    // 17, 鱼眼模组
    EE_DEV_FISH_FUN(17,
            R.string.dev_type_fish_fun,
			0),

    // 20, 飞碟设备
    EE_DEV_UFO(20,
            R.string.dev_type_ufo,
			0),

    // 21, 智能门铃
    EE_DEV_IDR(21,
            R.string.dev_type_idr,
			0),

    // 22, E型枪机
    EE_DEV_BULLET(22,
            R.string.dev_type_bullet,
			0),

    // 23, 架子鼓
    EE_DEV_DRUM(23,
            R.string.dev_type_drum,
			0),

    // 24, 摄像机
    EE_DEV_CAMERA(24,
            R.string.dev_type_camera,
			0),
	
	// 未知设备
	EE_DEV_UNKNOWN(-1, 
			R.string.dev_type_unknown,
			0);

	private int devIndex;
	private int devResId;
	private int drawResId;

	FunDevType(int id, int resid, int iconid) {
		this.devIndex = id;
		this.devResId = resid;
		this.drawResId = iconid;
	}

	/**
	 * 获取设备类型的字符串ID
	 * 
	 * @return 设备类型字符串ID
	 */
	public int getTypeStrId() {
		return this.devResId;
	}

	/**
	 * 获取设备图标的资源ID
	 * @return
	 */
	public int getDrawableResId() {
		return this.drawResId;
	}

	
	/**
	 * 获取设备类型的索引号
	 * 
	 * @return
	 */
	public int getDevIndex() {
		return this.devIndex;
	}
	
	public static FunDevType getType(int index) {
		for (FunDevType devType : FunDevType.values()) {
			if (devType.getDevIndex() == index) {
				return devType;
			}
		}
		return EE_DEV_NORMAL_MONITOR;
	}
}
