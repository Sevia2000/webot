package me.qiancheng.wechat.bot.service;

import com.blade.kit.json.JSONObject;

import me.qiancheng.wechat.bot.exception.WechatException;
import me.qiancheng.wechat.bot.model.WechatContact;
import me.qiancheng.wechat.bot.model.WechatMeta;

public interface WechatService {
	
	/**
	 * 获取UUID
	 * @return
	 */
	String getUUID() throws WechatException;
	
	/**
	 * 微信初始化
	 * @param wechatMeta
	 * @throws WechatException
	 */
	void wxInit(WechatMeta wechatMeta) throws WechatException;
	
	/**
	 * 开启状态通知
	 * @return
	 */
	void openStatusNotify(WechatMeta wechatMeta) throws WechatException;
	
	/**
	 * 获取联系人
	 * @param wechatMeta
	 * @return
	 */
	WechatContact getContact(WechatMeta wechatMeta) throws WechatException;
	
	/**
	 * 选择同步线路
	 * 
	 * @param wechatMeta
	 * @return
	 * @throws WechatException
	 */
	void choiceSyncLine(WechatMeta wechatMeta) throws WechatException;
	
	/**
	 * 消息检查
	 * @param wechatMeta
	 * @return
	 */
	int[] syncCheck(WechatMeta wechatMeta) throws WechatException;
	
	/**
	 * 处理聊天信息
	 * @param wechatRequest
	 * @param data
	 */
	void handleMsg(WechatMeta wechatMeta, JSONObject data) throws WechatException;
	
	/**
	 * 获取最新消息
	 * @param meta
	 * @return
	 */
	JSONObject webwxsync(WechatMeta meta) throws WechatException;
}
