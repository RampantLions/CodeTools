/* @(#)Parameter.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.util.Map;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Parameter.
 * 
 * Source: https://github.com/swagger-api/swagger-core/wiki/Parameters/e22da2fb334170c7676cdde6e89b966e7604de13
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "dataType", "name",
		"paramType", "required", "description", "allowableValues" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "dataType", "name",
		"paramType", "required", "description", "allowableValues" })
@com.wordnik.swagger.annotations.ApiModel(value = "Parameter11", description = "ResourceListing12 Parameter11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_Parameter11")
@javax.persistence.Table(name = "Swagger11_Parameter11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.all", query = "SELECT a FROM Parameter11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.id__", query = "SELECT a FROM Parameter11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.version__", query = "SELECT a FROM Parameter11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.dataType", query = "SELECT a FROM Parameter11 a WHERE a.dataType = :dataType"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.name", query = "SELECT a FROM Parameter11 a WHERE a.name = :name"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.paramType", query = "SELECT a FROM Parameter11 a WHERE a.paramType = :paramType"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.required", query = "SELECT a FROM Parameter11 a WHERE a.required = :required"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Parameter11.description", query = "SELECT a FROM Parameter11 a WHERE a.description = :description") })
public class Parameter11 extends CommonModel< Parameter11 >
{

	/** The data type. */
	@org.codehaus.jackson.annotate.JsonProperty("dataType")
	@com.fasterxml.jackson.annotation.JsonProperty("dataType")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("dataType")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "dataType entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "dataType")
	String dataType;

	/** The name. */
	@org.codehaus.jackson.annotate.JsonProperty("name")
	@com.fasterxml.jackson.annotation.JsonProperty("name")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("name")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "name entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "name")
	String name;

	/** The param type. */
	@org.codehaus.jackson.annotate.JsonProperty("paramType")
	@com.fasterxml.jackson.annotation.JsonProperty("paramType")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("paramType")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "paramType entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "paramType")
	String paramType;

	/** The required. */
	@org.codehaus.jackson.annotate.JsonProperty("required")
	@com.fasterxml.jackson.annotation.JsonProperty("required")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("required")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "required entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "required")
	@org.hibernate.annotations.Type(type = "true_false")
	boolean required = false;

	/** The description. */
	@org.codehaus.jackson.annotate.JsonProperty("description")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("description")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "description entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "description")
	String description;

	/** The allowable values. */
	@org.codehaus.jackson.annotate.JsonProperty("allowableValues")
	@com.fasterxml.jackson.annotation.JsonProperty("allowableValues")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("allowableValues")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "allowableValues entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.LAZY)
	@javax.persistence.Column(name = "allowableValues")
	@javax.persistence.CollectionTable(name = "Swagger11_Parameter11_allowableValues", joinColumns = { @javax.persistence.JoinColumn(name = "allowableValues_id") })
	@javax.persistence.MapKeyColumn(name = "map_id")
	Map< String, Object > allowableValues = new java.util.HashMap<>();

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	protected Parameters11 parameters11__href;

	public String getDataType() {
		return dataType;
	}

	public Parameter11 setDataType(String dataType) {
		this.dataType = dataType;
		return this;
	}

	public String getName() {
		return name;
	}

	public Parameter11 setName(String name) {
		this.name = name;
		return this;
	}

	public String getParamType() {
		return paramType;
	}

	public Parameter11 setParamType(String paramType) {
		this.paramType = paramType;
		return this;
	}

	public boolean getRequired() {
		return required;
	}

	public Parameter11 setRequired(boolean required) {
		this.required = required;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Parameter11 setDescription(String description) {
		this.description = description;
		return this;
	}

	public Map<String, Object> getAllowableValues() {
		return allowableValues;
	}

	public Parameter11 setAllowableValues(Map<String, Object> allowableValues) {
		this.allowableValues = allowableValues;
		return this;
	}
}
