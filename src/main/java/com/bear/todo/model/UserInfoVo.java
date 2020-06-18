package com.bear.todo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class UserInfoVo {

	private String name;
	private String avatar;
	private String roles;
	private String token;

}
