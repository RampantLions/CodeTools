/* @(#)ApiDeclaration12.java Sep 15, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class ApiDeclaration12.
 * The API Declaration provides information about an API exposed on a resource. There should be one file
 * per Resource described. The file MUST be served in the URL described by the path field.
 *
 * Resource: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#512-resource-object
 * Path: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#aePath
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#52-api-declaration
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "apis", "apiVersion",
		"authorizations", "basePath", "consumes", "models", "produces",
		"resourcePath", "swaggerVersion" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "apis", "apiVersion",
		"authorizations", "basePath", "consumes", "models", "produces",
		"resourcePath", "swaggerVersion" })
@com.wordnik.swagger.annotations.ApiModel(value = "ApiDeclaration12", description = "ResourceListing12 ApiDeclaration12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ApiDeclaration12")
@javax.persistence.Table(name = "Swagger12_ApiDeclaration12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.all", query = "SELECT a FROM ApiDeclaration12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.id__", query = "SELECT a FROM ApiDeclaration12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.version__", query = "SELECT a FROM ApiDeclaration12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.apiVersion", query = "SELECT a FROM ApiDeclaration12 a WHERE a.apiVersion = :apiVersion"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.authorizations", query = "SELECT a FROM ApiDeclaration12 a WHERE a.authorizations = :authorizations"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.basePath", query = "SELECT a FROM ApiDeclaration12 a WHERE a.basePath = :basePath"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.resourcePath", query = "SELECT a FROM ApiDeclaration12 a WHERE a.resourcePath = :resourcePath"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ApiDeclaration12.swaggerVersion", query = "SELECT a FROM ApiDeclaration12 a WHERE a.swaggerVersion = :swaggerVersion") })
public class ApiDeclaration12 extends CommonModel<ApiDeclaration12>
{

	/**
	 * The apis.
	 *
	 * Required. Lists the resources to be described by this specification implementation.
	 * The array can have 0 or more elements.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("apis")
	@com.fasterxml.jackson.annotation.JsonProperty("apis")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("apis")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apis entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.OneToMany(mappedBy = "apiDeclaration12__href")
	@javax.persistence.OrderColumn(name = "apis_index")
	protected List< ApiObject12 > apis = new java.util.ArrayList<>();

	/**
	 * The api version.
	 *
	 * Provides the version of the application API (not to be confused by the specification version).
	 * specification version: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#rlSwaggerVersion
	 */
	@org.codehaus.jackson.annotate.JsonProperty("apiVersion")
	@com.fasterxml.jackson.annotation.JsonProperty("apiVersion")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("apiVersion")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apiVersion entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "apiVersion")
	protected String apiVersion;

	/**
	 * The authorizations.
	 * Provides information about the authorization schemes allowed on this API.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("authorizations")
	@com.fasterxml.jackson.annotation.JsonProperty("authorizations")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("authorizations")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "authorizations entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.PrimaryKeyJoinColumn
	@javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
	protected AuthorizationObject12 authorizations;

	/**
	 * The base path.
	 * Required. The root URL serving the API. This field is important because while it is common to have
	 * the Resource Listing and API Declarations on the server providing the APIs themselves, it is not a
	 * requirement. The API specifications can be served using static files and not generated by the API
	 * server itself, so the URL for serving the API cannot always be derived from the URL serving the API
	 * specification. The value SHOULD be in the format of a URL.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("basePath")
	@com.fasterxml.jackson.annotation.JsonProperty("basePath")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("basePath")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "basePath entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "basePath")
	String basePath;

	/**
	 * The consumes.
	 *
	 * A list of MIME types the APIs can consume. This is global to all APIs but can be overridden on
	 * specific API calls. Value MUST be as described under Mime Types.
	 *
	 * Mime Types: https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#mimeTypes
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("consumes")
	@com.fasterxml.jackson.annotation.JsonProperty("consumes")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("consumes")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "consumes entry.", notes = " ", required = true)
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_ApiDeclaration12_consumes")
	@javax.persistence.Column(name = "consumes")
	@javax.persistence.OrderColumn(name = "consumes_index")
	protected List< String > consumes = new java.util.ArrayList<>();

	/**
	 * The models.
	 * A list of the models available to this resource. Note that these need to be exposed separately
	 * for each API Declaration.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("models")
	@com.fasterxml.jackson.annotation.JsonProperty("models")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("models")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "models entry.", notes = " ", required = true)
	@javax.persistence.OneToMany
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.EAGER)
	@javax.persistence.Column(name = "models")
	@javax.persistence.JoinTable(name = "Swagger12_ApiDeclaration12_models")
	@javax.persistence.MapKeyColumn(name = "modelObject12_id")
	Map< String, ModelObject12 > models = new java.util.HashMap<>();

	/**
	 * The produces.
	 *
	 * A list of MIME types the APIs can produce. This is global to all APIs but can be overridden on
	 * specific API calls. Value MUST be as described under Mime Types.
	 *
	 * Mime Types: https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#mimeTypes
	 */
	@org.codehaus.jackson.annotate.JsonProperty("produces")
	@com.fasterxml.jackson.annotation.JsonProperty("produces")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("produces")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "produces entry.", notes = " ", required = true)
	@javax.validation.Valid
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_ApiDeclaration12_produces")
	@javax.persistence.Column(name = "produces")
	@javax.persistence.OrderColumn(name = "produces_index")
	protected List< String > produces = new java.util.ArrayList<>();

	/**
	 * The resource path.
	 * The relative path to the resource, from the basePath, which this API Specification describes.
	 * The value MUST precede with a forward slash ("/").
	 */
	@org.codehaus.jackson.annotate.JsonProperty("resourcePath")
	@com.fasterxml.jackson.annotation.JsonProperty("resourcePath")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("resourcePath")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "resourcePath entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "resourcePath")
	protected String resourcePath;

	/**
	 * The swagger version.
	 *
	 * Required. Specifies the Swagger Specification version being used. It can be used by the Swagger UI
	 * and other clients to interpret the API listing. The value MUST be an existing Swagger specification version.
	 * Currently, "1.0", "1.1", "1.2" are valid values. The field is a string type for possible non-numeric versions
	 * in the future (for example, "1.2a").
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("swaggerVersion")
	@com.fasterxml.jackson.annotation.JsonProperty("swaggerVersion")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("swaggerVersion")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "swaggerVersion entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "swaggerVersion")
	protected String swaggerVersion;

	public List<ApiObject12> getApis() {
		return apis;
	}

	public ApiDeclaration12 setApis(List<ApiObject12> apis) {
		this.apis = apis;
		return this;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public ApiDeclaration12 setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
		return this;
	}

	public AuthorizationObject12 getAuthorizations() {
		return authorizations;
	}

	public ApiDeclaration12 setAuthorizations(AuthorizationObject12 authorizations) {
		this.authorizations = authorizations;
		return this;
	}

	public String getBasePath() {
		return basePath;
	}

	public ApiDeclaration12 setBasePath(String basePath) {
		this.basePath = basePath;
		return this;
	}

	public List<String> getConsumes() {
		return consumes;
	}

	public ApiDeclaration12 setConsumes(List<String> consumes) {
		this.consumes = consumes;
		return this;
	}

	public Map<String, ModelObject12> getModels() {
		return models;
	}

	public ApiDeclaration12 setModels(Map<String, ModelObject12> models) {
		this.models = models;
		return this;
	}

	public List<String> getProduces() {
		return produces;
	}

	public ApiDeclaration12 setProduces(List<String> produces) {
		this.produces = produces;
		return this;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public ApiDeclaration12 setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
		return this;
	}

	public String getSwaggerVersion() {
		return swaggerVersion;
	}

	public ApiDeclaration12 setSwaggerVersion(String swaggerVersion) {
		this.swaggerVersion = swaggerVersion;
		return this;
	}
}
