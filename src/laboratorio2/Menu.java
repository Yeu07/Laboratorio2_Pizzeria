/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;



/**
 *
 * @author Estudiar
 */
public class Menu {
	
    private Productos[] pizzas= {new PizzaBacon(),new PizzaCarnePollo(),new PizzaChampinion(), new PizzaChorizo(), new PizzaConPalmitos(),new PizzaJamonMorrones(), new PizzaMuzzarella()};
    private Productos[] bebidas;
    private Productos[] postres;
    private Productos[] pastas;
    private Productos[] hamburguesas;
    private Productos[] cafes;
    
    
    public Productos[] getCafes() {
		return cafes;
	}


	public Productos[] getPizzas() {
		return pizzas;
	}
    
    public Productos[] getBebidas() {
		return bebidas;
	}
    
    public Productos[] getPostres() {
		return postres;
	}
    
    public Productos[] getPastas() {
		return pastas;
	}
    
    public Productos[] getHamburguesas() {
		return hamburguesas;
	}

	public void setPizzas(Productos[] pizzas) {
		this.pizzas = pizzas;
	}
	
	public void setBebidas(Productos[] bebidas) {
		this.bebidas = bebidas;
	}

	
	public void setPostres(Productos[] postres) {
		this.postres = postres;
	}

	
	public void setPastas(Productos[] pastas) {
		this.pastas = pastas;
	}

	
	public void setHamburguesas(Productos[] hamburguesas) {
		this.hamburguesas = hamburguesas;
	}

	public void agregarPizza(Productos pizza) {
    	Productos[] nuevalista=new Productos[(this.pizzas.length)+1];
    	for (int i=0;i<this.pizzas.length;i++) {
    		nuevalista[i]=this.pizzas[i];
    	}
    	nuevalista[nuevalista.length]=this.pizzas[this.pizzas.length];
    	this.pizzas=nuevalista;
    }
    
    public Productos buscaPizza(int pos) {
    	return this.pizzas[pos];
    }
    
    public Productos buscaBebida(int pos) {
    	return this.bebidas[pos];
    }
    
    public Productos buscaPostre(int pos) {
    	return this.postres[pos];
    }
    
    public Productos buscaPasta(int pos) {
    	return this.pastas[pos];
    }
    
    public Productos buscaHamburguesa(int pos) {
    	return this.hamburguesas[pos];
    }
    
    public Productos buscaCafe(int pos) {
    	return this.cafes[pos];
    }
 
    
}
