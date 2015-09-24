/* @(#)ResponseMessage.java Sep 11, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class ResponseMessage.
 * The Response Message Object describes a single possible response message that can be returned from
 * the operation call, and maps to the responseMessages field in the Operation Object. Each Response Message
 * allows you to give further details as to why the HTTP status code may be received.
 *
 * responseMessages: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#operationResponseMessages
 * Operation Object: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#523-operation-object
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#525-response-message-object
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "code", "message",
		"responseModel" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "code", "message",
		"responseModel" })
@com.wordnik.swagger.annotations.ApiModel(value = "ResponseMessageObject12", description = "ResourceListing12 ResponseMessageObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ResponseMessageObject12")
@javax.persistence.Table(name = "Swagger12_ResponseMessageObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResponseMessageObject12.all", query = "SELECT a FROM ResponseMessageObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResponseMessageObject12.id__", query = "SELECT a FROM ResponseMessageObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResponseMessageObject12.version__", query = "SELECT a FROM ResponseMessageObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResponseMessageObject12.code", query = "SELECT a FROM ResponseMessageObject12 a WHERE a.code = :code"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResponseMessageObject12.message", query = "SELECT a FROM ResponseMessageObject12 a WHERE a.message = :message"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ResponseMessageObject12.responseModel", query = "SELECT a FROM ResponseMessageObject12 a WHERE a.responseModel = :responseModel") })
public class ResponseMessageObject12 extends CommonModel< ResponseMessageObject12 >
{

	/**
	 * The code.
	 * Required. The HTTP status code returned. The value SHOULD be one of the status codes as
	 * described in RFC 2616 - Section 10.
	 *
	 * RFC 2616 - Section 10: http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("code")
	@com.fasterxml.jackson.annotation.JsonProperty("code")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("code")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "code entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "code")
	protected Integer code;

	/**
	 * The message.
	 * Required. The explanation for the status code. It SHOULD be the reason an error is received
	 * if an error status code is used.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("message")
	@com.fasterxml.jackson.annotation.JsonProperty("message")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("message")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "message entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "message")
	protected String message;

	/**
	 * The response model.
	 * The return type for the given response.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("responseModel")
	@com.fasterxml.jackson.annotation.JsonProperty("responseModel")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("responseModel")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "responseModel entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "responseModel")
	protected String responseModel;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "operationObject12__href entry.", notes = " ", required = true)
	@javax.validation.Valid
	protected OperationObject12 operationObject12__href;

	public Integer getCode() {
		return code;
	}

	public ResponseMessageObject12 setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseMessageObject12 setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getResponseModel() {
		return responseModel;
	}

	public ResponseMessageObject12 setResponseModel(String responseModel) {
		this.responseModel = responseModel;
		return this;
	}

	public OperationObject12 getOperationObject12__href() {
		return operationObject12__href;
	}

	public ResponseMessageObject12 setOperationObject12__href(
			OperationObject12 operationObject12__href) {
				this.operationObject12__href = operationObject12__href;
				return this;
			}
}
