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
package org.onebusaway.transit_data.model.tripplanning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItinerariesBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private LocationBean from = null;

  private LocationBean to = null;

  private List<ItineraryBean> itineraries = new ArrayList<ItineraryBean>();
  
  private boolean computationTimeLimitReached = false;

  public LocationBean getFrom() {
    return from;
  }

  public void setFrom(LocationBean from) {
    this.from = from;
  }

  public LocationBean getTo() {
    return to;
  }

  public void setTo(LocationBean to) {
    this.to = to;
  }

  public List<ItineraryBean> getItineraries() {
    return itineraries;
  }

  public void setItineraries(List<ItineraryBean> itineraries) {
    this.itineraries = itineraries;
  }

  public boolean isComputationTimeLimitReached() {
    return computationTimeLimitReached;
  }

  public void setComputationTimeLimitReached(boolean computationTimeLimitReached) {
    this.computationTimeLimitReached = computationTimeLimitReached;
  }
}
