package com.compname.orders.core.persistence;

import java.io.Serializable;

public abstract class DbEntity<K extends Serializable & Comparable<K>> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * The constant ALLOCATION_SIZE.
     */
    public static final int ALLOCATION_SIZE = 1;

    /**
     * Instantiates the entity.<br>
     */
    public DbEntity() {}

    /**
     * Sets the ID associated with this entity.<br>
     *
     * @param pk [&lt;K&gt;] :: the entity ID
     */
    public abstract void setId(K pk);

    /**
     * Returns the ID associated with this entity.<br>
     *
     * @return id [&lt;K&gt;] :: the entity ID
     */
    public abstract K getId();
}