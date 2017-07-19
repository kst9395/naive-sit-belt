package com.xpquery.core;

import java.util.HashMap;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import com.xpquery.model.Field;

public class KeyValueParser {

	FieldProcessor processor;
	FieldTransformer transformer;
	
	
	public KeyValueParser(FieldProcessor processor, FieldTransformer transformer) {
		this.processor=processor;
		this.transformer=transformer;
	}
	
	public List<Field> ProcessField() throws XPathExpressionException{
		HashMap<String, String> processedFields = processor.ProcessFields();
		return transformer.transformData(processedFields);
		
	}
	

}
