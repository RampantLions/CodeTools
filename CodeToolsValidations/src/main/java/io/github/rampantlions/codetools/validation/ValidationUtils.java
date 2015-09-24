/* @(#)ValidationUtils.java Sep 11, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.validation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.inst2xsd.Inst2Xsd;
import org.apache.xmlbeans.impl.inst2xsd.Inst2XsdOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;

/**
 * The Class ValidationUtils.
 *
 * @author Wiechman, Joshua <jwiechman@paypal.com>
 */
public class ValidationUtils
{

	/** The enforce abstract class name prefix. */
	public static boolean enforceAbstractClassNamePrefix = false;

	/**
	 * Checks if is email address.
	 *
	 * @param name the name
	 * @return true, if is email address
	 */
	public static boolean isEmailAddress( final String name )
	{
		/* Reference http://www.mkyong.com/regular-expressions/10-java-regular-expression-examples-you-should-know/ */
		return ( !name.matches( "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" ) );
	}

	/**
	 * Checks if is hexadecumal color code.
	 *
	 * @param name the name
	 * @return true, if is hexadecumal color code
	 */
	public static boolean isHexadecumalColorCode( final String name )
	{
		/* Reference http://www.mkyong.com/regular-expressions/10-java-regular-expression-examples-you-should-know/ */
		return ( !name.matches( "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$" ) );
	}

	public static String xmlToJson( String xml, int indent ) throws JSONException
	{
		JSONObject xmlJSONObj = XML.toJSONObject( xml );
		String jsonPrettyPrintString = xmlJSONObj.toString( indent );
		return jsonPrettyPrintString;
	}

	public static String xmlToJson( String xml ) throws JSONException
	{
		return xmlToJson( xml, DEFAULT_INDENT );
	}



	public static File getResourceFile( String filename )
	{
		return getResourceFile( filename, null );
	}

	public static int DEFAULT_INDENT = 4;

	public static String fileToJson( File file ) throws IOException, JSONException
	{
		String data = fileToString( file );

		if ( isXml( data ) )
		{
			data = xmlToJson( data );
		}
		else
		{
			new JSONObject( data );
		}
		return data;
	}

	public static String fileToString( File file ) throws IOException
	{
		return FileUtils.readFileToString( file );
	}

	@SuppressWarnings( "unused" )
	private static SchemaDocument generateSchema( File ... files ) throws XmlException, IOException
	{
		XmlObject[] xmlInstances = new XmlObject[files.length];

		for ( int i = 0; i < files.length; i++ )
		{
			xmlInstances[i] = XmlObject.Factory.parse( files[i] );
		}

		return inst2xsd( xmlInstances );
	}

	@SuppressWarnings( "unused" )
	private static SchemaDocument generateSchema( InputStream ... inputStreams ) throws XmlException, IOException
	{

		XmlObject[] xmlInstances = new XmlObject[inputStreams.length];

		for ( int i = 0; i < inputStreams.length; i++ )
		{
			xmlInstances[i] = XmlObject.Factory.parse( inputStreams[i] );
		}

		return inst2xsd( xmlInstances );
	}

	private static SchemaDocument generateSchema( String ... strs ) throws XmlException, IOException
	{

		XmlObject[] xmlInstances = new XmlObject[strs.length];

		for ( int i = 0; i < strs.length; i++ )
		{
			// System.out.println("i= " + i + "  srts[i]= " + strs[i]);
			xmlInstances[i] = XmlObject.Factory.parse( strs[i] );
		}

		return inst2xsd( xmlInstances );
	}

	public static String quote( String string )
	{
		return "\"" + string.replace( "\\", "\\\\" ).replace( "\"", "\\\"" ) + "\"";
	}

	@SuppressWarnings( "rawtypes" )
	public static File getResourceFile( String filename, Class resource )
	{
		return new File( ( ( resource == null ) ? ValidationUtils.class : resource ).getClassLoader().getResource( filename ).getFile() );
	}

