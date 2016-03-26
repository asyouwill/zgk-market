package cn.thinkjoy.zgk.market.common;

import cn.thinkjoy.gk.common.BaseCommonController;
import cn.thinkjoy.gk.constant.SessionConst;
import cn.thinkjoy.gk.constant.UserRedisConst;
import cn.thinkjoy.gk.util.AreaCookieUtil;
import cn.thinkjoy.gk.util.RedisUtil;
import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;
import cn.thinkjoy.zgk.market.service.IUserAccountExService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class BaseController extends BaseCommonController {

	@Autowired
	private IUserAccountExService userAccountExService;

	protected UserAccountPojo getUserAccountPojo() {
		Long id = Long.valueOf(getCookieValue());
		String key = UserRedisConst.USER_KEY + id;
		UserAccountPojo userAccountBean  = null;
		if(!RedisUtil.getInstance().exists(key)){
			userAccountBean = userAccountExService.findUserAccountPojoById(id);
			if(null!=userAccountBean){
				RedisUtil.getInstance().set(key, JSON.toJSONString(userAccountBean), 5L, TimeUnit.HOURS);
			}
		} else{
			userAccountBean = JSON.parseObject(RedisUtil.getInstance().get(key).toString(),UserAccountPojo.class);
		}
		return userAccountBean;
	}

	protected void setUserAccountPojo(UserAccountPojo userAccountBean) throws Exception {
		if(null!=userAccountBean){
			String key = UserRedisConst.USER_KEY + userAccountBean.getId();
			RedisUtil.getInstance().set(key, JSON.toJSONString(userAccountBean));
		}
	}

	protected Long getAreaCookieValue() throws Exception {
		Object areaId = session.getAttribute(SessionConst.AREA_SESSION_NAME);
		if(null==areaId){
			areaId = AreaCookieUtil.getAreaCookieValue(request);
			session.setAttribute(SessionConst.AREA_SESSION_NAME,areaId);
		}
		return Long.valueOf(areaId.toString());
	}

}