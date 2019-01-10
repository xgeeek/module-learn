package module.learn.common.manage;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xugang on 2018/12/4
 */

public class ActivityManage {

    //保存所有创建的Activity
    private Set<Activity> allActivities = new HashSet<>();

    /**
     * 添加Activity到管理器
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            allActivities.add(activity);
        }
    }


    /**
     * 从管理器移除Activity
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            allActivities.remove(activity);
        }
    }

    /**
     * 关闭所有Activity
     */
    public void finishAll() {
        for (Activity activity : allActivities) {
            activity.finish();
        }

    }
}
