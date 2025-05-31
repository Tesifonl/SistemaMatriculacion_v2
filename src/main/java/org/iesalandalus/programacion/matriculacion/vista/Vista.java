package org.iesalandalus.programacion.matriculacion.vista;

import java.util.ArrayList;
import java.util.Collections;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Vista {
	
	private Controlador controlador;
	
	public Vista() {}
	
	public void setControlador(Controlador controlador) {
		
		if(controlador!=null) {
			this.controlador=controlador;
		}else {
			throw new IllegalArgumentException("ERROR: No se ha recibido el controlador.");
		}
	}
	
	public void comenzar() {
		
		Opcion opcion=null;
				
		do{
			Consola.mostrarMenu();
			opcion=Consola.elegirOpcion();
			ejecutarOpcion(opcion);
		}while(opcion!=Opcion.SALIR);
		
	}
	
	public void terminar() {
		controlador.terminar();
	}
	
	private void ejecutarOpcion(Opcion opcion) {
    	
		
			if (opcion.equals(Opcion.INSERTAR_ALUMNO)) {
				insertarAlumno();
			}
			if (opcion.equals(Opcion.BORRAR_ALUMNO)) {
				borrarAlumno();
			}
			if (opcion.equals(Opcion.BUSCAR_ALUMNO)) {
				buscarAlumno();
			}
			if (opcion.equals(Opcion.MOSTRAR_ALUMNOS)) {
				mostrarAlumnos();
			}
		
			if (opcion.equals(Opcion.INSERTAR_ASIGNATURA)) {
				insertarAsignatura();
			}
			if (opcion.equals(Opcion.BORRAR_ASIGNATURA)) {
				borrarAsignatura();
			}
			if (opcion.equals(Opcion.BUSCAR_ASIGNATURA)) {
				buscarAsignatura();
			}
			if (opcion.equals(Opcion.MOSTRAR_ASIGNATURAS)) {
				mostrarAsignaturas();
			}
		
			if (opcion.equals(Opcion.INSERTAR_CICLO_FORMATIVO)) {
				insertarCicloFormativo();
			}
			if (opcion.equals(Opcion.BORRAR_CICLO_FORMATIVO)) {
				borrarCicloFormativo();
			}
			if (opcion.equals(Opcion.BUSCAR_CICLO_FORMATIVO)) {
				buscarCicloFormativo();
			}
			if (opcion.equals(Opcion.MOSTRAR_CICLOS_FORMATIVOS)) {
				mostrarCiclosFormativos();
			}
			if (opcion.equals(Opcion.INSERTAR_MATRICULA)) {
				insertarMatricula();
			}
			if (opcion.equals(Opcion.BUSCAR_MATRICULA)) {
				buscarMatricula();
			}
			if (opcion.equals(Opcion.ANULAR_MATRICULA)) {
				anularMatricula();
			}
			if (opcion.equals(Opcion.MOSTRAR_MATRICULAS)) {
				mostrarMatriculas();
			}
			if (opcion.equals(Opcion.MOSTRAR_MATRICULAS_ALUMNO)) {
				mostrarMatriculasPorAlumno();
			}
			if (opcion.equals(Opcion.MOSTRAR_MATRICULAS_CICLO_FORMATIVO)) {
				mostrarMatriculasPorCicloFormativo();
			}
			if (opcion.equals(Opcion.MOSTRAR_MATRICULAS_CURSO_ACADEMICO)) {
				mostrarMatriculasPorCursoAcademico();
			}
			if (opcion.equals(Opcion.SALIR)) {
				terminar();
			}
		
	}


	private void insertarAlumno()  {
		try {
			Alumno alumno=Consola.leerAlumno();
			if(controlador.getAlumnos()==null) {
				controlador.insertarAlumno(alumno);
				System.out.println("Alumno insertado correctamente");
			}else if(!controlador.getAlumnos().contains(alumno)) {
				controlador.insertarAlumno(alumno);
				System.out.println("Alumno insertado correctamente");
			}else {
				System.out.println("ERROR: El alumno ya estaba incluido en la coleccion");
			}
			
			//controlador.insertarAlumno(Consola.leerAlumno());
			//System.out.println("Alumno insertado correctamente");
		}	
		
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());;
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}
	

	private  void buscarAlumno()  {
		try {
			//controlador.buscarAlumno(Consola.getAlumnoPorDni());
			System.out.println(controlador.buscarAlumno(Consola.getAlumnoPorDni()));
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}

	private void borrarAlumno()  {
		try {
			controlador.borrarAlumno(Consola.getAlumnoPorDni());
			System.out.println("Alumno borrado correctamente");
		}				
		
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());;
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void mostrarAlumnos()  {
		try {
			//controlador.getAlumnos();
			ArrayList<Alumno> nuevoArrayList=controlador.getAlumnos();
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
				for(Alumno alumno: nuevoArrayList)
				{
					System.out.println("Alumno: "+alumno);
				}
			}else {
				System.out.println(" No existen alumnos en el sistema");
			}
		

		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void insertarAsignatura() {
		
		try {
			
			Asignatura asignatura=Consola.leerAsignatura();
			
			if(asignatura==null) {
				System.out.println("ERROR: Asignatura creada erroneamente");
			}else if (controlador.getCiclosFormativos()==null ||!controlador.getCiclosFormativos().contains(asignatura.getCicloFormativo())) {
				System.out.println("ERROR: El ciclo formativo de la asignatura no esta incluido en la coleccion, debe incluirlo previamente");
			}else if(controlador.getAsignaturas()==null || Consola.asignaturaYaMatriculada(controlador.getAsignaturas(), asignatura)!=true) {
			controlador.insertarAsignatura(asignatura);
			System.out.println("Asignatura insertada correctamente");
			}else
			{
				System.out.println("ERROR:Asignatura insertada anteriormente");
			}
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}

	private void buscarAsignatura(){
		try{
			//controlador.buscarAsignatura(Consola.getAsignaturaPorCodigo());
			System.out.println(controlador.buscarAsignatura(Consola.getAsignaturaPorCodigo()));
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		}
		
	}

	private void borrarAsignatura() {
		
		try {
			controlador.borrarAsignatura(Consola.getAsignaturaPorCodigo());
			System.out.println("Asignatura borrada correctamente");
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void mostrarAsignaturas()  {
		try{
			
			//Consola.mostrarAsignaturas(controlador.getAsignaturas());
			ArrayList<Asignatura>nuevoArrayList=controlador.getAsignaturas();
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
				for(Asignatura asignatura: nuevoArrayList)
				{
					System.out.println("Asignatura: "+asignatura);
				}
			}else {
				System.out.println(" No existen asignaturas en el sistema");
			}
			
		}				
		catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}


	private void insertarCicloFormativo() {
		
		try{
			
			CicloFormativo cicloFormativo=Consola.leerCicloFormativo();
			if(controlador.getCiclosFormativos()==null) {
				controlador.insertarCicloFormativo(cicloFormativo);
				System.out.println("Ciclo formativo insertado correctamente");
			}else if(!controlador.getCiclosFormativos().contains(cicloFormativo)) {
				controlador.insertarCicloFormativo(cicloFormativo);;
				System.out.println("Ciclo formativo insertado correctamente");
			}else {
				System.out.println("ERROR: El ciclo formativo ya estaba incluido en la coleccion");
			}
			//controlador.insertarCicloFormativo(Consola.leerCicloFormativo());
			//System.out.println("Ciclo formativo insertado correctamente");
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void  buscarCicloFormativo()  {
		
		try{
			//controlador.buscarCicloFormativo(Consola.getCicloFormativoPorCodigo());
			System.out.println(controlador.buscarCicloFormativo(Consola.getCicloFormativoPorCodigo()));
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void  borrarCicloFormativo()  {
		
		try{
			controlador.borrarCicloFormativo(Consola.getCicloFormativoPorCodigo());
			System.out.println("Ciclo formativo borrado correctamente");
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}
	

	private void mostrarCiclosFormativos()  {
		try{
			//controlador.getCiclosFormativos();
			ArrayList<CicloFormativo>nuevoArrayList=controlador.getCiclosFormativos();
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
				for(CicloFormativo cicloFormativo: nuevoArrayList)
				{
					System.out.println("Ciclo formativo: "+cicloFormativo);
				}		
			}else {
				System.out.println(" No existen ciclos formativos en el sistema");
			}
				
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}


	private void  insertarMatricula() {
		try{
			
			Alumno alumno=Consola.getAlumnoPorDni();
			ArrayList<Asignatura>coleccionAsignaturas=Consola.elegirAsignaturasMatricula();
			ArrayList<Asignatura>nuevaColeccionAsignaturas=new ArrayList<Asignatura>();

			boolean noEncontrado1=false;
			boolean noEncontrado2=false;
			
			if(controlador.getAlumnos()==null ||!controlador.getAlumnos().contains(alumno)) {
				System.out.println("ERROR: El alumno no esta incluido en el sistema");
				noEncontrado2=false;
			}else if(controlador.getAsignaturas()==null) {
					System.out.println("ERROR: Las asignaturas no estan incluido en el sistema");
					noEncontrado2=false;
			}else {
					for(Asignatura asignatura: coleccionAsignaturas) 
						if (!controlador.getAsignaturas().contains(asignatura)) {
							System.out.println("ERROR: Las asignaturas no estan incluido en el sistema");
						    noEncontrado1=true;
						}else if(nuevaColeccionAsignaturas!=null && Consola.asignaturaYaMatriculada(nuevaColeccionAsignaturas,asignatura)==true) {
							System.out.println("ERROR: Asignatura repetida en la matricula ");
						    noEncontrado1=true;
						}
						
						else {
							noEncontrado2=true;
							Asignatura asignaturaRecuperada=controlador.buscarAsignatura(asignatura);
							nuevaColeccionAsignaturas.add(asignaturaRecuperada);
						}
			}
			
			
			if (noEncontrado2==true && noEncontrado1==false) {
				
			Alumno nuevoAlumno=controlador.buscarAlumno(alumno);
			
			Matricula matricula=Consola.leerMatricula(nuevoAlumno, nuevaColeccionAsignaturas);
			
			if(controlador.getMatriculas()==null) {
				controlador.insertarMatricula(matricula);
				System.out.println("Matricula insertada correctamente");
			}else if(!controlador.getMatriculas().contains(matricula)) {
				controlador.insertarMatricula(matricula);
				System.out.println("Matricula insertada correctamente");
			}else {
				System.out.println("ERROR: La matricula ya estaba incluida en la coleccion");
			}
			}

		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void  buscarMatricula()  {
		
		try{
			//controlador.buscarMatricula(Consola.getMatriculaPorIdentificador());
			System.out.println(controlador.buscarMatricula(Consola.getMatriculaPorIdentificador()));
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
	
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}
	

	private void  anularMatricula()  {
		
		try{
			Matricula nuevaMatricula=controlador.buscarMatricula(Consola.getMatriculaPorIdentificador());
			if (nuevaMatricula!=null) {
				controlador.borrarMatricula(nuevaMatricula);
				System.out.println("Matricula anulada correctamente");
			}
			else {System.out.println("Matricula anulada correctamente");}
		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}


	private void mostrarMatriculas()   {
		try{
			//controlador.getMatriculas();
			ArrayList<Matricula> nuevoArrayList=controlador.getMatriculas();;
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
				for (Matricula matricula: nuevoArrayList) {
					System.out.println("Matricula: "+ matricula);
					System.out.println("Asignatura: "+matricula.getColeccionAsignaturas().toString());
				}
			}else {
				System.out.println(" No existen matriculas en el sistema");
			}

		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());;
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}

	private void mostrarMatriculasPorAlumno()  {
		try{
			//controlador.getMatriculas(Consola.getAlumnoPorDni());
			ArrayList<Matricula> nuevoArrayList=controlador.getMatriculas(Consola.getAlumnoPorDni());
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
				for (Matricula matricula: nuevoArrayList) {
					System.out.println("Matricula: "+ matricula);
					System.out.println("Asignatura: "+matricula.getColeccionAsignaturas().toString());
				}
			}

		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}

	private void mostrarMatriculasPorCicloFormativo() {
		
		try{
			//controlador.getMatriculas(Consola.getCicloFormativoPorCodigo());
			ArrayList<Matricula> nuevoArrayList=controlador.getMatriculas(Consola.getCicloFormativoPorCodigo());
			
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
				for (Matricula matricula: nuevoArrayList) {
					System.out.println("Matricula: "+ matricula);
					System.out.println("Asignatura: "+matricula.getColeccionAsignaturas().toString());
				}
			}

		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
	}

	
	private void mostrarMatriculasPorCursoAcademico()   {
		
		try{
			System.out.println("Introduce el curso en formato DD-DD, por ejemplo 23-24");
			String cursoAcademico=Entrada.cadena();
			//controlador.getMatriculas(cursoAcademico);
			
			ArrayList<Matricula> nuevoArrayList=controlador.getMatriculas(cursoAcademico);
			
			if (nuevoArrayList!=null) {
				Collections.sort(nuevoArrayList);
	 			for (Matricula matricula: nuevoArrayList) {
	 				System.out.println("Matricula: "+ matricula);
	 				System.out.println("Asignatura: "+matricula.getColeccionAsignaturas().toString());
	 			}
			}
 

		}				
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(OperationNotSupportedException e) {
		System.out.println(e.getMessage());;}
		}

	}
