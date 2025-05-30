package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;

public class Alumnos {
	
	private ArrayList <Alumno> coleccionAlumnos;

	
	public Alumnos () {
		
		coleccionAlumnos=new ArrayList <Alumno>();

	}
	
	public ArrayList<Alumno> get() {
		ArrayList<Alumno> copia=copiaProfundaAlumnos();
		return copia;
	}
	
	
	private ArrayList<Alumno> copiaProfundaAlumnos() {
		
		ArrayList<Alumno>copiaAlumnos=new ArrayList<Alumno>();
		
		for(Alumno alumno:coleccionAlumnos) {
				copiaAlumnos.add(alumno);
			}
		return copiaAlumnos;
	}


	
	public int getTamano() {
	    return coleccionAlumnos.size();
	}

	
	
	public void insertar(Alumno alumno) throws OperationNotSupportedException {
		
		if(alumno!=null) {
			if(coleccionAlumnos.contains(alumno)) {
				throw new OperationNotSupportedException("ERROR: Ya existe un alumno con ese dni.");
			}else {
				coleccionAlumnos.add(alumno);
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar un alumno nulo.");
		}
	}
	
	


	public Alumno buscar(Alumno alumno) {
	    if (alumno == null) {
	        throw new NullPointerException("alumno recibido nulo");
	    }

	    if (coleccionAlumnos.isEmpty()) {
	        throw new NullPointerException("No hay alumnos incluidos en la coleccion");
	    }

	    Iterator<Alumno> iterador = coleccionAlumnos.iterator();

	    while (iterador.hasNext()) {
	        Alumno alumnoArray = iterador.next();
	        if (alumnoArray.equals(alumno)) {
	            return alumnoArray;
	        }
	    }

	    return null; 
	}


	
	public void borrar(Alumno alumno) throws OperationNotSupportedException {
		if(alumno!=null) {
			if (coleccionAlumnos.contains(alumno)) {
				coleccionAlumnos.remove(alumno);
			}
			else{
				throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede borrar un alumno nulo.");
		}
	}
	

}
