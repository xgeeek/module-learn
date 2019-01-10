package module.learn.wanandroid.bean;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import module.learn.common.base.bean.BaseBean;

/**
 * Describe： 分类
 * Created by 吴天强 on 2018/11/15.
 */
@Getter
@Setter
public class Classification extends BaseBean {

    /**
     * children : [{"courseId":13,"id":60,"name":"Android Studio相关","order":1000,"parentChapterId":150,"visible":1}]
     * courseId : 13
     * id : 150
     * name : 开发环境
     * order : 1
     * parentChapterId : 0
     * visible : 1
     */

    private int courseId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private int visible;
    private List<ClassificationChild> children;

}
