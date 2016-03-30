/**
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies characteristics for a temporary 'auto pool'. The Batch service
 * will create this auto pool, run all the tasks for the job on it, and will
 * delete the pool once the job has completed.
 */
public class AutoPoolSpecification {
    /**
     * Gets or sets a prefix to be added to the unique identifier when a pool
     * is automatically created. The prefix can be up to 20 characters long.
     */
    private String autoPoolIdPrefix;

    /**
     * Gets or sets the minimum lifetime of created auto pools, and how
     * multiple jobs on a schedule are assigned to pools. Possible values
     * include: 'jobschedule', 'job', 'unmapped'.
     */
    @JsonProperty(required = true)
    private PoolLifetimeOption poolLifetimeOption;

    /**
     * Gets or sets whether to keep an auto pool alive after its lifetime
     * expires.
     */
    private Boolean keepAlive;

    /**
     * Gets or sets the pool specification for the auto pool.
     */
    private PoolSpecification pool;

    /**
     * Get the autoPoolIdPrefix value.
     *
     * @return the autoPoolIdPrefix value
     */
    public String getAutoPoolIdPrefix() {
        return this.autoPoolIdPrefix;
    }

    /**
     * Set the autoPoolIdPrefix value.
     *
     * @param autoPoolIdPrefix the autoPoolIdPrefix value to set
     */
    public void setAutoPoolIdPrefix(String autoPoolIdPrefix) {
        this.autoPoolIdPrefix = autoPoolIdPrefix;
    }

    /**
     * Get the poolLifetimeOption value.
     *
     * @return the poolLifetimeOption value
     */
    public PoolLifetimeOption getPoolLifetimeOption() {
        return this.poolLifetimeOption;
    }

    /**
     * Set the poolLifetimeOption value.
     *
     * @param poolLifetimeOption the poolLifetimeOption value to set
     */
    public void setPoolLifetimeOption(PoolLifetimeOption poolLifetimeOption) {
        this.poolLifetimeOption = poolLifetimeOption;
    }

    /**
     * Get the keepAlive value.
     *
     * @return the keepAlive value
     */
    public Boolean getKeepAlive() {
        return this.keepAlive;
    }

    /**
     * Set the keepAlive value.
     *
     * @param keepAlive the keepAlive value to set
     */
    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    /**
     * Get the pool value.
     *
     * @return the pool value
     */
    public PoolSpecification getPool() {
        return this.pool;
    }

    /**
     * Set the pool value.
     *
     * @param pool the pool value to set
     */
    public void setPool(PoolSpecification pool) {
        this.pool = pool;
    }

}