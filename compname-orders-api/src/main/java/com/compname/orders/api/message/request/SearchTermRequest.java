package com.compname.orders.api.message.request;

import java.time.ZonedDateTime;

/**
 * Represents base create rule request.
 *
 * @author Marin Bilic
 * @since 1.0
 */
public class SearchTermRequest {

    private String location;
    private ZonedDateTime from;
    private ZonedDateTime to;

    /**
     * Instantiates a new SearchTermRequest
     */
    public SearchTermRequest() {}

    /**
     * Instantiates a new SearchTermRequest with given parameters
     *
     * @param location  [{@link String}] :: the location
     * @param from      [{@link ZonedDateTime}] :: the date from
     * @param to        [{@link ZonedDateTime}] :: the date to
     */
    public SearchTermRequest(String location, ZonedDateTime from, ZonedDateTime to) {
        this.location = location;
        this.from = from;
        this.to = to;
    }

    /**
     * Sets the (mandatory) location.<br>
     *
     * @param location [{@link String}] :: the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the (mandatory) from date.<br>
     *
     * @param from [{@link ZonedDateTime}] :: the from date
     */
    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    /**
     * Sets the (mandatory) to date.<br>
     *
     * @param to [{@link ZonedDateTime}] :: the to date
     */
    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public String getLocation() {
        return location;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public ZonedDateTime getTo() {
        return to;
    }
}
