alter table dangdang_address
   drop constraint FK_DANGDANG_USER_ADDR_DANGDANG;

drop table dangdang_address cascade constraints;

/*==============================================================*/
/* Table: dangdang_address                                      */
/*==============================================================*/
create table dangdang_address  (
   add_id               varchar2(64) primary key,
   add_postcode         varchar2(32),
   add_local            varchar2(300),
   add_recipients       varchar2(64),
   add_tel              varchar2(18),
   user_id              varchar2(64)
);

select * from dangdang_address;