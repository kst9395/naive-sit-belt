package com.xpquery.metadata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")
public class XPQueryConfiguration {
	private FieldDefinition fieldDefinition;
	
	@XmlElement(name="field-definitions")
	public FieldDefinition getFieldDefinition() {
		return fieldDefinition;
	}
	
	public void setFieldDefinition(FieldDefinition fieldDefinition) {
		this.fieldDefinition = fieldDefinition;
	}

	@Override
	public String toString() {
		return "XPQueryConfiguration [fieldDefinition=" + fieldDefinition + ", getFieldDefinition()="
				+ getFieldDefinition() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
