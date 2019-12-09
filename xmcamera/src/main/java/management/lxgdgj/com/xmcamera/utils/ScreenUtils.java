package management.lxgdgj.com.xmcamera.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * @author Pengshuwen
 * @date 2019-12-09
 * @describe
 */
public class ScreenUtils {

    public static void enterFullScreen(Activity activity) {
        int flags = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE // 保持View Layout不变，隐藏状态栏或者导航栏后，View不会拉伸。
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // 让View全屏显示，Layout会被拉伸到StatusBar下面，不包含NavigationBar。
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION // 让View全屏显示，Layout会被拉伸到StatusBar和NavigationBar下面。
                    | View.SYSTEM_UI_FLAG_FULLSCREEN // Activity全屏显示，且状态栏被隐藏覆盖掉。等同于（WindowManager.LayoutParams.FLAG_FULLSCREEN）。
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION; // 隐藏虚拟按键(导航栏)。有些手机会用虚拟按键来代替物理按键。
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // 这个flag只有当设置了SYSTEM_UI_FLAG_HIDE_NAVIGATION才起作用。如果没有设置这个flag，
                // 任意的View相互动作都退出SYSTEM_UI_FLAG_HIDE_NAVIGATION模式。如果设置就不会退出。
                flags |= View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            }
        }

        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(flags);
        }
    }

    public static void exitFullScreen(Activity activity) {
        int flags = View.SYSTEM_UI_FLAG_VISIBLE;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE // 保持View Layout不变，隐藏状态栏或者导航栏后，View不会拉伸。
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // 让View全屏显示，Layout会被拉伸到StatusBar下面，不包含NavigationBar。
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;// 让View全屏显示，Layout会被拉伸到StatusBar和NavigationBar下面
        }

        View decorView = activity.getWindow().getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(flags);
        }
    }
}
