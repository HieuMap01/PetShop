package vn.devpro.javaweb32.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb32.model.BaseModel;

@Service
public abstract class BaseService <Model extends BaseModel> {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public abstract Class<Model> clazz();
	
	//Lay mot ban ghi theo id
	public Model getById(int id) {
		return entityManager.find(clazz(), id);
	}
	
	//Lay tat ca cac ban ghi trong mot table
	@SuppressWarnings("unchecked")
	public List<Model> findAll() {
		Table table = clazz().getAnnotation(Table.class);
		return (List<Model>) entityManager.createNativeQuery(
				"SELECT * FROM " + table.name(), 
				clazz()).getResultList();
	}
	
	//Them moi hoac sua mot ban ghi
	@Transactional
	public Model saveOrUpdate(Model entity) {
		if (entity.getId() == null || entity.getId() <= 0) { //Add new entity
			entityManager.persist(entity);
			return entity;
		}
		else { //update entity
			return entityManager.merge(entity);
		}
	}
	
	//Xoa 1 ban ghi theo entity
	@Transactional
	public void delete(Model entity) {
		entityManager.remove(entity);	
	}
	//Delete theo id
	@Transactional
	public void deleteById(int id) {
		Model entity = this.getById(id);
		delete(entity);
	}
	
	// chuyên thực hiện các câu lệnh sqp tự thự thi nó se trả về 1 list 
	@SuppressWarnings("unchecked")
	public List<Model> excuteNativeSql(String sql){
		try {
			Query query = entityManager.createNativeQuery(sql, clazz());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}
	
	
	
}
