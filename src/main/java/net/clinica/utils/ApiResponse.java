package net.clinica.utils;

import java.time.LocalDateTime;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
*/

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ApiResponse<T> {

	private boolean success;
	//private LocalDateTime fecha;
	private String mensaje;
	private T data;
	
	public ApiResponse(boolean success, String mensaje, T data) {
		super();
		this.success = success;
		this.mensaje = mensaje;
		this.data = data;
	}
	public ApiResponse() {
		
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

	

}
