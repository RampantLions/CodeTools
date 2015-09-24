/* @(#)Parameters11.java Sep 16, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Parameters11.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@org.codehaus.jackson.map.annotate.JsonSerialize( include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL )
@org.codehaus.jackson.annotate.JsonPropertyOrder( { "parameter", "allowMultiple" } )
@com.fasterxml.jackson.annotation.JsonInclude( com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL )
@com.fasterxml.jackson.annotation.JsonPropertyOrder( { "parameter", "allowMultiple" } )
@com.wordnik.swagger.annotations.ApiModel( value = "Parameters11", description = "ResourceListing12 Parameters11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class )
@javax.persistence.Entity( name = "Swagger11_Parameters11" )
@javax.persistence.Table( name = "Swagger11_Parameters11", uniqueConstraints = @javax.persistence.UniqueConstraint( columnNames = { "Hibernate__ID" } ) )
@javax.persistence.NamedQueries( { @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameters11.all", query = "SELECT a FROM Parameters11 a" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameters11.id__", query = "SELECT a FROM Parameters11 a WHERE a.id__ = :id__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameters11.version__", query = "SELECT a FROM Parameters11 a WHERE a.version__ = :version__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameters11.allowMultiple", query = "SELECT a FROM Parameters11 a WHERE a.allowMultiple = :allowMultiple" ) } )
public class Parameters11 extends CommonModel< Parameters11 >
{

	/** The parameter. */
	@org.codehaus.jackson.annotate.JsonProperty( "parameter" )
	@com.fasterxml.jackson.annotation.JsonProperty( "parameter" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "parameter" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "parameter entry.", notes = " ", required = true )
	@javax.validation.Valid
	@javax.persistence.OneToMany( mappedBy = "parameters11__href" )
	@javax.persistence.OrderColumn( name = "parameter_index" )
	List< Parameter11 > parameter = new java.util.ArrayList<>();

	/** The allow multiple. */
	@org.codehaus.jackson.annotate.JsonProperty( "allowMultiple" )
	@com.fasterxml.jackson.annotation.JsonProperty( "allowMultiple" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "allowMultiple" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "allowMultiple entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "allowMultiple" )
	@org.hibernate.annotations.Type( type = "true_false" )
	boolean allowMultiple;

	public static class Parameters11TypeAdapter implements JsonDeserializer< Parameters11 >
	{
		public Parameters11 deserialize( JsonElement json, Type typeOfT, JsonDeserializationContext ctx )
		{
			Parameters11 vals = new Parameters11();

			if ( json.isJsonArray() )
			{
				for ( JsonElement entry : json.getAsJsonArray() )
				{
					if ( entry.isJsonPrimitive() )
					{
						for ( Map.Entry< String, JsonElement > namedEntry : json.getAsJsonObject().entrySet() )
						{
							if ( namedEntry.getKey().equals( "allowMultiple" ) )
							{
								entry.getAsJsonPrimitive().getAsBoolean();
							}
						}
					}
					else if ( entry.isJsonObject() )
					{
						vals.getParameter().add( (Parameter11) ctx.deserialize( entry, Parameter11.class ) );
					}
				}
			}
			else
			{
				throw new RuntimeException( "Unexpected JSON type: " + json.getClass() );
			}
			return vals;
		}
	}

	public List< Parameter11 > getParameter()
	{
		return parameter;
	}

	public Parameters11 setParameter( List< Parameter11 > parameter )
	{
		this.parameter = parameter;
		return this;
	}

	public boolean getAllowMultiple()
	{
		return allowMultiple;
	}

	public Parameters11 setAllowMultiple( boolean allowMultiple )
	{
		this.allowMultiple = allowMultiple;
		return this;
	}
}
