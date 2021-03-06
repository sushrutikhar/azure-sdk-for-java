/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.streamanalytics;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for OutputErrorPolicy.
 */
public final class OutputErrorPolicy {
    /** Static value Stop for OutputErrorPolicy. */
    public static final OutputErrorPolicy STOP = new OutputErrorPolicy("Stop");

    /** Static value Drop for OutputErrorPolicy. */
    public static final OutputErrorPolicy DROP = new OutputErrorPolicy("Drop");

    private String value;

    /**
     * Creates a custom value for OutputErrorPolicy.
     * @param value the custom value
     */
    public OutputErrorPolicy(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OutputErrorPolicy)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        OutputErrorPolicy rhs = (OutputErrorPolicy) obj;
        if (value == null) {
            return rhs.value == null;
        } else {
            return value.equals(rhs.value);
        }
    }
}
