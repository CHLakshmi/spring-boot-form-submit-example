package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemFilterUtils {
	
	public static List<String> convertObjectToList(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String valueAsString = mapper.writeValueAsString(obj).replaceAll("[\\[\\]\"]", "");
			List<String> valueAsArrayList = new ArrayList<>(Arrays.asList(valueAsString.split(",")));
			return valueAsArrayList;
		} catch (JsonProcessingException e) {
			e.getMessage();
		}
		return null;
	}
}
