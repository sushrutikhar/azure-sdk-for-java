/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for SearchServiceStatus.
 */
public enum SearchServiceStatus {
    /** Enum value running. */
    RUNNING("running"),

    /** Enum value provisioning. */
    PROVISIONING("provisioning"),

    /** Enum value deleting. */
    DELETING("deleting"),

    /** Enum value degraded. */
    DEGRADED("degraded"),

    /** Enum value disabled. */
    DISABLED("disabled"),

    /** Enum value error. */
    ERROR("error");

    /** The actual serialized value for a SearchServiceStatus instance. */
    private String value;

    SearchServiceStatus(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a SearchServiceStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed SearchServiceStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static SearchServiceStatus fromString(String value) {
        SearchServiceStatus[] items = SearchServiceStatus.values();
        for (SearchServiceStatus item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
