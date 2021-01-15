package GUI;

import java.awt.EventQueue;
import java.util.Random;

public class Codigo {

	
	
	protected final char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	protected final char[] numeros = "0123456789".toCharArray();
	protected Random r;
	String codigo = "";
	
	public Codigo() 
	{
		r = new Random();
	}
	
	private char getletra() 
	{
		return letras[r.nextInt(letras.length)];
	}
	private char getnumero() 
	{
		return numeros[r.nextInt(numeros.length)];
	}

	protected String generarcodigo(int lenght,int size) 
	{
		
		if(size==lenght) 
		{
			return codigo;
		}
		else 
		{
			int iterator = (int) (Math.random()*2);
			System.out.println(iterator);
			if(iterator==0) 
			{
				System.out.println("soy una cifra");
				codigo += getletra();
				generarcodigo(lenght,size-1);
			}
			else if (iterator==1)
			{
				System.out.println("soy un numero");
				codigo += getnumero();
				System.out.println(codigo);
				generarcodigo(lenght,size-1);
			}
			
		}
			return codigo;
		
	}
	public static void main(String[] args) {
		Codigo p = new Codigo();
		
		System.out.println(p.generarcodigo(0, 10));
	}
}
