/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlab;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for TargetCostStatus.
 */
public final class TargetCostStatus {
    /** Static value Enabled for TargetCostStatus. */
    public static final TargetCostStatus ENABLED = new TargetCostStatus("Enabled");

    /** Static value Disabled for TargetCostStatus. */
    public static final TargetCostStatus DISABLED = new TargetCostStatus("Disabled");

    private String value;

    /**
     * Creates a custom value for TargetCostStatus.
     * @param value the custom value
     */
    public TargetCostStatus(String value) {
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
        if (!(obj instanceof TargetCostStatus)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        TargetCostStatus rhs = (TargetCostStatus) obj;
        if (value == null) {
            return rhs.value == null;
        } else {
            return value.equals(rhs.value);
        }
    }
}
