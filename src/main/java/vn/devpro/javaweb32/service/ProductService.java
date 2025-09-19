package vn.devpro.javaweb32.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb32.dto.ProductSearch;
import vn.devpro.javaweb32.model.Product;

@Service
public class ProductService extends BaseService<Product> {

	@Override
	public Class<Product> clazz() {
		// TODO Auto-generated method stub
		return Product.class;
	}

	public List<Product> findAllActive() {
		String sql = "SELECT * FROM tbl_product WHERE status=1";
		return super.excuteNativeSql(sql);
	}

	public List<Product> search(ProductSearch productSearch) {
		String sql = "SELECT * FROM tbl_product p WHERE 1=1";

		if (productSearch.getStatus() != 2) {
			sql += " AND p.status=" + productSearch.getStatus();
		}

		if (productSearch.getCategoryId() != 0) {
			sql += " AND p.category_id=" + productSearch.getCategoryId();
		}

		String keyword;
		if (productSearch.getKeyword() != null) {
			keyword = productSearch.getKeyword();
			sql += " AND (LOWER(p.name) like '%" + keyword + "%'" + " OR LOWER(p.short_description) like '%" + keyword
					+ "%')";
		}

		String beginDate = productSearch.getBeginDate();
		String endDate = productSearch.getEndDate();
		if (beginDate != null && endDate != null) {
			sql += " AND p.create_date BETWEEN '" + beginDate + "'AND'" + endDate + "'";
		}

		System.out.println("sql = " + sql);
		return super.excuteNativeSql(sql);
	}

}
