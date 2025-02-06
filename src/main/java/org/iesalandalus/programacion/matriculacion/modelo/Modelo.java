package org.iesalandalus.programacion.matriculacion.modelo;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.Alumnos;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.Asignaturas;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.CiclosFormativos;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.Matriculas;


public class Modelo {

	private Alumnos alumnos;
	private Matriculas matriculas;
	private Asignaturas asignaturas;
	private CiclosFormativos ciclosFormativos;
	//private final int CAPACIDAD=5;
	
	
	public Modelo() {}
	
	public void comenzar() {
    	alumnos=new Alumnos();
    	asignaturas=new Asignaturas();
    	ciclosFormativos=new CiclosFormativos();
    	matriculas=new Matriculas();
	}
	
	public void terminar (){
		System.out.print("Hasta luego");
	}
	
	public  void insertarAlumno(Alumno alumno) throws OperationNotSupportedException {
		
		if(alumno!=null) {

				alumnos.insertar(alumno);	
	
		}else {
			throw new NullPointerException("ERROR: No se ha recibido el alumno");
		}
    }
    
    
	public Alumno buscarAlumno(Alumno alumno)  {
	  		
		if (alumno!=null) {
	  		
			if (alumnos.buscar(alumno)!=null) {
				System.out.println(alumnos.buscar(alumno));
				return alumnos.buscar(alumno);
			}
			else {
				throw new NullPointerException("ERROR: No se ha encontrado alumno para ese nif");
			}

		}else {
			throw new NullPointerException("ERROR: No se ha recibido el alumno");
		}
      }
    
    
    
    
    
	public void borrarAlumno(Alumno alumno) throws OperationNotSupportedException {

		if (alumno!=null) {
	  			
	  			
	  			/*if( alumnos.buscar(alumno)!=null) {
	  				System.out.println("Alumno econtrado y borrado");
	  				alumnos.borrar(alumno);
	  			}
	  			else {
	  				System.out.println("No encontrado en la coleccion");
	  			}*/
				alumnos.borrar(alumno);
	  			
		}else {
			throw new NullPointerException("ERROR: No se ha recibido el alumno");
		}
      }
    
    
	public List<Alumno> getAlumnos()  {
  		
	
  			 if(alumnos.getTamano()>0) {
  				 List<Alumno> nuevoArrayList=alumnos.get();
  				 boolean encontrado=false;
  				 
  				 for(int i=0;i<nuevoArrayList.size();i++)
  				 { if (nuevoArrayList.get(i)!=null) {
  					 System.out.println("Estos son los datos de los alumnos de la coleccion");
  					 System.out.println(nuevoArrayList.get(i));
  				 	}
  				 	else {encontrado=true;}
  				 }
  				 return nuevoArrayList;
  			 }
  			 else {
  				 System.out.println(" No existen alumnos en el sistema");
  				 return null;
  			 }

      }
    
	
	public void insertarAsignatura(Asignatura asignatura) throws OperationNotSupportedException {
	  		
		if(asignatura!=null) {

	  			asignaturas.insertar(asignatura);

		}else {
			throw new NullPointerException("ERROR: No se ha recibido la asignatura");
		}
      }
    
	
    public Asignatura buscarAsignatura(Asignatura asignatura) {
	  		
    	if(asignatura!=null) {

    		if (asignaturas.buscar(asignatura)!=null) {
    			System.out.println(asignaturas.buscar(asignatura));
    			return asignaturas.buscar(asignatura);
    		}
    		else {
    			throw new NullPointerException("ERROR: No se ha encontrado asignaturas por ese codigo");
    		}

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido la asignatura");
    	}
      }
    
    public void borrarAsignatura(Asignatura asignatura) throws OperationNotSupportedException {
	  		
    	if(asignatura!=null) {

	 
	  			/*if(asignaturas.buscar(asignatura)!=null) {
	  				System.out.println("Asignatura econtrada y borrada");
	  				asignaturas.borrar(asignatura);
	  			}
	  			else {
	  				System.out.println("Asignatura no encontrada en la coleccion");
	  			}*/
    			asignaturas.borrar(asignatura);
    		
	  			
    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido la asignatura");
    	}
      }

    
    public List<Asignatura> getAsignaturas()  {
  		
 
  			 if(asignaturas.getTamano()>0) {
  				 List<Asignatura>nuevoArrayList=asignaturas.get();
  				 /*boolean encontrado=false;
  				 
  				 for(int i=0;i<nuevoArray.length;i++)
  				 {
  					 if (nuevoArray[i]!=null) {
  	  					 System.out.println("Estos son los datos de las asignaturas de la coleccion");
  	  					 System.out.println(nuevoArray[i]);
  	  				 }
  	  				 else {encontrado=true;}
  				 }*/
  				 return nuevoArrayList;
  				 }
  			 else {
  				 
  				 return null;
  			 }	

      }
    
	
    public void insertarCicloFormativo(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
	  		
    	if(cicloFormativo!=null) {

	  			ciclosFormativos.insertar(cicloFormativo);
	  			

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido el ciclo formativo");
    	}
      }
    

