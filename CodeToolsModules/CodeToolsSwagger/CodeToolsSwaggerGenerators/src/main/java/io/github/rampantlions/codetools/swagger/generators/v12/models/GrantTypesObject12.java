/* @(#)GrantTypesObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class GrantTypesObject12.
 * Provides details regarding the OAuth2 grant types that are supported by the API. Currently, the
 * Authorization Code and Implicit grants are supported.
 *
 * At least one of the grant types MUST be included (otherwise there's no need for the OAuth2 declaration).
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#517-grant-types-object
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "authorization_code",
		"implicit" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "authorization_code",
		"implicit" })
@com.wordnik.swagger.annotations.ApiModel(value = "GrantTypesObject12", description = "ResourceListing12 GrantTypesObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_GrantTypesObject12")
@javax.persistence.Table(name = "Swagger12_GrantTypesObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.GrantTypesObject12.all", query = "SELECT a FROM GrantTypesObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.GrantTypesObject12.id__", query = "SELECT a FROM GrantTypesObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.GrantTypesObject12.version__", query = "SELECT a FROM GrantTypesObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.GrantTypesObject12.authorization_code", query = "SELECT a FROM GrantTypesObject12 a WHERE a.authorization_code = :authorization_code"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.GrantTypesObject12.implicit", query = "SELECT a FROM GrantTypesObject12 a WHERE a.implicit = :implicit") })
public class GrantTypesObject12 extends CommonModel<GrantTypesObject12>
{

	/**
	 * The authorization_code.
	 * The Authorization Code Grant flow definition.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("authorization_code")
	@com.fasterxml.jackson.annotation.JsonProperty("authorization_code")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("authorization_code")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "authorization_code entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	protected AuthorizationCodeObject12 authorization_code;

	/**
	 * The implicit.
	 * The Implicit Grant flow definition.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("implicit")
	@com.fasterxml.jackson.annotation.JsonProperty("implicit")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("implicit")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "implicit entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	protected ImplicitObject12 implicit;

	public AuthorizationCodeObject12 getAuthorization_code() {
		return authorization_code;
	}

	public GrantTypesObject12 setAuthorization_code(
			AuthorizationCodeObject12 authorization_code) {
				this.authorization_code = authorization_code;
				return this;
			}

	public ImplicitObject12 getImplicit() {
		return implicit;
	}

	public GrantTypesObject12 setImplicit(ImplicitObject12 implicit) {
		this.implicit = implicit;
		return this;
	}
}
