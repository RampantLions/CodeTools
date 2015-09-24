/* @(#)Operation.java Sep 12, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v11.models;

import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Operation11.
 *
 * Source: https://github.com/swagger-api/swagger-core/wiki/API-Declaration/e22da2fb334170c7676cdde6e89b966e7604de13
 * 
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "httpMethod", "nickname",
		"notes", "parameters", "responseClass", "statusCodes",
		"errorResponses", "summary" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "httpMethod", "nickname",
		"notes", "parameters", "responseClass", "statusCodes",
		"errorResponses", "summary" })
@com.wordnik.swagger.annotations.ApiModel(value = "Operation11", description = "ResourceListing12 Operation11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_Operation11")
@javax.persistence.Table(name = "Swagger11_Operation11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.all", query = "SELECT a FROM Operation11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.id__", query = "SELECT a FROM Operation11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.version__", query = "SELECT a FROM Operation11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.httpMethod", query = "SELECT a FROM Operation11 a WHERE a.httpMethod = :httpMethod"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.nickname", query = "SELECT a FROM Operation11 a WHERE a.nickname = :nickname"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.notes", query = "SELECT a FROM Operation11 a WHERE a.notes = :notes"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.parameters", query = "SELECT a FROM Operation11 a WHERE a.parameters = :parameters"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.responseClass", query = "SELECT a FROM Operation11 a WHERE a.responseClass = :responseClass"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.Operation11.summary", query = "SELECT a FROM Operation11 a WHERE a.summary = :summary") })
public class Operation11 extends CommonModel< Operation11 >
{

	/** The http method. */
	@org.codehaus.jackson.annotate.JsonProperty("httpMethod")
	@com.fasterxml.jackson.annotation.JsonProperty("httpMethod")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("httpMethod")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "httpMethod entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "httpMethod")
	String httpMethod;

	/** The nickname. */
	@org.codehaus.jackson.annotate.JsonProperty("nickname")
	@com.fasterxml.jackson.annotation.JsonProperty("nickname")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("nickname")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "nickname entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "nickname")
	String nickname;

	/** The notes. */
	@org.codehaus.jackson.annotate.JsonProperty("notes")
	@com.fasterxml.jackson.annotation.JsonProperty("notes")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("notes")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "notes entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "notes")
	String notes;

	/** The parameters. */
	@org.codehaus.jackson.annotate.JsonProperty("parameters")
	@com.fasterxml.jackson.annotation.JsonProperty("parameters")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("parameters")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "parameters entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	Parameters11 parameters;

	/** The response class. */
	@org.codehaus.jackson.annotate.JsonProperty("responseClass")
	@com.fasterxml.jackson.annotation.JsonProperty("responseClass")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("responseClass")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "responseClass entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "responseClass")
	String responseClass;

	/** The status codes. */
	@org.codehaus.jackson.annotate.JsonProperty("statusCodes")
	@com.fasterxml.jackson.annotation.JsonProperty("statusCodes")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("statusCodes")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "statusCodes entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.LAZY)
	@javax.persistence.Column(name = "statusCodes")
	@javax.persistence.CollectionTable(name = "Swagger11_Operation11_statusCodes", joinColumns = { @javax.persistence.JoinColumn(name = "statusCodes_id") })
	@javax.persistence.MapKeyColumn(name = "map_id")
	Map< String, String > statusCodes = new java.util.HashMap<>();

	/** The error responses. */
	@org.codehaus.jackson.annotate.JsonProperty("errorResponses")
	@com.fasterxml.jackson.annotation.JsonProperty("errorResponses")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("errorResponses")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "errorResponses entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany(mappedBy = "operation11__href")
	@javax.persistence.OrderColumn(name = "errorResponses_index")
	List< ErrorResponse11 > errorResponses = new java.util.ArrayList<>();

	/** The summary. */
	@org.codehaus.jackson.annotate.JsonProperty("summary")
	@com.fasterxml.jackson.annotation.JsonProperty("summary")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("summary")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "summary entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "summary")
	String summary;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "api11__href entry.", notes = " ", required = true)
	@javax.validation.Valid
	protected Api11 api11__href;

	public String getHttpMethod() {
		return httpMethod;
	}

	public Operation11 setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public Operation11 setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Operation11 setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public Parameters11 getParameters() {
		return parameters;
	}

	public Operation11 setParameters(Parameters11 parameters) {
		this.parameters = parameters;
		return this;
	}

	public String getResponseClass() {
		return responseClass;
	}

	public Operation11 setResponseClass(String responseClass) {
		this.responseClass = responseClass;
		return this;
	}

	public Map<String, String> getStatusCodes() {
		return statusCodes;
	}

	public Operation11 setStatusCodes(Map<String, String> statusCodes) {
		this.statusCodes = statusCodes;
		return this;
	}

	public List<ErrorResponse11> getErrorResponses() {
		return errorResponses;
	}

	public Operation11 setErrorResponses(List<ErrorResponse11> errorResponses) {
		this.errorResponses = errorResponses;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public Operation11 setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public Api11 getApi11__href() {
		return api11__href;
	}

	public Operation11 setApi11__href(Api11 api11__href) {
		this.api11__href = api11__href;
		return this;
	}
}
