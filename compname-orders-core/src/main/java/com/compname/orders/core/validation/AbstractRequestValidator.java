package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.ApiIdRequest;
import com.compname.orders.api.message.request.ApiPaginationRequest;
import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.utility.OrdersServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The base request validator common to all request validators.<br>
 *
 * @author Marin Bilic
 * @since 1.0
 */
public abstract class AbstractRequestValidator
{
    private static final String UNKNOWN_USER = "UNKNOWN_USER";
    private static final String UNKNOWN_CHANNEL = "UNKNOWN_CHANNEL";
    private static final Integer DEFAULT_PAGE_SIZE = 20;
    private static final Integer MINIMUM_PAGE_SIZE = 1;
    private static final Integer MINIMUM_PAGE_NUMBER = 0;
    private static final Integer MAXIMUM_ENTITIES_PER_PAGE = 100;

    protected static final String NAME = "name";
    protected static final String CREATED = "created";
    protected static final String CREATED_BY = "created by";
    protected static final String OIB = "oib";
    protected static final String ADDRESS = "address";
    protected static final String PHONE = "phone";
    protected static final String CITY = "city";
    protected static final String POSTAL_CODE = "postal code";
    protected static final String LATITUDE = "latitude";
    protected static final String LONGITUDE = "longitude";
    protected static final String BUSINESS_ID = "business id";
    protected static final String OFFER_ID = "offer id";

    /**
     * The Logger.
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Validate base request.<br>
     * If no channel or user is given, it sets it to their default values.<br>
     *
     * @param <R>     [&lt;R&gt;] :: the type parameter
     * @param request [{@link ApiRequest}] :: the request
     *
     * @return request [{@link ApiRequest}] :: the verified request
     */
    protected final <R extends ApiRequest> R validateBaseRequest(R request)
    {
        notNull(request, "request");

        if (Objects.isNull(request.getUser())) {
            request.setUser(UNKNOWN_USER);
        }
        if (Objects.isNull(request.getChannel())) {
            request.setChannel(UNKNOWN_CHANNEL);
        }

        return request;
    }

    /**
     * Validate the given ID request.<br>
     *
     * @param <R>     [&lt;R&gt;] :: the type parameter
     * @param request [{@link ApiIdRequest}] :: the request
     *
     * @return id [Long] :: the id
     */
    protected final <R extends ApiIdRequest> Long validateIdRequest(R request)
    {
        validateBaseRequest(request);

        notNull(request.getId(), "entity ID");

        return request.getId();
    }

    /**
     * Defends null objects.<br>
     *
     * @param <T>       [&lt;T&gt;] :: the type parameter
     * @param parameter [&lt;T&gt;] :: the object to be verified
     * @param name      [{@link String}] :: the name of the parameter to be verified
     *
     * @return parameter [&lt;T&gt;] :: the verified object
     */
    protected final <T> T notNull(T parameter, String name)
    {
        if (Objects.isNull(parameter)) {
            throw OrdersServiceException.validationError(String.format("Parameter must not be null [parameter=%s]", name));
        }

        return parameter;
    }

    /**
     * Validates the given pagination request.<br>
     *
     * @param <R>     [&lt;R&gt;] :: the type parameter
     * @param request [{@link ApiPaginationRequest}] :: the request
     *
     * @return request [{@link ApiPaginationRequest}] :: the verified request
     */
    protected final <R extends ApiPaginationRequest> R validatePaginationRequest(R request)
    {
        validateBaseRequest(request);

        if (!(Objects.isNull(request.getPageNumber()) || Objects.isNull(request.getPageSize()))) {
            notLessThan(request.getPageNumber(), MINIMUM_PAGE_NUMBER, "page number");
            notLessThan(request.getPageSize(), MINIMUM_PAGE_SIZE, "page size");
            notGreaterThan(request.getPageSize(), MAXIMUM_ENTITIES_PER_PAGE, "page size");
        } else {
            request.setPageNumber(1);
            request.setPageSize(DEFAULT_PAGE_SIZE);
        }

        return request;
    }

    /**
     * Defends a comparable that is less than a given threshold.<br>
     *
     * @param <C>       [&lt;C&gt;] :: the type parameter
     * @param value     [{@link Comparable}] :: the comparable to be verified
     * @param threshold [{@link Comparable}] :: the comparable threshold
     * @param name      [{@link String}] :: the name of the parameter to be verified
     *
     * @return number [&lt;T&gt;] :: the verified number
     */
    protected final <C extends Comparable<? super C>> C notLessThan(C value, C threshold, String name)
    {
        if (value.compareTo(threshold) < 0) {
            throw OrdersServiceException.validationError("Parameter must not be less than [threshold=%s, parameter=%s, comparable=%s]", threshold, name, value);
        }

        return value;
    }

    /**
     * Defends a comparable that is greater than a given threshold.<br>
     *
     * @param <C>       [&lt;C&gt;] :: the type parameter
     * @param value     [{@link Comparable}] :: the comparable to be verified
     * @param threshold [{@link Comparable}] :: the comparable threshold
     * @param name      [{@link String}] :: the name of the parameter to be verified
     *
     * @return number [&lt;T&gt;] :: the verified number
     */
    protected final <C extends Comparable<? super C>> C notGreaterThan(C value, C threshold, String name)
    {
        if (value.compareTo(threshold) > 0) {
            throw OrdersServiceException.validationError("Parameter must not be greater than [threshold=%s, parameter=%s, comparable=%s]", threshold, name, value);
        }

        return value;
    }

    /**
     * Defends a string.
     *
     * @param string    [{@link String}] :: the string to check
     * @param name      [{@link String}] :: the name of the parameter to be verified
     *
     * @return string   [{@link String}] :: the verified string
     */
    protected final String notEmpty(String string, String name)
    {
        notNull(string, name);
        if (string.isEmpty()) {
            throw OrdersServiceException.validationError("Parameter must not be empty [parameter=%s]", name);
        }

        return string;
    }
}