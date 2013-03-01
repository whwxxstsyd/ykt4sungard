/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Wed Oct 26 16:44:25 CST 2005 by MyEclipse Hibernate Tool.
 */
package com.kingstargroup.advquery.tradelog;

import java.io.Serializable;

/**
 * A class that represents a row in the T_TIF_TRADELOG table. 
 * You can customize the behavior of this class by editing the class, {@link TTifTradelog()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractTTifTradelog 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The simple primary key value. */
    private TTifTradelogKey id;

    /** The value of the simple subno property. */
    private java.lang.String subno;

    /** The value of the simple otherActid property. */
    private java.lang.String otherActid;

    /** The value of the simple otherSubno property. */
    private java.lang.String otherSubno;

    /** The value of the simple outorin property. */
    private java.lang.Integer outorin;

    /** The value of the simple opFee property. */
    private java.lang.Double opFee;

    /** The value of the simple newFee property. */
    private java.lang.Double newFee;

    /** The value of the simple curFrozebala property. */
    private java.lang.Double curFrozebala;

    /** The value of the simple warrantType property. */
    private java.lang.Integer warrantType;

    /** The value of the simple warrantNo property. */
    private java.lang.String warrantNo;

    /** The value of the simple operateDate property. */
    private java.lang.String operateDate;

    /** The value of the simple operateTime property. */
    private java.lang.String operateTime;

    /** The value of the simple collectDate property. */
    private java.lang.String collectDate;

    /** The value of the simple collectTime property. */
    private java.lang.String collectTime;

    /** The value of the simple enteractDate property. */
    private java.lang.String enteractDate;

    /** The value of the simple enteractTime property. */
    private java.lang.String enteractTime;

    /** The value of the simple maindeviceId property. */
    private java.lang.Integer maindeviceId;

    /** The value of the simple deviceId property. */
    private java.lang.Integer deviceId;

    /** The value of the simple annex property. */
    private java.lang.Integer annex;

    /** The value of the simple recordOper property. */
    private java.lang.String recordOper;

    /** The value of the simple checkOper property. */
    private java.lang.String checkOper;

    /** The value of the simple writeOper property. */
    private java.lang.String writeOper;

    /** The value of the simple reserve1 property. */
    private java.lang.String reserve1;

    /** The value of the simple reserve2 property. */
    private java.lang.String reserve2;

    /** The value of the simple reserve3 property. */
    private java.lang.String reserve3;

    /** The value of the simple comments property. */
    private java.lang.String comments;

    /**
     * Simple constructor of AbstractTTifTradelog instances.
     */
    public AbstractTTifTradelog()
    {
    }

    /**
     * Constructor of AbstractTTifTradelog instances given a composite primary key.
     * @param id
     */
    public AbstractTTifTradelog(TTifTradelogKey id)
    {
        this.setId(id);
    }

    /**
     * Return the composite id instance that identifies this object.
     * @return TTifTradelogKey
     */
    public TTifTradelogKey getId()
    {
        return this.id;
    }

    /**
     * Set the composite id instance that identifies this object.
     * @param id
     */
    public void setId(TTifTradelogKey id)
    {
        this.hashValue = 0;
        this.id = id;
    }

    /**
     * Return the value of the SUBNO column.
     * @return java.lang.String
     */
    public java.lang.String getSubno()
    {
        return this.subno;
    }

    /**
     * Set the value of the SUBNO column.
     * @param subno
     */
    public void setSubno(java.lang.String subno)
    {
        this.subno = subno;
    }

    /**
     * Return the value of the OTHER_ACTID column.
     * @return java.lang.String
     */
    public java.lang.String getOtherActid()
    {
        return this.otherActid;
    }

    /**
     * Set the value of the OTHER_ACTID column.
     * @param otherActid
     */
    public void setOtherActid(java.lang.String otherActid)
    {
        this.otherActid = otherActid;
    }

    /**
     * Return the value of the OTHER_SUBNO column.
     * @return java.lang.String
     */
    public java.lang.String getOtherSubno()
    {
        return this.otherSubno;
    }

    /**
     * Set the value of the OTHER_SUBNO column.
     * @param otherSubno
     */
    public void setOtherSubno(java.lang.String otherSubno)
    {
        this.otherSubno = otherSubno;
    }

    /**
     * Return the value of the OUTORIN column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getOutorin()
    {
        return this.outorin;
    }

    /**
     * Set the value of the OUTORIN column.
     * @param outorin
     */
    public void setOutorin(java.lang.Integer outorin)
    {
        this.outorin = outorin;
    }

    /**
     * Return the value of the OP_FEE column.
     * @return java.lang.Double
     */
    public java.lang.Double getOpFee()
    {
        return this.opFee;
    }

    /**
     * Set the value of the OP_FEE column.
     * @param opFee
     */
    public void setOpFee(java.lang.Double opFee)
    {
        this.opFee = opFee;
    }

    /**
     * Return the value of the NEW_FEE column.
     * @return java.lang.Double
     */
    public java.lang.Double getNewFee()
    {
        return this.newFee;
    }

    /**
     * Set the value of the NEW_FEE column.
     * @param newFee
     */
    public void setNewFee(java.lang.Double newFee)
    {
        this.newFee = newFee;
    }

    /**
     * Return the value of the CUR_FROZEBALA column.
     * @return java.lang.Double
     */
    public java.lang.Double getCurFrozebala()
    {
        return this.curFrozebala;
    }

    /**
     * Set the value of the CUR_FROZEBALA column.
     * @param curFrozebala
     */
    public void setCurFrozebala(java.lang.Double curFrozebala)
    {
        this.curFrozebala = curFrozebala;
    }

    /**
     * Return the value of the WARRANT_TYPE column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getWarrantType()
    {
        return this.warrantType;
    }

    /**
     * Set the value of the WARRANT_TYPE column.
     * @param warrantType
     */
    public void setWarrantType(java.lang.Integer warrantType)
    {
        this.warrantType = warrantType;
    }

    /**
     * Return the value of the WARRANT_NO column.
     * @return java.lang.String
     */
    public java.lang.String getWarrantNo()
    {
        return this.warrantNo;
    }

    /**
     * Set the value of the WARRANT_NO column.
     * @param warrantNo
     */
    public void setWarrantNo(java.lang.String warrantNo)
    {
        this.warrantNo = warrantNo;
    }

    /**
     * Return the value of the OPERATE_DATE column.
     * @return java.lang.String
     */
    public java.lang.String getOperateDate()
    {
        return this.operateDate;
    }

    /**
     * Set the value of the OPERATE_DATE column.
     * @param operateDate
     */
    public void setOperateDate(java.lang.String operateDate)
    {
        this.operateDate = operateDate;
    }

    /**
     * Return the value of the OPERATE_TIME column.
     * @return java.lang.String
     */
    public java.lang.String getOperateTime()
    {
        return this.operateTime;
    }

    /**
     * Set the value of the OPERATE_TIME column.
     * @param operateTime
     */
    public void setOperateTime(java.lang.String operateTime)
    {
        this.operateTime = operateTime;
    }

    /**
     * Return the value of the COLLECT_DATE column.
     * @return java.lang.String
     */
    public java.lang.String getCollectDate()
    {
        return this.collectDate;
    }

    /**
     * Set the value of the COLLECT_DATE column.
     * @param collectDate
     */
    public void setCollectDate(java.lang.String collectDate)
    {
        this.collectDate = collectDate;
    }

    /**
     * Return the value of the COLLECT_TIME column.
     * @return java.lang.String
     */
    public java.lang.String getCollectTime()
    {
        return this.collectTime;
    }

    /**
     * Set the value of the COLLECT_TIME column.
     * @param collectTime
     */
    public void setCollectTime(java.lang.String collectTime)
    {
        this.collectTime = collectTime;
    }

    /**
     * Return the value of the ENTERACT_DATE column.
     * @return java.lang.String
     */
    public java.lang.String getEnteractDate()
    {
        return this.enteractDate;
    }

    /**
     * Set the value of the ENTERACT_DATE column.
     * @param enteractDate
     */
    public void setEnteractDate(java.lang.String enteractDate)
    {
        this.enteractDate = enteractDate;
    }

    /**
     * Return the value of the ENTERACT_TIME column.
     * @return java.lang.String
     */
    public java.lang.String getEnteractTime()
    {
        return this.enteractTime;
    }

    /**
     * Set the value of the ENTERACT_TIME column.
     * @param enteractTime
     */
    public void setEnteractTime(java.lang.String enteractTime)
    {
        this.enteractTime = enteractTime;
    }

    /**
     * Return the value of the MAINDEVICE_ID column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getMaindeviceId()
    {
        return this.maindeviceId;
    }

    /**
     * Set the value of the MAINDEVICE_ID column.
     * @param maindeviceId
     */
    public void setMaindeviceId(java.lang.Integer maindeviceId)
    {
        this.maindeviceId = maindeviceId;
    }

    /**
     * Return the value of the DEVICE_ID column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getDeviceId()
    {
        return this.deviceId;
    }

    /**
     * Set the value of the DEVICE_ID column.
     * @param deviceId
     */
    public void setDeviceId(java.lang.Integer deviceId)
    {
        this.deviceId = deviceId;
    }

    /**
     * Return the value of the ANNEX column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getAnnex()
    {
        return this.annex;
    }

    /**
     * Set the value of the ANNEX column.
     * @param annex
     */
    public void setAnnex(java.lang.Integer annex)
    {
        this.annex = annex;
    }

    /**
     * Return the value of the RECORD_OPER column.
     * @return java.lang.String
     */
    public java.lang.String getRecordOper()
    {
        return this.recordOper;
    }

    /**
     * Set the value of the RECORD_OPER column.
     * @param recordOper
     */
    public void setRecordOper(java.lang.String recordOper)
    {
        this.recordOper = recordOper;
    }

    /**
     * Return the value of the CHECK_OPER column.
     * @return java.lang.String
     */
    public java.lang.String getCheckOper()
    {
        return this.checkOper;
    }

    /**
     * Set the value of the CHECK_OPER column.
     * @param checkOper
     */
    public void setCheckOper(java.lang.String checkOper)
    {
        this.checkOper = checkOper;
    }

    /**
     * Return the value of the WRITE_OPER column.
     * @return java.lang.String
     */
    public java.lang.String getWriteOper()
    {
        return this.writeOper;
    }

    /**
     * Set the value of the WRITE_OPER column.
     * @param writeOper
     */
    public void setWriteOper(java.lang.String writeOper)
    {
        this.writeOper = writeOper;
    }

    /**
     * Return the value of the RESERVE_1 column.
     * @return java.lang.String
     */
    public java.lang.String getReserve1()
    {
        return this.reserve1;
    }

    /**
     * Set the value of the RESERVE_1 column.
     * @param reserve1
     */
    public void setReserve1(java.lang.String reserve1)
    {
        this.reserve1 = reserve1;
    }

    /**
     * Return the value of the RESERVE_2 column.
     * @return java.lang.String
     */
    public java.lang.String getReserve2()
    {
        return this.reserve2;
    }

    /**
     * Set the value of the RESERVE_2 column.
     * @param reserve2
     */
    public void setReserve2(java.lang.String reserve2)
    {
        this.reserve2 = reserve2;
    }

    /**
     * Return the value of the RESERVE_3 column.
     * @return java.lang.String
     */
    public java.lang.String getReserve3()
    {
        return this.reserve3;
    }

    /**
     * Set the value of the RESERVE_3 column.
     * @param reserve3
     */
    public void setReserve3(java.lang.String reserve3)
    {
        this.reserve3 = reserve3;
    }

    /**
     * Return the value of the COMMENTS column.
     * @return java.lang.String
     */
    public java.lang.String getComments()
    {
        return this.comments;
    }

    /**
     * Set the value of the COMMENTS column.
     * @param comments
     */
    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }

    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof TTifTradelog))
            return false;
        TTifTradelog that = (TTifTradelog) rhs;
        if (this.getId() == null || that.getId() == null)
            return false;
        return (this.getId().equals(that.getId()));
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
            if (this.getId() == null)
            {
                result = super.hashCode();
            }
            else
            {
                result = this.getId().hashCode();
            }
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
