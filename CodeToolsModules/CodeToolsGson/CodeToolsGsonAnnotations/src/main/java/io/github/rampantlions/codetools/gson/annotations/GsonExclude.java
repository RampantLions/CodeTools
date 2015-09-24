/* GsonExclude.java 1.00 Apr 11, 2015
*
* Copyright (c) 2015. All rights reserved.
* @author <a href="mailto:josh.wiechman@gmail.com">Wiechman, Joshua</a>
* 
*/
package io.github.rampantlions.codetools.gson.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* The Interface GsonExclude.
*/
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.FIELD, ElementType.METHOD } )
public @interface GsonExclude
{

}
