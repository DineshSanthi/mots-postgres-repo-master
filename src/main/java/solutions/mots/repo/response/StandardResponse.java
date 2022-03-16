package solutions.mots.repo.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StandardResponse {
	
	private Object data;
	
	private ErrorResponse error = null;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
}
