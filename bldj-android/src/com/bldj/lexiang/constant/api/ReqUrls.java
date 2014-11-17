package com.bldj.lexiang.constant.api;

public interface ReqUrls {

	public static final String PROJECT_NAME = "";
	
	public static final boolean neuSecure = false;
	
	public static final String Connection_Type_Seccurity = "https://";
	
	public static final String Connection_Type_Common = "http://";
	
	public static String ONLINE_CONFIG_FILE_TYPE=".json";
	
	public static String ACCOUNT="account"; //用户账号
	
	public static String PASSWORD="password";
	
	public static String CURPAGE = "curpage";
	
	public static String ID = "id";
	
	public static String WAY_LIFE_ID = "wayLifeId";
	
	public static String ACTIVE_ID = "activeId";
	
	public static String LIMIT = "limit" ;
	
	public static String PKG_NAME = "pkgName"; //游戏包名
	
	public static String USER_ID = "userId" ;
	
	public static String USER_LON = "lon" ;
	
	public static String USER_LAT = "lat" ;
	
	public static String UIDS = "uids";
	
	public static String AD_INDEX ="adIndex";
	
	public static String ALL_PRICE = "allPrice";
	
	public static String ITEM_TYPE = "itemType";
	
	public static String OPER_TYPE = "operType";
	
	public static String KIND_TYPE = "kindType";
	
	public static String ITEM_ID = "itemId";
	
	public static String INFO_STR = "infoStr";
	
	public static String CATEGORY_ID = "industryId";
	
	public static String APP_ID = "appId";

    public static String INDUSTRY_ID = "industryId";
	
	public static String PRODUCT_MODEL = "productModel";
	

	
	public static final String CONFIG_HOST_IP="172.21.0.41:18082"; //dns ip
//	public static final String CONFIG_HOST_IP="http://bldj.com" 
	
//	public static final String DEFAULT_REQ_HOST_IP = "http://bldj.com";
    public static final String DEFAULT_REQ_HOST_IP = "172.16.102.145:8080/wechatshop/login.html"; //默认值异常的请求地址
	
	public static final String LIMIT_DEFAULT_NUM="10";
	
	public static final String SEARCH_KEY="keyWord";
	
	public static final String ORDER_ID = "orderId";
	public static final String ORDER_TYPE = "orderType";
	
	public static final String NICK_NAME = "nickName";
	public static final String NAME = "name";
	public static final String MOBILE = "mobile";
	public static final String ADDRESS = "address";

	
	public static final String OPEN_TYPE = "operType";
	
	public static final String IMG_FILE = "imgFile";
	
	public static final String CUR_VERSION = "curVersion";
	
	public static final String FILE_STATE = "fileState";
	
	public static final String DEVICE_VERSION = "deviceVersion";
	
	public static final String CLIENT_IP = "clientIp";
	
	public static final String DEVICE = "device";
	
	public static final String EXCEPTION_MSG="exceptionMsg";
	
	public static final String USER_REQUEST_INFO="userRequestInfo";
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 用户登录
	 */
	public static final String REQUEST_USER_LOGIN = "/user/login";
	/**
	 * 修改密码
	 */
	public static final String UPDATE_PWD = "/user/mpass/";
	
	/**
	 * 修改用户昵称
	 */
	public static final String UPDATE_NICKNAME = "/user/updateNickName";
	/**
	 * 修改用户头像
	 */
	public static final String UPDATE_HEADER_URL="/user/updateHeadPic";
	/**
	 * 信息收集接口(意见、招聘、打分)
	 */
	public static final String UNIFOR = "/user/uinfor";
	/**
	 * 忘记密码
	 */
	public static final String FORGET_PWD = "/user/rpass";
	/**
	 * 用户注册
	 */
	public static final String REGISTER_USER = "/user/reg";
	/**
	 * 用户地址(0:添加 1删除 2修改 3查询)
	 */
	public static final String ADDRESS_MANAGER = "/user/addressManage";
	/**
	 * 短信验证
	 */
	public static final String CHECK_CODE = "/user/checkCode";
	/**
	 * 获取精品及热门推荐接口
	 */
	public static final String REQUEST_HOT_PRODUCT = "/pro/getProducts";
	
