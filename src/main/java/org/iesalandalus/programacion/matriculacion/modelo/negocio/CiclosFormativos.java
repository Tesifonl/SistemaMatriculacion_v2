package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;

public class CiclosFormativos {
	
	private ArrayList <CicloFormativo> coleccionCiclosFormativos;

	
	public CiclosFormativos () {
		
		coleccionCiclosFormativos=new ArrayList<CicloFormativo> ();

	}
	
	public ArrayList<CicloFormativo> get() {
		ArrayList<CicloFormativo> copia=copiaProfundaCiclosFormativos();
		return copia;
	}
	
	private ArrayList<CicloFormativo> copiaProfundaCiclosFormativos() {
		
		ArrayList<CicloFormativo>copiaCicloFormativo=new ArrayList<CicloFormativo>();
		
		for(CicloFormativo cicloFormativo: coleccionCiclosFormativos) {
			copiaCicloFormativo.add(cicloFormativo);
			}
	
		return copiaCicloFormativo;
	}


	
	public int getTamano() {
	    return coleccionCiclosFormativos.size();
	}

	

	
	public void insertar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {

		
		if (cicloFormativo!=null) {
			
				if(coleccionCiclosFormativos.contains(cicloFormativo)) {
					throw new OperationNotSupportedException("ERROR: Ya existe un ciclo formativo con ese codigo.");
				}else {
					coleccionCiclosFormativos.add(cicloFormativo);
					System.out.println("Ciclo formativo introducido en la lista");
				}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar un ciclo formativo nulo.");
		}
	}
	
	
	
	

	public CicloFormativo buscar(CicloFormativo cicloFormativo) {
	    if (cicloFormativo == null) {
	        throw new NullPointerException("ciclo formativo recibido nulo");
	    }

	    if (coleccionCiclosFormativos.isEmpty()) {
	        throw new NullPointerException("No hay ciclos formativos incluidos en la coleccion");
	    }

	    Iterator<CicloFormativo> iterador = coleccionCiclosFormativos.iterator();

	    while (iterador.hasNext()) {
	        CicloFormativo cicloFormativoArray = iterador.next();
	        if (cicloFormativoArray.equals(cicloFormativo)) {
	            return cicloFormativoArray;
	        }
	    }

	    return null; 
	}
	

	

	public void borrar(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
		if(cicloFormativo!=null) {
			if (coleccionCiclosFormativos.contains(cicloFormativo)) {
				coleccionCiclosFormativos.remove(cicloFormativo);
			}
			else{
				throw new OperationNotSupportedException("ERROR: No existe ningún ciclo formativo como el indicado.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede borrar un ciclo formativo nulo.");
		}
	}
	

}
