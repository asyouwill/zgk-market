package cn.thinkjoy.zgk.market.common;

/**
 * Created by xgfan on 14-12-4.
 */
public enum ERRORCODE {

	PARAM_ERROR("0100001", "参数错误"), FAIL("0100002", "失败"), PHONE_FORMAT_ERROR("0100003", "电话号码格式错误"), ACCOUNT_NO_EXIST("0100004", "账户不存在"), TEACHER_NO_EXIST("0100005", "教师不存在"), PARENT_NO_EXIST("0100006", "家长不存在"), CHILD_NO_EXIST("0100007", "孩子不存在"), STUDENT_NO_EXIST("0100008", "学生不存在"), CLASS_NO_EXIST("0100009", "班级不存在"), GROUP_NO_EXIST("0100010", "群组不存在"),
	SCHOOL_NO_EXIST("0100011", "学校不存在"),
	USER_NO_EXIST("0100012", "用户不存在"),

	AUTHENTICATION_FAIL("0100020", "鉴权失败"),

	/**
	 * 登录
	 */

	LOGIN_PHONE_FORMAT_ERROR("0200001", "电话号码格式错误"), LOGIN_ACCOUNT_NO_EXIST("0200002", "账户不存在"), LOGIN_PASSWORD_ERROR("0200003", "密码错误"), LOGIN_ERROR("0200004", "登录失败"),

	/**
	 * 验证码输入错误
	 */

	UPDATE_PASSWORD_ERROR("0300001", "更新密码失败"),

	/**
	 * 验证码
	 */

	CHECK_SMSCODE_ERROR("0400001", "验证码输入错误"), CHECK_SMSCODE_EXPIRE("0400002", "验证码失效"),
	/**
	 * 发送验证码失败
	 */

	SEND_SMSCODE_ERROR("0500001", "发送验证码失败"), SEND_SMSCODE_MORE("0500002", "获取验证码太频烦,请稍后再试"),
	ORDER_VIP_REPEAT("0600001", "重复订购"),
	PARAM_ISNULL("0700001","参数不能为空"),
	NO_RECORD("0800001","无记录"),
	VIP_EXIST("0900001","该用户已经是VIP了，请勿重复申请"),
	VIP_CARD_NOT_INVALID("0900002","该卡无效"),
	RESTFUL_INTERFACE_ISNULL("1000001","第三方数据接口返回数据为空"),
	RESTFUL_INTERFACE_ISERROR("1000002","第三方数据接口异常"),
	CREATE_VERIFY_CODE_ERROR("1000003","生成验证码发生错误!"),
	NO_LOGIN("1000004","请先登录后再进行操作"),
	VERIFY_CODE_ERROR("0100005", "验证码错误!"),
	NOT_IS_VIP_ERROR("0100006", "升级成VIP用户才可使用该功能，快点升级VIP用户去吧！"),


	UPLOAD_ERROR_0("1100001", "非法上传!"),

	UPLOAD_ERROR_405("1100002", "请上传文件!"),

	UPLOAD_ERROR_400("1100003", "文件超过大小限制!"),

	UPLOAD_ERROR_401("1100004", "零字节的文件!"),

	UPLOAD_ERROR_402("1100005", "无效的文件类型!"),

	UPLOAD_ERROR_500("1100006", "服务端发生错误!");










	/** The code. */
	private final String code;

	/** The message. */
	private final String message;

	/**
	 * Instantiates a new error type.
	 * 
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 */
	private ERRORCODE(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}