/* @(#)Parameter.java Sep 11, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.ArrayList;
import java.util.List;

import io.github.rampantlions.codetools.annotations.Recommended;
import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.annotations.RequiredIf;
import io.github.rampantlions.codetools.annotations.Validity;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Parameter.
 * The Parameter Object describes a single parameter to be sent in an operation and maps to the parameters field in the Operation Object.
 *
 * This object includes the Data Type Fields in order to describe the type of this parameter. The type field MUST be used to link to other models.
 *
 * If type is File, the consumes field MUST be "multipart/form-data", and the paramType MUST be "form".
 *
 * parameters: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#operationParameters
 * Operation Object: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#523-operation-object
 * Data Type Fields: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#433-data-type-fields
 * type: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#dataTypeType
 * File: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#434-file
 * consumes: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#operationConsumes
 * paramType: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#parameterParamType
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#524-parameter-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "allowMultiple",
		"defaultValue", "description", "enums", "format", "items", "maximum",
		"minimum", "name", "paramType", "ref", "required", "type",
		"uniqueItems" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "allowMultiple",
		"defaultValue", "description", "enums", "format", "items", "maximum",
		"minimum", "name", "paramType", "ref", "required", "type",
		"uniqueItems" })
@com.wordnik.swagger.annotations.ApiModel(value = "ParameterObject12", description = "ResourceListing12 ParameterObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ParameterObject12")
@javax.persistence.Table(name = "Swagger12_ParameterObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.all", query = "SELECT a FROM ParameterObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.id__", query = "SELECT a FROM ParameterObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.version__", query = "SELECT a FROM ParameterObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.allowMultiple", query = "SELECT a FROM ParameterObject12 a WHERE a.allowMultiple = :allowMultiple"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.defaultValue", query = "SELECT a FROM ParameterObject12 a WHERE a.defaultValue = :defaultValue"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.description", query = "SELECT a FROM ParameterObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.format", query = "SELECT a FROM ParameterObject12 a WHERE a.format = :format"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.maximum", query = "SELECT a FROM ParameterObject12 a WHERE a.maximum = :maximum"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.minimum", query = "SELECT a FROM ParameterObject12 a WHERE a.minimum = :minimum"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.name", query = "SELECT a FROM ParameterObject12 a WHERE a.name = :name"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.paramType", query = "SELECT a FROM ParameterObject12 a WHERE a.paramType = :paramType"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.ref", query = "SELECT a FROM ParameterObject12 a WHERE a.ref = :ref"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.required", query = "SELECT a FROM ParameterObject12 a WHERE a.required = :required"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.type", query = "SELECT a FROM ParameterObject12 a WHERE a.type = :type"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ParameterObject12.uniqueItems", query = "SELECT a FROM ParameterObject12 a WHERE a.uniqueItems = :uniqueItems") })
public class ParameterObject12 extends CommonModel< ParameterObject12 >
{

	/**
	 * The allow multiple.
	 * Another way to allow multiple values for a "query" parameter. If used, the query parameter may
	 * accept comma-separated values. The field may be used only if paramType is "query",
	 * "header" or "path".
	 *
	 * paramType: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#parameterParamType
	 */
	@org.codehaus.jackson.annotate.JsonProperty("allowMultiple")
	@com.fasterxml.jackson.annotation.JsonProperty("allowMultiple")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("allowMultiple")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "allowMultiple entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "allowMultiple")
	@org.hibernate.annotations.Type(type = "true_false")
	protected boolean allowMultiple;

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
	 * The description.
	 * Recommended. A brief description of this parameter.
	 */
	@Recommended
	@org.codehaus.jackson.annotate.JsonProperty("description")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("description")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "description entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "description")
	protected String description;

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
	@javax.persistence.CollectionTable(name = "Swagger12_ParameterObject12_enums")
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
	@javax.persistence.OneToMany(mappedBy = "parameterObject12__href")
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
	 * The name.
	 * Required. The unique name for the parameter. Each name MUST be unique, even if they are associated with different paramType values. Parameter names are case sensitive.
	 *
	 * If paramType is "path", the name field MUST correspond to the associated path segment from the path field in the API Object.
	 * If paramType is "query", the name field corresponds to the query parameter name.
	 * If paramType is "body", the name is used only for Swagger-UI and Swagger-Codegen. In this case, the name MUST be "body".
	 * If paramType is "form", the name field corresponds to the form parameter key.
	 * If paramType is "header", the name field corresponds to the header parameter key.
	 *
	 * Examples: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#5241-name-examples
	 *
	 * paramType: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#parameterParamType
	 * path: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#apiPath
	 * API Object: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#522-api-object
	 */
	@org.codehaus.jackson.annotate.JsonProperty("name")
	@com.fasterxml.jackson.annotation.JsonProperty("name")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("name")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "name entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "name")
	protected String name;

	/**
	 * The param type.
	 * Required. The type of the parameter (that is, the location of the parameter in the request). The value MUST be one of these values: "path", "query", "body", "header", "form". Note that the values MUST be lower case.
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("paramType")
	@com.fasterxml.jackson.annotation.JsonProperty("paramType")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("paramType")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "paramType entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "paramType")
	protected String paramType;

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
	 * The required.
	 * A flag to note whether this parameter is required. If this field is not included, it is equivalent to adding
	 * this field with the value false. If paramType is "path" then this field MUST be included and have the value true.
	 *
	 * paramType: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#parameterParamType
	 */
	@org.codehaus.jackson.annotate.JsonProperty("required")
	@com.fasterxml.jackson.annotation.JsonProperty("required")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("required")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "required entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "required")
	@org.hibernate.annotations.Type(type = "true_false")
	protected boolean required;

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
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "operationObject12__href entry.", notes = " ", required = true)
	@javax.validation.Valid
	protected OperationObject12 operationObject12__href;

	public boolean getAllowMultiple() {
		return allowMultiple;
	}

	public ParameterObject12 setAllowMultiple(boolean allowMultiple) {
		this.allowMultiple = allowMultiple;
		return this;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public ParameterObject12 setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ParameterObject12 setDescription(String description) {
		this.description = description;
		return this;
	}

	public List<String> getEnums() {
		return enums;
	}

	public ParameterObject12 setEnums(List<String> enums) {
		this.enums = enums;
		return this;
	}

	public String getFormat() {
		return format;
	}

	public ParameterObject12 setFormat(String format) {
		this.format = format;
		return this;
	}

	public List<ItemObject12> getItems() {
		return items;
	}

	public ParameterObject12 setItems(List<ItemObject12> items) {
		this.items = items;
		return this;
	}

	public String getMaximum() {
		return maximum;
	}

	public ParameterObject12 setMaximum(String maximum) {
		this.maximum = maximum;
		return this;
	}

	public String getMinimum() {
		return minimum;
	}

	public ParameterObject12 setMinimum(String minimum) {
		this.minimum = minimum;
		return this;
	}

	public String getName() {
		return name;
	}

	public ParameterObject12 setName(String name) {
		this.name = name;
		return this;
	}

	public String getParamType() {
		return paramType;
	}

	public ParameterObject12 setParamType(String paramType) {
		this.paramType = paramType;
		return this;
	}

	public String getRef() {
		return ref;
	}

	public ParameterObject12 setRef(String ref) {
		this.ref = ref;
		return this;
	}

	public boolean getRequired() {
		return required;
	}

	public ParameterObject12 setRequired(boolean required) {
		this.required = required;
		return this;
	}

	public String getType() {
		return type;
	}

	public ParameterObject12 setType(String type) {
		this.type = type;
		return this;
	}

	public boolean getUniqueItems() {
		return uniqueItems;
	}

	public ParameterObject12 setUniqueItems(boolean uniqueItems) {
		this.uniqueItems = uniqueItems;
		return this;
	}

	public OperationObject12 getOperationObject12__href() {
		return operationObject12__href;
	}

	public ParameterObject12 setOperationObject12__href(
			OperationObject12 operationObject12__href) {
				this.operationObject12__href = operationObject12__href;
				return this;
			}
}
