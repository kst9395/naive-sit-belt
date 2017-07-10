package com.xpquery.metadata;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class SingleFieldDefinition {

	private String labelQuery;
	private String valueQuery;
	
	private String sectionName;
	
	
	
	
	@XmlAttribute(name="section")
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	@XmlElement(name="label-query")
	public String getLabelQuery() {
		return labelQuery;
	}
	public void setLabelQuery(String labelQuery) {
		this.labelQuery = labelQuery;
	}
	@XmlElement(name="value-query")
	public String getValueQuery() {
		return valueQuery;
	}
	public void setValueQuery(String valueQuery) {
		this.valueQuery = valueQuery;
	}
	@Override
	public String toString() {
		return "SIngleFieldDefinition [labelQuery=" + labelQuery + ", valueQuery=" + valueQuery + ", getLabelQuery()="
				+ getLabelQuery() + ", getValueQuery()=" + getValueQuery() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
