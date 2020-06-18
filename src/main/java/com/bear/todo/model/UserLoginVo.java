package com.bear.todo.model;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class UserLoginVo implements Serializable {

	private String name;

	private String password;


}
