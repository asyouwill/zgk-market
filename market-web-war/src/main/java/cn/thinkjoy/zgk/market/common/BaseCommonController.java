package cn.thinkjoy.zgk.market.common;


import cn.thinkjoy.zgk.market.constant.UserRedisConst;
import cn.thinkjoy.zgk.market.domain.Province;
import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;
import cn.thinkjoy.zgk.market.service.IProvinceService;
import cn.thinkjoy.zgk.market.util.RedisUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseCommonController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	@Autowired
	private IProvinceService provinceService;
	private Map<String, Long> areaMap = new HashMap<>();

	private Map<String, Long> getAreaMap()
	{
		if(areaMap.isEmpty())
		{
			initAreaInfo();
		}
		return areaMap;
	}


	private void initAreaInfo()
	{
		List<Province> list =  provinceService.findAll();
		for (Province province:list) {
			areaMap.put(province.getCode(), Long.parseLong(String.valueOf(province.getId())));
		}
	}

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
							 HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}


	/**
	 * 获取用户ID
	 * @return
     */
	public String getAccoutId(){
		Long uid=(Long)UserContext.getCurrentUser().getId();
//		Long uid=17L;
		return uid.toString();
	}
	/**
	 * 获取用户信息
	 * @return
	 */
	protected UserAccountPojo getUserAccountPojo() {
		return UserContext.getCurrentUser();
	}

	protected void setUserAccountPojo(UserAccountPojo userAccountBean,String token) throws Exception {
		if(null!=userAccountBean){
			String key = UserRedisConst.USER_KEY + token;
			try{
				RedisUtil.getInstance().set(key, JSON.toJSONString(userAccountBean), 4l, TimeUnit.HOURS);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取省份ID
	 * @return
	 */
	protected Long getAreaId(){
		//默认浙江省
		try{
			return Long.valueOf(String.valueOf(getAreaMap().get(UserAreaContext.getCurrentUserArea())).toString());
		}catch (Exception e){
			return Long.valueOf(String.valueOf(getAreaMap().get("zj")).toString());
		}
	}

}