/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.sql.models;

import java.util.Calendar;

/**
* Represents Azure SQL recommended elastic pool metric.
*/
public class RecommendedElasticPoolMetric {
    private Calendar dateTime;
    
    /**
    * Optional. Gets or sets the time of metric.
    * @return The DateTime value.
    */
    public Calendar getDateTime() {
        return this.dateTime;
    }
    
    /**
    * Optional. Gets or sets the time of metric.
    * @param dateTimeValue The DateTime value.
    */
    public void setDateTime(final Calendar dateTimeValue) {
        this.dateTime = dateTimeValue;
    }
    
    private double dtu;
    
    /**
    * Optional. Gets or sets the DTU.
    * @return The Dtu value.
    */
    public double getDtu() {
        return this.dtu;
    }
    
    /**
    * Optional. Gets or sets the DTU.
    * @param dtuValue The Dtu value.
    */
    public void setDtu(final double dtuValue) {
        this.dtu = dtuValue;
    }
    
    private double sizeGB;
    
    /**
    * Optional. Gets or sets size in gigabytes.
    * @return The SizeGB value.
    */
    public double getSizeGB() {
        return this.sizeGB;
    }
    
    /**
    * Optional. Gets or sets size in gigabytes.
    * @param sizeGBValue The SizeGB value.
    */
    public void setSizeGB(final double sizeGBValue) {
        this.sizeGB = sizeGBValue;
    }
}