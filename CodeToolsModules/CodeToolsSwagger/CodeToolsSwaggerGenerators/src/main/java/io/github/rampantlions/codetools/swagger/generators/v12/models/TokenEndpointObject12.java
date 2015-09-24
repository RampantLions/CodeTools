/* @(#)TokenEndpointObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class TokenEndpointObject12.
 * Provides details regarding the OAuth2's Token Endpoint.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#5112-token-endpoint-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "tokenName", "url" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "tokenName", "url" })
@com.wordnik.swagger.annotations.ApiModel(value = "TokenEndpointObject12", description = "ResourceListing12 TokenEndpointObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_TokenEndpointObject12")
@javax.persistence.Table(name = "Swagger12_TokenEndpointObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenEndpointObject12.all", query = "SELECT a FROM TokenEndpointObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenEndpointObject12.id__", query = "SELECT a FROM TokenEndpointObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenEndpointObject12.version__", query = "SELECT a FROM TokenEndpointObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenEndpointObject12.tokenName", query = "SELECT a FROM TokenEndpointObject12 a WHERE a.tokenName = :tokenName"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenEndpointObject12.url", query = "SELECT a FROM TokenEndpointObject12 a WHERE a.url = :url") })
public class TokenEndpointObject12 extends CommonModel<TokenEndpointObject12>
{

	/**
	 * The token name.
	 * An optional alternative name to standard "access_token" OAuth2 parameter.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("tokenName")
	@com.fasterxml.jackson.annotation.JsonProperty("tokenName")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("tokenName")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "tokenName entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "tokenName")
	protected String tokenName;

	/**
	 * The url.
	 * Required. The URL of the token endpoint for the authentication code grant flow.
	 * The value SHOULD be in a URL format.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("url")
	@com.fasterxml.jackson.annotation.JsonProperty("url")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("url")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "url entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "url")
	protected String url;

	public String getTokenName() {
		return tokenName;
	}

	public TokenEndpointObject12 setTokenName(String tokenName) {
		this.tokenName = tokenName;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public TokenEndpointObject12 setUrl(String url) {
		this.url = url;
		return this;
	}
}
