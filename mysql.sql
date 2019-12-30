select admin_id,admin_username,admin_password from dangdang_admin;
<!--创建管理员表-->
create table dangdang_admin  (
   admin_id             varchar2(64) primary key,
   admin_username       varchar2(64),
   admin_password       varchar2(32)
);
<!--删除管理员表-->
drop table dangdang_admin cascade constraints;

<!--创建专属序列-->
create sequence dangdang_admin_sequence start with 1;

drop sequence dangdang_admin_sequence;

insert into dangdang_admin values (dangdang_admin_sequence.nextval,'李少涵','666');


<!--类别表的管理-->
<!--类别的id通过DDID获取-->
create table dangdang_sort  (
   sort_id              varchar2(64) primary key,
   sort_name            varchar2(32),
   father_id            varchar2(64),
   sort_rank            varchar2(6)
);
/*==============================================================*/
/* Table: dangdang_sort                                         */
/*==============================================================*/
drop table dangdang_sort cascade constraints;

<!--查询-->
select d1.sort_id, d1.sort_name, d1.sort_rank
from dangdang_sort d1
left join dangdang_sort d2
on d1.father_id = d2.sort_id

select *
from dangdang_sort

delete from dangdang_sort where sort_id = 'e8a5829f-66f9-4d5f-a76e-dd32f560fab8' or father_id = 'e8a5829f-66f9-4d5f-a76e-dd32f560fab8'


<!--书籍表-->
alter table dangdang_book
   drop constraint FK_DANGDANG_BOOK_SORT_DANGDANG;

alter table order_book_connection
   drop constraint FK_ORDER_BO_BOOK_CONN_DANGDANG;

drop table dangdang_book cascade constraints;

/*==============================================================*/
/* Table: dangdang_book                                         */
/*==============================================================*/

select *
from dangdang_book;

create table dangdang_book  (
   book_id              varchar2(64) primary key,
   book_name            varchar2(64),
   book_author          varchar2(64),
   author_introduction  varchar2(300),
   book_introduction    varchar2(300),
   book_publisher       varchar2(64),
   book_publish_time    date,
   book_printing_time   date,
   book_putaway_time    date,
   book_edition         varchar2(32),
   book_impression      varchar2(32),
   book_paper           varchar2(32),
   book_pages           varchar2(8),
   book_pack            varchar2(32),
   book_format          varchar2(32),
   book_words           varchar2(10),
   book_isbn            varchar2(13),
   book_editer_comment  varchar2(300),
   book_media_comment    varchar2(600),
   book_catalog         varchar2(1200),
   book_cover           varchar2(180),
   book_original_price  number(6,2),
   book_dangdang_price  number(6,2),
   book_inventory       varchar2(6),
   book_sales_volume    varchar2(10),
   sort_id              varchar2(64)
);

insert into dangdang_book values ('1','红楼梦','曹雪芹','大家好，我是曹雪芹','红楼梦这本书的书籍简介','中国人民出版社',TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'),TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'),TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'),'第三版','第七次印刷','16开','500','胶版纸','精装','731017','19','编辑评论','媒体评论','基本目录','封面',45.5,39.9,'3000','0','3cd8ef77-2f92-49fc-a279-48889099970d');
INSERT INTO dangdang_book VALUES ('6', '东周列国志', '冯梦龙', 'dzlgz.jpg', '民主与建设出版社', TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'), '第三版', TO_DATE('2018-12-12 16:32:08', 'YYYY-MM-DD HH24:MI:SS'), '第五次印刷', '9787551123426', '50000', '500', '16开', '胶版纸', '精装', '20', '19', TO_DATE('2019-01-07 16:34:07', 'YYYY-MM-DD HH24:MI:SS'), '当当网此版本销售火爆！写尽东周五百年群雄争霸颠覆历史格局的传奇巨著！', '古典小说精品系列： 《芈月传》小说原著及编剧蒋胜男读的首本书《 东周列国志 》 ', '作者很低调，没有做简介', '买了就知道目录了，我就不多介绍了', '媒体也说很好看的一本书', 'f0dbdcb6-1857-4063-8759-090265c217c6', '0', '1000');

