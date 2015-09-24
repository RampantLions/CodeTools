/* @(#)InfoObject12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class InfoObject12.
 * The object provides metadata about the API. The metadata can be used by the clients if needed, and
 * can be presented in the Swagger-UI for convenience.
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#513-info-object
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "contact", "description",
		"license", "licenseUrl", "termsOfServiceUrl", "title" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "contact", "description",
		"license", "licenseUrl", "termsOfServiceUrl", "title" })
@com.wordnik.swagger.annotations.ApiModel(value = "InfoObject12", description = "ResourceListing12 InfoObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_InfoObject12")
@javax.persistence.Table(name = "Swagger12_InfoObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.all", query = "SELECT a FROM InfoObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.id__", query = "SELECT a FROM InfoObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.version__", query = "SELECT a FROM InfoObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.contact", query = "SELECT a FROM InfoObject12 a WHERE a.contact = :contact"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.description", query = "SELECT a FROM InfoObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.license", query = "SELECT a FROM InfoObject12 a WHERE a.license = :license"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.licenseUrl", query = "SELECT a FROM InfoObject12 a WHERE a.licenseUrl = :licenseUrl"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.termsOfServiceUrl", query = "SELECT a FROM InfoObject12 a WHERE a.termsOfServiceUrl = :termsOfServiceUrl"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.InfoObject12.title", query = "SELECT a FROM InfoObject12 a WHERE a.title = :title") })
public class InfoObject12 extends CommonModel<InfoObject12>
{

	/**
	 * The contact.
	 * An email to be used for API-related correspondence.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("contact")
	@com.fasterxml.jackson.annotation.JsonProperty("contact")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("contact")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "contact entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "contact")
	String contact;

	/**
	 * The description.
	 * Required. A short description of the application
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("description")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("description")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "description entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "description")
	String description;

	/**
	 * The license.
	 * The license name used for the API.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("license")
	@com.fasterxml.jackson.annotation.JsonProperty("license")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("license")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "license entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "license")
	String license;

	/**
	 * The license url.
	 * A URL to the license used for the API.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("licenseUrl")
	@com.fasterxml.jackson.annotation.JsonProperty("licenseUrl")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("licenseUrl")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "licenseUrl entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "licenseUrl")
	String licenseUrl;

	/**
	 * The terms of service url.
	 * A URL to the Terms of Service of the API.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("termsOfServiceUrl")
	@com.fasterxml.jackson.annotation.JsonProperty("termsOfServiceUrl")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("termsOfServiceUrl")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "termsOfServiceUrl entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "termsOfServiceUrl")
	String termsOfServiceUrl;

	/**
	 * The title.
	 * Required. The title of the application.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("title")
	@com.fasterxml.jackson.annotation.JsonProperty("title")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("title")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "title entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "title")
	String title;

	public String getContact() {
		return contact;
	}

	public InfoObject12 setContact(String contact) {
		this.contact = contact;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public InfoObject12 setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getLicense() {
		return license;
	}

	public InfoObject12 setLicense(String license) {
		this.license = license;
		return this;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public InfoObject12 setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
		return this;
	}

	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	public InfoObject12 setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public InfoObject12 setTitle(String title) {
		this.title = title;
		return this;
	}
}
