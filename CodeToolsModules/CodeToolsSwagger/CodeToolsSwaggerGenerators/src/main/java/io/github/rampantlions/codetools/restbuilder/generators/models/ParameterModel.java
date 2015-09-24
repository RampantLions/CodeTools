/* @(#)ParameterModel.java Sep 14, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.restbuilder.generators.models;

import java.util.ArrayList;
import java.util.List;

import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.jboss.forge.roaster.model.source.ParameterSource;

import io.github.rampantlions.codetools.ModelGenUtils;


/**
 * The Class ParameterModel.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class ParameterModel
{

	/** The data type. */
	protected String dataType;

	/** The documentation. */
	protected String documentation;

	/** The enums. */
	protected List< String > enums = new ArrayList<>();

	/** The multiple. */
	protected boolean multiple = false;

	/** The name. */
	protected String name;

	/** The serial name. */
	protected String serialName;

	/** The type. */
	protected String type = "QUERY";

	/**
	 * Generate retrofit api.
	 *
	 * @param modelApiInterface the model api interface
	 * @param method the method
	 * @param createAsSingleIfMultiple the create as single if multiple
	 */
	public void generateRetrofitApiParameter( JavaInterfaceSource modelApiInterface, MethodSource< JavaInterfaceSource > method, boolean createAsSingleIfMultiple )
	{
		ParameterSource< JavaInterfaceSource > methodParameter = null;

		if ( type.trim().equalsIgnoreCase( "BODY" ) )
		{
			methodParameter = method.addParameter( "retrofit.mime.TypedInput", name );
			ModelGenUtils.addImport( method.getOrigin(), retrofit.mime.TypedInput.class );
		}
		else
		{
			if ( ( multiple ) && ( !createAsSingleIfMultiple ) )
			{
				methodParameter = method.addParameter( "java.util.List< " + dataType + " >", name );
			}
			else if ( ( multiple ) && ( createAsSingleIfMultiple ) )
			{
				methodParameter = method.addParameter( dataType, name );
			}
			else if ( !createAsSingleIfMultiple )
			{
				methodParameter = method.addParameter( dataType, name );
			}
		}

		switch ( type.trim().toUpperCase() )
		{
			case "PATH":
			{
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( methodParameter, retrofit.http.Path.class ), ( ( serialName == null ) ? name : serialName ), true, false, false );
			}
				break;
			case "QUERY":
			{
				ModelGenUtils.setAnnotationValue( ModelGenUtils.addAnnotation( methodParameter, retrofit.http.Query.class ), ( ( serialName == null ) ? name : serialName ), true, false, false );
			}
				break;
			case "BODY":
			{
				ModelGenUtils.addAnnotation( methodParameter, retrofit.http.Body.class );
			}
				break;
			default:
				// Throw Exception Here!
				break;
		}
	}

	/**
	 * Gets the data type.
	 *
	 * @return the data type
	 */
	public String getDataType()
	{
		return dataType;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
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
	 * Sets the data type.
	 *
	 * @param dataType the new data type
	 */
	public void setDataType( String dataType )
	{
		this.dataType = dataType;
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
	 * Sets the serial name.
	 *
	 * @param serialName the new serial name
	 */
	public void setSerialName( String serialName )
	{
		this.serialName = serialName;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType( String type )
	{
		this.type = type;
	}

}
