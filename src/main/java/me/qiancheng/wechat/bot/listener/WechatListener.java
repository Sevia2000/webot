package me.qiancheng.wechat.bot.listener;

import com.blade.kit.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import me.qiancheng.wechat.bot.model.WechatMeta;
import me.qiancheng.wechat.bot.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class WechatListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(WechatListener.class);
	
	int playWeChat = 0;

	public void start(final WechatService wechatService, final WechatMeta wechatMeta){

		new Thread(new Runnable() {
			@Override
			public void run() {
				LOGGER.info("进入消息监听模式 ...");
				wechatService.choiceSyncLine(wechatMeta);
				while(true){
					int[] arr = wechatService.syncCheck(wechatMeta);
					LOGGER.info("retcode={}, selector={}", arr[0], arr[1]);
					
					if(arr[0] == 1100){
						LOGGER.info("你在手机上登出了微信，再见！");
						break;
					}
					if(arr[0] == 0){
						if(arr[1] == 2){
							JSONObject data = wechatService.webwxsync(wechatMeta);
							wechatService.handleMsg(wechatMeta, data);
						} else if(arr[1] == 6){
							JSONObject data = wechatService.webwxsync(wechatMeta);
							wechatService.handleMsg(wechatMeta, data);
						} else if(arr[1] == 7){
							playWeChat += 1;
							LOGGER.info("你在手机上玩微信被我发现了 {} 次", playWeChat);
							wechatService.webwxsync(wechatMeta);
						} else if(arr[1] == 3){
							continue;
						} else if(arr[1] == 0){
							continue;
						}
					} else {
						// 
					}
					try {
						LOGGER.info("等待500ms...");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						log.error("微信监听消息异常",e);
					}
				}
			}
		}, "wechat-listener-thread").start();
	}
	
}
