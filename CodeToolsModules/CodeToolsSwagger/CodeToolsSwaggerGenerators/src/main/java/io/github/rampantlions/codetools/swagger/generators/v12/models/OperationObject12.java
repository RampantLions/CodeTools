/* @(#)Operation.java Sep 11, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.annotations.RequiredIf;
import io.github.rampantlions.codetools.annotations.Validity;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Operation.
 * The Operation Object describes a single operation on a path.
 * In the operations array, there MUST be only one Operation Object per method.
 *
 * This object includes the Data Type Fields in order to describe the return value of the operation.
 * The type field MUST be used to link to other models.
 *
 * This is the only object where the type MAY have the value of void to indicate that the operation returns no value.
 *
 * Path: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#apiPath
 * Operation Object: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#523-operation-object
 * Method: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#operationMethod
 * Data Type Fields: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#dataTypeType
 * Type: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#dataTypeType
 * Void: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#432-void
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#523-operation-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings( "serial" )
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "authorizations",
		"consumes", "defaultValue", "deprecated", "enums", "format", "items",
		"maximum", "method", "minimum", "nickname", "notes", "parameters",
		"produces", "ref", "responseMessages", "summary", "type", "uniqueItems" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "authorizations",
		"consumes", "defaultValue", "deprecated", "enums", "format", "items",
		"maximum", "method", "minimum", "nickname", "notes", "parameters",
		"produces", "ref", "responseMessages", "summary", "type", "uniqueItems" })
@com.wordnik.swagger.annotations.ApiModel(value = "OperationObject12", description = "ResourceListing12 OperationObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_OperationObject12")
@javax.persistence.Table(name = "Swagger12_OperationObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.all", query = "SELECT a FROM OperationObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.id__", query = "SELECT a FROM OperationObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.version__", query = "SELECT a FROM OperationObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.defaultValue", query = "SELECT a FROM OperationObject12 a WHERE a.defaultValue = :defaultValue"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.deprecated", query = "SELECT a FROM OperationObject12 a WHERE a.deprecated = :deprecated"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.format", query = "SELECT a FROM OperationObject12 a WHERE a.format = :format"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.maximum", query = "SELECT a FROM OperationObject12 a WHERE a.maximum = :maximum"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.method", query = "SELECT a FROM OperationObject12 a WHERE a.method = :method"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.minimum", query = "SELECT a FROM OperationObject12 a WHERE a.minimum = :minimum"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.nickname", query = "SELECT a FROM OperationObject12 a WHERE a.nickname = :nickname"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.notes", query = "SELECT a FROM OperationObject12 a WHERE a.notes = :notes"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.ref", query = "SELECT a FROM OperationObject12 a WHERE a.ref = :ref"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.summary", query = "SELECT a FROM OperationObject12 a WHERE a.summary = :summary"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.type", query = "SELECT a FROM OperationObject12 a WHERE a.type = :type"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.OperationObject12.uniqueItems", query = "SELECT a FROM OperationObject12 a WHERE a.uniqueItems = :uniqueItems") })
public class OperationObject12 extends CommonModel< OperationObject12 >
{

	/**
	 * The authorizations.
	 * A list of authorizations required to execute this operation. While not mandatory, if used, it overrides
	 * the value given at the API Declaration's authorizations. In order to completely remove API Declaration's
	 * authorizations completely, an empty object ({}) may be applied.
	 *
	 * authorizations: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#adAuthorizations
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("authorizations")
	@com.fasterxml.jackson.annotation.JsonProperty("authorizations")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("authorizations")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "authorizations entry.", notes = " ", required = true)
	@javax.persistence.OneToMany
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.EAGER)
	@javax.persistence.Column(name = "authorizations")
	@javax.persistence.JoinTable(name = "Swagger12_OperationObject12_authorizations")
	@javax.persistence.MapKeyColumn(name = "authorizationObject12_id")
	protected Map< String, AuthorizationObject12 > authorizations = new java.util.HashMap<>();

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
	@javax.persistence.CollectionTable(name = "Swagger12_OperationObject12_consumes")
	@javax.persistence.Column(name = "consumes")
	@javax.persistence.OrderColumn(name = "consumes_index")
	protected List< String > consumes = new java.util.ArrayList<>();

	/**
	 * The default value.
	 * The default value to be used for the field. The value type MUST conform with the primitive's type value.
	 */
	@Validity( "primitive" )
	@org.codehaus.jackson.annotate.JsonProperty("defaultValue")
	@com.fasterxml.jackson.annotation.JsonProperty("defaultValue")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("defaultValue")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "defaultValue entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "defaultValue")
	protected Object defaultValue;

	/**
	 * The deprecated.
	 * Declares this operation to be deprecated. Usage of the declared operation should be refrained.
	 * Valid value MUST be either "true" or "false". Note: This field will change to type boolean in the future.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("deprecated")
	@com.fasterxml.jackson.annotation.JsonProperty("deprecated")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("deprecated")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "deprecated entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "deprecated")
	protected String deprecated;

	/**
	 * The enum.
	 * A fixed list of possible values. If this field is used in conjunction with the defaultValue field,
	 * then the default value MUST be one of the values defined in the enum.
	 */
	@Validity( "string" )
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("enums")
	@com.fasterxml.jackson.annotation.JsonProperty("enums")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("enums")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "enums entry.", notes = " ", required = true)
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_OperationObject12_enums")
	@javax.persistence.Column(name = "enums")
	@javax.persistence.OrderColumn(name = "enums_index")
	protected List< String > enums = new java.util.ArrayList<>();

	/**
	 * The format.
	 * Fine-tuned primitive type definition. See Primitives for further information.
	 * The value MUST be one that is defined under Primitives, corresponding to the right primitive type.
	 */
	@Validity( "primitive" )
	@org.codehaus.jackson.annotate.JsonProperty("format")
	@com.fasterxml.jackson.annotation.JsonProperty("format")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("format")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "format entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "format")
	protected String format;

	/**
	 * The items.
	 * Required. The type definition of the values in the container. A container MUST NOT be nested in another
	 * container.
	 */
	@Validity( "array" )
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("items")
	@com.fasterxml.jackson.annotation.JsonProperty("items")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("items")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "items entry.", notes = " ", required = true)
	@javax.persistence.OneToMany(mappedBy = "operationObject12__href")
	@javax.persistence.OrderColumn(name = "items_index")
	protected List< ItemObject12 > items = new ArrayList<>();

	/**
	 * The maximum.
	 * The maximum valid value for the type, inclusive. If this field is used in conjunction with the defaultValue
	 * field, then the default value MUST be lower than or equal to this value. The value type is string and should
	 * represent the maximum numeric value. Note: This will change to a numeric value in the future.
	 */
	@Validity( "number, integer" )
	@org.codehaus.jackson.annotate.JsonProperty("maximum")
	@com.fasterxml.jackson.annotation.JsonProperty("maximum")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("maximum")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "maximum entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "maximum")
	protected String maximum;

	/**
	 * The method.
	 * Required. The HTTP method required to invoke this operation. The value MUST be one of the following values:
	 * "GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS". The values MUST be in uppercase.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("method")
	@com.fasterxml.jackson.annotation.JsonProperty("method")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("method")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "method entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "method")
	protected String method;

	/**
	 * The minimum.
	 * The minimum valid value for the type, inclusive. If this field is used in conjunction with the defaultValue
	 * field, then the default value MUST be higher than or equal to this value. The value type is string and should
	 * represent the minimum numeric value. Note: This will change to a numeric value in the future.
	 */
	@Validity( "number, integer" )
	@org.codehaus.jackson.annotate.JsonProperty("minimum")
	@com.fasterxml.jackson.annotation.JsonProperty("minimum")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("minimum")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "minimum entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "minimum")
	protected String minimum;

	/**
	 * The nickname.
	 * Required. A unique id for the operation that can be used by tools reading the output for further and
	 * easier manipulation. For example, Swagger-Codegen will use the nickname as the method name of the
	 * operation in the client it generates. The value MUST be alphanumeric and may include underscores.
	 * Whitespace characters are not allowed.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("nickname")
	@com.fasterxml.jackson.annotation.JsonProperty("nickname")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("nickname")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "nickname entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "nickname")
	protected String nickname;

	/**
	 * The notes.
	 * A verbose explanation of the operation behavior.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("notes")
	@com.fasterxml.jackson.annotation.JsonProperty("notes")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("notes")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "notes entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "notes")
	protected String notes;

	/**
	 * The parameters.
	 * Required. The inputs to the operation. If no parameters are needed, an empty array MUST be included.
	 */
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("parameters")
	@com.fasterxml.jackson.annotation.JsonProperty("parameters")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("parameters")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "parameters entry.", notes = " ", required = true)
	@javax.persistence.OneToMany(mappedBy = "operationObject12__href")
	@javax.persistence.OrderColumn(name = "parameters_index")
	protected List< ParameterObject12 > parameters = new java.util.ArrayList<>();

	/**
	 * The produces.
	 *
	 * A list of MIME types the APIs can produce. This is global to all APIs but can be overridden on
	 * specific API calls. Value MUST be as described under Mime Types.
	 *
	 * Mime Types: https://github.com/swagger-api/swagger-spec/blob/master/versions/2.0.md#mimeTypes
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("produces")
	@com.fasterxml.jackson.annotation.JsonProperty("produces")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("produces")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "produces entry.", notes = " ", required = true)
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_OperationObject12_produces")
	@javax.persistence.Column(name = "produces")
	@javax.persistence.OrderColumn(name = "produces_index")
	protected List< String > produces = new java.util.ArrayList<>();

	/**
	 * The $ref.
	 * Required (if type is not used). The Model to be used. The value MUST be a model's id.
	 */
	@RequiredIf( "if type is not used" )
	@Validity( "Any" )
	@org.codehaus.jackson.annotate.JsonProperty("ref")
	@com.fasterxml.jackson.annotation.JsonProperty("ref")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("ref")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "ref entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "ref")
	protected String ref;

	/**
	 * The response messages.
	 * Lists the possible response statuses that can return from the operation.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("responseMessages")
	@com.fasterxml.jackson.annotation.JsonProperty("responseMessages")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("responseMessages")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "responseMessages entry.", notes = " ", required = true)
	@javax.persistence.OneToMany(mappedBy = "operationObject12__href")
	@javax.persistence.OrderColumn(name = "responseMessages_index")
	protected List< ResponseMessageObject12 > responseMessages = new java.util.ArrayList<>();

	/**
	 * The summary.
	 * A short summary of what the operation does. For maximum readability in the swagger-ui, this
	 * field SHOULD be less than 120 characters.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("summary")
	@com.fasterxml.jackson.annotation.JsonProperty("summary")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("summary")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "summary entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "summary")
	protected String summary;

	/**
	 * The type.
	 * Required (if $ref is not used). The return type of the operation. The value MUST be
	 * one of the Primitives, array or a model's id.
	 */
	@RequiredIf( "if $ref is not used" )
	@Validity( "Any" )
	@org.codehaus.jackson.annotate.JsonProperty("type")
	@com.fasterxml.jackson.annotation.JsonProperty("type")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("type")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "type entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "type")
	protected String type;

	/**
	 * The unique items.
	 * A flag to note whether the container allows duplicate values or not. If the value is set to true,
	 * then the array acts as a set.
	 */
	@Validity( "array" )
	@org.codehaus.jackson.annotate.JsonProperty("uniqueItems")
	@com.fasterxml.jackson.annotation.JsonProperty("uniqueItems")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("uniqueItems")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "uniqueItems entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "uniqueItems")
	@org.hibernate.annotations.Type(type = "true_false")
	boolean uniqueItems;

	@org.codehaus.jackson.annotate.JsonIgnore
	@com.fasterxml.jackson.annotation.JsonIgnore
	@io.github.rampantlions.codetools.gson.annotations.GsonExclude

	@javax.xml.bind.annotation.XmlTransient
	@javax.persistence.ManyToOne
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "apiObject12__href entry.", notes = " ", required = true)
	@javax.validation.Valid
	protected ApiObject12 apiObject12__href;

	public Map< String, AuthorizationObject12 > getAuthorizations()
	{
		return authorizations;
	}

	public OperationObject12 setAuthorizations( Map< String, AuthorizationObject12 > authorizations )
	{
		this.authorizations = authorizations;
		return this;
	}

	public List< String > getConsumes()
	{
		return consumes;
	}

	public OperationObject12 setConsumes( List< String > consumes )
	{
		this.consumes = consumes;
		return this;
	}

	public Object getDefaultValue()
	{
		return defaultValue;
	}

	public OperationObject12 setDefaultValue( Object defaultValue )
	{
		this.defaultValue = defaultValue;
		return this;
	}

	public String getDeprecated()
	{
		return deprecated;
	}

	public OperationObject12 setDeprecated( String deprecated )
	{
		this.deprecated = deprecated;
		return this;
	}

	public List< String > getEnums()
	{
		return enums;
	}

	public OperationObject12 setEnums( List< String > enums )
	{
		this.enums = enums;
		return this;
	}

	public String getFormat()
	{
		return format;
	}

	public OperationObject12 setFormat( String format )
	{
		this.format = format;
		return this;
	}

	public List< ItemObject12 > getItems()
	{
		return items;
	}

	public OperationObject12 setItems( List< ItemObject12 > items )
	{
		this.items = items;
		return this;
	}

	public String getMaximum()
	{
		return maximum;
	}

	public OperationObject12 setMaximum( String maximum )
	{
		this.maximum = maximum;
		return this;
	}

	public String getMethod()
	{
		return method;
	}

	public OperationObject12 setMethod( String method )
	{
		this.method = method;
		return this;
	}

	public String getMinimum()
	{
		return minimum;
	}

	public OperationObject12 setMinimum( String minimum )
	{
		this.minimum = minimum;
		return this;
	}

	public String getNickname()
	{
		return nickname;
	}

	public OperationObject12 setNickname( String nickname )
	{
		this.nickname = nickname;
		return this;
	}

	public String getNotes()
	{
		return notes;
	}

	public OperationObject12 setNotes( String notes )
	{
		this.notes = notes;
		return this;
	}

	public List< ParameterObject12 > getParameters()
	{
		return parameters;
	}

	public OperationObject12 setParameters( List< ParameterObject12 > parameters )
	{
		this.parameters = parameters;
		return this;
	}

	public List< String > getProduces()
	{
		return produces;
	}

	public OperationObject12 setProduces( List< String > produces )
	{
		this.produces = produces;
		return this;
	}

	public String getRef()
	{
		return ref;
	}

	public OperationObject12 setRef( String ref )
	{
		this.ref = ref;
		return this;
	}

	public List< ResponseMessageObject12 > getResponseMessages()
	{
		return responseMessages;
	}

	public OperationObject12 setResponseMessages( List< ResponseMessageObject12 > responseMessages )
	{
		this.responseMessages = responseMessages;
		return this;
	}

	public String getSummary()
	{
		return summary;
	}

	public OperationObject12 setSummary( String summary )
	{
		this.summary = summary;
		return this;
	}

	public String getType()
	{
		return type;
	}

	public OperationObject12 setType( String type )
	{
		this.type = type;
		return this;
	}

	public boolean getUniqueItems()
	{
		return uniqueItems;
	}

	public OperationObject12 setUniqueItems( boolean uniqueItems )
	{
		this.uniqueItems = uniqueItems;
		return this;
	}

	public ApiObject12 getApiObject12__href() {
		return apiObject12__href;
	}

	public OperationObject12 setApiObject12__href(ApiObject12 apiObject12__href) {
		this.apiObject12__href = apiObject12__href;
		return this;
	}
}
