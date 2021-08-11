package interfaces;

import java.util.Set;

public interface CRUD<T> {
	public void create(T obj);
	public T read(T obj);
	public Set<T> readAll();
}
