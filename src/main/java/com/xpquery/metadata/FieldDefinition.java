package com.xpquery.metadata;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class FieldDefinition {
	
	private List<SingleFieldDefinition> definitions;
	
	public void setDefinitions(List<SingleFieldDefinition> definitions) {
		this.definitions = definitions;
	}
	
	@XmlElement(name="field")
	public List<SingleFieldDefinition> getDefinitions() {
		return definitions;
	}

	@Override
	public String toString() {
		return "FieldDefinition [definitions=" + definitions + ", getDefinitions()=" + getDefinitions()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
