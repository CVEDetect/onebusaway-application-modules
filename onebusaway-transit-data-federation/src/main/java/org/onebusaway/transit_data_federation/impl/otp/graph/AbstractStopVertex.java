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
package org.onebusaway.transit_data_federation.impl.otp.graph;

import org.onebusaway.gtfs.model.AgencyAndId;
import org.onebusaway.transit_data_federation.impl.otp.GraphContext;
import org.onebusaway.transit_data_federation.services.transit_graph.StopEntry;
import org.opentripplanner.routing.core.Vertex;

public abstract class AbstractStopVertex extends AbstractVertex implements
    HasStopTransitVertex {

  protected final StopEntry _stop;

  public AbstractStopVertex(GraphContext context, StopEntry stop) {
    super(context);
    _stop = stop;
  }

  @Override
  public StopEntry getStop() {
    return _stop;
  }

  /****
   * {@link Vertex} Interface
   ****/

  @Override
  public AgencyAndId getStopId() {
    return _stop.getId();
  }

  @Override
  public double getX() {
    return _stop.getStopLon();
  }

  @Override
  public double getY() {
    return _stop.getStopLat();
  }

  /****
   * {@link Object} Interface
   ****/

  @Override
  public int hashCode() {
    return _stop.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractStopVertex other = (AbstractStopVertex) obj;
    return _stop.equals(other._stop);
  }
}
