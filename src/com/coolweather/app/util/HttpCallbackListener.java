package com.coolweather.app.util;

public interface HttpCallbackListener {

	/**�ص��ɹ��ķ���
	 * @param response
	 */
	public void onFinish(String response);
	
	/**�ص�ʧ�ܵķ���
	 * @param e
	 */
	public void onError(Exception e);
}
