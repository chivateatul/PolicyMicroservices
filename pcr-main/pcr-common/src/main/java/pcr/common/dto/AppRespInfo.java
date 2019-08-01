package pcr.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppRespInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> response = new HashMap<String, Object>();

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public void addData(String key, Object val) {
		this.response.put(key, val);
	}
}
