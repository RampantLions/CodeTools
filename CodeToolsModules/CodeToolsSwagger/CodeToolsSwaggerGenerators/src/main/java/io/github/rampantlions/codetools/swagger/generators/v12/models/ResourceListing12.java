/* @(#)ResourceListing12.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Resource Listing for Swagger 1.2.
 * The Resource Listing serves as the root document for the API description. It contains general information
 * about the API and an inventory of the available resources.
 *
 * By default, this document SHOULD be served at the /api-docs path.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#51-resource-listing
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "apis", "apiVersion",
		"authorizations", "info", "swaggerVersion" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "apis", "apiVersion",
		"authorizations", "info", "swaggerVersion" })
@com.wordnik.swagger.annotations.ApiModel(value = "ResourceListing12", description = "ResourceListing12 ResourceListing12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ResourceListing12")
@javax.persistence.Table(name = "Swagger12_ResourceListing12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12.all", query = "SELECT a FROM ResourceListing12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12.id__", query = "SELECT a FROM ResourceListing12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12.version__", query = "SELECT a FROM ResourceListing12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12.apiVersion", query = "SELECT a FROM ResourceListing12 a WHERE a.apiVersion = :apiVersion"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12.info", query = "SELECT a FROM ResourceListing12 a WHERE a.info = :info"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResourceListing12.swaggerVersion", query = "SELECT a FROM ResourceListing12 a WHERE a.swaggerVersion = :swaggerVersion") })
public class ResourceListing12 extends CommonModel< ResourceListing12 >
{

	/**
	 * The apis.
	 *
	 * Required. Lists the resources to be described by this specification implementation.
	 * The array can have 0 or more elements.
	 */
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("apis")
	@com.fasterxml.jackson.annotation.JsonProperty("apis")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("apis")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apis entry.", notes = " ", required = true)
	@javax.persistence.OneToMany(mappedBy = "resourceListing12__href")
	@javax.persistence.OrderColumn(name = "apis_index")
	protected List< ResourceObject12 > apis = new java.util.ArrayList<>();

	/**
	 * The api version.
	 *
	 * Provides the version of the application API (not to be confused by the specification version).
	 * specification version: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#rlSwaggerVersion
	 */
	@org.codehaus.jackson.annotate.JsonProperty("apiVersion")
	@com.fasterxml.jackson.annotation.JsonProperty("apiVersion")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("apiVersion")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apiVersion entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "apiVersion")
	protected String apiVersion;

	/**
	 * The authorizations.
	 * Provides information about the authorization schemes allowed on this API.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("authorizations")
	@com.fasterxml.jackson.annotation.JsonProperty("authorizations")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("authorizations")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "authorizations entry.", notes = " ", required = true)
	@javax.persistence.OneToMany
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.EAGER)
	@javax.persistence.Column(name = "authorizations")
	@javax.persistence.JoinTable(name = "Swagger12_ResourceListing12_authorizations")
	@javax.persistence.MapKeyColumn(name = "authorizationObject12_id")
	protected Map< String, AuthorizationObject12 > authorizations = new java.util.HashMap<>();

	/**
	 * The info.
	 * Provides metadata about the API. The metadata can be used by the clients if needed,
	 * and can be presented in the Swagger-UI for convenience.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("info")
	@com.fasterxml.jackson.annotation.JsonProperty("info")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("info")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "info entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	protected InfoObject12 info;

	/**
	 * The swagger version.
	 *
	 * Required. Specifies the Swagger Specification version being used. It can be used by the Swagger UI
	 * and other clients to interpret the API listing. The value MUST be an existing Swagger specification version.
	 * Currently, "1.0", "1.1", "1.2" are valid values. The field is a string type for possible non-numeric versions
	 * in the future (for example, "1.2a").
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("swaggerVersion")
	@com.fasterxml.jackson.annotation.JsonProperty("swaggerVersion")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("swaggerVersion")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "swaggerVersion entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "swaggerVersion")
	String swaggerVersion;

	public List<ResourceObject12> getApis() {
		return apis;
	}

	public ResourceListing12 setApis(List<ResourceObject12> apis) {
		this.apis = apis;
		return this;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public ResourceListing12 setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
		return this;
	}

	public Map<String, AuthorizationObject12> getAuthorizations() {
		return authorizations;
	}

	public ResourceListing12 setAuthorizations(
			Map<String, AuthorizationObject12> authorizations) {
				this.authorizations = authorizations;
				return this;
			}

	public InfoObject12 getInfo() {
		return info;
	}

	public ResourceListing12 setInfo(InfoObject12 info) {
		this.info = info;
		return this;
	}

	public String getSwaggerVersion() {
		return swaggerVersion;
	}

	public ResourceListing12 setSwaggerVersion(String swaggerVersion) {
		this.swaggerVersion = swaggerVersion;
		return this;
	}
}
