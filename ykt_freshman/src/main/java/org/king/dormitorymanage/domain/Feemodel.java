package org.king.dormitorymanage.domain;
// Generated by MyEclipse - Hibernate Tools



/**
 * Feemodel generated by MyEclipse - Hibernate Tools
 */
public class Feemodel extends AbstractFeemodel implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Feemodel() {
    }

	/** minimal constructor */
    public Feemodel(String feeNo) {
        super(feeNo);        
    }
    
    /** full constructor */
    public Feemodel(String feeNo, String feeName, double fee) {
        super(feeNo, feeName, fee);        
    }
   
}