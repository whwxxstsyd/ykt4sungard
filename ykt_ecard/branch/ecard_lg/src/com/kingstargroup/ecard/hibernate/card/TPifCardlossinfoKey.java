/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Fri Sep 30 13:53:44 CST 2005 by MyEclipse Hibernate Tool.
 */
package com.kingstargroup.ecard.hibernate.card;

import java.io.Serializable;

/**
 * A class representing a composite primary key id for the T_PIF_CARDLOSSINFO
 * table.  This object should only be instantiated for use with instances 
 * of the TPifCardlossinfo class.
 */
public class TPifCardlossinfoKey
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private volatile int hashValue = 0;

    /** The value of the OPERATE_DATE component of this composite id. */
    private java.lang.String operateDate;

    /** The value of the OPERATE_TIME component of this composite id. */
    private java.lang.String operateTime;

    /** The value of the CARD_ID component of this composite id. */
    private java.lang.Integer cardId;

    /**
     * Simple constructor of TPifCardlossinfoKey instances.
     */
    public TPifCardlossinfoKey()
    {
    }

    /**
     * Returns the value of the operateDate property.
     * @return java.lang.String
     */
    public java.lang.String getOperateDate()
    {
        return operateDate;
    }

    /**
     * Sets the value of the operateDate property.
     * @param operateDate
     */
    public void setOperateDate(java.lang.String operateDate)
    {
        hashValue = 0;
        this.operateDate = operateDate;
    }

    /**
     * Returns the value of the operateTime property.
     * @return java.lang.String
     */
    public java.lang.String getOperateTime()
    {
        return operateTime;
    }

    /**
     * Sets the value of the operateTime property.
     * @param operateTime
     */
    public void setOperateTime(java.lang.String operateTime)
    {
        hashValue = 0;
        this.operateTime = operateTime;
    }

    /**
     * Returns the value of the cardId property.
     * @return java.lang.Integer
     */
    public java.lang.Integer getCardId()
    {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * @param cardId
     */
    public void setCardId(java.lang.Integer cardId)
    {
        hashValue = 0;
        this.cardId = cardId;
    }

    /**
     * Implementation of the equals comparison on the basis of equality of the id components.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof TPifCardlossinfoKey))
            return false;
        TPifCardlossinfoKey that = (TPifCardlossinfoKey) rhs;
        if (this.getOperateDate() == null || that.getOperateDate() == null)
        {
            return false;
        }
        if (! this.getOperateDate().equals(that.getOperateDate()))
        {
            return false;
        }
        if (this.getOperateTime() == null || that.getOperateTime() == null)
        {
            return false;
        }
        if (! this.getOperateTime().equals(that.getOperateTime()))
        {
            return false;
        }
        if (this.getCardId() == null || that.getCardId() == null)
        {
            return false;
        }
        if (! this.getCardId().equals(that.getCardId()))
        {
            return false;
        }
        return true;
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int operateDateValue = this.getOperateDate() == null ? 0 : this.getOperateDate().hashCode();
            result = result * 37 + operateDateValue;
            int operateTimeValue = this.getOperateTime() == null ? 0 : this.getOperateTime().hashCode();
            result = result * 37 + operateTimeValue;
            int cardIdValue = this.getCardId() == null ? 0 : this.getCardId().hashCode();
            result = result * 37 + cardIdValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
