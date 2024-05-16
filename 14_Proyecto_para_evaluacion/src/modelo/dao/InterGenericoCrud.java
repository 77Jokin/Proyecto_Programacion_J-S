package modelo.dao;

import java.util.List;

public interface InterGenericoCrud<k,T> {
	boolean alta (T obj);
	boolean eliminar (k clave);
	boolean modificar (T obj);
	T buscarUno (k clave);
	List<T> buscarTodos();
}
