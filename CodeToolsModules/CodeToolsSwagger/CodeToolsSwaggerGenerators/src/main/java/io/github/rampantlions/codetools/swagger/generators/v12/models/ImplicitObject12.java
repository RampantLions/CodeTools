/* @(#)ImplicitObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class ImplicitObject12.
 * Provides details regarding the OAuth2's Implicit Grant flow type.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#518-implicit-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "loginEndpoint", "tokenName" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "loginEndpoint",
		"tokenName" })
@com.wordnik.swagger.annotations.ApiModel(value = "ImplicitObject12", description = "ResourceListing12 ImplicitObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ImplicitObject12")
@javax.persistence.Table(name = "Swagger12_ImplicitObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ImplicitObject12.all", query = "SELECT a FROM ImplicitObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ImplicitObject12.id__", query = "SELECT a FROM ImplicitObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ImplicitObject12.version__", query = "SELECT a FROM ImplicitObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ImplicitObject12.loginEndpoint", query = "SELECT a FROM ImplicitObject12 a WHERE a.loginEndpoint = :loginEndpoint"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ImplicitObject12.tokenName", query = "SELECT a FROM ImplicitObject12 a WHERE a.tokenName = :tokenName") })
public class ImplicitObject12 extends CommonModel<ImplicitObject12>
{

	/**
	 * The login endpoint.
	 * Required. The login endpoint definition.
	 */
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("loginEndpoint")
	@com.fasterxml.jackson.annotation.JsonProperty("loginEndpoint")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("loginEndpoint")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "loginEndpoint entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	LoginEndpointObject12 loginEndpoint;

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
	String tokenName;

	public LoginEndpointObject12 getLoginEndpoint() {
		return loginEndpoint;
	}

	public ImplicitObject12 setLoginEndpoint(LoginEndpointObject12 loginEndpoint) {
		this.loginEndpoint = loginEndpoint;
		return this;
	}

	public String getTokenName() {
		return tokenName;
	}

	public ImplicitObject12 setTokenName(String tokenName) {
		this.tokenName = tokenName;
		return this;
	}
}