    public CicloFormativo  buscarCicloFormativo(CicloFormativo cicloFormativo) {
	  		
    	if(cicloFormativo!=null) {

    		if(ciclosFormativos.buscar(cicloFormativo)!=null) {
    	
    			System.out.println(ciclosFormativos.buscar(cicloFormativo));
    			return ciclosFormativos.buscar(cicloFormativo);
    		}
    		else {
    			throw new NullPointerException("ERROR: No se encuentra ciclos formativos para ese codigo");
    		}
	
    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido el ciclo formativo");
    	}
      }
    
    
    public void  borrarCicloFormativo(CicloFormativo cicloFormativo) throws OperationNotSupportedException {
	  		
    	if(cicloFormativo!=null) {

	  			/*if( ciclosFormativos.buscar(cicloFormativo)!=null) {
	  				System.out.println("Ciclo formativo econtrado y borrado");
	  				ciclosFormativos.borrar(cicloFormativo);
	  			}
	  			else {
	  				System.out.println("Ciclo formativo no encontrado en la coleccion");
	  			}*/
    			ciclosFormativos.borrar(cicloFormativo);

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido el ciclo formativo");
    	}
      }
    
    
    public List<CicloFormativo> getCiclosFormativos()  {

  			 if(ciclosFormativos.getTamano()>0) {
  				 List<CicloFormativo>nuevoArrayList=ciclosFormativos.get();
  				 boolean encontrado=false;
  				 
  				 for(int i=0;i<nuevoArrayList.size();i++)
  				 
  	  				 { if (nuevoArrayList.get(i)!=null) {
  	  					 System.out.println("Estos son los datos de los ciclos formativos de la coleccion");
  	  					 System.out.println(nuevoArrayList.get(i));
  	  				 	}
  	  				 	else {encontrado=true;}
  					 
  	  				 }
  				 return nuevoArrayList;
  	  			}
  			 else {
  				 System.out.println(" No existen ciclos formativos en el sistema");
  				 return null;
  			 }
  			
      }
    
    public void  insertarMatricula(Matricula matricula) throws OperationNotSupportedException {
	  		
    	if(matricula!=null) {
			
	  			/*Alumno alumno=Consola.getAlumnoPorDni();
	  			System.out.println("Indica el numero de asignaturas que vas a introducir, debe ser mayor que 0");
	  			Asignatura [] coleccionAsignaturas=new Asignatura[10];
	  			int numeroAsignaturas=Entrada.entero();
	  			for (int i=0;i<numeroAsignaturas;i++) {
	  				coleccionAsignaturas[i]=Consola.getAsignaturaPorCodigo();*/
	  			matriculas.insertar(matricula);
	  			

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido la matricula");
    	}
      }
    
    
    public Matricula buscarMatricula(Matricula matricula) throws OperationNotSupportedException {
	  		
    	if(matricula!=null) {
    		
    		if(matriculas.buscar(matricula)!=null) {

    			System.out.println(matriculas.buscar(matricula));
    			return matriculas.buscar(matricula);
    		}
    		else {
    			
    			throw new NullPointerException("ERROR: No hay matriculas para este codigo");
    		}

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido la matricula");
    	}
      }
    
    
    public void borrarMatricula(Matricula matricula) throws OperationNotSupportedException {
	  		
    	if(matricula!=null) {

    			matriculas.borrar(matricula);

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido la matricula");
    	}
      }
    
    
    public List<Matricula> getMatriculas() throws OperationNotSupportedException  {
  	
  			 if(matriculas.getTamano()>0) {
  				
  				List<Matricula> nuevoArrayList=matriculas.get();
  				 boolean encontrado=false;
  				 
  				 for(int i=0;i<nuevoArrayList.size();i++)
  				 {
  					if (nuevoArrayList.get(i)!=null) {
  						System.out.println("Estos son los datos de las matriculas de la coleccion");
  						System.out.println(nuevoArrayList.get(i));
  						List<Asignatura> arrayListAsignaturas=nuevoArrayList.get(i).getColeccionAsignaturas();
  						for (int j=0;j<arrayListAsignaturas.size();j++)
  						{ if(arrayListAsignaturas.get(j)!=null) {
  								System.out.println("Estas son sus asignaturas");
  								System.out.println(arrayListAsignaturas.get(j));
  							}
  							else {encontrado=true;}
  						}
  					}else {
  						encontrado=true;
  					}
  				 }
  				 return matriculas.get();
  			 }
  			 else {
  				 System.out.println(" No existen matriculas en el sistema");
  				 return null;
  			 }
  			

      }
    
