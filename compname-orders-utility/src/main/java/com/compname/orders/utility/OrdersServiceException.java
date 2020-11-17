package com.compname.orders.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Service exception.<br>
 *
 * @author Marin Bilic
 * @since 1.0
 */
public class OrdersServiceException extends RuntimeException
{
    private static final Logger logger = LoggerFactory.getLogger(OrdersServiceException.class);

    /**
     * Creates the exception by the given arguments.<br>
     *
     * @param message      [{@link String}] :: the message
     */
    protected OrdersServiceException(ResponseCode responseCode, String message)
    {
        super(String.format("[CODE=%s]::[message=%s]", responseCode.name(), message));
    }

    /**
     * Creates the exception by the given arguments.<br>
     *
     * @param responseCode [{@link ResponseCode}] :: the response code
     * @param message      [{@link String}] :: the message
     * @param throwable    [{@link Throwable}] :: the exception cause
     */
    protected OrdersServiceException(ResponseCode responseCode, String message, Throwable throwable)
    {
        this(responseCode, message);

        logger.debug(String.format("[CODE=%s]::[message=%s]", responseCode.name(), message), throwable);

        initCause(throwable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString()
    {
        return String.format("%s::[message=%s]", getClass().getSimpleName(), getMessage());
    }

    /**
     * Returns an <b>internal error</b> exception.<br>
     *
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException internalError(String template, Object... arguments)
    {
        return error(ResponseCode.UNKNOWN, template, arguments);
    }

    /**
     * Returns an <b>internal error</b> exception.<br>
     *
     * @param throwable [{@link Throwable}] :: the exception cause
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException internalError(Throwable throwable, String template, Object... arguments)
    {
        return error(ResponseCode.UNKNOWN, throwable, template, arguments);
    }

    /**
     * Creates a <b>execution</b> exception.<br>
     *
     * @param throwable [{@link Throwable}] :: the exception cause
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException executionError(Throwable throwable, String template, Object... arguments)
    {
        return error(ResponseCode.EXECUTION_EXCEPTION, throwable, template, arguments);
    }

    /**
     * Creates a <b>execution</b> exception.<br>
     *
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException executionError(String template, Object... arguments)
    {
        return error(ResponseCode.EXECUTION_EXCEPTION, template, arguments);
    }

    /**
     * Creates a <b>validation</b> exception.<br>
     *
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException validationError(String template, Object... arguments)
    {
        return error(ResponseCode.REQUEST_INVALID, template, arguments);
    }

    /**
     * Creates a <b>publisher</b> exception.<br>
     *
     * @param throwable [{@link Throwable}] :: the exception cause
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException publisherError(Throwable throwable, String template, Object... arguments)
    {
        return error(ResponseCode.PUBLISHER_EXCEPTION, throwable, template, arguments);
    }

    /**
     * Creates a <b>unknown entity</b> exception.<br>
     *
     * @param template  [{@link String}] :: the error message template
     * @param arguments [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: the exception
     */
    public static OrdersServiceException unknownEntity(String template, Object... arguments)
    {
        return error(ResponseCode.ENTITY_NOT_FOUND, template, arguments);
    }

    /**
     * Creates a new top-up service exception by the given arguments.<br>
     *
     *
     * @param responseCode [{@link ResponseCode}] :: the response code
     * @param template     [{@link String}] :: the error message template
     * @param arguments    [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: SSOServiceException
     */
    private static OrdersServiceException error(ResponseCode responseCode, String template, Object... arguments)
    {
        return new OrdersServiceException(responseCode, String.format(template, arguments));
    }

    /**
     * Creates a new top-up service exception by the given arguments.<br>
     *
     * @param responseCode [{@link ResponseCode}] :: the response code
     * @param throwable    [{@link Throwable}] :: the error cause
     * @param template     [{@link String}] :: the error message template
     * @param arguments    [{@link Object}[]] :: the error template arguments
     *
     * @return exception [{@link OrdersServiceException}] :: SSOServiceException
     */
    private static OrdersServiceException error(ResponseCode responseCode, Throwable throwable, String template, Object... arguments)
    {
        return new OrdersServiceException(responseCode, String.format(template, arguments), throwable.getCause());
    }
}
