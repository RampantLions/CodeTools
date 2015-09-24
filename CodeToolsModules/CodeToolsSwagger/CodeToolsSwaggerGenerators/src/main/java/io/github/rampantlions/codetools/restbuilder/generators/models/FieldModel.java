/* @(#)FieldModel.java Sep 14, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.restbuilder.generators.models;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class FieldModel.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
public class FieldModel
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

	@Override
	public String toString()
	{
		return "FieldModel [dataType=" + dataType + ", documentation=" + documentation + ", enums=" + enums + ", multiple=" + multiple + ", name=" + name + ", serialName=" + serialName + "]";
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
		switch ( name )
		{
			case "class":
				this.name = "clazz";
				break;
			case "package":
				this.name = "pkg";
				break;
			default:
				this.name = name;
				break;
		}
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
