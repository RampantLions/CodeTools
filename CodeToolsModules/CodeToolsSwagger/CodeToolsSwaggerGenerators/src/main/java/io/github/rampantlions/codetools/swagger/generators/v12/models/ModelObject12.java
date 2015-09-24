/* @(#)Model.java Sep 11, 2015
 *
 * Copyright (c) 2015. All rights reserved.
 */

package io.github.rampantlions.codetools.swagger.generators.v12.models;

import java.util.List;
import java.util.Map;

import io.github.rampantlions.codetools.annotations.Required;
import io.github.rampantlions.codetools.CommonModel;

/**
 * The Class Model.
 * A Model Object holds the definition of a new model for this API Declaration.
 *
 * Models in Swagger allow for inheritance. The inheritance is controlled by two fields - subTypes to give
 * the name of the models extending this definition, and discriminator to support polymorphism.
 *
 * subTypes: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#modelSubTypes
 * discriminator: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#modelDiscriminator
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#527-model-object
 *
 * Model Objects:
 * The Models Object holds a field per model definition, and this is different than the structure of the other
 * objects in the spec. It follows a subset of the JSON-Schema specification.
 *
 * JSON-Schema: http://json-schema.org/
 *
 * Source: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#526-models-object
 *
 * @author Wiechman, Joshua <josh.wiechman@gmail.com>
 */
@java.lang.SuppressWarnings("serial")
@org.codehaus.jackson.map.annotate.JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@org.codehaus.jackson.annotate.JsonPropertyOrder({ "description",
		"discriminator", "id", "properties", "required", "subTypes" })
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonPropertyOrder({ "description",
		"discriminator", "id", "properties", "required", "subTypes" })
@com.wordnik.swagger.annotations.ApiModel(value = "ModelObject12", description = "ResourceListing12 ModelObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class)
@javax.persistence.Entity(name = "Swagger12_ModelObject12")
@javax.persistence.Table(name = "Swagger12_ModelObject12", uniqueConstraints = @javax.persistence.UniqueConstraint(columnNames = { "Hibernate__ID" }))
@javax.persistence.NamedQueries({
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12.all", query = "SELECT a FROM ModelObject12 a"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12.id__", query = "SELECT a FROM ModelObject12 a WHERE a.id__ = :id__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12.version__", query = "SELECT a FROM ModelObject12 a WHERE a.version__ = :version__"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12.description", query = "SELECT a FROM ModelObject12 a WHERE a.description = :description"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12.discriminator", query = "SELECT a FROM ModelObject12 a WHERE a.discriminator = :discriminator"),
		@javax.persistence.NamedQuery(name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelObject12.id", query = "SELECT a FROM ModelObject12 a WHERE a.id = :id") })
public class ModelObject12 extends CommonModel< ModelObject12 >
{

	/**
	 * The description.
	 * A brief description of this model.
	 */
	@org.codehaus.jackson.annotate.JsonProperty("description")
	@com.fasterxml.jackson.annotation.JsonProperty("description")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("description")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "description entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "description")
	protected String description;

	/**
	 * The discriminator.
	 * MUST be included only if subTypes is included. This field allows for polymorphism within the described
	 * inherited models. This field MAY be included at any base model but MUST NOT be included in a sub-model.
	 * The value of this field MUST be a name of one of the properties in this model, and that field MUST be in the
	 * required list. When used, the value of the discriminator property MUST be the name of the parent model or any
	 * of its sub-models (to any depth of inheritance).
	 */
	@org.codehaus.jackson.annotate.JsonProperty("discriminator")
	@com.fasterxml.jackson.annotation.JsonProperty("discriminator")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("discriminator")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "discriminator entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "discriminator")
	protected String discriminator;

	/**
	 * The id.
	 * Required. A unique identifier for the model. This MUST be the name given to {Model Name}.
	 *
	 * Model Name: https://github.com/swagger-api/swagger-spec/blob/master/versions/1.2.md#modelsModelname
	 */
	@Required
	@org.codehaus.jackson.annotate.JsonProperty("id")
	@com.fasterxml.jackson.annotation.JsonProperty("id")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("id")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "id entry.", notes = " ", required = true)
	@javax.persistence.Column(name = "id")
	protected String id;

	/**
	 * The properties.
	 * Required. A list of properties (fields) that are part of the model
	 */
	@Required
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("properties")
	@com.fasterxml.jackson.annotation.JsonProperty("properties")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("properties")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "properties entry.", notes = " ", required = true)
	@javax.persistence.OneToMany
	@javax.persistence.ElementCollection(fetch = javax.persistence.FetchType.EAGER)
	@javax.persistence.Column(name = "properties")
	@javax.persistence.JoinTable(name = "Swagger12_ModelObject12_properties")
	@javax.persistence.MapKeyColumn(name = "propertyObject12_id")
	protected Map< String, PropertyObject12 > properties = new java.util.HashMap<>();

	/**
	 * The required.
	 * A definition of which properties MUST exist when a model instance is produced.
	 * The values MUST be the {Property Name} of one of the properties.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("required")
	@com.fasterxml.jackson.annotation.JsonProperty("required")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("required")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "required entry.", notes = " ", required = true)
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_ModelObject12_required")
	@javax.persistence.Column(name = "required")
	@javax.persistence.OrderColumn(name = "required_index")
	protected List< String > required = new java.util.ArrayList<>();

	/**
	 * The sub types.
	 * List of the model ids that inherit from this model. Sub models inherit all the properties of the parent model. Since inheritance is transitive, if the parent of a model inherits from another model, its sub-model will include all properties. As such, if you have Foo->Bar->Baz, then Baz will inherit the properties of Bar and Foo. There MUST NOT be a cyclic definition of inheritance. For example, if Foo -> ... -> Bar, having Bar -> ... -> Foo is not allowed. There also MUST NOT be a case of multiple inheritance. For example, Foo -> Baz <- Bar is not allowed. A sub-model definition MUST NOT override the properties of any of its ancestors. All sub-models MUST be defined in the same API Declaration.
	 */
	@javax.validation.Valid
	@org.codehaus.jackson.annotate.JsonProperty("subTypes")
	@com.fasterxml.jackson.annotation.JsonProperty("subTypes")
	@com.google.gson.annotations.Expose
	@com.google.gson.annotations.SerializedName("subTypes")
	@com.wordnik.swagger.annotations.ApiModelProperty(value = "subTypes entry.", notes = " ", required = true)
	@javax.persistence.ElementCollection
	@javax.persistence.CollectionTable(name = "Swagger12_ModelObject12_subTypes")
	@javax.persistence.Column(name = "subTypes")
	@javax.persistence.OrderColumn(name = "subTypes_index")
	protected List< String > subTypes = new java.util.ArrayList<>();

	public String getDescription() {
		return description;
	}

	public ModelObject12 setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getDiscriminator() {
		return discriminator;
	}

	public ModelObject12 setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
		return this;
	}

	public String getId() {
		return id;
	}

	public ModelObject12 setId(String id) {
		this.id = id;
		return this;
	}

	public Map<String, PropertyObject12> getProperties() {
		return properties;
	}

	public ModelObject12 setProperties(Map<String, PropertyObject12> properties) {
		this.properties = properties;
		return this;
	}

	public List<String> getRequired() {
		return required;
	}

	public ModelObject12 setRequired(List<String> required) {
		this.required = required;
		return this;
	}

	public List<String> getSubTypes() {
		return subTypes;
	}

	public ModelObject12 setSubTypes(List<String> subTypes) {
		this.subTypes = subTypes;
		return this;
	}

}
