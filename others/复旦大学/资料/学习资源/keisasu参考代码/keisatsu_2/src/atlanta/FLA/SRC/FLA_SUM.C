/*--------------------------------------------------------------------------*/
/*  プロジェクト : POPLAR/ANZU_L                                            */
/*  ファイル名   : fla_sum.c                                                */
/*  作成者       : 桑原美紀                                                 */
/*  日  付       : 1997/04/25                                               */
/*  概  要       : コマンド書込みチェック			                        */
/*  修正履歴     :                                                          */
/*--------------------------------------------------------------------------*/
#include	"\src\atlanta\define\product.h"
#include	"\src\ATLANTA\FLA\define\fla_pro.h"
#include	"\src\ATLANTA\FLA\define\fla_def.h"
#include	"\src\ATLANTA\FLA\ext_v\fla_tbl.h"

#include	"\src\ATLANTA\FLA\define\sys_pro.h"

#pragma section FLASHWRITE /*  "PFLASHWRITE" */
#if (PRO_RDS_FLASH_ROM_WRITE == ENABLE)
/*************************************************************************
	module		:[コマンド書込みチェック（１６ビット・サムチェック]
	function	:[書込みチェックの為のデータ合計数を取得]
	return		:[データ合計数]
	common		:[]
	condition	:[]
	comment		:[ＲＯＭ０，ＲＯＭ１の各合計数も表示する為、値を返すように変更 ** 97/08/11 M.Kuwahara **
]
	machine		:[SH7043]
	language	:[SHC]
	keyword		:[FLASH]
	date		:[1997/04/25]
	author		:[桑原美紀]
*************************************************************************/
/*UWORD	GetWordSumCheck( void )*/
UWORD	GetWordSumCheck( UWORD *Rom0_sum,
						 UWORD *Rom1_sum )

{
	UBYTE	sector_cnt;			/* ｾｸﾀｶｳﾝﾀ */
	UWORD	*TopAddress;		/* 先頭ｱﾄﾞﾚｽ */
	UDWORD	SizeCounter;		/* ｻｲｽﾞｶｳﾝﾀ */
	UWORD	SumCheck;			/* ﾃﾞｰﾀ合計数 */
	UWORD	rom_sum;			/* ROM毎の合計数 */

	SumCheck = 0;
	*Rom0_sum = 0;
	*Rom1_sum = 0;

	for (sector_cnt = 0; sector_cnt < SECTOR_MAX; sector_cnt++) {
		rom_sum	= 0;
		if (SYS_RomMap[sector_cnt].Status == ROM_USE) {
			TopAddress = (UWORD *)((UDWORD)FLASH_MEM + SYS_RomMap[sector_cnt].StartAddress);
			for( SizeCounter = 0; SizeCounter < (UDWORD)SYS_RomMap[sector_cnt].Size; SizeCounter += 2 ){
				rom_sum		+= *TopAddress;
				SumCheck	+= *TopAddress;
				TopAddress ++;
/*				SumCheck	+= *TopAddress++;*/
			}
		}
		if (SYS_RomMap[sector_cnt].StartAddress < 0x00080000L) {	/* ROM0の合計数 */
			*Rom0_sum += rom_sum;
		}
		else{
			*Rom1_sum += rom_sum;
		}
	}

	return( SumCheck );

#if (0)
	UBYTE	RomMapNo;			/* ROM_MAPﾃｰﾌﾞﾙNo */
	UWORD	*TopAddress;		/* 先頭ｱﾄﾞﾚｽ */
	UDWORD	Size;				/* ﾌﾟﾛｸﾞﾗﾑｻｲｽﾞ */
	UDWORD	SizeCounter;		/* ｻｲｽﾞｶｳﾝﾀ */
	UWORD	SumCheck	= 0;	/* ﾃﾞｰﾀ合計数 */

	for( RomMapNo = 0; SYS_RomMap[RomMapNo].Status != NOT_ROM_USE; RomMapNo++ ){
		TopAddress = (UWORD *)(FLASH_MEM + SYS_RomMap[RomMapNo].StartAddress);
		Size = (UDWORD)( SYS_RomMap[RomMapNo].Size + 1 );
		for( SizeCounter = 0; SizeCounter < Size; SizeCounter++ ){
			SumCheck	+= *TopAddress++;
		}
	}

	return( SumCheck );
#endif

}
#endif
#pragma section
