package org.onebusaway.transit_data_federation.services.realtime;

import org.onebusaway.geospatial.model.CoordinatePoint;
import org.onebusaway.gtfs.model.AgencyAndId;
import org.onebusaway.transit_data_federation.services.tripplanner.StopTimeEntry;
import org.onebusaway.transit_data_federation.services.tripplanner.TripEntry;

/**
 * Vehicle position information for a particular block.
 * 
 * @author bdferris
 */
public class BlockLocation {

  /****
   * These are fields that we can supply from schedule data
   ****/

  private TripEntry activeTrip;

  private long serviceDate;

  private boolean inService;

  private double scheduledDistanceAlongBlock = Double.NaN;

  /****
   * These are fields that we can supply from schedule data, but also update
   * from real-time data when available
   ****/

  private CoordinatePoint location;

  private StopTimeEntry closestStop;

  private int closestStopTimeOffset;

  /****
   * These are fields that we can supply only from real-time data
   ****/

  private boolean predicted;

  private long lastUpdateTime;

  private CoordinatePoint lastKnownLocation;

  private double scheduleDeviation = Double.NaN;

  private double distanceAlongBlock = Double.NaN;

  private AgencyAndId vehicleId;

  /**
   * @return the active trip for the block
   */
  public TripEntry getActiveTrip() {
    return activeTrip;
  }

  public void setActiveTrip(TripEntry activeTrip) {
    this.activeTrip = activeTrip;
  }

  public long getServiceDate() {
    return serviceDate;
  }

  public void setServiceDate(long serviceDate) {
    this.serviceDate = serviceDate;
  }

  /**
   * @return true if the block trip is actively in service
   */
  public boolean isInService() {
    return inService;
  }

  public void setInService(boolean inService) {
    this.inService = inService;
  }

  public boolean isScheduledDistanceAlongBlockSet() {
    return !Double.isNaN(scheduledDistanceAlongBlock);
  }

  /**
   * If the trip is not in service (see {@link #isInService()}), this value will
   * be {@link Double#NaN}.
   * 
   * @return the scheduled distance traveled along the shape of the block, in
   *         meters
   */
  public double getScheduledDistanceAlongBlock() {
    return scheduledDistanceAlongBlock;
  }

  public void setScheduledDistanceAlongBlock(double scheduledDistanceAlongBlock) {
    this.scheduledDistanceAlongBlock = scheduledDistanceAlongBlock;
  }

  /**
   * @return the block position
   */
  public CoordinatePoint getLocation() {
    return location;
  }

  public void setLocation(CoordinatePoint location) {
    this.location = location;
  }

  /**
   * The closest stop to the current position of the transit vehicle among the
   * stop times of the current trip.
   * 
   * @return the closest stop time entry
   */
  public StopTimeEntry getClosestStop() {
    return closestStop;
  }

  public void setClosestStop(StopTimeEntry closestStop) {
    this.closestStop = closestStop;
  }

  /**
   * The time offset, in seconds, from the closest stop to the current position
   * of the transit vehicle among the stop times of the current trip. If the
   * number is positive, the stop is coming up. If negative, the stop has
   * already been passed.
   * 
   * @return time, in seconds
   */
  public int getClosestStopTimeOffset() {
    return closestStopTimeOffset;
  }

  /**
   * See description in {@link #getClosestStopTimeOffset()}.
   * 
   * @param closestStopTimeOffset the time offset from the closest stop, in
   *          seconds
   */
  public void setClosestStopTimeOffset(int closestStopTimeOffset) {
    this.closestStopTimeOffset = closestStopTimeOffset;
  }

  /**
   * If real-time data is available in any form (schedule deviation,
   * distanceAlongBlock, last known location) for this vehicle
   * 
   * @return true if real-time is available
   */
  public boolean isPredicted() {
    return predicted;
  }

  public void setPredicted(boolean predicted) {
    this.predicted = predicted;
  }

  /**
   * @return the time we last heard from the bus (Unix-time)
   */
  public long getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(long lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public CoordinatePoint getLastKnownLocation() {
    return lastKnownLocation;
  }

  public void setLastKnownLocation(CoordinatePoint lastKnownLocation) {
    this.lastKnownLocation = lastKnownLocation;
  }

  /**
   * @return true if we have schedule deviation data
   */
  public boolean hasScheduleDeviation() {
    return !Double.isNaN(scheduleDeviation);
  }

  /**
   * If no schedule deviation data is available, this value with be
   * {@link Double#NaN}.
   * 
   * @return schedule deviation, in seconds, (+deviation is late, -deviation is
   *         early)
   */
  public double getScheduleDeviation() {
    return scheduleDeviation;
  }

  /**
   * 
   * @param scheduleDeviation schedule deviation, in seconds, (+deviation is
   *          late, -deviation is early)
   */
  public void setScheduleDeviation(double scheduleDeviation) {
    this.scheduleDeviation = scheduleDeviation;
  }

  public boolean hasDistanceAlongBlock() {
    return !Double.isNaN(distanceAlongBlock);
  }

  /**
   * If the trip is not in service (see {@link #isInService()}), this value will
   * be {@link Double#NaN}.
   * 
   * @return the distance traveled along the shape of the block, in meters
   */
  public double getDistanceAlongBlock() {
    return distanceAlongBlock;
  }

  public void setDistanceAlongBlock(double distanceAlongBlock) {
    this.distanceAlongBlock = distanceAlongBlock;
  }

  public AgencyAndId getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(AgencyAndId vehicleId) {
    this.vehicleId = vehicleId;
  }

}
