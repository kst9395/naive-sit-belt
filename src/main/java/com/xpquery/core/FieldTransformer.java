package com.xpquery.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.xpquery.model.Field;

public class FieldTransformer {


	private Field AsField(Map.Entry<String, String> entry){
		return new Field(entry.getKey(), entry.getValue());
	}
	

	public List<Field> transformData(HashMap<String, String> parsedData) {
		List<Field> transformed = new ArrayList<>();
		
		transformed = parsedData.entrySet().stream().map(this::AsField).collect(Collectors.toList());
		
		return transformed;
	}

}
