/* @(#)Swagger.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Swagger.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "apis", "apiVersion",
		"basePath", "models", "swaggerVersion" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "apis", "apiVersion",
		"basePath", "models", "swaggerVersion" })
@com.wordnik.swagger.annotations.ApiModel(value = "ResourceListing11", description = "ResourceListing12 ResourceListing11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_ResourceListing11")
@javax.persistence.Table(name = "Swagger11_ResourceListing11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ResourceListing11.all", query = "SELECT a FROM ResourceListing11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ResourceListing11.id__", query = "SELECT a FROM ResourceListing11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ResourceListing11.version__", query = "SELECT a FROM ResourceListing11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ResourceListing11.apiVersion", query = "SELECT a FROM ResourceListing11 a WHERE a.apiVersion = :apiVersion"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ResourceListing11.basePath", query = "SELECT a FROM ResourceListing11 a WHERE a.basePath = :basePath"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ResourceListing11.swaggerVersion", query = "SELECT a FROM ResourceListing11 a WHERE a.swaggerVersion = :swaggerVersion") })
public class ResourceListing11 extends CommonModel< ResourceListing11 >
{

	/** The apis. */
	@org.codehaus.jackson.annotate.JsonProperty("apis")
	@com.fasterxml.jackson.annotation.JsonProperty("apis")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("apis")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apis entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany(mappedBy = "resourceListing11__href")
	@javax.persistence.OrderColumn(name = "apis_index")
	List< Api11 > apis = new java.util.ArrayList<>();

	/** The api version. */
	@org.codehaus.jackson.annotate.JsonProperty("apiVersion")
	@com.fasterxml.jackson.annotation.JsonProperty("apiVersion")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("apiVersion")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apiVersion entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "apiVersion")
	String apiVersion;

	/** 
	 * The base path.
	 * 
	 * The base path on which the API is served, which is relative to the host. If it is not included, 
	 * the API is served directly under the host. The value MUST start with a leading slash (/). 
	 * The basePath does not support path templating.
	 * 
	 * path templating: https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#pathTemplating
	 */
	@org.codehaus.jackson.annotate.JsonProperty("basePath")
	@com.fasterxml.jackson.annotation.JsonProperty("basePath")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("basePath")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "basePath entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "basePath")
	String basePath;

	/** The models. */
	@org.codehaus.jackson.annotate.JsonProperty("models")
	@com.fasterxml.jackson.annotation.JsonProperty("models")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("models")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "models entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.EAGER)
	@javax.persistence.Column(name = "models")
	@javax.persistence.JoinTable(name = "Swagger11_ResourceListing11_models")
	@javax.persistence.MapKeyColumn(name = "model11_id")
	Map< String, Model11 > models = new java.util.HashMap<>();

	/** The swagger version. */
	@org.codehaus.jackson.annotate.JsonProperty("swaggerVersion")
	@com.fasterxml.jackson.annotation.JsonProperty("swaggerVersion")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("swaggerVersion")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "swaggerVersion entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "swaggerVersion")
	String swaggerVersion;

	public List<Api11> getApis() {
		return apis;
	}

	public ResourceListing11 setApis(List<Api11> apis) {
		this.apis = apis;
		return this;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public ResourceListing11 setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
		return this;
	}

	public String getBasePath() {
		return basePath;
	}

	public ResourceListing11 setBasePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public Map<String, Model11> getModels() {
		return models;
	}

	public ResourceListing11 setModels(Map<String, Model11> models) {
		this.models = models;
		return this;
	}

	public String getSwaggerVersion() {
		return swaggerVersion;
	}

	public ResourceListing11 setSwaggerVersion(String swaggerVersion) {
		this.swaggerVersion = swaggerVersion;
		return this;
	}
}
