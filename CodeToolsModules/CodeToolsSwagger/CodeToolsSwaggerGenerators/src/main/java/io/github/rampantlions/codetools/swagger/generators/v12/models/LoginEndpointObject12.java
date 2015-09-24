/* @(#)LoginEndpointObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class LoginEndpointObject12.
 * Provides details regarding the Implicit Grant's authorization endpoint.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#5110-login-endpoint-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "url" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "url" })
@com.wordnik.swagger.annotations.ApiModel(value = "LoginEndpointObject12", description = "ResourceListing12 LoginEndpointObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_LoginEndpointObject12")
@javax.persistence.Table(name = "Swagger12_LoginEndpointObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.LoginEndpointObject12.all", query = "SELECT a FROM LoginEndpointObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.LoginEndpointObject12.id__", query = "SELECT a FROM LoginEndpointObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.LoginEndpointObject12.version__", query = "SELECT a FROM LoginEndpointObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.LoginEndpointObject12.url", query = "SELECT a FROM LoginEndpointObject12 a WHERE a.url = :url") })
public class LoginEndpointObject12 extends CommonModel<LoginEndpointObject12>
{

	/**
	 * The url.
	 * Required. The URL of the authorization endpoint for the implicit grant flow.
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

	public String getUrl() {
		return url;
	}

	public LoginEndpointObject12 setUrl(String url) {
		this.url = url;
		return this;
	}
}
