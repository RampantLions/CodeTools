package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.List;
import io.github.rampantlions.codetools.CommonModel;

@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "authorizationObject" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "authorizationObject" })
@com.wordnik.swagger.annotations.ApiModel(value = "AuthorizationsObject12", description = "ResourceListing12 AuthorizationsObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_AuthorizationsObject12")
@javax.persistence.Table(name = "Swagger12_AuthorizationsObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationsObject12.all", query = "SELECT a FROM AuthorizationsObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationsObject12.id__", query = "SELECT a FROM AuthorizationsObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.AuthorizationsObject12.version__", query = "SELECT a FROM AuthorizationsObject12 a WHERE a.version__ = :version__") })
public class AuthorizationsObject12 extends CommonModel<AuthorizationsObject12>
{
	@org.codehaus.jackson.annotate.JsonProperty("authorizationObject")
	@com.fasterxml.jackson.annotation.JsonProperty("authorizationObject")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("authorizationObject")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "authorizationObject entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany(mappedBy = "authorizationsObject12__href")
	@javax.persistence.OrderColumn(name = "authorizationObject_index")
	List<AuthorizationObject12> authorizationObject = new java.util.ArrayList<>();

	public List<AuthorizationObject12> getAuthorizationObject() {
		return authorizationObject;
	}

	public AuthorizationsObject12 setAuthorizationObject(
			List<AuthorizationObject12> authorizationObject) {
				this.authorizationObject = authorizationObject;
				return this;
			}
}
