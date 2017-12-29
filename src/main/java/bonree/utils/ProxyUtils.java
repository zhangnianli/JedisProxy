package bonree.utils;

import java.util.StringTokenizer;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * @date 2016-6-10 下午01:50:32
 * @Author: <a href=mailto:zhangnl@bonree.com>张念礼</a>
 * @Title: Globals.java
 * @Package bonree.utils
 * Description: 全局公共类
 * Version: 1.0
 ******************************************************************************/
public class ProxyUtils {
	
	/**
	 * 概述：分割字符串
	 * @Title: getSplit
	 * @param str 字段串
	 * @param delim 分割符号
	 * @return
	 * String[]
	 * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
	 */
	public static final String[] getSplit(String str, String delim) {
		if (str == null || delim == null) {
			return null;
		}
		StringTokenizer token = new StringTokenizer(str, delim);
		int num = token.countTokens();
		String[] result = new String[num];
		int i = 0;
		while (token.hasMoreTokens()) {
			result[i++] = token.nextToken();
		}
		return result;
	}
	
	/**
	 * 概述：合并字节数组
	 * @Title: combineByte
	 * @param array 需要合并的数组集合
	 * @return
	 * byte[]
	 * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
	 */
	public static final byte[] combineByte(byte[]... array) {
	    if(array == null){
	        return null;
	    }
		int length = 0;
		//获取数组总长度
		for (int i = 0; i < array.length; i++) {
			length += array[i].length;
		}
		//合并数组
		byte[] combined = new byte[length];
		int destPos = 0;
		for (int i = 0; i < array.length; i++) {
			System.arraycopy(array[i], 0, combined, destPos, array[i].length);
			destPos += array[i].length; //目标数据当前长度
		}
		return combined;
	}		
}
