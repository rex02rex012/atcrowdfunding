package com.atguigu.crowd.util;


/**
 * �Τ@��Ӷ��ؤ�Ajax�ШD��^�����G�]���Ӥ]�i�H�Ω���G���[�c�U�ӼҲն��եήɪ�^�Τ@�����^
 * @author Lenovo
 *
 * @param <T>
 */
public class ResultEntity<T> {
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
	
	// �Ψӫʸ˷�e�ШD�B�z�����G�O���\�٬O����
	private String result;
	
	// �ШD�B�z���Ѯɪ�^�����~����
	private String message;
	
	// �n��^���ƾ�
	private T data;
	
	/**
	 * �ШD�B�z���\�B���ݭn��^�ƾڮɨϥΪ��u���k
	 * @return
	 */
	public static <Type> ResultEntity<Type> successWithoutData() {
		return new ResultEntity<Type>(SUCCESS, null, null);
	}
	
	/**
	 * �ШD�B�z���\�B�ݭn��^�ƾڮɨϥΪ��u���k
	 * @param data �n��^���ƾ�
	 * @return
	 */
	public static <Type> ResultEntity<Type> successWithData(Type data) {
		return new ResultEntity<Type>(SUCCESS, null, data);
	}
	
	/**
	 * �ШD�B�z���ѫ�ϥΪ��u���k
	 * @param message ���Ѫ����~����
	 * @return
	 */
	public static <Type> ResultEntity<Type> failed(String message) {
		return new ResultEntity<Type>(FAILED, message, null);
	}
	
	public ResultEntity() {
		
	}

	public ResultEntity(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}