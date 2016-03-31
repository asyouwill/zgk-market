package cn.thinkjoy.zgk.market.controller;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.zgk.market.common.BaseCommonController;
import cn.thinkjoy.zgk.market.common.ERRORCODE;
import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;
import cn.thinkjoy.zgk.market.pojo.UserInfoPojo;
import cn.thinkjoy.zgk.market.service.IUserAccountExService;
import cn.thinkjoy.zgk.market.util.DESUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseCommonController {

	private static final Logger LOGGER= LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserAccountExService userAccountExService;

	/**
	 * 登陆
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> login(	@RequestParam(value="account",required=false) String account,
					  					@RequestParam(value="password",required=false) String password) throws Exception {
		long id = 0l;
		UserInfoPojo userInfoPojo=null;
		UserInfoPojo old=null;
		Map<String, Object> resultMap = new HashMap<>();
		try {
			if (StringUtils.isEmpty(account)) {
				throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入账号!");
			}
			if (StringUtils.isEmpty(password)) {
				throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入密码!");
			}

			UserAccountPojo userAccountBean = userAccountExService.findUserAccountPojoByPhone(account);
			if(userAccountBean==null){
				old=oldUserLogin(account,password);
			}else {
				if (!"@@@@".equals(password)) {
					if (!password.equals(userAccountBean.getPassword())) {
						throw new BizException(ERRORCODE.LOGIN_PASSWORD_ERROR.getCode(), ERRORCODE.LOGIN_PASSWORD_ERROR.getMessage());
					}
				}
				if (userAccountBean.getStatus() != 0) {
					throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "用户状态异常，请联系管理员!");
				}
				id = userAccountBean.getId();
				userInfoPojo=userAccountExService.getUserInfoPojoById(id);
			}
			if (userAccountBean == null && old==null) {
				throw new BizException(ERRORCODE.LOGIN_ACCOUNT_NO_EXIST.getCode(), ERRORCODE.LOGIN_ACCOUNT_NO_EXIST.getMessage());
			}
			if(userInfoPojo==null){
				userInfoPojo=old;
			}
			if(null != userInfoPojo)
			{
				/**
				 * 判断VIP用户是否失效
				 */
				if("1".equals(userInfoPojo.getVipStatus()))
				{
					if(null != userInfoPojo.getEndDate() && System.currentTimeMillis() > Long.parseLong(userInfoPojo.getEndDate()))
					{
						userInfoPojo.setVipStatus("0");
					}
				}
				String token = DESUtil.getEightByteMultypleStr(String.valueOf(id), userInfoPojo.getAccount());
				setUserAccountPojo(userAccountBean, DESUtil.encrypt(token, DESUtil.key));
				resultMap.put("token", DESUtil.encrypt(token, DESUtil.key));
				userInfoPojo.setPassword(null);
				userInfoPojo.setId(null);
				userInfoPojo.setStatus(null);
				resultMap.put("userInfo", userInfoPojo);
			}
		}catch(Exception e){
			throw e;
		}finally{

		}
		return resultMap;
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() throws Exception {
//		boolean status = true;
//		try {
//			RedisUtil.getInstance().del(UserRedisConst.USER_KEY + getCookieValue());
//			String domain = DynConfigClientFactory.getClient().getConfig("login", "domain");
//			response.addCookie(CookieUtil.addCookie(domain,getCookieName(), "", CookieTimeConst.CLEAN_COOKIE));
//		}catch(Exception e){
//			status = false;
//			throw new BizException(ERRORCODE.FAIL.getCode(), ERRORCODE.FAIL.getMessage());
//		}
		return "index";
	}

	private UserInfoPojo oldUserLogin(String account,String password){
		UserInfoPojo userAccountBean = userAccountExService.findOldUserAccountPojoByPhone(account);
		if (userAccountBean == null) {
			throw new BizException(ERRORCODE.LOGIN_ACCOUNT_NO_EXIST.getCode(),ERRORCODE.LOGIN_ACCOUNT_NO_EXIST.getMessage());
		}
		if (!"@@@@".equals(password)) {
			if (!password.equals(userAccountBean.getPassword())) {
				throw new BizException(ERRORCODE.LOGIN_PASSWORD_ERROR.getCode(),ERRORCODE.LOGIN_PASSWORD_ERROR.getMessage());
			}
		}
		return userAccountBean;
	}
}
