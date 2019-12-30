alter table dangdang_order
   drop constraint FK_DANGDANG_USER_ORDE_DANGDANG;

alter table order_book_connection
   drop constraint FK_ORDER_BO_ORDER_CON_DANGDANG;

drop table dangdang_order cascade constraints;

/*==============================================================*/
/* Table: dangdang_order                                        */
/*==============================================================*/

select order_id,order_serial,order_total,order_status,user_id,add_recipients,add_local,order_date
from dangdang_order

create table dangdang_order  (
   order_id             varchar2(64) primary key,
   order_serial         varchar2(64),
   order_total          number(8,2),
   order_status         varchar2(32),
   user_id              varchar2(64),
   add_recipients       varchar2(64),
   add_local            varchar2(600),
   order_date           date
);

alter table dangdang_order
   add constraint FK_DANGDANG_USER_ORDE_DANGDANG foreign key (user_id)
      references dangdang_user (user_id);