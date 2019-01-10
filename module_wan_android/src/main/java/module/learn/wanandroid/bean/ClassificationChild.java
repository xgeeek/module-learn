package module.learn.wanandroid.bean;


import lombok.Getter;
import lombok.Setter;
import module.learn.common.base.bean.BaseBean;

/**
 * Describe：二级分配
 * Created by 吴天强 on 2018/11/15.
 */
@Getter
@Setter
public class ClassificationChild extends BaseBean {

    /**
     * courseId : 13
     * id : 60
     * name : Android Studio相关
     * order : 1000
     * parentChapterId : 150
     * visible : 1
     */

    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private int visible;

}
