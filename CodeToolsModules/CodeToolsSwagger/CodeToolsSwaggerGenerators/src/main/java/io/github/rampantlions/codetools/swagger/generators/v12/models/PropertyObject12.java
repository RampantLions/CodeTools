/* @(#)Property.java Sep 11, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.ArrayList;
import java.util.List;

import io.github.rampantlions.codetools.annotations.Recommended;
import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.annotations.RequiredIf;
import io.github.rampantlions.codetools.annotations.Validity;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Property.
 * A Property Object holds the definition of a new property for a model.
 *
 * This object includes the Data Type Fields in order to describe the type of this property. The $ref field MUST be used when linking to other models.
 *
 * Properties MUST NOT contain other properties. If there's a need for an internal object hierarchy, additional models MUST be created and linked to a flat structure.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#529-property-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "defaultValue",
		"description", "enums", "format", "items", "maximum", "minimum", "ref",
		"type", "uniqueItems" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "defaultValue",
		"description", "enums", "format", "items", "maximum", "minimum", "ref",
		"type", "uniqueItems" })
@com.wordnik.swagger.annotations.ApiModel(value = "PropertyObject12", description = "ResourceListing12 PropertyObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_PropertyObject12")
@javax.persistence.Table(name = "Swagger12_PropertyObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.all", query = "SELECT a FROM PropertyObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.id__", query = "SELECT a FROM PropertyObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.version__", query = "SELECT a FROM PropertyObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.defaultValue", query = "SELECT a FROM PropertyObject12 a WHERE a.defaultValue = :defaultValue"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.description", query = "SELECT a FROM PropertyObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.format", query = "SELECT a FROM PropertyObject12 a WHERE a.format = :format"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.maximum", query = "SELECT a FROM PropertyObject12 a WHERE a.maximum = :maximum"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.minimum", query = "SELECT a FROM PropertyObject12 a WHERE a.minimum = :minimum"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.ref", query = "SELECT a FROM PropertyObject12 a WHERE a.ref = :ref"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.type", query = "SELECT a FROM PropertyObject12 a WHERE a.type = :type"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.PropertyObject12.uniqueItems", query = "SELECT a FROM PropertyObject12 a WHERE a.uniqueItems = :uniqueItems") })
public class PropertyObject12 extends CommonModel< ParameterObject12 >
{

	/**
	 * The default value.
	 * The default value to be used for the field. The value type MUST conform with the primitive's type value.
	 */
	@Validity( "primitive" )
	@org.codehaus.jackson.annotate.JsonProperty("defaultValue")
	@com.fasterxml.jackson.annotation.JsonProperty("defaultValue")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("defaultValue")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "defaultValue entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "defaultValue")
	protected Object defaultValue;

	/**
	 * The description.
	 * Recommended. A brief description of this property.
	 */
	@Recommended
	@org.codehaus.jackson.annotate.JsonProperty("description")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("description")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "description entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "description")
	String description;

	/**
	 * The enum.
	 * A fixed list of possible values. If this field is used in conjunction with the defaultValue field,
	 * then the default value MUST be one of the values defined in the enum.
	 */
	@Validity( "string" )
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("enums")
	@com.fasterxml.jackson.annotation.JsonProperty("enums")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("enums")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "enums entry.", notes = " ", required = true)
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_PropertyObject12_enums")
	@javax.persistence.Column(name = "enums")
	@javax.persistence.OrderColumn(name = "enums_index")
	protected List< String > enums = new java.util.ArrayList<>();

	/**
	 * The format.
	 * Fine-tuned primitive type definition. See Primitives for further information.
	 * The value MUST be one that is defined under Primitives, corresponding to the right primitive type.
	 */
	@Validity( "primitive" )
	@org.codehaus.jackson.annotate.JsonProperty("format")
	@com.fasterxml.jackson.annotation.JsonProperty("format")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("format")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "format entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "format")
	protected String format;

	/**
	 * The items.
	 * Required. The type definition of the values in the container. A container MUST NOT be nested in another
	 * container.
	 */
	@Validity( "array" )
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("items")
	@com.fasterxml.jackson.annotation.JsonProperty("items")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("items")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "items entry.", notes = " ", required = true)
	@javax.persistence.OneToMany(mappedBy = "propertyObject12__href")
	@javax.persistence.OrderColumn(name = "items_index")
	protected List< ItemObject12 > items = new ArrayList<>();

	/**
	 * The maximum.
	 * The maximum valid value for the type, inclusive. If this field is used in conjunction with the defaultValue
	 * field, then the default value MUST be lower than or equal to this value. The value type is string and should
	 * represent the maximum numeric value. Note: This will change to a numeric value in the future.
	 */
	@Validity( "number, integer" )
	@org.codehaus.jackson.annotate.JsonProperty("maximum")
	@com.fasterxml.jackson.annotation.JsonProperty("maximum")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("maximum")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "maximum entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "maximum")
	protected String maximum;

	/**
	 * The minimum.
	 * The minimum valid value for the type, inclusive. If this field is used in conjunction with the defaultValue
	 * field, then the default value MUST be higher than or equal to this value. The value type is string and should
	 * represent the minimum numeric value. Note: This will change to a numeric value in the future.
	 */
	@Validity( "number, integer" )
	@org.codehaus.jackson.annotate.JsonProperty("minimum")
	@com.fasterxml.jackson.annotation.JsonProperty("minimum")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("minimum")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "minimum entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "minimum")
	protected String minimum;

	/**
	 * The $ref.
	 * Required (if type is not used). The Model to be used. The value MUST be a model's id.
	 */
	@RequiredIf( "if type is not used" )
	@Validity( "Any" )
	@org.codehaus.jackson.annotate.JsonProperty("ref")
	@com.fasterxml.jackson.annotation.JsonProperty("ref")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("ref")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "ref entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "ref")
	protected String ref;

	/**
	 * The type.
	 * Required (if $ref is not used). The return type of the operation. The value MUST be
	 * one of the Primitives, array or a model's id.
	 */
	@RequiredIf( "if $ref is not used" )
	@Validity( "Any" )
	@org.codehaus.jackson.annotate.JsonProperty("type")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("type")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "type entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "type")
	protected String type;

	/**
	 * The unique items.
	 * A flag to note whether the container allows duplicate values or not. If the value is set to true,
	 * then the array acts as a set.
	 */
	@Validity( "array" )
	@org.codehaus.jackson.annotate.JsonProperty("uniqueItems")
	@com.fasterxml.jackson.annotation.JsonProperty("uniqueItems")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("uniqueItems")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "uniqueItems entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "uniqueItems")
	@org.hibernate.annotations.Type(type = "true_false")
	boolean uniqueItems;

	public Object getDefaultValue()
	{
		return defaultValue;
	}

	public PropertyObject12 setDefaultValue( Object defaultValue )
	{
		this.defaultValue = defaultValue;
		return this;
	}

	public String getDescription()
	{
		return description;
	}

	public PropertyObject12 setDescription( String description )
	{
		this.description = description;
		return this;
	}

	public List< String > getEnums()
	{
		return enums;
	}

	public PropertyObject12 setEnums( List< String > enums )
	{
		this.enums = enums;
		return this;
	}

	public String getFormat()
	{
		return format;
	}

	public PropertyObject12 setFormat( String format )
	{
		this.format = format;
		return this;
	}

	public List< ItemObject12 > getItems()
	{
		return items;
	}

	public PropertyObject12 setItems( List< ItemObject12 > items )
	{
		this.items = items;
		return this;
	}

	public String getMaximum()
	{
		return maximum;
	}

	public PropertyObject12 setMaximum( String maximum )
	{
		this.maximum = maximum;
		return this;
	}

	public String getMinimum()
	{
		return minimum;
	}

	public PropertyObject12 setMinimum( String minimum )
	{
		this.minimum = minimum;
		return this;
	}

	public String getRef()
	{
		return ref;
	}

	public PropertyObject12 setRef( String ref )
	{
		this.ref = ref;
		return this;
	}

	public String getType()
	{
		return type;
	}

	public PropertyObject12 setType( String type )
	{
		this.type = type;
		return this;
	}

	public boolean getUniqueItems()
	{
		return uniqueItems;
	}

	public PropertyObject12 setUniqueItems( boolean uniqueItems )
	{
		this.uniqueItems = uniqueItems;
		return this;
	}
}
