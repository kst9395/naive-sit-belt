package com.xpquery.core;

import java.util.HashMap;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.xpquery.metadata.SingleFieldDefinition;
import com.xpquery.metadata.XPQueryConfiguration;

/**
 * This class read get a xml document + configuration model and return list of key value pair, should
 * be simple enough to implement
 * TODO: add abstraction to enable custom field processor
 * 
 * @category service
 **/
public class FieldProcessor {
	private final Document document;
	private final XPQueryConfiguration configuration;

	public FieldProcessor(Document document, XPQueryConfiguration configuration) {
		this.document = document;
		this.configuration = configuration;
	}

	public HashMap<String, String> ProcessFields() throws XPathExpressionException {
		HashMap<String, String> fieldMap = new HashMap<>();

		List<SingleFieldDefinition> fieldDefinitions = configuration.getFieldDefinition().getDefinitions();

		if (fieldDefinitions != null) {
			XPath xpath = XPathFactory.newInstance().newXPath();
			for (SingleFieldDefinition def : fieldDefinitions) {

				String labelQuery = def.getLabelQuery();
				String valueQuery = def.getValueQuery();
				XPathExpression labelExpression = xpath.compile(labelQuery);
				XPathExpression valueExpression = xpath.compile(valueQuery);

				NodeList labels = (NodeList) labelExpression.evaluate(document, XPathConstants.NODESET);
				NodeList values = (NodeList) valueExpression.evaluate(document, XPathConstants.NODESET);

				if (labels == null || values == null) {
					throw new IllegalStateException("Error");
				}
				int labelCount = labels.getLength();
				int valuesCount = values.getLength();
				if (labelCount != valuesCount) {
					throw new IllegalStateException();
				}

				for (int i = 0; i < labelCount; i++) {
					Node labelItem = labels.item(i);
					String labelValue = labelItem.getTextContent();
					Node valueItem = values.item(i);
					String metaValue = valueItem.getTextContent();
					fieldMap.put(labelValue, metaValue);
				}

			}
		}

		return fieldMap;

	}

}
