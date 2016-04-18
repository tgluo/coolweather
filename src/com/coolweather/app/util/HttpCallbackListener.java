package com.coolweather.app.util;

public interface HttpCallbackListener {

	/**回调成功的方法
	 * @param response
	 */
	public void onFinish(String response);
	
	/**回调失败的方法
	 * @param e
	 */
	public void onError(Exception e);
}
