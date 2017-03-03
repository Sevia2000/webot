package me.qiancheng.wechat.bot;

import com.blade.kit.base.Config;
import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="mailto:i@qiancheng.me">yan.peng</a>
 */
@Slf4j
public class Application {
	
	public static void main(String[] args) {
		try {

			Constant.config = Config.load("classpath:config.properties");

			WechatRobot wechatRobot = new WechatRobot();
			wechatRobot.showQrCode();
			while(!Constant.HTTP_OK.equals(wechatRobot.waitForLogin())){
				Thread.sleep(2000);
			}
			wechatRobot.closeQrWindow();
			wechatRobot.start();
		} catch (Exception e) {
			log.error("异常",e);
		}
	}
	
}