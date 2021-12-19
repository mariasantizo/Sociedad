/**
 * Son los diferentes productos que encontraremos en nuestra sociedad
 * @author malensanz
 * @version 1
 * @since 1
 */

package datos;

import java.util.ArrayList;

public class Producto implements Comparable <Producto>, Buscable <Producto>{
	private String nombre; 
	private int codigo; 
	private TipoProducto tipo;
	private double precio;
	private int tipoAux;
	
	public Producto(String nombre, int codigo, TipoProducto tipo, double precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
		this.precio=precio;
	}

	public Producto(String nombre, int codigo, int tipo, double precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipoAux = tipo;
		this.precio=precio;
		
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public TipoProducto getTipo() {
		return tipo;
	}


	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void convertirTipo (ArrayList<TipoProducto> tipos) {
		for (TipoProducto t: tipos) {
			if (t.getCodigo()==this.tipoAux) {
				this.tipo=t;
			}
		}
	}
	
	//expresion lambda
	/*public void convertirTipoLambda (ArrayList<TipoProducto> tipos) {
		tipos.stream().filter(e->e.getCodigo()==this.tipoAux).forEach(e-> this.tipo=e);
	}
*/
	/**
	 * Es el método que proviene de la interfaz Comparable, compara dos productos segun sus precios
	 * @author mariasantizo
	 */
	
	@Override
	public int comparar(Producto objeto2) {
		// TODO Auto-generated method stub
		int resultado = 0;
		if (this.precio>objeto2.getPrecio()) {
			resultado=1;
		}
		else if (this.precio==objeto2.getPrecio()) {
			resultado=0;
		} else {
			resultado=-1;
		}
		return resultado;
	}

	/**
	 * Es el método que proviene de la interfaz Buscable, escoge un producto con un precio exacto
	 * @author malensanz
	 */
	
	@Override
	public Object buscar(ArrayList<Producto> array, Producto objeto) {	
		int start=0;
		int end=array.size()-1;
		while (start<=end){
			int mid=(start+end)/2;
			if (array.get(mid).getPrecio()==objeto.getPrecio()){
				System.out.println(mid);
				return mid;
			}else if (objeto.getPrecio()<array.get(mid).getPrecio()) {
				end= mid-1;
			}else{
				start=mid+1;
			}
			}
		System.out.println("No hay ningun producto con ese precio en el array");
		return -1;
	}
	
	@Override
	public String obtenerValorComparable() {
		// TODO Auto-generated method stub
		return ""+this.precio;
	}
	
	@Override
	public String toString() {
		return nombre+" - "+precio+"€";
		
	}

	@Override
	public void establecerValorComparable(String valor) {
		// TODO Auto-generated method stub
		this.precio=Double.parseDouble(valor);
	}


}
