/* @(#)AuthorizationCodeObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class AuthorizationCodeObject12.
 * Provides details regarding the OAuth2's Authorization Code Grant flow type.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#519-authorization-code-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "tokenEndpoint",
		"tokenRequestEndpoint" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "tokenEndpoint",
		"tokenRequestEndpoint" })
@com.wordnik.swagger.annotations.ApiModel(value = "AuthorizationCodeObject12", description = "ResourceListing12 AuthorizationCodeObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_AuthorizationCodeObject12")
@javax.persistence.Table(name = "Swagger12_AuthorizationCodeObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationCodeObject12.all", query = "SELECT a FROM AuthorizationCodeObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationCodeObject12.id__", query = "SELECT a FROM AuthorizationCodeObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationCodeObject12.version__", query = "SELECT a FROM AuthorizationCodeObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationCodeObject12.tokenEndpoint", query = "SELECT a FROM AuthorizationCodeObject12 a WHERE a.tokenEndpoint = :tokenEndpoint"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationCodeObject12.tokenRequestEndpoint", query = "SELECT a FROM AuthorizationCodeObject12 a WHERE a.tokenRequestEndpoint = :tokenRequestEndpoint") })
public class AuthorizationCodeObject12 extends CommonModel<AuthorizationCodeObject12>
{

	/**
	 * The token endpoint.
	 * Required. The token endpoint definition.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("tokenEndpoint")
	@com.fasterxml.jackson.annotation.JsonProperty("tokenEndpoint")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("tokenEndpoint")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "tokenEndpoint entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	protected TokenEndpointObject12 tokenEndpoint;

	/**
	 * The token request endpoint.
	 * Required. The token request endpoint definition.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("tokenRequestEndpoint")
	@com.fasterxml.jackson.annotation.JsonProperty("tokenRequestEndpoint")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("tokenRequestEndpoint")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "tokenRequestEndpoint entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	protected TokenRequestEndpointObject12 tokenRequestEndpoint;

	public TokenEndpointObject12 getTokenEndpoint() {
		return tokenEndpoint;
	}

	public AuthorizationCodeObject12 setTokenEndpoint(TokenEndpointObject12 tokenEndpoint) {
		this.tokenEndpoint = tokenEndpoint;
		return this;
	}

	public TokenRequestEndpointObject12 getTokenRequestEndpoint() {
		return tokenRequestEndpoint;
	}

	public AuthorizationCodeObject12 setTokenRequestEndpoint(
			TokenRequestEndpointObject12 tokenRequestEndpoint) {
				this.tokenRequestEndpoint = tokenRequestEndpoint;
				return this;
			}

}
