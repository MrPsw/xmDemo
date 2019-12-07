package management.lxgdgj.com.xmcamera.config;

public interface JsonListener {
	String getSendMsg();

	boolean onParse(String json);
}
