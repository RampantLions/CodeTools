/* @(#)TokenRequestEndpointObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class TokenRequestEndpointObject12.
 * Provides details regarding the OAuth2's Authorization Endpoint.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#5111-token-request-endpoint-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "clientIdName",
		"clientSecretName", "url" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "clientIdName",
		"clientSecretName", "url" })
@com.wordnik.swagger.annotations.ApiModel(value = "TokenRequestEndpointObject12", description = "ResourceListing12 TokenRequestEndpointObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_TokenRequestEndpointObject12")
@javax.persistence.Table(name = "Swagger12_TokenRequestEndpointObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenRequestEndpointObject12.all", query = "SELECT a FROM TokenRequestEndpointObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenRequestEndpointObject12.id__", query = "SELECT a FROM TokenRequestEndpointObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenRequestEndpointObject12.version__", query = "SELECT a FROM TokenRequestEndpointObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenRequestEndpointObject12.clientIdName", query = "SELECT a FROM TokenRequestEndpointObject12 a WHERE a.clientIdName = :clientIdName"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenRequestEndpointObject12.clientSecretName", query = "SELECT a FROM TokenRequestEndpointObject12 a WHERE a.clientSecretName = :clientSecretName"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.TokenRequestEndpointObject12.url", query = "SELECT a FROM TokenRequestEndpointObject12 a WHERE a.url = :url") })
public class TokenRequestEndpointObject12 extends CommonModel< TokenRequestEndpointObject12 >
{
	/**
	 * The client id name.
	 * An optional alternative name to standard "client_id" OAuth2 parameter.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("clientIdName")
	@com.fasterxml.jackson.annotation.JsonProperty("clientIdName")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("clientIdName")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "clientIdName entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "clientIdName")
	protected String clientIdName;

	/**
	 * The client secret name.
	 * An optional alternative name to the standard "client_secret" OAuth2 parameter.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("clientSecretName")
	@com.fasterxml.jackson.annotation.JsonProperty("clientSecretName")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("clientSecretName")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "clientSecretName entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "clientSecretName")
	protected String clientSecretName;

	/**
	 * The url.
	 * Required. The URL of the authorization endpoint for the authentication code grant flow.
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

	public String getClientIdName()
	{
		return clientIdName;
	}

	public String getClientSecretName()
	{
		return clientSecretName;
	}

	public String getUrl()
	{
		return url;
	}

	public TokenRequestEndpointObject12 setClientIdName( final String clientIdName )
	{
		this.clientIdName = clientIdName;
		return this;
	}

	public TokenRequestEndpointObject12 setClientSecretName( final String clientSecretName )
	{
		this.clientSecretName = clientSecretName;
		return this;
	}

	public TokenRequestEndpointObject12 setUrl( final String url )
	{
		this.url = url;
		return this;
	}
}
