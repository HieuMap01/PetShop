package vn.devpro.javaweb32.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb32.model.Category;

@Service
public class CategoryService extends BaseService<Category> {

	@Override
	public Class<Category> clazz() {
		return Category.class;
	}

	public List<Category> findByName(String name) {
		String sql = "SELECT * FROM tbl_category WHERE name='" + name + "'";
		return super.excuteNativeSql(sql);
	}

	public List<Category> findAllActive() {
		String sql = "SELECT * FROM tbl_category WHERE status=1";
		return super.excuteNativeSql(sql);
	}
}
