/* @(#)AuthorizationObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.annotations.Validity;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class AuthorizationObject12.
 * The object provides information about a specific authorization scheme. Currently, the authorization schemes
 * supported are basic authentication, API key and OAuth2. Within OAuth2, the Authorization Code Grant and
 * Implicit Grant are supported.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#515-authorization-object
 *
 * Authorizations:
 *
 * The object provides information about the authorization schemes provided
 * on this API. Currently, Swagger supports three authorization schemes - basic
 * authentication, API key and OAuth2. The Authorizations Object is used only to
 * declare the available authorization schemes but not say which are required where.
 * The actual authorization restrictions are done at the API declaration level.
 *
 * Please note that the Authorizations Object is an object containing other object definitions.
 * Should be contained in Map<String, AuthorizationObject12>, where string is auth type, i.e. "oauth2"
 *
 * API declaration: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#52-api-declaration
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#514-authorizations-object
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "grantTypes", "keyName",
		"passAs", "scope", "type" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "grantTypes", "keyName",
		"passAs", "scope", "type" })
@com.wordnik.swagger.annotations.ApiModel(value = "AuthorizationObject12", description = "ResourceListing12 AuthorizationObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_AuthorizationObject12")
@javax.persistence.Table(name = "Swagger12_AuthorizationObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.all", query = "SELECT a FROM AuthorizationObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.id__", query = "SELECT a FROM AuthorizationObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.version__", query = "SELECT a FROM AuthorizationObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.grantTypes", query = "SELECT a FROM AuthorizationObject12 a WHERE a.grantTypes = :grantTypes"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.keyName", query = "SELECT a FROM AuthorizationObject12 a WHERE a.keyName = :keyName"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.passAs", query = "SELECT a FROM AuthorizationObject12 a WHERE a.passAs = :passAs"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.scope", query = "SELECT a FROM AuthorizationObject12 a WHERE a.scope = :scope"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationObject12.type", query = "SELECT a FROM AuthorizationObject12 a WHERE a.type = :type") })
public class AuthorizationObject12 extends CommonModel<AuthorizationObject12>
{

	/**
	 * The grant types.
	 * Required. Detailed information about the grant types supported by the OAuth2 authorization scheme.
	 */
	@Required
	@Validity( "oauth2" )
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("grantTypes")
	@com.fasterxml.jackson.annotation.JsonProperty("grantTypes")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("grantTypes")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "grantTypes entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	GrantTypesObject12 grantTypes;

	/**
	 * The key name.
	 * Required. The name of the header or query parameter to be used when passing the API key.
	 */
	@Required
	@Validity( "apiKey" )
	@org.codehaus.jackson.annotate.JsonProperty("keyName")
	@com.fasterxml.jackson.annotation.JsonProperty("keyName")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("keyName")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "keyName entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "keyName")
	String keyName;

	/**
	 * The pass as.
	 * Required. Denotes how the API key must be passed. Valid values are "header" or "query".
	 */
	@Required
	@Validity( "apiKey" )
	@org.codehaus.jackson.annotate.JsonProperty("passAs")
	@com.fasterxml.jackson.annotation.JsonProperty("passAs")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("passAs")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "passAs entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "passAs")
	String passAs;

	/**
	 * The scope.
	 * A list of supported OAuth2 scopes.
	 */
	@Validity( "oauth2" )
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("scope")
	@com.fasterxml.jackson.annotation.JsonProperty("scope")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("scope")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "scope entry.", notes = " ", required = true)
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	ScopeObject12 scope;

	/**
	 * The type.
	 * Required. The type of the authorization scheme. Values MUST be either "basicAuth", "apiKey" or "oauth2".
	 */
	@Required
	@Validity( "Any" )
	@org.codehaus.jackson.annotate.JsonProperty("type")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("type")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "type entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "type")
	String type;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	protected AuthorizationsObject12 authorizationsObject12__href;

	public GrantTypesObject12 getGrantTypes() {
		return grantTypes;
	}

	public AuthorizationObject12 setGrantTypes(GrantTypesObject12 grantTypes) {
		this.grantTypes = grantTypes;
		return this;
	}

	public String getKeyName() {
		return keyName;
	}

	public AuthorizationObject12 setKeyName(String keyName) {
		this.keyName = keyName;
		return this;
	}

	public String getPassAs() {
		return passAs;
	}

	public AuthorizationObject12 setPassAs(String passAs) {
		this.passAs = passAs;
		return this;
	}

	public ScopeObject12 getScope() {
		return scope;
	}

	public AuthorizationObject12 setScope(ScopeObject12 scope) {
		this.scope = scope;
		return this;
	}

	public String getType() {
		return type;
	}

	public AuthorizationObject12 setType(String type) {
		this.type = type;
		return this;
	}
}