    public List<Matricula> getMatriculas (Alumno alumno) throws OperationNotSupportedException  {
	  		
    	if(alumno!=null) {
    	
 			
 			if (matriculas.get(alumno)!=null) {
 				List<Matricula> nuevoArrayList=matriculas.get(alumno);
 	 			boolean encontrado=false;
 				 
 				 for(int i=0;i<nuevoArrayList.size();i++)
 				 {
 					if (nuevoArrayList.get(i)!=null) {
 						System.out.println("Estos son los datos de las matriculas de la coleccion");
 						System.out.println(nuevoArrayList.get(i));
 						List<Asignatura> arrayListAsignaturas=nuevoArrayList.get(i).getColeccionAsignaturas();
 						for (int j=0;j<arrayListAsignaturas.size();j++)
 						{ if(arrayListAsignaturas.get(j)!=null) {
 								System.out.println("Estas son sus asignaturas");
 								System.out.println(arrayListAsignaturas.get(j));
 							}
 							else {encontrado=true;}
 						}
 					}else {
 						encontrado=true;
 					}
 				 }
 				 return matriculas.get(alumno);
 			}
 			else {
 				throw new NullPointerException("ERROR: No hay matriculas para este alumno");
 			}			
    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido el alumno para consultar la matricula");
    	}
      }
    

    public List<Matricula> getMatriculas(CicloFormativo cicloFormativo) throws OperationNotSupportedException  {
	  		
    	if(cicloFormativo!=null) {

 			if (matriculas.get(cicloFormativo)!=null) {
 				
 				List<Matricula> nuevoArrayList=matriculas.get(cicloFormativo);
 	 			boolean encontrado=false;
 			
 				 for(int i=0;i<nuevoArrayList.size();i++)
 				 {
 					if (nuevoArrayList.get(i)!=null) {
 						System.out.println("Estos son los datos de las matriculas de la coleccion");
 						System.out.println(nuevoArrayList.get(i));
 						List<Asignatura> arrayListAsignaturas=nuevoArrayList.get(i).getColeccionAsignaturas();
 						for (int j=0;j<arrayListAsignaturas.size();j++)
 						{ if(arrayListAsignaturas.get(j)!=null && arrayListAsignaturas.get(j).getCicloFormativo().equals(cicloFormativo)) {
 								System.out.println("Estas son sus asignaturas");
 								System.out.println(arrayListAsignaturas.get(j));
 							}
 							else {encontrado=true;}
 						}
 					}else {
 						encontrado=true;
 					}
 				 }
 				 return matriculas.get(cicloFormativo); 
 			}
 			else {
 				throw new NullPointerException("ERROR: No hay matriculas para este ciclo formativo");
 			}

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido el ciclo formativo para consultar la matricula");
    	}
      }
    
    public List<Matricula>getMatriculas(String cursoAcademico) throws OperationNotSupportedException  {
	  		
    	if(cursoAcademico!=null) {
    		
 			
 			if (matriculas.get(cursoAcademico)!=null) {
 				
 				List<Matricula> nuevoArrayList=matriculas.get(cursoAcademico);
 	 			boolean encontrado=false;
 				 
 				 for(int i=0;i<nuevoArrayList.size();i++)
 				 {
 					if (nuevoArrayList.get(i)!=null) {
 						System.out.println("Estos son los datos de las matriculas de la coleccion");
 						System.out.println(nuevoArrayList.get(i));
 						List<Asignatura> arrayListAsignaturas=nuevoArrayList.get(i).getColeccionAsignaturas();
 						for (int j=0;j<arrayListAsignaturas.size();j++)
 						{ if(arrayListAsignaturas.get(j)!=null) {
 								System.out.println("Estas son sus asignaturas");
 								System.out.println(arrayListAsignaturas.get(j));
 							}
 							else {encontrado=true;}
 						}
 					}else {
 						encontrado=true;
 					}
 				 }
 				 return matriculas.get(cursoAcademico);
			}
			else {
				throw new NullPointerException("ERROR: No hay matriculas para este curso academico");
			}

    	}else {
    		throw new NullPointerException("ERROR: No se ha recibido el curso academico para consultar la matricula");
    	}
      }

    
}
