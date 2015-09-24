
package io.github.rampantlions.codetools.swagger.generators.v11.models;

import io.github.rampantlions.codetools.CommonModel;

@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "code", "reason" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "code", "reason" })
@com.wordnik.swagger.annotations.ApiModel(value = "ErrorResponse11", description = "ResourceListing12 ErrorResponse11 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger11_ErrorResponse11")
@javax.persistence.Table(name = "Swagger11_ErrorResponse11", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ErrorResponse11.all", query = "SELECT a FROM ErrorResponse11 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ErrorResponse11.id__", query = "SELECT a FROM ErrorResponse11 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ErrorResponse11.version__", query = "SELECT a FROM ErrorResponse11 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ErrorResponse11.code", query = "SELECT a FROM ErrorResponse11 a WHERE a.code = :code"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v11.models.ErrorResponse11.reason", query = "SELECT a FROM ErrorResponse11 a WHERE a.reason = :reason") })
public class ErrorResponse11 extends CommonModel<ErrorResponse11>
{
	@org.codehaus.jackson.annotate.JsonProperty("code")
	@com.fasterxml.jackson.annotation.JsonProperty("code")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("code")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "code entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "code")
	String code;
	@org.codehaus.jackson.annotate.JsonProperty("reason")
	@com.fasterxml.jackson.annotation.JsonProperty("reason")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("reason")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "reason entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "reason")
	String reason;
	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	protected Operation11 operation11__href;
	public String getCode() {
		return code;
	}
	public ErrorResponse11 setCode(String code) {
		this.code = code;
		return this;
	}
	public String getReason() {
		return reason;
	}
	public ErrorResponse11 setReason(String reason) {
		this.reason = reason;
		return this;
	}
}
