package cn.tedu.netctoss.service;
/**
 * 应用异常类
 *
 */
public class ApplicationException 
	extends RuntimeException {

	public ApplicationException() {
		
	}

	public ApplicationException(
			String message) {
		super(message);
	}

}


