package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;

public class Asignaturas {

	private ArrayList<Asignatura> coleccionAsignaturas;

	
	
	public Asignaturas () {
	
		coleccionAsignaturas=new ArrayList<Asignatura>();

	}
	
	public ArrayList<Asignatura> get() {
		ArrayList<Asignatura> copia=copiaProfundaAsignaturas();
		return copia;
	}
	
	private ArrayList<Asignatura> copiaProfundaAsignaturas() {
		
		ArrayList<Asignatura>copiaAsignatura=new ArrayList<Asignatura>();
		
		for(Asignatura asignatura: coleccionAsignaturas){
			copiaAsignatura.add(asignatura);
			}

		return copiaAsignatura;
	}

	/*public int getTamano() {
		int tamano=0;
		
		for (int i=0;i<coleccionAsignaturas.size();i++) {
			if(coleccionAsignaturas.get(i)!=null) {tamano++;}
		}
		
		return tamano;
	}*/

	public int getTamano() {
	    return coleccionAsignaturas.size();
	}
	
	
	public void insertar(Asignatura asignatura) throws OperationNotSupportedException {
		
		if(asignatura!=null) {
			if(coleccionAsignaturas.contains(asignatura)) {
				throw new OperationNotSupportedException("ERROR: Ya existe una asignatura con ese codigo.");
			}else {
				coleccionAsignaturas.add(asignatura);
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar una asignatura nula.");
		}
	}

	


	public Asignatura buscar(Asignatura asignatura) {
	    if (asignatura == null) {
	        throw new NullPointerException("asignatura recibido nulo");
	    }

	    if (coleccionAsignaturas.isEmpty()) {
	        throw new NullPointerException("No hay asignaturas incluidas en la coleccion");
	    }

	    Iterator<Asignatura> iterador = coleccionAsignaturas.iterator();

	    while (iterador.hasNext()) {
	        Asignatura asignaturaArray = iterador.next();
	        if (asignaturaArray.equals(asignatura)) {
	            return asignaturaArray;
	        }
	    }

	    return null; 
	}

	
	public void borrar(Asignatura asignatura) throws OperationNotSupportedException {
		if(asignatura!=null) {
			if (coleccionAsignaturas.contains(asignatura)) {
				coleccionAsignaturas.remove(asignatura);
			}
			else{
				throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede borrar una asignatura nula.");
		}
	}
	

	
}
