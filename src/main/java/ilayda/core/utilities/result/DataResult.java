package ilayda.core.utilities.result;

public class DataResult<T> extends Result{

	private T data;
	public DataResult(T data,boolean success, String message) {
		
		super(success, message);  //super base sınıfın constructorını çalıştırmaya yarar
		this.data = data;
	}


	public DataResult(T data,boolean success) {
		
		super(success);  //super base sınıfın constructorını çalıştırmaya yarar
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}
