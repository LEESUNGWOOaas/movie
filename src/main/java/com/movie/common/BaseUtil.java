package com.movie.common;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class BaseUtil {


	public static Boolean isEmpty(Object obj) {
		if (obj instanceof Integer)
			return obj == null || (int) obj == 0;
		else if (obj instanceof String)
			return obj == null || "".equals(obj.toString().trim());
		else if (obj instanceof List)
			return obj == null || ((List<?>) obj).isEmpty();
		else if (obj instanceof Map)
			return obj == null || ((Map<?, ?>) obj).isEmpty();
		else if (obj instanceof Object[])
			return obj == null || Array.getLength(obj) == 0;
		else
			return obj == null;
	}

	public static Boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}


	// 날짜관련
	public static final int currentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static final int currentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	public static final String addZeroString(int value) {
		String result = String.format("%02d", value);
		return result;
	}

	public static final String currentYM() {
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}

	public static final String currentYMD() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public static final String currentYMDHM() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	}

	public static Date string2date(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		return date;
	}

	public static String timestamp2stringYMD(Timestamp timestamp) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(timestamp);
	}

	public static String timestamp2stringYMDHM(Timestamp timestamp) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(timestamp);
	}

	public static boolean isBigger(String d1, String d2) throws Exception {
		return d1.compareTo(d2) > 0;
	}

	public static boolean isDateBetween(Date d, Date min, Date max) throws Exception {
		return d.compareTo(min) >= 0 && d.compareTo(max) <= 0;
	}

	public static String htmlTags(String str) {
		if (isEmpty(str))
			return "";
		else {
			str = str.replaceAll("<javascript", "&lt;javascript");
			str = str.replaceAll("<script", "&lt;script");
			str = str.replaceAll("<iframe", "&lt;iframe");
			str = str.replaceAll("<vbscript", "&lt;vbscript");
			str = str.replaceAll("<applet", "&lt;applet");
			str = str.replaceAll("<embed", "&lt;embed");
			str = str.replaceAll("<object", "&lt;object");
			str = str.replaceAll("<frame", "&lt;frame");

			str = str.replaceAll("</javascript", "&lt;/javascript");
			str = str.replaceAll("</script", "&lt;/script");
			str = str.replaceAll("</iframe", "&lt;/iframe");
			str = str.replaceAll("</vbscript", "&lt;/vbscript");
			str = str.replaceAll("</applet", "&lt;/applet");
			str = str.replaceAll("</embed", "&lt;/embed");
			str = str.replaceAll("</object", "&lt;/object");
			str = str.replaceAll("</frame", "&lt;/frame");
		}
		return str;
	}

	public static String restorestripTags(String str) {
		if (isEmpty(str))
			return "";
		else {
			str = str.replaceAll("&lt;", "<");
			str = str.replaceAll("&gt;", ">");
			str = str.replaceAll("&quot;", "'");
			str = str.replaceAll("&amp;", "&");
			str = str.replaceAll("&#39;", "\'");
			str = str.replaceAll("\r\n", "<br>");
		}
		return str;
	}

	public String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

	public static String getClientIP(HttpServletRequest request) {
	    String ip = request.getHeader("X-Forwarded-For");

	    if (ip == null) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null) {
	        ip = request.getRemoteAddr();
	    }

	    return ip;
	}

	public static String getRandomPassword(int size) { 
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        uuid = uuid.substring(0, size); //uuid를 앞에서부터 10자리 잘라줌.
        
        return uuid;
	}

	public static String getRandomNumString(int size) { 
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
		}; 
		
		StringBuffer sb = new StringBuffer(); 
		SecureRandom sr = new SecureRandom(); 
		sr.setSeed(new Date().getTime()); 
		int idx = 0; 
		int len = charSet.length; 
		for (int i=0; i<size; i++) { 
			idx = sr.nextInt(len); 
			sb.append(charSet[idx]); 
		} 
		return sb.toString();
	}
	
	public static boolean isAjax(HttpServletRequest request){
		String requestedWithHeader = request.getHeader("X-Requested-With");
	    return "XMLHttpRequest".equals(requestedWithHeader);
	}
	

	public static boolean isImageExtension(String ext){
		String[] imageExtensions = {"jpg","bmp","gif","png","jpeg"}; //  etc
		return Arrays.asList(imageExtensions).contains(ext.toLowerCase());
	}
	
	public static boolean isVideoExtension(String ext){
		String[] imageExtensions = {"mp4","avi","mkv"}; //  etc
		return Arrays.asList(imageExtensions).contains(ext.toLowerCase());
	}
	
	public static boolean checkIdPattern(String str) {
		String regex = "^[a-zA-Z0-9_]{4,12}$";
		return Pattern.matches(regex, str);
    }
    
    public static boolean checkPwPattern(String str) {
    	return BaseUtil.isNotEmpty(str) && str.length()>=4;
    }
    
    public static boolean isMobile(HttpServletRequest request) {
    	String userAgent = request.getHeader("user-agent");
    	boolean mobile1 = userAgent.matches( ".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
    	boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*"); 

    	if (mobile1 || mobile2) return true;
    	else return false;
    }

}
