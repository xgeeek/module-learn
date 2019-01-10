package module.learn.common.bean;


import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import module.learn.common.base.BaseActivity;
import module.learn.common.base.bean.BaseBean;

/**
 * Describe：可跳转的模板
 * Created by 吴天强 on 2018/11/13.
 */
@Getter
@Setter
public class Template extends BaseBean {

    private String title;
    private int res;
    private String describe;
    private Class clazz;
    private String url;//模块外跳转链接
    private int type;//0.本模块内Activity跳转 1.业务模块跳转 2.应用外跳转[WebView]
    private Map<String, ?> params;//其他附加参数

    public Template(String title, int res, String url, int type, String describe) {
        this.title = title;
        this.res = res;
        this.url = url;
        this.type = type;
        this.describe = describe;
    }

    public Template(String title, int res, Class<? extends BaseActivity> clazz) {
        this(title, res, clazz, "");
    }

    public Template(String title, int res, Class<? extends BaseActivity> clazz, String describe) {
        this.title = title;
        this.res = res;
        this.clazz = clazz;
        this.describe = describe;
    }

}
