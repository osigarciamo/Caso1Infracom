import java.util.Random;

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
				enviar(nuevo);
				System.out.println("||ETAPA 1||\nEl producto " + id + " ha sido generado");
				productos--;
			}
		break;
		case 2:
			//PROCESAMOS LOS PRODUCTOS
			while (productos>0) {
				Producto producto = recoger();
				Random random = new Random();
				int lapso = random.nextInt(450)+50;
				System.out.println("Procesando el producto " + producto.getId() 
				+ " en un lapso de " + lapso + " ms");
				producto.setMensaje(producto.getMensaje()+"");
				//Simulamos el tiempo de procesamiento del producto
				try {
					Thread.sleep(lapso);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("||ETAPA 2||\nEl producto " + producto.getId()+ " ha sido procesado\n\n");
				productos--;
			}
		break;
		case 3:
			//PROCESAMOS LOS PRODUCTOS
		break;
		}
		
	}
	
	
	public Producto recoger() {
		if (color.equals("Naranja")) {
			//Si el proceso es de color naranja recoge los mensajes de forma semiactiva
			return buzon.retirarSemiactivo();
		} else if (color.equals("Azul")) {
			//Si el proceso es de color azul recoge los mensajes de forma pasiva
			return buzon.retirarPasivo();
		} else {
			//Si el proceso es de color rojo recoge los mensajes de forma activa
			return buzon.retirarActivo();
		}
	}
	
	public void enviar(Producto producto) {
		if (color.equals("Naranja")) {
			buzon.almacenarSemiactivo(producto);
		} else {
			buzon.almacenarPasivo(producto);
		}
	}

}
