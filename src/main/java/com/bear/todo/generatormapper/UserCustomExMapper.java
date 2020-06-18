package com.bear.todo.generatormapper;

import com.bear.todo.generatormodel.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserCustomExMapper extends UserMapper {
	@Select({
			"select",
			"id, name, password, avatar, roles, token, create_time, lastlogin_time, lastlogout_time",
			"from user",
			"where token = #{id,jdbcType=VARCHAR}"
	})
	@ResultMap("com.bear.todo.generatormapper.UserMapper.BaseResultMap")
	User selectByPrimaryToken(String Token);
}
