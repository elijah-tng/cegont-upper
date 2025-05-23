/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tripleo.vendor.org.apache.commons.lang3.builder;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Works with {@link ToStringBuilder} to create a {@code toString}.
 *
 * <p>This class is intended to be used as a singleton.
 * There is no need to instantiate a new style each time.
 * Simply instantiate the class once, customize the values as required, and
 * store the result in a public static final variable for the rest of the
 * program to access.</p>
 *
 * @since 1.0
 */
public class StandardToStringStyle extends ToStringStyle {

    /**
     * Required for serialization support.
     *
     * @see java.io.Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new instance.
     */
    public StandardToStringStyle() {
    }

    /**
     * Gets the array end text.
     *
     * @return the current array end text
     */
    @Override
    public String getArrayEnd() {
        return super.getArrayEnd();
    }

    /**
     * Gets the array separator text.
     *
     * @return the current array separator text
     */
    @Override
    public String getArraySeparator() {
        return super.getArraySeparator();
    }

    /**
     * Gets the array start text.
     *
     * @return the current array start text
     */
    @Override
    public String getArrayStart() {
        return super.getArrayStart();
    }

    /**
     * Gets the content end text.
     *
     * @return the current content end text
     */
    @Override
    public String getContentEnd() {
        return super.getContentEnd();
    }

    /**
     * Gets the content start text.
     *
     * @return the current content start text
     */
    @Override
    public String getContentStart() {
        return super.getContentStart();
    }

    /**
     * Gets the field name value separator text.
     *
     * @return the current field name value separator text
     */
    @Override
    public String getFieldNameValueSeparator() {
        return super.getFieldNameValueSeparator();
    }

    /**
     * Gets the field separator text.
     *
     * @return the current field separator text
     */
    @Override
    public String getFieldSeparator() {
        return super.getFieldSeparator();
    }

    /**
     * Gets the text to output when {@code null} found.
     *
     * @return the current text to output when {@code null} found
     */
    @Override
    public String getNullText() {
        return super.getNullText();
    }

    /**
     * Gets the end text to output when a {@link Collection},
     * {@link Map} or {@link Array} size is output.
     *
     * <p>This is output after the size value.</p>
     *
     * @return the current end of size text
     */
    @Override
    public String getSizeEndText() {
        return super.getSizeEndText();
    }

    /**
     * Gets the text to output when a {@link Collection},
     * {@link Map} or {@link Array} size is output.
     *
     * <p>This is output before the size value.</p>
     *
     * @return the current start of size text
     */
    @Override
    public String getSizeStartText() {
        return super.getSizeStartText();
    }

    /**
     * Gets the end text to output when an {@link Object} is
     * output in summary mode.
     *
     * <p>This is output after the size value.</p>
     *
     * @return the current end of summary text
     */
    @Override
    public String getSummaryObjectEndText() {
        return super.getSummaryObjectEndText();
    }

    /**
     * Gets the start text to output when an {@link Object} is
     * output in summary mode.
     *
     * <p>This is output before the size value.</p>
     *
     * @return the current start of summary text
     */
    @Override
    public String getSummaryObjectStartText() {
        return super.getSummaryObjectStartText();
    }

    /**
     * Gets whether to output array content detail.
     *
     * @return the current array content detail setting
     */
    @Override
    public boolean isArrayContentDetail() {
        return super.isArrayContentDetail();
    }

    /**
     * Gets whether to use full detail when the caller doesn't
     * specify.
     *
     * @return the current defaultFullDetail flag
     */
    @Override
    public boolean isDefaultFullDetail() {
        return super.isDefaultFullDetail();
    }

    /**
     * Gets whether the field separator should be added at the end
     * of each buffer.
     *
     * @return fieldSeparatorAtEnd flag
     * @since 2.0
     */
    @Override
    public boolean isFieldSeparatorAtEnd() {
        return super.isFieldSeparatorAtEnd();
    }

    /**
     * Gets whether the field separator should be added at the start
     * of each buffer.
     *
     * @return the fieldSeparatorAtStart flag
     * @since 2.0
     */
    @Override
    public boolean isFieldSeparatorAtStart() {
        return super.isFieldSeparatorAtStart();
    }

    /**
     * Gets whether to use the class name.
     *
     * @return the current useClassName flag
     */
    @Override
    public boolean isUseClassName() {
        return super.isUseClassName();
    }

    /**
     * Gets whether to use the field names passed in.
     *
     * @return the current useFieldNames flag
     */
    @Override
    public boolean isUseFieldNames() {
        return super.isUseFieldNames();
    }

    /**
     * Gets whether to use the identity hash code.
     * @return the current useIdentityHashCode flag
     */
    @Override
    public boolean isUseIdentityHashCode() {
        return super.isUseIdentityHashCode();
    }

    /**
     * Gets whether to output short or long class names.
     *
     * @return the current useShortClassName flag
     * @since 2.0
     */
    @Override
    public boolean isUseShortClassName() {
        return super.isUseShortClassName();
    }

    /**
     * Sets whether to output short or long class names.
     *
     * @param useShortClassName  the new useShortClassName flag
     * @since 2.0
     */
    @Override
    public void setUseShortClassName(final boolean useShortClassName) {
        super.setUseShortClassName(useShortClassName);
    }

    /**
     * Sets whether to use the identity hash code.
     *
     * @param useIdentityHashCode  the new useIdentityHashCode flag
     */
    @Override
    public void setUseIdentityHashCode(final boolean useIdentityHashCode) {
        super.setUseIdentityHashCode(useIdentityHashCode);
    }

