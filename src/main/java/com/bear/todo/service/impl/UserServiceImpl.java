package com.bear.todo.service.impl;

import com.bear.todo.generatormapper.ToDosMapper;
import com.bear.todo.generatormapper.UserCustomExMapper;
import com.bear.todo.generatormapper.UserMapper;
import com.bear.todo.generatormodel.ToDos;
import com.bear.todo.generatormodel.ToDosExample;
import com.bear.todo.generatormodel.User;
import com.bear.todo.generatormodel.UserExample;
import com.bear.todo.model.ToDosVo;
import com.bear.todo.model.UserLoginVo;
import com.bear.todo.model.UserInfoVo;
import com.bear.todo.service.UserService;
import com.bear.todo.utils.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserCustomExMapper userCustomExMapper;

	@Resource
	private ToDosMapper toDosMapper;

	@Override
	public UserInfoVo login(UserLoginVo userLogin) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andNameEqualTo(userLogin.getName());
		criteria.andPasswordEqualTo(userLogin.getPassword());
		List<User> userList = userMapper.selectByExample(userExample);
		if (userList.size() > 0) {
			//更新user表token lastlogin
			User user = userList.get(0);
			user.withToken(UUIDGenerator.getUUID()).withLastloginTime(new Date());
			userMapper.updateByPrimaryKey(user);
			return UserInfoVo.builder()
					.name(user.getName())
					.token(user.getToken())
					.roles(user.getRoles())
					.avatar(user.getAvatar())
					.build();
		}
		return null;
	}

	@Override
	public UserInfoVo register(User user) {
		UserInfoVo userRegister = null;
		try {
			userMapper.insert(user.withToken(UUIDGenerator.getUUID()).withCreateTime(new Date()));
			userRegister = UserInfoVo.builder().name(user.getName()).avatar(user.getAvatar()).roles(user.getRoles()).token(user.getToken()).build();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return userRegister;
	}

	@Override
	public List<ToDosVo> queryTodoThings(Date beginDate, Date endDate) {
		ToDosExample toDosExample = new ToDosExample();
		ToDosExample.Criteria criteria = toDosExample.createCriteria();
		criteria.andDateBetween(beginDate, endDate);
		List<ToDos> list = toDosMapper.selectByExample(toDosExample);
		if (list.size() > 0) {
			List<ToDosVo> toDosVoList = new ArrayList<>(list.size());
			list.forEach(todo -> toDosVoList.add(
					ToDosVo.builder()
							.id(todo.getId())
							.date(todo.getDate())
							.abstracts(todo.getAbstracts())
							.detail(todo.getDetail())
							.status(todo.getStatus())
							.build()
			));
			return toDosVoList;
		}
		return null;
	}

	@Override
	public ToDosVo saveTodoThing(ToDosVo toDosForm) {
		ToDos toDos = new ToDos();
		BeanUtils.copyProperties(toDosForm,toDos);
		toDos.withCreateTime(new Date());
		toDosMapper.insertSelective(toDos);
		toDosForm.setId(toDos.getId());
		return toDosForm;
	}

	@Override
	public UserInfoVo queryUserInfoByToken(String token) {
		User u = userCustomExMapper.selectByPrimaryToken(token);
		UserInfoVo userInfoVo = new UserInfoVo();
		BeanUtils.copyProperties(u,userInfoVo);
		return userInfoVo;
	}

	@Override
	public int logout(String token) {
		User u = userCustomExMapper.selectByPrimaryToken(token);
		u.withLastlogoutTime(new Date());
		return userCustomExMapper.updateByPrimaryKey(u);
	}
}
