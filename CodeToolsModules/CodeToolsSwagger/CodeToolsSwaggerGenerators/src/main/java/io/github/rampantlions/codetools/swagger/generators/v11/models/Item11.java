/* @(#)Item11.java Sep 13, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Item11.
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "ref", "type" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "ref", "type" })
@com.wordnik.swagger.annotations.ApiModel(value = "Item11", description = "ResourceListing12 Item11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_Item11")
@javax.persistence.Table(name = "Swagger11_Item11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Item11.all", query = "SELECT a FROM Item11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Item11.id__", query = "SELECT a FROM Item11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Item11.version__", query = "SELECT a FROM Item11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Item11.ref", query = "SELECT a FROM Item11 a WHERE a.ref = :ref"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Item11.type", query = "SELECT a FROM Item11 a WHERE a.type = :type") })
public class Item11 extends CommonModel< Item11 >
{

	/** The ref. */
	@org.codehaus.jackson.annotate.JsonProperty("$ref")
	@com.fasterxml.jackson.annotation.JsonProperty("$ref")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("$ref")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "$ref entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "ref")
	protected String ref;

	/** The type. */
	@org.codehaus.jackson.annotate.JsonProperty("type")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("type")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "type entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "type")
	protected String type;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	protected Property11 property11__href;

	public String getRef() {
		return ref;
	}

	public Item11 setRef(String ref) {
		this.ref = ref;
		return this;
	}

	public String getType() {
		return type;
	}

	public Item11 setType(String type) {
		this.type = type;
		return this;
	}

}
