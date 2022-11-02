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
    private Productos[] bebidas= {new Gaseosa(),new Vino(),new Jugo(),new Batido(),new Cerveza()};
    private Productos[] postres= {new Helado(),new BatidoDeHelado(),new Torta()};
    private Productos[] pastas= {new Ravioles(),new Nioquis(),new Sorrentinos(),new Spaghetti()};
    private Productos[] hamburguesas= {new Hamburguesa()};
    private Productos[] cafes= {new Cafe(),new CafeConLeche(),new CafeCortado(),new Submarino()};
    
    
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
    	nuevalista[nuevalista.length]=pizza;
    	this.pizzas=nuevalista;
    }
    
    public void agregarCafe(Productos cafe) {
    	Productos[] nuevalista2=new Productos[(this.cafes.length)+1];
    	for (int i=0;i<this.cafes.length;i++) {
    		nuevalista2[i]=this.cafes[i];
    	}
    	nuevalista2[nuevalista2.length]=cafe;
    	this.cafes=nuevalista2;
    }
    
    public void agregarPasta(Productos pasta) {
    	Productos[] nuevalista3=new Productos[(this.pastas.length)+1];
    	for (int i=0;i<this.pastas.length;i++) {
    		nuevalista3[i]=this.pastas[i];
    	}
    	nuevalista3[nuevalista3.length]=pasta;
    	this.pastas=nuevalista3;
    }
    
    public void agregarPostre(Productos postre) {
    	Productos[] nuevalista4=new Productos[(this.postres.length)+1];
    	for (int i=0;i<this.postres.length;i++) {
    		nuevalista4[i]=this.postres[i];
    	}
    	nuevalista4[nuevalista4.length]=postre;
    	this.postres=nuevalista4;
    }
    
    public void agregarHamburguesa(Productos hamburguesa) {
    	Productos[] nuevalista5=new Productos[(this.hamburguesas.length)+1];
    	for (int i=0;i<this.hamburguesas.length;i++) {
    		nuevalista5[i]=this.hamburguesas[i];
    	}
    	nuevalista5[nuevalista5.length]=hamburguesa;
    	this.hamburguesas=nuevalista5;
    }
    
    public void agregarBebida(Productos bebida) {
    	Productos[] nuevalista6=new Productos[(this.bebidas.length)+1];
    	for (int i=0;i<this.bebidas.length;i++) {
    		nuevalista6[i]=this.bebidas[i];
    	}
    	nuevalista6[nuevalista6.length]=bebida;
    	this.bebidas=nuevalista6;
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
