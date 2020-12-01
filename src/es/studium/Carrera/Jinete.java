package es.studium.Carrera;

import java.util.Random;

public class Jinete extends Thread
{
	static CarreraJinetes carrera = new CarreraJinetes();

	private int nombre;
//	private int i = 0;
	//private int trayectoRecorrido = 0;
//	int distanciaCarrera = carrera.getDistanciaCarrera();
	int avance=0;
	int lanzamiento=0;
//	public int quedan = 0;
//	static int tam = carrera.getNumJinetes();
	public static int listaCamellos[] = new int[carrera.getNumJinetes()];


	//int restante = 0;

	public Jinete (int name) {

		this.nombre = name;
	}

	
	
	public void run() {
				
		System.out.println("Comienza el camello "+ nombre);
		avance = carrera.getDistanciaCarrera() - posicionActual(lanzamiento);
//		primeraPosicion();
		while(!CarreraJinetes.finCarrera) {
		
			lanzamiento = lanzarBola();			
			progresoCarrera(lanzamiento); 			
		}
	}

	public synchronized void progresoCarrera(int lanzamiento) {	
		
//		Jinete pos = new Jinete(camell);
		
		carrera.setDistanciaCarrera(avance);
		
		listaCamellos[(nombre - 1)] = nombre;
		if (carrera.getDistanciaCarrera()>=lanzamiento) {
			System.out.println("Camello "+nombre + " avanza "+ lanzamiento 
					+" metros, se encuentra a "+ (avance -=posicionActual(lanzamiento))  
					+ " metros del final " +" Camello "+ nombre + " esta a ");
		} else {
			
				System.out.println();
				System.out.println("%%%%%%%%%%  FIN DE CARRERA  %%%%%%%%%%%");
				System.out.println();
				System.out.println("��� Ha ganado el Camello "+ nombre + " !!!");
				System.out.println();
				System.out.println("%%%%%%%%%%    PODIO FINAL   %%%%%%%%%%%");
				for (int i = 1; i < listaCamellos.length; i++)
				{
					int posicion = listaCamellos[i];
					System.out.println(i+"� puesto para Camello "+ posicion);
				}
				CarreraJinetes.finCarrera=true;
				System.exit(1);
			
		}

	}
	private synchronized int posicionActual(int lanzamiento) {

		int posicion = 0;
		if (carrera.getDistanciaCarrera() >= 0) {
			posicion +=lanzamiento;

		}else {
			System.out.println("Fin");
		}
		return posicion;

	}
//	public int restanDelFinal(int metros, int lanzamiento) {
//
//
//		metros -= lanzamiento;
//		return metros;
//
//	}
	public int avanceCamello(int tirada) {
		
		int variablePosicion = carrera.getPosicionCabeza();
		int avanceJinete = variablePosicion + tirada;
		carrera.setPosicionCabeza(avanceJinete);
		return avanceJinete;
	}
	
	//	public void comprobarPosicion(int posicion)	{
	//		
	//		for (int i = 0; i <tam; i++)
	//		{
	//			
	//			
	//		}
	//	}
	public int ordenarPosiciones(int[] pos) {
		int nombre=0;

		for (int i = 0; i < pos.length; i++)
		{
			if (pos[i]>pos[i+1]) {
				nombre = pos[i];
			}else {
				
				nombre = pos[i];
			}
		}
		return nombre;
	}
//		return nombre;


	//	public int avanceTrayecto(Jinete o)
	//	{
	//		int resultado=0;		
	//
	//		if(distanciaCarrera<=trayectoRecorrido) {
	//			resultado = distanciaCarrera - trayectoRecorrido;
	//		}else {
	//			resultado = 0;
	//		}
	//
	//		return resultado;
	//	}
	
	//Gracias a este m�todo he conseguido aislar la posicion del que va el primero
		public int primeraPosicion() {
			int primero=0;
		
			//Bucle que recorre todo el listado de Jinetes
			for (int i = 0; i < listaCamellos.length; i++)
			{
				//Mediante esta condici�n conseguimos capturar el n�mero del Jinete que ha avanzado m�s.
				if (listaCamellos[i] > primero) {
					//capturamos el n�mero del Jinete m�s avanzado
					primero = listaCamellos[i+1];
				}
			}
			//devolvemos el n�mero del que va en primera posici�n 
			return primero;
			
		}
	public synchronized int lanzarBola () {
		int resultado = 0;
		Random aleatorio = new Random();
		long sleep = 1 + aleatorio.nextInt(100)*(aleatorio.nextInt(10)+1);
		int lanzamiento = 1 + aleatorio.nextInt(100);
		if(lanzamiento <= 30) {
			resultado = 0;
			try
			{
				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (lanzamiento <= 70) {
			resultado = 1;
			try
			{

				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (lanzamiento <= 90) {
			resultado = 2;
			try
			{

				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			resultado = 3;
			try
			{

				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//restante = restante - resultado;
		}

		return resultado;
	}
	//	public int restante ( int lanz) {
	//
	//		distanciaCarrera -= lanz;
	//
	//		return distanciaCarrera;
	//	}
	public int getJinete()
	{
		return nombre;
	}
	public void setJinete(int jinete)
	{
		nombre = jinete;
	}



	public static int fijarCero(int negativo) {
		if (negativo<=0) {
			return 0;
		}
		else {
			return negativo;
		}
	}
	

}
