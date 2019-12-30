alter table order_book_connection
   drop constraint FK_ORDER_BO_BOOK_CONN_DANGDANG;

alter table order_book_connection
   drop constraint FK_ORDER_BO_ORDER_CON_DANGDANG;

drop table order_book_connection cascade constraints;

/*==============================================================*/
/* Table: order_book_connection                                 */
/*==============================================================*/
create table order_book_connection  (
   conn_id              varchar2(64) primary key,
   order_id             varchar2(64),
   book_id              varchar2(64),
   book_name          varchar2(64),
   book_num             varchar2(6),
   conn_original_price  number(6,2),
   conn_dangdang_price  number(6,2),
   book_cover           varchar2(180),
   conn_date            date
);

select * from order_book_connection;