alter table dangdang_address
   drop constraint FK_DANGDANG_USER_ADDR_DANGDANG;

alter table dangdang_order
   drop constraint FK_DANGDANG_USER_ORDE_DANGDANG;

drop table dangdang_user cascade constraints;

/*==============================================================*/
/* Table: dangdang_user               用户表                        */
/*==============================================================*/
create table dangdang_user  (
   user_id              varchar2(64) primary key,
   user_nickname        varchar2(64),
   user_email           varchar2(64),
   user_code            varchar2(18),
   user_password        varchar2(32),
   user_status          varchar2(18),
   salt                 varchar2(18),
   regist_date            date
);

select * from dangdang_user