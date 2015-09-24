/* @(#)CommonModel.java Sep 3, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

/**
 * The Class CommonModel.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 * @param <T>
 *            the generic type
 */
@java.lang.SuppressWarnings({ "serial" })
public abstract class CommonModel<T extends CommonModel<T>> implements java.io.Serializable, java.lang.Cloneable {

	// @com.fasterxml.jackson.annotation.JsonIgnore
	// @org.codehaus.jackson.annotate.JsonIgnore
	// @GsonExclude
	// @javax.xml.bind.annotation.XmlTransient
	// @javax.persistence.Transient
	protected static final transient Gson gson__ = new GsonBuilder().setPrettyPrinting()
			// .setExclusionStrategies( new
			// GsonExclusionStrategy( null ) ).registerTypeAdapter( Date.class,
			// new
			// DateTypeAdapter() )
			.create();

	/**
	 * From json.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param json
	 *            the json
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static <CType> CType fromJson(final File json, final Class<CType> clazz)
			throws UnsupportedEncodingException, FileNotFoundException {
		FileInputStream in = new FileInputStream(json);
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		return gson__.fromJson(reader, clazz);
	}

	/**
	 * From json.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param json
	 *            the json
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 */
	public static <CType> CType fromJson(final JsonObject json, final Class<CType> clazz) {
		return fromJson(json.toString(), clazz);
	}

	/**
	 * From json.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param json
	 *            the json
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 */
	public static <CType> CType fromJson(final JSONObject json, final Class<CType> clazz) {
		return gson__.fromJson(json.toString(), clazz);
	}

	/**
	 * From json.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param json
	 *            the json
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 */
	@javax.ws.rs.Consumes("application/json")
	public static <CType> CType fromJson(final Gson gson, final String json, final Class<CType> clazz) {
		return gson.fromJson(json, clazz);
	}

	@javax.ws.rs.Consumes("application/json")
	public static <CType> CType fromJson(final String json, final Class<CType> clazz) {
		return fromJson(gson__, json, clazz);
	}

	/**
	 * From json.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param jsonUrl
	 *            the json url
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static <CType> CType fromJson(final URL jsonUrl, final Class<CType> clazz) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(jsonUrl.openStream(), "UTF-8"));
		return gson__.fromJson(reader, clazz);
	}

	/**
	 * From xml.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param xml
	 *            the xml
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 * @throws JAXBException
	 *             the JAXB exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@SuppressWarnings("unchecked")
	public static <CType> CType fromXml(final File xml, final Class<CType> clazz)
			throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		FileInputStream in = new FileInputStream(xml);

		CType returntype = (CType) jaxbUnmarshaller.unmarshal(in);

		return returntype;
	}

	/**
	 * From xml.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param xml
	 *            the xml
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 * @throws JAXBException
	 *             the JAXB exception
	 */
	@SuppressWarnings("unchecked")
	@javax.ws.rs.Consumes("application/xml")
	public static <CType> CType fromXml(final String xml, final Class<CType> clazz) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		InputStreamReader is = new InputStreamReader(IOUtils.toInputStream(xml));

		// FileInputStream in = new FileInputStream( new File( folder +
		// field.getType().getTypeArguments().get( LISTTYPEPOSITION ) + DOTJAVA
		// ) );

		CType returntype = (CType) jaxbUnmarshaller.unmarshal(is);

		return returntype;
	}

	/**
	 * From xml.
	 *
	 * @param <CType>
	 *            the generic type
	 * @param xmlUrl
	 *            the xml url
	 * @param clazz
	 *            the clazz
	 * @return the c type
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws JAXBException
	 *             the JAXB exception
	 */
	@SuppressWarnings("unchecked")
	public static <CType> CType fromXml(final URL xmlUrl, final Class<CType> clazz) throws IOException, JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		CType returntype = (CType) jaxbUnmarshaller.unmarshal(new InputStreamReader(xmlUrl.openStream(), "UTF-8"));
		return returntype;
	}

	/**
	 * equals (non-Javadoc).
	 *
	 * @param other
	 *            the other
	 * @return true, if successful
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	/**
	 * hashCode (non-Javadoc).
	 *
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * To json.
	 *
	 * @return the string
	 */
	@javax.ws.rs.Produces("application/json")
	public String toJson() {
		return gson__.toJson(this);
	}

	/**
	 * To json object.
	 *
	 * @return the json object
	 */
	@javax.xml.bind.annotation.XmlTransient
	public JsonObject toJsonObject() {
		// return new JsonParser().parse( toJson() ).getAsJsonObject();
		return gson__.fromJson(toJson(), JsonElement.class).getAsJsonObject();
	}

	/**
	 * To json object.
	 *
	 * @return the JSON object
	 * @throws JSONException
	 *             the JSON exception
	 */
	@javax.xml.bind.annotation.XmlTransient
	public JSONObject toJSONObject() throws JSONException {
		return new JSONObject(toJson());
	}

	/**
	 * toString (non-Javadoc).
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	@javax.ws.rs.Produces("text/plain")
	@javax.xml.bind.annotation.XmlTransient
	public String toString() {
		return ToStringBuilder.reflectionToString((this));
	}

	/**
	 * To xml.
	 *
	 * @return the string
	 * @throws JSONException
	 *             the JSON exception
	 */
	@javax.ws.rs.Produces("application/xml")
	@javax.xml.bind.annotation.XmlTransient
	public String toXml() throws JSONException {
		// String result;
		// StringWriter sw = new StringWriter();
		// try
		// {
		// JAXBContext context = JAXBContext.newInstance( this.getClass() );
		// Marshaller marshaller = context.createMarshaller();
		// marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		// marshaller.marshal( this, sw );
		// result = sw.toString();
		// }
		// catch ( JAXBException e )
		// {
		// throw new RuntimeException( e );
		// }

		// try
		// {
		// Document document = null;
		//
		// try
		// {
		// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// DocumentBuilder db = dbf.newDocumentBuilder();
		// InputSource is = new InputSource( new StringReader( XML.toString(
		// this ) ) );
		// document = db.parse( is );
		// }
		// catch ( ParserConfigurationException e )
		// {
		// throw new RuntimeException( e );
		// }
		// catch ( SAXException e )
		// {
		// throw new RuntimeException( e );
		// }
		// catch ( IOException e )
		// {
		// throw new RuntimeException( e );
		// }
		//
		// if ( document != null )
		// {
		// OutputFormat format = new OutputFormat( document );
		// format.setLineWidth( 65 );
		// format.setIndenting( true );
		// format.setIndent( 2 );
		// Writer out = new StringWriter();
		// XMLSerializer serializer = new XMLSerializer( out, format );
		// serializer.serialize( document );
		//
		// return out.toString();
		// }
		// }
		// catch ( IOException e )
		// {
		// throw new RuntimeException( e );
		// }

		return XML.toString(this);
	}

}