	private static String getSchema( SchemaDocument schemaDocument ) throws IOException
	{
		StringWriter writer = new StringWriter();
		schemaDocument.save( writer, new XmlOptions().setSavePrettyPrint() );
		writer.close();

		return writer.toString();
	}

	private static SchemaDocument inst2xsd( XmlObject[] xmlInstances ) throws IOException
	{
		Inst2XsdOptions inst2XsdOptions = new Inst2XsdOptions();
		// if (design == null || design == XMLSchemaDesign.VENETIAN_BLIND) {
		// inst2XsdOptions.setDesign(Inst2XsdOptions.DESIGN_VENETIAN_BLIND);
		// } else if (design == XMLSchemaDesign.RUSSIAN_DOLL) {
		inst2XsdOptions.setDesign( Inst2XsdOptions.DESIGN_RUSSIAN_DOLL );
		/*
		 * } else if (design == XMLSchemaDesign.SALAMI_SLICE) {
		 * inst2XsdOptions.setDesign(Inst2XsdOptions.DESIGN_SALAMI_SLICE); }
		 */

		SchemaDocument[] schemaDocuments = Inst2Xsd.inst2xsd( xmlInstances, inst2XsdOptions );

		if ( schemaDocuments != null && schemaDocuments.length > 0 )
		{
			return schemaDocuments[0];
		}

		return null;
	}

	public static boolean isJson( String possibleJson )
	{
		try
		{
			new JSONObject( possibleJson );
		}
		catch ( JSONException e )
		{
			return false;
		}

		try
		{
			new JSONArray( possibleJson );
		}
		catch ( JSONException e )
		{
			return false;
		}

		return true;
	}

	public static String jsonToXml( String json )
	{
		XMLSerializer serializer = new XMLSerializer();
		JSON jsonObj = JSONSerializer.toJSON( json );
		return serializer.write( jsonObj );
	}

