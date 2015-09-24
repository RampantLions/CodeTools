/* @(#)Swagger.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.models;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Swagger.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@javax.xml.bind.annotation.XmlSeeAlso( io.github.rampantlions.codetools.CommonModel.class )
@javax.xml.bind.annotation.XmlRootElement( name = "Swagger" )
@javax.xml.bind.annotation.XmlAccessorType( javax.xml.bind.annotation.XmlAccessType.FIELD )
@javax.xml.bind.annotation.XmlType( propOrder = { "apiVersion", "basePath", "swaggerVersion" } )
@org.codehaus.jackson.map.annotate.JsonSerialize( include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL )
@org.codehaus.jackson.annotate.JsonPropertyOrder( { "apiVersion", "basePath", "swaggerVersion" } )
@com.fasterxml.jackson.annotation.JsonInclude( com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL )
@com.fasterxml.jackson.annotation.JsonPropertyOrder( { "apiVersion", "basePath", "swaggerVersion" } )
@com.wordnik.swagger.annotations.ApiModel( value = "Swagger", description = "ResourceListing12 Swagger model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class )
@javax.persistence.Entity
@javax.persistence.Table( name = "Swagger_Swagger", uniqueConstraints = @javax.persistence.UniqueConstraint( columnNames = { "Hibernate__ID" } ) )
@javax.persistence.NamedQueries( { @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Swagger.all", query = "SELECT a FROM Swagger a" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Swagger.id__", query = "SELECT a FROM Swagger a WHERE a.id__ = :id__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Swagger.version__", query = "SELECT a FROM Swagger a WHERE a.version__ = :version__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Swagger.apiVersion", query = "SELECT a FROM Swagger a WHERE a.apiVersion = :apiVersion" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Swagger.swaggerVersion", query = "SELECT a FROM Swagger a WHERE a.swaggerVersion = :swaggerVersion" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Swagger.basePath", query = "SELECT a FROM Swagger a WHERE a.basePath = :basePath" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.models.Swagger.all", query = "SELECT a FROM Swagger a" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.models.Swagger.id__", query = "SELECT a FROM Swagger a WHERE a.id__ = :id__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.models.Swagger.version__", query = "SELECT a FROM Swagger a WHERE a.version__ = :version__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.models.Swagger.apiVersion", query = "SELECT a FROM Swagger a WHERE a.apiVersion = :apiVersion" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.models.Swagger.basePath", query = "SELECT a FROM Swagger a WHERE a.basePath = :basePath" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.models.Swagger.swaggerVersion", query = "SELECT a FROM Swagger a WHERE a.swaggerVersion = :swaggerVersion" ) } )
public class Swagger extends CommonModel< Swagger >
{
	/** The api version. */
	@javax.xml.bind.annotation.XmlAttribute( name = "apiVersion" )
	@org.codehaus.jackson.annotate.JsonProperty( "apiVersion" )
	@com.fasterxml.jackson.annotation.JsonProperty( "apiVersion" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "apiVersion" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "apiVersion entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "apiVersion" )
	String apiVersion;

	/** The base path. */
	@javax.xml.bind.annotation.XmlAttribute( name = "basePath" )
	@org.codehaus.jackson.annotate.JsonProperty( "basePath" )
	@com.fasterxml.jackson.annotation.JsonProperty( "basePath" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "basePath" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "basePath entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "basePath" )
	String basePath;

	/** The swagger version. */
	@javax.xml.bind.annotation.XmlAttribute( name = "swaggerVersion" )
	@org.codehaus.jackson.annotate.JsonProperty( "swaggerVersion" )
	@com.fasterxml.jackson.annotation.JsonProperty( "swaggerVersion" )
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName( "swaggerVersion" )
	@com.wordnik.swagger.annotations.ApiModelProperty( value = "swaggerVersion entry.", notes = " ", required = true )
	@javax.persistence.Column( name = "swaggerVersion" )
	String swaggerVersion;

	public boolean equals( final Object other )
	{
		return org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals( this, other );
	}

	public String getApiVersion()
	{
		return apiVersion;
	}

	public String getBasePath()
	{
		return basePath;
	}

	public String getSwaggerVersion()
	{
		return swaggerVersion;
	}

	public int hashCode()
	{
		return org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode( this );
	}

	public Swagger setApiVersion( final String apiVersion )
	{
		this.apiVersion = apiVersion;
		return this;
	}

	public Swagger setBasePath( final String basePath )
	{
		this.basePath = basePath;
		return this;
	}

	public Swagger setSwaggerVersion( final String swaggerVersion )
	{
		this.swaggerVersion = swaggerVersion;
		return this;
	}

	@javax.ws.rs.Produces( "text/plain" )
	public String toString()
	{
		return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString( this );
	}
}
