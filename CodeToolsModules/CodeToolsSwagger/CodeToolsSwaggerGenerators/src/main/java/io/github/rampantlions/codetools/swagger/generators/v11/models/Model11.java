/* @(#)Model.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.util.Map;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Model.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "id", "properties", "type" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "id", "properties",
		"type" })
@com.wordnik.swagger.annotations.ApiModel(value = "Model11", description = "ResourceListing12 Model11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_Model11")
@javax.persistence.Table(name = "Swagger11_Model11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Model11.all", query = "SELECT a FROM Model11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Model11.id__", query = "SELECT a FROM Model11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Model11.version__", query = "SELECT a FROM Model11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Model11.id", query = "SELECT a FROM Model11 a WHERE a.id = :id"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Model11.type", query = "SELECT a FROM Model11 a WHERE a.type = :type") })
public class Model11 extends CommonModel< Model11 >
{

	/** The id. */
	@org.codehaus.jackson.annotate.JsonProperty("id")
	@com.fasterxml.jackson.annotation.JsonProperty("id")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("id")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "id entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "id")
	String id;

	/** The properties. */
	@org.codehaus.jackson.annotate.JsonProperty("properties")
	@com.fasterxml.jackson.annotation.JsonProperty("properties")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("properties")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "properties entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.EAGER)
	@javax.persistence.Column(name = "properties")
	@javax.persistence.JoinTable(name = "Swagger11_Model11_properties")
	@javax.persistence.MapKeyColumn(name = "property11_id")
	Map< String, Property11 > properties = new java.util.HashMap<>();

	/** The type. */
	@org.codehaus.jackson.annotate.JsonProperty("type")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("type")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "type entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "type")
	String type;

	public String getId() {
		return id;
	}

	public Model11 setId(String id) {
		this.id = id;
		return this;
	}

	public Map<String, Property11> getProperties() {
		return properties;
	}

	public Model11 setProperties(Map<String, Property11> properties) {
		this.properties = properties;
		return this;
	}

	public String getType() {
		return type;
	}

	public Model11 setType(String type) {
		this.type = type;
		return this;
	}

}
