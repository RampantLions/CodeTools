/* @(#)ModelModel.java Sep 14, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.restbuilder.generators.models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import io.github.rampantlions.codetools.ModelGenUtils;

/**
 * The Class ModelModel.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class ModelModel
{

	/** The data type. */
	protected String dataType;

	/** The documentation. */
	protected String documentation;

	/** The enums. */
	protected List< String > enums = new ArrayList<>();

	/** The fields. */
	protected Set< FieldModel > fields = new HashSet<>();

	/** The multiple. */
	protected boolean multiple = false;;

	/** The name. */
	protected String name;

	/** The serial name. */
	protected String serialName;

	/**
	 * Generate retrofit model.
	 * @throws IOException 
	 */
	public void generateRetrofitModel( JavaClassSource modelClass, File modelFolder ) throws IOException
	{
		for ( FieldModel fieldModel : fields )
		{
			if ( !ModelGenUtils.hasField( modelClass, fieldModel.getName() ) ) // , ( ( fieldModel.isMultiple() ) ? fieldModel.getDataType() : "java.util.List< " + fieldModel.getDataType() + " >" )
			{

				if ( fieldModel.getDataType().startsWith( modelClass.getPackage() + "." ) )
				{
					String[] split = fieldModel.getDataType().split( Pattern.quote( "." ) );
					ModelGenUtils.getOrCreateClass( modelClass.getPackage(), split[split.length - 1], modelFolder );
				}

				FieldSource< JavaClassSource > field = modelClass.addField().setName( fieldModel.getName() );
				field.setProtected();

				if ( fieldModel.isMultiple() )
				{
					if ( ( !fieldModel.getDataType().contains( "." ) ) && Character.isLowerCase( fieldModel.getDataType().charAt( 0 ) ) )
					{
						switch ( fieldModel.getDataType() )
						{
							case "int":
								field.setType( "java.util.List< java.util.Integer >" );
							default:
								field.setType( "java.util.List< " + "java.util." + StringUtils.capitalize( fieldModel.getDataType() ) + " >" );
								break;
						}
					}
					else
					{
						field.setType( "java.util.List< " + fieldModel.getDataType() + " >" );
					}
				}
				else
				{
					field.setType( fieldModel.getDataType() );
				}
			}
		}
	}

	@Override
	public String toString()
	{
		return "ModelModel [dataType=" + dataType + ", documentation=" + documentation + ", enums=" + enums + ", fields=" + fields + ", multiple=" + multiple + ", name=" + name + ", serialName=" + serialName + "]";
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
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public Set< FieldModel > getFields()
	{
		return fields;
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
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	public void setFields( Set< FieldModel > fields )
	{
		this.fields = fields;
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

}
