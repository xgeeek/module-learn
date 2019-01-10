package module.learn.common.constants;

/**
 * @author xugang on 2018/12/4
 */

public class Constants {

    /**
     * 服务器类型
     * SERVER_DEVELOP       开发环境
     * SERVER_TEST          测试环境
     * SERVER_PRODUCTION    生产环境
     */
    public static final int SERVER_TYPE = ServerType.SERVER_DEVELOP;

    /**
     * 服务器类型
     */
    public class ServerType {
        public static final int SERVER_DEVELOP = 0;//开发环境
        public static final int SERVER_TEST = 1;//测试环境
        public static final int SERVER_PRODUCTION = 2;//生产环境
    }

    /**
     * 默认日期格式
     */
    public static final String DATE_FORMAT_SLASH = "yyyy/MM/dd";
    public static final String DATE_FORMAT_LINE = "yyyy-MM-dd";
    public static final String DATE_FORMAT_DEFAULT = DATE_FORMAT_SLASH + " HH:mm:ss";

    public static final String ERROR_MESSAGE = "网络连接失败";
    public static final int SUCCESS_CODE = 0;

}