	/**
	 * 预约时间和选择美容师接口
	 */
	public static final String REQUEST_SCHEDULED = "/seller/getScheduled";
	/**
	 * 添加、查询和校验优惠券
	 */
	public static final String COUPONS_MANAGE = "/user/couponsManage";
	
	/**
	 * 生成订单
	 */
	public static final String CREATE_ORDER = "/user/orderGenerate";
	
	/**
	 * 获取用户订单
	 */
	public static final String REQUEST_ORDERS = "/user/getOrders";
	
	/**
	 * 获取美容师列表
	 */
	public static final String REQUEST_SELLERS = "/seller/getSellers";
	
	/**
	 * 获取美容师好中差评个数
	 */
	public static final String REQUEST_SELLER_EVALS = "/seller/getEvals";
	
	/**
	 * 版本升级
	 */
	public static final String CHECK_VERSION = "user/checkVersion";
	
	/**获取首页 广告**/
	public static final String REQUEST_GET_MAINPAGE_AD = "/ad/getAds";
	
	
	
	/**用户个人中心**/
    public static final String REQUEST_USER_INFO = "/user/getUserInfo";
    /**修改用户个人中心**/
    public static final String UPDATE_USER_INFO = "/user/updateUserInfo";


    /**收藏App**/
    public static final String REQUEST_COLLECT_APP = "/enterStroe/saveEnterStroe";
    /**取消收藏App**/
    public static final String QUIT_COLLECT_APP = "/enterStroe/delEnterStroe";
	/**获取收藏列表**/
	public static final String REQUEST_GET_COLLECT = "/enterStroe/getEnterStroeList";
	

	
	
	
	/**获取应用商店页 广告**/
	public static final String REQUEST_GET_APPSTORE_AD = "/ad/getAdList";
	/**获取应用商店应用列表**/
	public static final String REQUEST_GET_APP_LIST = "/app/getOperAppList";

    /**获取最受欢迎应用列表**/
    public static final String REQUEST_GET_HOTTESTAPP_LIST = "/app/getHottestAppList";
    /**获取热门推荐应用列表**/
    public static final String REQUEST_GET_RECOMMEND_LIST = "/app/getClickMostAppList";
    /**获取最新发布应用列表**/
    public static final String REQUEST_GET_NEWEST_LIST = "/app/getNewestAppList";

    /**提交订单**/
    public static final String SUBMIT_ORDER = "/order/uploadOrder";

    /**获取订单列表**/
    public static final String GET_ORDER_LIST = "/order/getOrderList";

    /**获取行业分类列表**/
    public static final String REQUEST_GET_INDUSTRY_LIST = "/industry/getIndustryList";
	
	/**获取分类列表**/
	public static final String REQUEST_GET_KIND = "/app/getRecomend";
	
	/**获取更新列表**/
	public static final String GET_UPDATABLE_LIST = "/app/appLeaveUp";
	/**分类获取列表**/
	public static final String REQUEST_GET_APPS_CATEGORY = "/app/getAppIndustryList";
	/**通过app info**/
	public static final String REQUEST_GET_APPBYID = "/app/getAppInfo";

    /**获取app套餐 info**/
    public static final String REQUEST_GET_APP_PACKAGE= "/package/getAppPackageList";
	

	/**获取热词列表**/
	public static final String REQUEST_GET_HOTWORDS = "/word/getAppHotWord";
	/**搜索结果**/
	public static final String REQUEST_GET_SEARCH_RESULT = "/app/appFind";
	/**汇报未收录的游戏**/
	public static final String REQUEST_GET_REPO_UNRECORDGAME = "/homePage/insertAppWithUserRequest";
    /**获取已购买应用**/
    public static final String REQUEST_GET_PURCHASED_APP= "/enterprise/getPayAppList";

    public static final String DOWNLOAD_REPO_INFO = "/app/downLoadApp";
    public static final String REQUEST_EXCEPTION_REPO = "";
}
