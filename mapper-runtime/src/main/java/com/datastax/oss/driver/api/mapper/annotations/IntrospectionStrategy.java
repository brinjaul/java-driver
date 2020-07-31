/*
 * Copyright DataStax, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastax.oss.driver.api.mapper.annotations;

import com.datastax.oss.driver.api.mapper.entity.naming.GetterStyle;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates an {@link Entity} to customize certain aspects of the introspection process that
 * determines which methods are considered as properties, and how new instances will be created.
 *
 * <p>Example:
 *
 * <pre>
 * &#64;Entity
 * &#64;IntrospectionStrategy(getterStyle = SHORT)
 * public class Product {
 *   ...
 * }
 * </pre>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntrospectionStrategy {

  /** The style of getter. See {@link GetterStyle} and its constants for more explanations. */
  GetterStyle getterStyle() default GetterStyle.JAVABEANS;

  /**
   * Whether the entity is mutable.
   *
   * <p>If this is set to false:
   *
   * <ul>
   *   <li>the mapper won't try to discover setters for the properties;
   *   <li>it will assume that the entity class has a visible constructor that takes all the
   *       non-transient properties as arguments.
   * </ul>
   */
  boolean mutable() default true;
}