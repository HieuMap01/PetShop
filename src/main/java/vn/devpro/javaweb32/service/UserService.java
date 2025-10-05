package vn.devpro.javaweb32.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.devpro.javaweb32.model.User;

@Service
public class UserService extends BaseService<User> {

	@Override
	public Class<User> clazz() {
		return User.class;
	}

	public List<User> findAllActive() {
		String sql = "SELECT * FROM tbl_user WHERE status=1";
		return super.excuteNativeSql(sql);
	}

	public List<User> findAdminUser() {
		String sql = "SELECT * FROM tbl_user u, tbl_user_role ur, "
				+ "tbl_role r WHERE u.id=ur.user_id AND ur.role_id = r.id AND r.name='ADMIN'";
		return super.excuteNativeSql(sql);
	}

}
