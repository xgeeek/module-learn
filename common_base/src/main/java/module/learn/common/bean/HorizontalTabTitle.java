package module.learn.common.bean;


import lombok.Getter;
import lombok.Setter;
import module.learn.common.base.bean.BaseBean;

/**
 * Describe：水平选项卡Title
 * Created by 吴天强 on 2018/10/22.
 */
@Getter
@Setter
public class HorizontalTabTitle<T> extends BaseBean {
    private String title;
    private T data;

    public HorizontalTabTitle(String title) {
        this.title = title;
    }

    public HorizontalTabTitle(String title, T data) {
        this.title = title;
        this.data = data;
    }

}
