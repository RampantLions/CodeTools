/* @(#)ScopeObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Recommended;
import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class ScopeObject12.
 * Describes an OAuth2 authorization scope.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#516-scope-object
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "description", "scope" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "description", "scope" })
@com.wordnik.swagger.annotations.ApiModel(value = "ScopeObject12", description = "ResourceListing12 ScopeObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ScopeObject12")
@javax.persistence.Table(name = "Swagger12_ScopeObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ScopeObject12.all", query = "SELECT a FROM ScopeObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ScopeObject12.id__", query = "SELECT a FROM ScopeObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ScopeObject12.version__", query = "SELECT a FROM ScopeObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ScopeObject12.description", query = "SELECT a FROM ScopeObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ScopeObject12.scope", query = "SELECT a FROM ScopeObject12 a WHERE a.scope = :scope") })
public class ScopeObject12 extends CommonModel<ScopeObject12>
{
	/**
	 * The description.
	 * Recommended. A short description of the scope.
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
	 * The scope.
	 * Required. The name of the scope.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("scope")
	@com.fasterxml.jackson.annotation.JsonProperty("scope")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("scope")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "scope entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "scope")
	String scope;

	public String getDescription() {
		return description;
	}

	public ScopeObject12 setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getScope() {
		return scope;
	}

	public ScopeObject12 setScope(String scope) {
		this.scope = scope;
		return this;
	}

}
