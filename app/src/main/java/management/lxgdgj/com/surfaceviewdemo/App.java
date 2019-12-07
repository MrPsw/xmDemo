package management.lxgdgj.com.surfaceviewdemo;

import android.app.Application;

import management.lxgdgj.com.xmcamera.FunSupport;

/**
 * @author Pengshuwen
 * @date 2019/12/6
 * @describe
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FunSupport.getInstance().init(this);

    }
}