    /**
     * Sets whether to use the field names passed in.
     *
     * @param useFieldNames  the new useFieldNames flag
     */
    @Override
    public void setUseFieldNames(final boolean useFieldNames) {
        super.setUseFieldNames(useFieldNames);
    }

    /**
     * Sets whether to use the class name.
     *
     * @param useClassName  the new useClassName flag
     */
    @Override
    public void setUseClassName(final boolean useClassName) {
        super.setUseClassName(useClassName);
    }

    /**
     * Sets whether the field separator should be added at the start
     * of each buffer.
     *
     * @param fieldSeparatorAtStart  the fieldSeparatorAtStart flag
     * @since 2.0
     */
    @Override
    public void setFieldSeparatorAtStart(final boolean fieldSeparatorAtStart) {
        super.setFieldSeparatorAtStart(fieldSeparatorAtStart);
    }

    /**
     * Sets whether the field separator should be added at the end
     * of each buffer.
     *
     * @param fieldSeparatorAtEnd  the fieldSeparatorAtEnd flag
     * @since 2.0
     */
    @Override
    public void setFieldSeparatorAtEnd(final boolean fieldSeparatorAtEnd) {
        super.setFieldSeparatorAtEnd(fieldSeparatorAtEnd);
    }

    /**
     * Sets whether to use full detail when the caller doesn't
     * specify.
     *
     * @param defaultFullDetail  the new defaultFullDetail flag
     */
    @Override
    public void setDefaultFullDetail(final boolean defaultFullDetail) {
        super.setDefaultFullDetail(defaultFullDetail);
    }

    /**
     * Sets whether to output array content detail.
     *
     * @param arrayContentDetail  the new arrayContentDetail flag
     */
    @Override
    public void setArrayContentDetail(final boolean arrayContentDetail) {
        super.setArrayContentDetail(arrayContentDetail);
    }

    /**
     * Sets the start text to output when an {@link Object} is
     * output in summary mode.
     *
     * <p>This is output before the size value.</p>
     *
     * <p>{@code null} is accepted, but will be converted to
     * an empty String.</p>
     *
     * @param summaryObjectStartText  the new start of summary text
     */
    @Override
    public void setSummaryObjectStartText(final String summaryObjectStartText) {
        super.setSummaryObjectStartText(summaryObjectStartText);
    }

    /**
     * Sets the end text to output when an {@link Object} is
     * output in summary mode.
     *
     * <p>This is output after the size value.</p>
     *
     * <p>{@code null} is accepted, but will be converted to
     * an empty String.</p>
     *
     * @param summaryObjectEndText  the new end of summary text
     */
    @Override
    public void setSummaryObjectEndText(final String summaryObjectEndText) {
        super.setSummaryObjectEndText(summaryObjectEndText);
    }

    /**
     * Sets the start text to output when a {@link Collection},
     * {@link Map} or {@link Array} size is output.
     *
     * <p>This is output before the size value.</p>
     *
     * <p>{@code null} is accepted, but will be converted to
     * an empty String.</p>
     *
     * @param sizeStartText  the new start of size text
     */
    @Override
    public void setSizeStartText(final String sizeStartText) {
        super.setSizeStartText(sizeStartText);
    }

    /**
     * Sets the end text to output when a {@link Collection},
     * {@link Map} or {@link Array} size is output.
     *
     * <p>This is output after the size value.</p>
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param sizeEndText  the new end of size text
     */
    @Override
    public void setSizeEndText(final String sizeEndText) {
        super.setSizeEndText(sizeEndText);
    }

    /**
     * Sets the text to output when {@code null} found.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param nullText  the new text to output when {@code null} found
     */
    @Override
    public void setNullText(final String nullText) {
        super.setNullText(nullText);
    }

    /**
     * Sets the field separator text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param fieldSeparator  the new field separator text
     */
    @Override
    public void setFieldSeparator(final String fieldSeparator) {
        super.setFieldSeparator(fieldSeparator);
    }

    /**
     * Sets the field name value separator text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param fieldNameValueSeparator  the new field name value separator text
     */
    @Override
    public void setFieldNameValueSeparator(final String fieldNameValueSeparator) {
        super.setFieldNameValueSeparator(fieldNameValueSeparator);
    }

    /**
     * Sets the content start text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param contentStart  the new content start text
     */
    @Override
    public void setContentStart(final String contentStart) {
        super.setContentStart(contentStart);
    }

    /**
     * Sets the content end text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param contentEnd  the new content end text
     */
    @Override
    public void setContentEnd(final String contentEnd) {
        super.setContentEnd(contentEnd);
    }

    /**
     * Sets the array start text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param arrayStart  the new array start text
     */
    @Override
    public void setArrayStart(final String arrayStart) {
        super.setArrayStart(arrayStart);
    }

    /**
     * Sets the array separator text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param arraySeparator  the new array separator text
     */
    @Override
    public void setArraySeparator(final String arraySeparator) {
        super.setArraySeparator(arraySeparator);
    }

    /**
     * Sets the array end text.
     *
     * <p>{@code null} is accepted, but will be converted
     * to an empty String.</p>
     *
     * @param arrayEnd  the new array end text
     */
    @Override
    public void setArrayEnd(final String arrayEnd) {
        super.setArrayEnd(arrayEnd);
    }

}
