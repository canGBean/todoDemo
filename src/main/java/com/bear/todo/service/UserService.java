package com.bear.todo.service;

import com.bear.todo.generatormodel.User;
import com.bear.todo.model.ToDosVo;
import com.bear.todo.model.UserLoginVo;
import com.bear.todo.model.UserInfoVo;

import java.util.Date;
import java.util.List;

public interface UserService {
	//登陆
	UserInfoVo login(UserLoginVo userLogin);
	//注册
	UserInfoVo register(User user);
	//查询
	List<ToDosVo> queryTodoThings(Date beginDate, Date endDate);
	//保存待办
	ToDosVo saveTodoThing(ToDosVo toDosForm);
	//根据token查用户
	UserInfoVo queryUserInfoByToken(String token);
	//退出,更新退出时间
	int logout(String token);
}
