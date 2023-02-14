
public class Principal {
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer(4) ;
		Productor p = new Productor (20, buffer) ;
		Consumidor c = new Consumidor (20, buffer) ;
		p.start () ;
		c.start () ;
		}

}
