
public class Producto {
	
	public Producto(int id, String mensaje) {
		super();
		this.id = id;
		this.mensaje = mensaje;
	}

	private int id;
	
	private int tipo;
	
	private String mensaje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
