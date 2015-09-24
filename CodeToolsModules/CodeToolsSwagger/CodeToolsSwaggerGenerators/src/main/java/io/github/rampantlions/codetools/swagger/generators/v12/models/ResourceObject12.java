/* @(#)ResourceObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Recommended;
import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class ResourceObject12.
 * The Resource object describes a resource API endpoint in the application.
 *
 * Resource: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#definitionResource
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#512-resource-object
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "description", "path" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "description", "path" })
@com.wordnik.swagger.annotations.ApiModel(value = "ResourceObject12", description = "ResourceListing12 ResourceObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ResourceObject12")
@javax.persistence.Table(name = "Swagger12_ResourceObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceObject12.all", query = "SELECT a FROM ResourceObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceObject12.id__", query = "SELECT a FROM ResourceObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceObject12.version__", query = "SELECT a FROM ResourceObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceObject12.description", query = "SELECT a FROM ResourceObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceObject12.path", query = "SELECT a FROM ResourceObject12 a WHERE a.path = :path") })
public class ResourceObject12 extends CommonModel<ResourceObject12>
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
	 * The path.
	 * Required. A relative path to the API declaration from the path used to retrieve this Resource Listing.
	 * This path does not necessarily have to correspond to the URL which actually serves this resource in the
	 * API but rather where the resource listing itself is served. The value SHOULD be in a relative (URL) path
	 * format.
	 *
	 * API declaration: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#52-api-declaration
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("path")
	@com.fasterxml.jackson.annotation.JsonProperty("path")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("path")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "path entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "path")
	String path;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "resourceListing12__href entry.", notes = " ", required = true)
	@javax.validation.Valid
	protected ResourceListing12 resourceListing12__href;

	public String getDescription() {
		return description;
	}

	public ResourceObject12 setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getPath() {
		return path;
	}

	public ResourceObject12 setPath(String path) {
		this.path = path;
		return this;
	}

	public ResourceListing12 getResourceListing12__href() {
		return resourceListing12__href;
	}

	public ResourceObject12 setResourceListing12__href(
			ResourceListing12 resourceListing12__href) {
				this.resourceListing12__href = resourceListing12__href;
				return this;
			}
}
