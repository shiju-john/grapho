package com.flytxt.grapho.service;

import java.util.List;

/**
 * 
 * @author shiju.john
 *
 * @param <T>
 */
public interface FlyService<T, E> {

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T save(T entity) throws Exception;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T get(T entity) throws Exception;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T update(T entity) throws Exception;

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @return
	 * @throws Exception
	 */
	public List<T> findPage(int pageNo, int pageSize, String sortField, String sortOrder) throws Exception;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T delete(T entity) throws Exception;

	/**
	 * 
	 * @return
	 */
	public Iterable<T> findAll() throws Exception;

	/**
	 * 
	 * @return
	 */
	public Iterable<T> search(List<E> criteria) throws Exception;

}
