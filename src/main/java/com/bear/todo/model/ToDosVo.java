package com.bear.todo.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class ToDosVo {

	private Long id;
	private Date date;
	private String abstracts;
	private String detail;
	private Integer status;
}
