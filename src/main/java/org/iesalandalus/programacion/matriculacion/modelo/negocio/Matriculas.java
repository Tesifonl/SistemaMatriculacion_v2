package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;

public class Matriculas  {

	private ArrayList<Matricula>  coleccionMatriculas;

	
	public Matriculas () {

		coleccionMatriculas=new ArrayList<Matricula> ();
		

	}
	
	public ArrayList<Matricula> get() throws OperationNotSupportedException {
		ArrayList<Matricula> copia=copiaProfundaMatriculas();
		return copia;
	}
	
	private ArrayList<Matricula> copiaProfundaMatriculas() throws OperationNotSupportedException {
		
		ArrayList<Matricula>copiaMatricula=new ArrayList<Matricula>();
		
		for(Matricula matricula: coleccionMatriculas) {
			copiaMatricula.add(matricula);
			}
		return copiaMatricula;
	}

	

	
	public int getTamano() {
	    return coleccionMatriculas.size();
	}


	
	public void insertar(Matricula matricula) throws OperationNotSupportedException {
		
		if(matricula!=null) {
			if(coleccionMatriculas.contains(matricula)) {
				throw new OperationNotSupportedException("ERROR: Ya existe una matricula con ese codigo.");
			}else {
				coleccionMatriculas.add(matricula);
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede insertar una matrícula nula.");
		}
	}

	

	

	public Matricula buscar(Matricula matricula) throws OperationNotSupportedException {
	    if (matricula == null) {
	        throw new NullPointerException("matricula recibido nulo");
	    }

	    if (coleccionMatriculas.isEmpty()) {
	        throw new NullPointerException("No hay matriculas incluidas en la coleccion");
	    }

	    Iterator<Matricula> iterador = coleccionMatriculas.iterator();

	    while (iterador.hasNext()) {
	        Matricula matriculaArray = iterador.next();
	        if (matriculaArray.equals(matricula)) {
	            return matriculaArray;
	        }
	    }

	    return null; 
	}

	
	public void borrar(Matricula matricula) throws OperationNotSupportedException {
		if(matricula!=null) {
			if (coleccionMatriculas.contains(matricula)) {
	
				
				for(Matricula matriculaArray:coleccionMatriculas) {
					if (matriculaArray.equals(matricula)) {
						matricula.setFechaAnulacion(LocalDate.now());;
					}
				}
			}
			else{
				throw new OperationNotSupportedException("ERROR: No existe ningún alumno como el indicado.");
			}
		}
		else {
			throw new NullPointerException("ERROR: No se puede borrar una matrícula nula.");
		}
	}
	

	
	public ArrayList<Matricula> get (Alumno alumno) throws OperationNotSupportedException{
		boolean encontrado=false;
		boolean otro=false;
		ArrayList<Matricula> nuevaColeccion=new ArrayList<Matricula>();
		
		
		if (alumno!=null) {	
			for (Matricula matricula:coleccionMatriculas) {
				if (matricula.getAlumno().equals(alumno)) {
					encontrado=true;
					nuevaColeccion.add(matricula);	
						
				}
				else {
					otro=false;
				}
			}	
		
			if (encontrado==true) {
				return nuevaColeccion;
			}
			else {
				return null;
			}
		}	
		else {
			throw new NullPointerException("ERROR: Se ha recibido un alumno nulo");
		}
	}
	
	public ArrayList<Matricula> get (String cursoAcademico){
		boolean encontrado=false;
		boolean otro=false;
		ArrayList<Matricula> nuevaColeccion=new ArrayList<Matricula>();
		
		
		if (cursoAcademico!=null) {
			
			for (Matricula matricula:coleccionMatriculas) {
				if (matricula.getCursoAcademico().equals(cursoAcademico)) {
					encontrado=true;
					nuevaColeccion.add(matricula);	
						
				}
				else {
					otro=false;
				}
			}	
		
			if (encontrado==true) {
				return nuevaColeccion;
			}
			else {
				return null;
			}
		}
		else {
			throw new NullPointerException("ERROR: Se ha recibido un curso academico nulo");
		}
	}
	
	public ArrayList<Matricula> get (CicloFormativo cicloFormativo) throws OperationNotSupportedException{
		boolean encontrado=false;
		boolean otro=false;
		ArrayList<Matricula> nuevaColeccion=new ArrayList<Matricula>();
	
	
		
		if (cicloFormativo!=null) {
			for (Matricula matricula:coleccionMatriculas) {
			
					ArrayList<Asignatura> nuevaColeccionAsignatura=matricula.getColeccionAsignaturas();
					
					for (Asignatura asignatura: nuevaColeccionAsignatura)
						if (asignatura.getCicloFormativo().equals(cicloFormativo))
							{encontrado=true;
							nuevaColeccion.add(matricula);					
							}
						else {
							otro=false;
						}
					
							
				}
				if (encontrado==true) {
					return nuevaColeccion;
				}
				else {
					return null;
				}
			
		}
		else {
			throw new NullPointerException("ERROR: Se ha recibido un ciclo formativo nulo");
		}
	
	}
}
