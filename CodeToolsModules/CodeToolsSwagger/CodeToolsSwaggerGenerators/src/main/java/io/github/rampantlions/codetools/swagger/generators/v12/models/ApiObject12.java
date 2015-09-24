/* @(#)ApiObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.annotations.Recommended;
import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class ApiObject12.
 * The API Object describes one or more operations on a single path. In the apis array,
 * there MUST be only one API Object per path.
 *
 * Path: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#apiPath
 * Apis: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#adApis
 * API Object: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#522-api-object
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#522-api-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "description", "operations",
		"path" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "description",
		"operations", "path" })
@com.wordnik.swagger.annotations.ApiModel(value = "ApiObject12", description = "ResourceListing12 ApiObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ApiObject12")
@javax.persistence.Table(name = "Swagger12_ApiObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiObject12.all", query = "SELECT a FROM ApiObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiObject12.id__", query = "SELECT a FROM ApiObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiObject12.version__", query = "SELECT a FROM ApiObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiObject12.description", query = "SELECT a FROM ApiObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiObject12.path", query = "SELECT a FROM ApiObject12 a WHERE a.path = :path") })
public class ApiObject12 extends CommonModel< ApiObject12 >
{

	/**
	 * The description.
	 * Recommended. A short description of the resource.
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
	 * The operations.
	 * Required. A list of the API operations available on this path. The array may include 0 or more operations.
	 * There MUST NOT be more than one Operation Object per method in the array.
	 */
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("operations")
	@com.fasterxml.jackson.annotation.JsonProperty("operations")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("operations")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "operations entry.", notes = " ", required = true)
	@javax.persistence.OneToMany(mappedBy = "apiObject12__href")
	@javax.persistence.OrderColumn(name = "operations_index")
	List< OperationObject12 > operations = new java.util.ArrayList<>();

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apiDeclaration12__href entry.", notes = " ", required = true)
	@javax.validation.Valid
	protected ApiDeclaration12 apiDeclaration12__href;

	public List< OperationObject12 > getOperations()
	{
		return operations;
	}

	public ApiObject12 setOperations( List< OperationObject12 > operations )
	{
		this.operations = operations;
		return this;
	}

	/**
	 * The path.
	 * Required. The relative path to the operation, from the basePath, which this operation describes.
	 * The value SHOULD be in a relative (URL) path format.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("path")
	@com.fasterxml.jackson.annotation.JsonProperty("path")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("path")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "path entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "path")
	String path;

	public String getDescription()
	{
		return description;
	}

	public ApiObject12 setDescription( String description )
	{
		this.description = description;
		return this;
	}

	public String getPath()
	{
		return path;
	}

	public ApiObject12 setPath( String path )
	{
		this.path = path;
		return this;
	}

	public ApiDeclaration12 getApiDeclaration12__href() {
		return apiDeclaration12__href;
	}

	public ApiObject12 setApiDeclaration12__href(
			ApiDeclaration12 apiDeclaration12__href) {
				this.apiDeclaration12__href = apiDeclaration12__href;
				return this;
			}
}
