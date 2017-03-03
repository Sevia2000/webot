package me.qiancheng.wechat.bot.robot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blade.kit.StringKit;
import com.blade.kit.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import me.qiancheng.wechat.bot.Constant;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class MoLiRobot implements Robot {

	private String apiUrl;

	public MoLiRobot() {
		String api_key = Constant.config.get("itpk.api_key");
		String api_secret = Constant.config.get("itpk.api_secret");
		if(StringKit.isNotBlank(api_key) && StringKit.isNotBlank(api_secret)){
			this.apiUrl = Constant.ITPK_API + "?api_key=" + api_key + "&api_secret=" + api_secret;
		}
	}

	@Override
	public String talk(String msg) {
		if(null == this.apiUrl){
			return "机器人未配置";
		}
		String url = apiUrl + "&question=" + msg;
		String result = "我走神了～ 你可以再讲一遍嘛～";
		try {
			result = HttpRequest.get(url).connectTimeout(3000).body();
			if(StringUtils.isNotBlank(result)){
				result = StringUtils.trim(result);
				try{
					JSONObject jsonObject = JSON.parseObject(result);
					String content = jsonObject.getString("content");
					result = StringKit.isNotBlank(content) ? content : result;
				}catch (Exception e1){}
			}
		}catch (Exception e){
//			log.error("服务器出了小差～",e);
//			 TODO retry
		}
		return result;
	}

}
