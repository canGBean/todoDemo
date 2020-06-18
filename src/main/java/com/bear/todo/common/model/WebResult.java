package com.bear.todo.common.model;

import lombok.*;

import java.io.Serializable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class WebResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg = "";
	private String exception = "";
	private T data;
	private Long timestamp = System.currentTimeMillis();

	public static <T> WebResult<T> success(T data) {
		return (WebResult<T>) WebResult.builder().code(200).msg("SUCCESS").exception("None").data(data).build();
	}
}
