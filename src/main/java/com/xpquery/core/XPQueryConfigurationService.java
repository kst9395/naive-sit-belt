package com.xpquery.core;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.xpquery.metadata.FieldDefinition;
import com.xpquery.metadata.SingleFieldDefinition;
import com.xpquery.metadata.XPQueryConfiguration;

public class XPQueryConfigurationService {

	JAXBContext context;

	public XPQueryConfigurationService() {
		try {
			context = JAXBContext.newInstance(XPQueryConfiguration.class, FieldDefinition.class,
					SingleFieldDefinition.class, FieldDefinition.class);
		} catch (Exception e) {
		}

	}

	public XPQueryConfiguration LoadConfiguration(InputStream stream) throws JAXBException {
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object unmarshalled = unmarshaller.unmarshal(stream);

		return (XPQueryConfiguration) unmarshalled;

	}

}
