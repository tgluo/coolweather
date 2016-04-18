package com.coolweather.app.util;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.text.TextUtils;

public class Utility {

	/**解析和处理服务器返回的省市数据
	 * @author direct-pc
	 *
	 */
	public synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB,
			String response){
		if(!TextUtils.isEmpty(response)){
			String []allProvinces = response.split(",");
			if(allProvinces!=null &&allProvinces.length>0){
				for(String p:allProvinces){
					String array[] = p.split("\\|");
					Province province =new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
		
	}
	/**
	 * 解析和处理服务器返回的城市信息
	 * @param coolWeatherDB
	 * @param response
	 * @return
	 */
	public synchronized static boolean handleCititiesResponse(CoolWeatherDB coolWeatherDB,
			String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String []allcities = response.split(",");
			if(allcities!=null &&allcities.length>0){
				for(String c:allcities){
					String array[] = c.split("\\|");
					City city =new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
		
	}
	/**解析和处理服务器返回的县级数据
	 * @param coolWeatherDB
	 * @param response
	 * @param cityId
	 * @return
	 */
	public synchronized static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,
			String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			String []allCounties = response.split(",");
			if(allCounties!=null &&allCounties.length>0){
				for(String c:allCounties){
					String array[] = c.split("\\|");
					County county =new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
		
	}
}
