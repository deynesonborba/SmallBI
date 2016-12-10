package br.com.smallbi.business.interfaceBusiness;

import java.util.List;

import br.com.smallbi.business.exception.BusinessException;

public interface InterfaceBusiness <T>{
/*	public void create(T t) throws BusinessException;
	public List<T> list();
	public void update(T t) throws BusinessException;
	public void delete(Integer id) throws BusinessException;
	public T getObjById(Integer id) throws BusinessException;*/
	public String create(T t);
	public List<T> list();
	public String update(T t);
	public String delete(Integer id);
	public T getObjById(Integer id);
}