	public static String xmlToXsd( String xml )
	{
		String schema = null;
		try
		{
			SchemaDocument schemaDocument = generateSchema( xml );
			schema = getSchema( schemaDocument );
			System.out.println( schema );
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return schema;
	}

	public String objectToJson( Object obj )
	{
		return ( new Gson() ).toJson( obj );
	}

	public static boolean isXml( String inXMLStr )
	{

		boolean retBool = false;
		Pattern pattern;
		Matcher matcher;

		/* REGULAR EXPRESSION TO SEE IF IT AT LEAST STARTS AND ENDS WITH THE SAME ELEMENT */
		final String XML_PATTERN_STR = "<(\\S+?)(.*?)>(.*?)</\\1>";

		/* IF WE HAVE A STRING */
		if ( inXMLStr != null && inXMLStr.trim().length() > 0 )
		{

			// IF WE EVEN RESEMBLE XML
			if ( inXMLStr.trim().startsWith( "<" ) )
			{

				pattern = Pattern.compile( XML_PATTERN_STR, Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE );

				// RETURN TRUE IF IT HAS PASSED BOTH TESTS
				matcher = pattern.matcher( inXMLStr );
				retBool = matcher.matches();
			}
			// ELSE WE ARE FALSE
		}

		return retBool;
	}

	/**
	 * Checks if is ip address.
	 *
	 * @param name the name
	 * @return true, if is ip address
	 */
	public static boolean isIpAddress( final String name )
	{
		/* Reference http://www.mkyong.com/regular-expressions/10-java-regular-expression-examples-you-should-know/ */
		return ( !name.matches( "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$" ) );
	}

	/**
	 * Checks if is name violation on abstract class.
	 *
	 * @param name the name
	 * @return true, if is name violation on abstract class
	 */
	public static boolean isNameViolationOnAbstractClass( final String name )
	{
		return ValidationUtils.isNameViolationOnAbstractClass( name, ValidationUtils.enforceAbstractClassNamePrefix );
	}

	/**
	 * Checks if is name violation on abstract class.
	 *
	 * @param name the name
	 * @param enforceAbstractClassNamePrefix the enforce abstract class name prefix
	 * @return true, if is name violation on abstract class
	 */
	public static boolean isNameViolationOnAbstractClass( final String name, final boolean enforceAbstractClassNamePrefix )
	{
		/* Reference 1: https://code.google.com/p/digr2id/wiki/JavaNamingGuide */
		/* Reference 2: http://checkstyle.sourceforge.net/config_naming.html */
		// Starts with "Abstract" or Ends with "Factory"
		// ^Abstract.+$|^.*Factory$
		return ( enforceAbstractClassNamePrefix ) ? ValidationUtils.isNameViolationOnClass( name ) : ( ValidationUtils.isNameViolationOnClass( name ) || ( !name.matches( "^Abstract.+$|^.*Factory$" ) ) );
	}

	/**
	 * Checks if is name violation on annotation.
	 *
	 * @param name the name
	 * @return true, if is name violation on annotation
	 */
	public static boolean isNameViolationOnAnnotation( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		return ValidationUtils.isNameViolationOnType( name );
	}

	/**
	 * Checks if is name violation on class.
	 *
	 * @param name the name
	 * @return true, if is name violation on class
	 */
	public static boolean isNameViolationOnClass( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		return ValidationUtils.isNameViolationOnType( name );
	}

	/**
	 * Checks if is name violation on constant.
	 *
	 * @param name the name
	 * @return true, if is name violation on constant
	 */
	public static boolean isNameViolationOnConstant( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		// ^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$
		return ( !name.matches( "^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$" ) );

	}

	/**
	 * Checks if is name violation on enumeration.
	 *
	 * @param name the name
	 * @return true, if is name violation on enumeration
	 */
	public static boolean isNameViolationOnEnumeration( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		return ValidationUtils.isNameViolationOnType( name );
	}

	/**
	 * Checks if is name violation on field.
	 *
	 * @param name the name
	 * @return true, if is name violation on field
	 */
	public static boolean isNameViolationOnField( final String name )
	{
		return ValidationUtils.isNameViolationOnMember( name );
	}

	/**
	 * Checks if is name violation on field non static.
	 *
	 * @param name the name
	 * @return true, if is name violation on field non static
	 */
	public static boolean isNameViolationOnFieldNonStatic( final String name )
	{
		return ValidationUtils.isNameViolationOnField( name );
	}

	/**
	 * Checks if is name violation on field static.
	 *
	 * @param name the name
	 * @return true, if is name violation on field static
	 */
	public static boolean isNameViolationOnFieldStatic( final String name )
	{
		return ValidationUtils.isNameViolationOnField( name );
	}

	/**
	 * Checks if is name violation on interface.
	 *
	 * @param name the name
	 * @return true, if is name violation on interface
	 */
	public static boolean isNameViolationOnInterface( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		return ValidationUtils.isNameViolationOnType( name );
	}

	/**
	 * Checks if is name violation on interface type parameter.
	 *
	 * @param name the name
	 * @return true, if is name violation on interface type parameter
	 */
	public static boolean isNameViolationOnInterfaceTypeParameter( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		// ^[A-Z]$
		return ( !name.matches( "^[A-Z]$" ) );
	}

	/**
	 * Checks if is name violation on member.
	 *
	 * @param name the name
	 * @return true, if is name violation on member
	 */
	public static boolean isNameViolationOnMember( final String name )
	{
		/* Reference https://code.google.com/p/digr2id/wiki/JavaNamingGuide */
		// ^[a-z][a-z0-9]*([A-Z][a-z0-9]+|[A-Z]$)*$
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		// ^[a-z][a-zA-Z0-9]*$
		return ( !name.matches( "^[a-z][a-z0-9]*([A-Z][a-z0-9]+|[A-Z]$)*$" ) );
	}

	/**
	 * Checks if is name violation on method.
	 *
	 * @param javaMethod the java method
	 * @param checkSub the check sub
	 * @return true, if is name violation on method
	 */
	public static boolean isNameViolationOnMethod( final MethodSource< JavaClassSource > javaMethod, final boolean checkSub )
	{
		return ValidationUtils.isNameViolationOnMethod( javaMethod.getName() );
	}

	/**
	 * Checks if is name violation on method.
	 *
	 * @param name the name
	 * @return true, if is name violation on method
	 */
	public static boolean isNameViolationOnMethod( final String name )
	{
		return ValidationUtils.isNameViolationOnMember( name );
	}

	/**
	 * Checks if is name violation on method parameter.
	 *
	 * @param name the name
	 * @return true, if is name violation on method parameter
	 */
	public static boolean isNameViolationOnMethodParameter( final String name )
	{
		return ValidationUtils.isNameViolationOnParameter( name );
	}

	/**
	 * Checks if is name violation on method type parameter.
	 *
	 * @param name the name
	 * @return true, if is name violation on method type parameter
	 */
	public static boolean isNameViolationOnMethodTypeParameter( final String name )
	{
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		// ^[A-Z]$
		return ( !name.matches( "^[A-Z]$" ) );
	}

	/**
	 * Checks if is name violation on package.
	 *
	 * @param name the name
	 * @return true, if is name violation on package
	 */
	public static boolean isNameViolationOnPackage( final String name )
	{
		/* Reference https://code.google.com/p/digr2id/wiki/JavaNamingGuide */
		// ^[a-z]+(\.[a-z][a-z0-9]*)*$
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		// ^[a-z]+(\.[a-zA-Z_][a-zA-Z0-9_]*)*$
		return ( !name.matches( "^[a-z]+(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$" ) );
	}

	/**
	 * Checks if is name violation on parameter.
	 *
	 * @param name the name
	 * @return true, if is name violation on parameter
	 */
	public static boolean isNameViolationOnParameter( final String name )
	{
		return ValidationUtils.isNameViolationOnMember( name );
	}

	/**
	 * Checks if is name violation on type.
	 *
	 * @param name the name
	 * @return true, if is name violation on type
	 */
	public static boolean isNameViolationOnType( final String name )
	{
		/* Reference 1: https://code.google.com/p/digr2id/wiki/JavaNamingGuide */
		// ^[A-Z][a-z0-9]+([A-Z][a-z0-9]+|[A-Z]$)*$
		/* Reference http://checkstyle.sourceforge.net/config_naming.html */
		// ^[A-Z][a-zA-Z0-9]*$
		return ( !name.matches( "^[A-Z][a-zA-Z0-9]*$" ) );
	}

	/**
	 * Checks if is name violation on type parameter.
	 *
	 * @param name the name
	 * @return true, if is name violation on type parameter
	 */
	public static boolean isNameViolationOnTypeParameter( final String name )
	{
		/* Reference 1: https://code.google.com/p/digr2id/wiki/JavaNamingGuide */
		/* Reference 2: http://checkstyle.sourceforge.net/config_naming.html */
		// Regular Expression: ^[A-Z]$
		return ( !name.matches( "^[A-Z]$" ) );
	}

	/**
	 * Checks if is name violation on variable.
	 *
	 * @param name the name
	 * @return true, if is name violation on variable
	 */
	public static boolean isNameViolationOnVariable( final String name )
	{
		return ValidationUtils.isNameViolationOnMember( name );
	}

	/**
	 * Checks if is name violation on variable local.
	 *
	 * @param name the name
	 * @return true, if is name violation on variable local
	 */
	public static boolean isNameViolationOnVariableLocal( final String name )
	{
		return ValidationUtils.isNameViolationOnVariable( name );
	}

	/**
	 * Checks if is name violation on variable local final.
	 *
	 * @param name the name
	 * @return true, if is name violation on variable local final
	 */
	public static boolean isNameViolationOnVariableLocalFinal( final String name )
	{
		return ValidationUtils.isNameViolationOnVariableLocal( name );
	}

	/**
	 * Checks if is name violation on variable local non final.
	 *
	 * @param name the name
	 * @return true, if is name violation on variable local non final
	 */
	public static boolean isNameViolationOnVariableLocalNonFinal( final String name )
	{
		return ValidationUtils.isNameViolationOnVariableLocal( name );
	}

}
