import java.util.ArrayList;

public class Buffer {
	
	private ArrayList buff ;
	private int n ;
	public Buffer (int n) {
	this.n = n ;
	buff = new ArrayList () ;
	}
	
	public synchronized void almacenar (Integer i) {
		while (buff.size() == n)
			try {
				wait() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //Conceptual
		buff.add (i) ;
		notify () ;
		}
	
	
	public synchronized Integer retirar () {
		while (buff.size () == 0)
			try {
				wait() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //Conceptual
		Integer i = (Integer) buff.remove (0) ;
		notify () ;
		return i ;
		}

	public synchronized Producto retirarSemiactivo(String color) {
		
		while (buff.size()==0 and buff.peek.producto.color ==color) {
			Thread.yield();
		}
		return buff.pop();
	}

}
