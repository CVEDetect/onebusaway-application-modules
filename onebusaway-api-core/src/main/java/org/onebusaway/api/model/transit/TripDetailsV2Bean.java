/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.api.model.transit;

import java.io.Serializable;
import java.util.List;

public final class TripDetailsV2Bean implements Serializable {

  private static final long serialVersionUID = 1L;

  private String tripId;

  private long serviceDate;

  private FrequencyV2Bean frequency;

  private TripStatusV2Bean status;

  private TripStopTimesV2Bean schedule;

  private List<String> situationIds;

  public String getTripId() {
    return tripId;
  }

  public void setTripId(String tripId) {
    this.tripId = tripId;
  }

  public long getServiceDate() {
    return serviceDate;
  }

  public void setServiceDate(long serviceDate) {
    this.serviceDate = serviceDate;
  }

  public FrequencyV2Bean getFrequency() {
    return frequency;
  }

  public void setFrequency(FrequencyV2Bean frequency) {
    this.frequency = frequency;
  }

  public TripStatusV2Bean getStatus() {
    return status;
  }

  public void setStatus(TripStatusV2Bean status) {
    this.status = status;
  }

  public TripStopTimesV2Bean getSchedule() {
    return schedule;
  }

  public void setSchedule(TripStopTimesV2Bean schedule) {
    this.schedule = schedule;
  }

  public List<String> getSituationIds() {
    return situationIds;
  }

  public void setSituationIds(List<String> situationIds) {
    this.situationIds = situationIds;
  }
}
