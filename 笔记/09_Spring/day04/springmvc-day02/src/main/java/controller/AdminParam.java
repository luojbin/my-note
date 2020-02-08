package controller;
/**
 * 用于封装请求参数值
 *		属性名与请求参数名一致
 *		注：
 *			名称要一样，类型要匹配
 *		（会做类型转换，比如将String转换成int）
 *		提供相应的get/set方法
 */
public class AdminParam {
	private String adminCode;
	private String pwd;
	
	public String getAdminCode() {
		return adminCode;
	}
	
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
