/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2007-5-14 15:14:18                           */
/*==============================================================*/

/*
drop tablespace TS_YKT_CUR including contents cascade constraints;
drop tablespace TS_YKT_HIS including contents cascade constraints;
drop tablespace TS_YKT_MON including contents cascade constraints;
drop tablespace TS_YKT_WEB including contents cascade constraints;
drop tablespace TS_YKT_PHOTO including contents cascade constraints;
*/

create tablespace TS_YKT_CUR
datafile 
'{dbfile_dir}/ts_yktcur.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_WEB
datafile  
'{dbfile_dir}/ts_yktweb.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M
logging
extent management  local  autoallocate
segment space management auto
flashback on;
create tablespace TS_YKT_PHOTO
datafile  
'{dbfile_dir}/ts_yktphoto.dbf' size 4000M reuse  autoextend on  next 100M  maxsize 20000M
logging
extent management  local  autoallocate
segment space management auto
flashback on;

create tablespace TS_YKT_HIS
datafile  
'{dbfile_dir}/ts_ykthis01.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis02.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis03.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis04.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis05.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis06.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis07.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis08.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis09.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis10.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis11.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis12.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis13.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis14.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis15.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis16.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis17.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis18.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis19.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M,
'{dbfile_dir}/ts_ykthis20.dbf' size 1000M reuse  autoextend on  next 100M  maxsize 20000M
logging
extent management  local  autoallocate
segment space management auto
flashback on;