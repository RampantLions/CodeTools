/* @(#)Property.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Property.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@javax.xml.bind.annotation.XmlSeeAlso( io.github.rampantlions.codetools.CommonModel.class )
@javax.xml.bind.annotation.XmlRootElement( name = "Property" )
@javax.xml.bind.annotation.XmlAccessorType( javax.xml.bind.annotation.XmlAccessType.FIELD )
@javax.xml.bind.annotation.XmlType( propOrder = { "required", "type", "items" } )
@org.codehaus.jackson.map.annotate.JsonSerialize( include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL )
@org.codehaus.jackson.annotate.JsonPropertyOrder( { "additionalProperties", "enums", "format", "items", "ref", "required", "type" } )
@com.fasterxml.jackson.annotation.JsonInclude( com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL )
@com.fasterxml.jackson.annotation.JsonPropertyOrder( { "additionalProperties", "enums", "format", "items", "ref", "required", "type" } )
@com.wordnik.swagger.annotations.ApiModel( value = "Property11", description = "ResourceListing12 Property11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class )
@javax.persistence.Entity( name = "Swagger11_Property11" )
@javax.persistence.Table( name = "Swagger11_Property11", uniqueConstraints = @javax.persistence.UniqueConstraint( columnNames = { "Hibernate__ID" } ) )
@javax.persistence.NamedQueries( { @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property.all", query = "SELECT a FROM Property a" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property.id__", query = "SELECT a FROM Property a WHERE a.id__ = :id__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property.version__", query = "SELECT a FROM Property a WHERE a.version__ = :version__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property.required", query = "SELECT a FROM Property a WHERE a.required = :required" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property.type", query = "SELECT a FROM Property a WHERE a.type = :type" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.all", query = "SELECT a FROM Property11 a" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.id__", query = "SELECT a FROM Property11 a WHERE a.id__ = :id__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.version__", query = "SELECT a FROM Property11 a WHERE a.version__ = :version__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.format", query = "SELECT a FROM Property11 a WHERE a.format = :format" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.ref", query = "SELECT a FROM Property11 a WHERE a.ref = :ref" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.required", query = "SELECT a FROM Property11 a WHERE a.required = :required" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Property11.type", query = "SELECT a FROM Property11 a WHERE a.type = :type" ) } )
public class Property11 extends CommonModel< Property11 >
{
	/** The additional properties. */
	@org.codehaus.jackson.annotate.JsonProperty( "additionalProperties" )
	@com.fasterxml.jackson.annotation.JsonProperty( "additionalProperties" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "additionalProperties" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "additionalProperties entry.", notes = " ", required = true )
	@javax.validation.Valid
	@javax.persistence.OneToMany( mappedBy = "property11__href" )
	@javax.persistence.OrderColumn( name = "additionalProperties_index" )
	List< Property11 > additionalProperties = new ArrayList<>();

	/** The enums. */
	@org.codehaus.jackson.annotate.JsonProperty( "enums" )
	@com.fasterxml.jackson.annotation.JsonProperty( "enums" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "enums" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "enums entry.", notes = " ", required = true )
	@javax.validation.Valid
	@javax.persistence.ElementCollection( fetch = javax.persistence.FetchType.LAZY )
	@javax.persistence.Column( name = "enums" )
	@javax.persistence.CollectionTable( name = "Swagger11_Property11_enums", joinColumns = { @javax.persistence.JoinColumn( name = "enums_id" ) } )
	@javax.persistence.MapKeyColumn( name = "map_id" )
	Map< Integer, String > enums = new java.util.HashMap<>();

	/** The format. */
	@org.codehaus.jackson.annotate.JsonProperty( "format" )
	@com.fasterxml.jackson.annotation.JsonProperty( "format" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "format" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "format entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "format" )
	String format;

	/** The items. */
	@org.codehaus.jackson.annotate.JsonProperty( "items" )
	@com.fasterxml.jackson.annotation.JsonProperty( "items" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "items" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "items entry.", notes = " ", required = true )
	@javax.validation.Valid
	@javax.persistence.OneToMany( mappedBy = "property11__href" )
	@javax.persistence.OrderColumn( name = "items_index" )
	List< Item11 > items = new ArrayList<>();

	/** The ref. */
	@org.codehaus.jackson.annotate.JsonProperty( "$ref" )
	@com.fasterxml.jackson.annotation.JsonProperty( "$ref" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "$ref" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "$ref entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "ref" )
	protected String ref;

	/** The required. */
	@org.codehaus.jackson.annotate.JsonProperty( "required" )
	@com.fasterxml.jackson.annotation.JsonProperty( "required" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "required" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "required entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "required" )
	@org.hibernate.annotations.Type( type = "true_false" )
	boolean required;

	/** The type. */
	@org.codehaus.jackson.annotate.JsonProperty( "type" )
	@com.fasterxml.jackson.annotation.JsonProperty( "type" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "type" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "type entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "type" )
	String type;

	public List< Property11 > getAdditionalProps()
	{
		return additionalProperties;
	}

	public Property11 setAdditionalProps( List< Property11 > additionalProperties )
	{
		this.additionalProperties = additionalProperties;
		return this;
	}

	public Map< Integer, String > getEnums()
	{
		return enums;
	}

	public Property11 setEnums( Map< Integer, String > enums )
	{
		this.enums = enums;
		return this;
	}

	public String getFormat()
	{
		return format;
	}

	public Property11 setFormat( String format )
	{
		this.format = format;
		return this;
	}

	public List< Item11 > getItems()
	{
		return items;
	}

	public Property11 setItems( List< Item11 > items )
	{
		this.items = items;
		return this;
	}

	public String getRef()
	{
		return ref;
	}

	public Property11 setRef( String ref )
	{
		this.ref = ref;
		return this;
	}

	public boolean getRequired()
	{
		return required;
	}

	public Property11 setRequired( boolean required )
	{
		this.required = required;
		return this;
	}

	public String getType()
	{
		return type;
	}

	public Property11 setType( String type )
	{
		this.type = type;
		return this;
	}
}
