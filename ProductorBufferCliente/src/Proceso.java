
public class Proceso extends Thread{
	
	

	private Buffer buzon;
	
	private String color;
	
	private int etapa;
	
	private int productos;
	
	private static IdGen generador = new IdGen();
	
	public Proceso(Buffer buzon, String color, int etapa,int productos) {
		super();
		this.buzon = buzon;
		this.color = color;
		this.etapa = etapa;
		this.productos = productos;
	}
	
	
	
	
	
	public void run() {
		
		switch (etapa) {
		case 1:;
			//CREAMOS LOS PRODUCTOS
			while (productos>0) {
				int id = generador.asignar();
				String mensaje = id + ". Producto de color " + color; 
				Producto nuevo = new Producto(id,mensaje);
				buzon.almacenar(nuevo);
			}
		break;
		case 2:
			//PROCESAMOS LOS PRODUCTOS
			while (productos>0) {
				
			}
		break;
		case 3:
			//PROCESAMOS LOS PRODUCTOS
		break;
		}
		
	}
	
	
	public String recoger() {
		if (color.equals("Naranja")) {
			return "";
		} else {
			return "";
		}
	}

}
