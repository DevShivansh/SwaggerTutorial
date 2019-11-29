package com.techprimer.SwaggerTutorial.entity;

import java.util.Map;

import lombok.Data;

@Data
public class ResponseTO {

	private Map<Object, Object> map;
	
	public ResponseTO(Object key, Object value) {
		// TODO Auto-generated constructor stub
		map.put(key, value);
	}
}
