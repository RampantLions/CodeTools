/* @(#)ApiModel.java Sep 14, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.restbuilder.generators.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.MethodSource;

import io.github.rampantlions.codetools.ModelGenUtils;

/**
 * The Class ApiModel.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class ApiModel
{

	/** The Constant JSON_ELEMENT_CLASS. */
	public static final String JSON_ELEMENT_CLASS = "com.google.gson.JsonElement";

	/** The documentation. */
	protected String documentation;

	/** The enums. */
	protected List< String > enums = new ArrayList<>();;

	/** The form url encoded. */
	// TODO
	protected boolean formUrlEncoded = false;

	/** The header. */
	// TODO
	protected boolean header = false;

	/** The http method. */
	protected String httpMethod = "GET";

	/** The multiple. */
	protected boolean multiple = false;

	/** The name. */
	protected String name;

	/** The parameters. */
	protected List< ParameterModel > parameters = new ArrayList<>();;

	/** The path. */
	protected String path;

	/** The response codes. */
	// http://blog.robinchutaux.com/blog/a-smart-way-to-use-retrofit/
	protected Map< String, String > responseCodes;

	/** The return type. */
	protected String returnType = JSON_ELEMENT_CLASS; //

	/** The serial name. */
	protected String serialName;

	/**
	 * Generate retrofit api.
	 *
	 * @param modelApiInterface the model api interface
	 * @param returnJsonElement the return json element
	 * @param singleIfMultiple the single if multiple
	 */
	public void generateRetrofitApi( JavaInterfaceSource modelApiInterface, boolean returnJsonElement, boolean singleIfMultiple )
	{
		MethodSource< JavaInterfaceSource > method = modelApiInterface.addMethod().setName( name );
		if ( returnJsonElement )
		{
			if ( returnType.equals( JSON_ELEMENT_CLASS ) )
			{
				method.setReturnType( returnType );
			}
			else
			{
				if ( multiple )
				{
					method.setReturnType( returnType );
				}
				else
				{
					method.setReturnType( "java.util.List< " + returnType + " >" );
				}
			}
		}
		else
		{
			method.setReturnType( JSON_ELEMENT_CLASS );
		}

		switch ( httpMethod.trim().toUpperCase() )
		{
			case "GET":
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( method, retrofit.http.GET.class ), path, true, false, false );
				break;
			case "DELETE":
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( method, retrofit.http.DELETE.class ), path, true, false, false );
				break;
			case "POST":
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( method, retrofit.http.POST.class ), path, true, false, false );
				break;
			case "PUT":
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( method, retrofit.http.PUT.class ), path, true, false, false );
				break;
			case "PATCH":
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( method, retrofit.http.PATCH.class ), path, true, false, false );
				break;
			case "HEAD":
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( method, retrofit.http.HEAD.class ), path, true, false, false );
				break;
			default:
				// Throw Exception Here!
				break;
		}

		for ( ParameterModel parameter : parameters )
		{
			parameter.generateRetrofitApiParameter( modelApiInterface, method, false );
			if ( singleIfMultiple )
			{
				parameter.generateRetrofitApiParameter( modelApiInterface, method, true );
			}
		}

	}

	/**
	 * Gets the documentation.
	 *
	 * @return the documentation
	 */
	public String getDocumentation()
	{
		return documentation;
	}

	/**
	 * Gets the enums.
	 *
	 * @return the enums
	 */
	public List< String > getEnums()
	{
		return enums;
	}

	/**
	 * Gets the http method.
	 *
	 * @return the http method
	 */
	public String getHttpMethod()
	{
		return httpMethod;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public List< ParameterModel > getParameters()
	{
		return parameters;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath()
	{
		return path;
	}

	/**
	 * Gets the response codes.
	 *
	 * @return the response codes
	 */
	public Map< String, String > getResponseCodes()
	{
		return responseCodes;
	}

	/**
	 * Gets the return type.
	 *
	 * @return the return type
	 */
	public String getReturnType()
	{
		return returnType;
	}

	/**
	 * Gets the serial name.
	 *
	 * @return the serial name
	 */
	public String getSerialName()
	{
		return serialName;
	}

	/**
	 * Checks if is form url encoded.
	 *
	 * @return true, if is form url encoded
	 */
	public boolean isFormUrlEncoded()
	{
		return formUrlEncoded;
	}

	/**
	 * Checks if is header.
	 *
	 * @return true, if is header
	 */
	public boolean isHeader()
	{
		return header;
	}

	/**
	 * Checks if is multiple.
	 *
	 * @return true, if is multiple
	 */
	public boolean isMultiple()
	{
		return multiple;
	}

	/**
	 * Sets the documentation.
	 *
	 * @param documentation the new documentation
	 */
	public void setDocumentation( String documentation )
	{
		this.documentation = documentation;
	}

	/**
	 * Sets the enums.
	 *
	 * @param enums the new enums
	 */
	public void setEnums( List< String > enums )
	{
		this.enums = enums;
	}

	/**
	 * Sets the form url encoded.
	 *
	 * @param formUrlEncoded the new form url encoded
	 */
	public void setFormUrlEncoded( boolean formUrlEncoded )
	{
		this.formUrlEncoded = formUrlEncoded;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the new header
	 */
	public void setHeader( boolean header )
	{
		this.header = header;
	}

	/**
	 * Sets the http method.
	 *
	 * @param httpMethod the new http method
	 */
	public void setHttpMethod( String httpMethod )
	{
		this.httpMethod = httpMethod;
	}

	/**
	 * Sets the multiple.
	 *
	 * @param multiple the new multiple
	 */
	public void setMultiple( boolean multiple )
	{
		this.multiple = multiple;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName( String name )
	{
		this.name = name;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters the new parameters
	 */
	public void setParameters( List< ParameterModel > parameters )
	{
		this.parameters = parameters;
	}

	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath( String path )
	{
		this.path = path;
	}

	/**
	 * Sets the response codes.
	 *
	 * @param responseCodes the response codes
	 */
	public void setResponseCodes( Map< String, String > responseCodes )
	{
		this.responseCodes = responseCodes;
	}

	/**
	 * Sets the return type.
	 *
	 * @param returnType the new return type
	 */
	public void setReturnType( String returnType )
	{
		this.returnType = returnType;
	}

	/**
	 * Sets the serial name.
	 *
	 * @param serialName the new serial name
	 */
	public void setSerialName( String serialName )
	{
		this.serialName = serialName;
	}

}
