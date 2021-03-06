
package io.github.rampantlions.codetools.swagger.generators.v12.models;

import io.github.rampantlions.codetools.CommonModel;

@java.lang.SuppressWarnings( "serial" )
@org.codehaus.jackson.map.annotate.JsonSerialize( include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL )
@org.codehaus.jackson.annotate.JsonPropertyOrder( {} )
@com.fasterxml.jackson.annotation.JsonInclude( com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL )
@com.fasterxml.jackson.annotation.JsonPropertyOrder( {} )
@com.wordnik.swagger.annotations.ApiModel( value = "ModelsObject12", description = "ResourceListing12 ModelsObject12 model.", discriminator = "io.github.rampantlions.codetools.CommonModel.class", parent = io.github.rampantlions.codetools.CommonModel.class )
@javax.persistence.Entity( name = "Swagger12_ModelsObject12" )
@javax.persistence.Table( name = "Swagger12_ModelsObject12", uniqueConstraints = @javax.persistence.UniqueConstraint( columnNames = { "Hibernate__ID" } ) )
@javax.persistence.NamedQueries( { @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelsObject12.all", query = "SELECT a FROM ModelsObject12 a" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelsObject12.id__", query = "SELECT a FROM ModelsObject12 a WHERE a.id__ = :id__" ), @javax.persistence.NamedQuery( name = "io.github.rampantlions.codetools.swagger.generators.v12.models.ModelsObject12.version__", query = "SELECT a FROM ModelsObject12 a WHERE a.version__ = :version__" ) } )
public class ModelsObject12 extends CommonModel< ModelsObject12 >
{

}
