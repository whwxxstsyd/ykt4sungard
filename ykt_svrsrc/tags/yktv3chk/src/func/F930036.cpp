/* --------------------------------------------
 * ��������: F930036.sqc
 * ��������: 20050306
 * ��������: �Ž�
 * �汾��Ϣ: 1.0.0.0
 * ������:  �ɼ��ֽ��ֵ��������ˮ
 * --------------------------------------------*/
#define _IN_SQC_
#include <stdio.h>
#include <string.h>
#include "pubdef.h"
#include "errdef.h"
#include "pubfunc.h"
#include "pubdb.h"
#include "dbfunc.h"
#include "account.h"
#include "busqc.h"

static int check(T_t_tif_rcvdtl *p)
{
	int ret=0;
	if(strlen(p->crc)==0)
	{
		return E_999_CRC;							//�ϴ���ˮCRCУ�����
	}
	ret=IsInvalidDateTime(p->tx_date,"YYYYMMDD");
	if(ret)
	{
		return E_999_DATE;							//�ϴ���ˮ������������
	}
	ret=IsInvalidDateTime(p->tx_time,"HHMMSS");
	if(ret)
	{
		return E_999_TIME;							//�ϴ���ˮ����ʱ������
	}

	if((p->tx_mark!=0X30)&&(p->tx_mark!=0xFE)	)
	{
		return 	p->tx_mark+E_999_0X00;			//�ѷ�������Ϊ���ױ��
	}
	if(0X30==p->tx_mark)
	{
		if(p->amount<=0)
		{
			return E_999_AMT;							//�ϴ���ˮ���׷����������
		}
	}
	else
	{
		if(p->amount>=0)
		{
			return E_999_AMT;							//�ϴ���ˮ���׷����������
		}
	}
	return 0;
}
int F930036(TRUSERID *handle,int iRequest,ST_PACK *rPack,int *pRetCode,char *szMsg)
{

	int ret=0;
	T_t_tif_rcvdtl tRcvdtl;
	/*
	ret=chk_dyn_key(rPack->lcert_code,rPack->scust_limit2);
	if(ret)
	{
		writelog(LOG_ERR,"subsys_id[%d]dyn_key[%s]",rPack->lcert_code,rPack->scust_limit2);
		*pRetCode =  ret;
		goto L_RETU;
	}
	*/
	memset(&tRcvdtl,0,sizeof(tRcvdtl));

	tRcvdtl.serial_no= rPack->lvol4;							//�ϴ�����ˮ��
	tRcvdtl.tx_mark=rPack->lvol12;							//999���ױ��
	tRcvdtl.sys_id  = rPack->lcert_code;						//�ϴ�����վ��ʶ(ǰ�û�ע���)
	des2src(tRcvdtl.deviceid, rPack->sdate1);				//�����豸ID
	des2src(tRcvdtl.inpower_no,rPack->stx_pwd);				//�ն��豸��Ȩ��
//	tRcvdtl.comu_ver=rPack->lbank_acc_type;				//ͨ�Ű汾��
//	tRcvdtl.run_reason = rPack->lbank_acc_type2;				//����ԭ��
	des2src(tRcvdtl.crc,rPack->sbank_code2);				//CRCУ��

	tRcvdtl.cardno= rPack->lvol5;							//���׿���
	tRcvdtl.purse_no = rPack->lvol6;						//����Ǯ����
	tRcvdtl.in_bala= rPack->lvol9;							//�뿨���
	tRcvdtl.out_bala = rPack->lvol10;						//�������
	tRcvdtl.amount = rPack->lvol8;							//�������ѽ��
	tRcvdtl.total_cnt= rPack->lvol7;							//��ǰ�����ʻ����Ѵ���(�ۼ�ʹ�ô���)
	tRcvdtl.tx_code = 930036;								//���״���
 	snprintf(tRcvdtl.tx_date,9,"20%s",rPack->spost_code);		//��������(��ʽ�����������)
	des2src(tRcvdtl.tx_time,rPack->spost_code2);			//����ʱ��(��ʽ�������ʱ��)
	getsystimestamp(tRcvdtl.col_timestamp);
	ret=check(&tRcvdtl);
	if(ret)
	{
		tRcvdtl.status[0]='5';								//��Ч����
//		tRcvdtl.run_reason=ret;
		tRcvdtl.err_code=ret;
		strncpy(tRcvdtl.deal_date,tRcvdtl.col_timestamp,8);
		strncpy(tRcvdtl.deal_time,tRcvdtl.col_timestamp+8,6);
	}
	else
		tRcvdtl.status[0]='1';
	g_dbchkerr=0;
	ret = DB_t_tif_rcvdtl_add(&tRcvdtl);
	if (ret)
	{
		g_dbchkerr=1;
		writelog(LOG_DEBUG,"serial_no[%d]cardno[%d]deviceid[%s]tx_date[%s]tx_time[%s]",tRcvdtl.serial_no,tRcvdtl.cardno,tRcvdtl.deviceid,tRcvdtl.tx_date,tRcvdtl.tx_time);
		if(DB_REPEAT==ret)
			return 0;
		else
			*pRetCode = E_DB_TRADESERIAL_I;
		goto L_RETU;
	}
	g_dbchkerr=1;
	return 0;
L_RETU:
	//�ع�����
	return -1;
}
