/* @(#)Api.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.util.List;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Api11.
 * 
 * Source: https://github.com/swagger-api/swagger-core/wiki/API-Declaration/e22da2fb334170c7676cdde6e89b966e7604de13
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "description", "operations",
		"path" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "description",
		"operations", "path" })
@com.wordnik.swagger.annotations.ApiModel(value = "Api11", description = "ResourceListing12 Api11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_Api11")
@javax.persistence.Table(name = "Swagger11_Api11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Api11.all", query = "SELECT a FROM Api11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Api11.id__", query = "SELECT a FROM Api11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Api11.version__", query = "SELECT a FROM Api11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Api11.description", query = "SELECT a FROM Api11 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Api11.path", query = "SELECT a FROM Api11 a WHERE a.path = :path") })
public class Api11 extends CommonModel< Api11 >
{

	/** The description. */
	@org.codehaus.jackson.annotate.JsonProperty("description")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("description")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "description entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "description")
	String description;

	/** The operations. */
	@org.codehaus.jackson.annotate.JsonProperty("operations")
	@com.fasterxml.jackson.annotation.JsonProperty("operations")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("operations")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "operations entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany(mappedBy = "api11__href")
	@javax.persistence.OrderColumn(name = "operations_index")
	List< Operation11 > operations = new java.util.ArrayList<>();

	/** The path. */
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
	protected ApiDeclaration11 apiDeclaration11__href;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	protected ResourceListing11 resourceListing11__href;

	public String getDescription() {
		return description;
	}

	public Api11 setDescription(String description) {
		this.description = description;
		return this;
	}

	public List<Operation11> getOperations() {
		return operations;
	}

	public Api11 setOperations(List<Operation11> operations) {
		this.operations = operations;
		return this;
	}

	public String getPath() {
		return path;
	}

	public Api11 setPath(String path) {
		this.path = path;
		return this;
	}

}
