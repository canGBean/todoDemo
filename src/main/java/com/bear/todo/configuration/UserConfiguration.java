package com.bear.todo.configuration;


import com.bear.todo.TodoApplication;
import com.bear.todo.common.model.WebResult;
import com.bear.todo.generatormodel.User;
import com.bear.todo.model.ToDosVo;
import com.bear.todo.model.UserLoginVo;
import com.bear.todo.model.UserInfoVo;
import com.bear.todo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping(value = "/api")
@Slf4j
public class UserConfiguration {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WebResult index(@RequestBody UserLoginVo userLogin) {
		UserInfoVo userInfoVo = userService.login(userLogin);
		return WebResult.success(userInfoVo);
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WebResult index(@RequestBody UserInfoVo userInfoVo) {
		return WebResult.success(userService.logout(userInfoVo.getToken()));
	}


	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public WebResult queryUserInfoByToken(@RequestParam(value = "token", required = false) String token) {
		UserInfoVo userInfoVo = userService.queryUserInfoByToken(token);
		return WebResult.success(userInfoVo);
	}


	@RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public WebResult register(@RequestBody User user) {
		UserInfoVo userInfoVo = userService.register(user);
		return WebResult.success(userInfoVo);
	}

	@RequestMapping(value = "/todo/getTodoThingsByDate", method = RequestMethod.GET)
	public WebResult queryTodoThings(@RequestParam(value = "beginDate", required = false) String beginDate, @RequestParam(value = "endDate", required = false) String endDate) throws ParseException {
		List<ToDosVo> toDosVoArray = userService.queryTodoThings(
				DateUtils.parseDate(beginDate, Locale.TRADITIONAL_CHINESE, "yyyy-MM-dd"),
				DateUtils.parseDate(endDate, Locale.TRADITIONAL_CHINESE, "yyyy-MM-dd"));
		return WebResult.success(toDosVoArray);
	}

	@RequestMapping(value = "/todo/saveTodoThing", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public WebResult saveTodoThing(@RequestBody ToDosVo toDosForm) {
		ToDosVo toDosVo = userService.saveTodoThing(toDosForm);
		return WebResult.success(toDosVo);
	}

}
