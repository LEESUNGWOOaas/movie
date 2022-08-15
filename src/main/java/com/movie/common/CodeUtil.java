package com.movie.common;

public class CodeUtil {

	public static String getSupportAreaCode(String str) {
		String code = "";
		switch(str) {
		case "재정": code = "SUPPORT_AREA_1"; break;
		case "금융": code = "SUPPORT_AREA_2"; break;
		case "서비스": code = "SUPPORT_AREA_3"; break;
		case "혜택부여": code = "SUPPORT_AREA_4"; break;
		}
		return code;
	}
	
	public static String getSupportMethodCode(String str) {
		String code = "";
		switch(str) {
		case "고용안정 선제대응 패키지": code = "SUPPORT_METHOD_1"; break;
		case "핵심재정지원사업": code = "SUPPORT_METHOD_2"; break;
		}
		return code;
	}
	
	public static String getSupportTypeCode(String str) {
		String code = "";
		switch(str) {
		case "기업": code = "SUPPORT_TYPE_1"; break;
		case "구직자": code = "SUPPORT_TYPE_2"; break;
		case "재직자": code = "SUPPORT_TYPE_3"; break;
		}
		return code;
	}
	
	public static String getMajorCode(String str) {
		String code = "";
		switch(str) {
		case "고용유지지원": code = "MAJOR_1"; break;
		case "채용지원": code = "MAJOR_2"; break;
		case "고용환경개선지원": code = "MAJOR_3"; break;
		case "직업훈련 및 지원": code = "MAJOR_4"; break;
		case "경영 또는 창업지원": code = "MAJOR_5"; break;
		case "기타 제도 안내": code = "MAJOR_6"; break;
		}
		return code;
	}
	
	public static String getTargetCode(String str) {
		String code = "";
		switch(str) {
		case "공통": code = "TARGET_1"; break;
		case "청년맞춤형": code = "TARGET_2"; break;
		case "여성맞춤형": code = "TARGET_3"; break;
		case "장애인 맞춤형": code = "TARGET_4"; break;
		case "중장년, 고령자 맞춤형": code = "TARGET_5"; break;
		}
		return code;
	}
	
	public static String getEmployeesCode(String str) {
		String code = "";
		switch(str) {
		case "0~4인 기업": code = "EMPLOYEES_1"; break;
		case "5~9인 기업": code = "EMPLOYEES_2"; break;
		case "10인 이상 기업": code = "EMPLOYEES_3"; break;
		}
		return code;
	}
	
	public static String getJobCode(String str) {
		String code = "";
		switch(str) {
		case "일반업종": code = "JOB_1"; break;
		case "특별고용지원업종": code = "JOB_2"; break;
		}
		return code;
	}
	
	
}
