/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package me.qiancheng.wechat.bot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blade.kit.StringKit;
import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="mailto:i@qiancheng.me">yan.peng</a>
 */
public class StringTest {
    public static void main(String[] args) {
//        String result = "\uFEFF{\"title\":\"\u679c\u7136\u5f88\u4e0d\u4e00\u6837\u554a\uff01\",\"content\":\"\u5728\u9762\u5bf9\u56f0\u96be\u7684\u65f6\u5019\uff0c\u9009\u62e9\u9003\u907f\u662f\u61e6\u592b\u7684\u884c\u4e3a\u3002\r\n\u50cf\u6211\u5c31\u4e0d\u4e00\u6837\u4e86\uff0c\u6211\u5982\u679c\u5f97\u7f6a\u4e86\u8c01\uff0c\r\n\u6211\u5c31\u4f1a\u52c7\u6562\u5730\u8d70\u5230\u4ed6\u9762\u524d\uff0c\u8dea\u4e0b\u6765\u6c42\u4ed6\u539f\u8c05\u3002\"}";
        String result = "{\"number1\":\"\u2467\u3007\",\"number2\":\"\u516b\u3007\",\"haohua\":\"\u4e0a\",\"shiyi\":\"\u60b2\u83ab\u60b2\u516e\u751f\u522b\u79bb\uff0c\u4e50\u83ab\u4e50\u516e\u65b0\u76f8\u77e5\u3002\",\"jieqian\":\"\u60b2\u83ab\u60b2\u516e\u3002\u867d\u662f\u4ee4\u4eba\u60b2\u54c0\u8005\u3002\u4ea6\u4e0d\u5fc5\u60b2\u3002\u751f\u800c\u5fc5\u987b\u522b\u79bb\u4e4b\u82e6\u75db\u4e8b\u3002\u541b\u6c5d\u5df2\u7ecf\u5c1d\u8fc7\u82e6\u5934\u77e3\u3002\u552f\u4e50\u83ab\u4e50\u516e\u3002\u5feb\u4e50\u4e4b\u4e8b\u3002\u4ee4\u4eba\u9f13\u8d77\u52c7\u6c14\u4e4b\u4e8b\u3002\u5df2\u5728\u773c\u524d\u3002\u60b2\u5df2\u53bb\u3002\u4e50\u5728\u773c\u524d\u3002\u4e0d\u5fc5\u518d\u62c5\u5fc3\u8005\u8036\u3002\u987a\u5883\u8005\u5df2\u81f3\u3002\",\"zhushi\":\"\",\"baihua\":\"\",\"type\":\"\u6708\u8001\u7075\u7b7e\"}";
        if(StringUtils.isNotBlank(result)){
            result = StringUtils.remove(result,"\uFEFF");
            result = StringUtils.trim(result);
                JSONObject jsonObject = JSON.parseObject(result);
                String content = jsonObject.getString("content");
                result = StringKit.isNotBlank(content) ? content : result;
                System.out.println(result);

        }

    }
}
