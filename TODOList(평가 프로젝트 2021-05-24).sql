create table tbl_List(
    td_seq NUMBER PRIMARY key,
    td_work NVARCHAR2(125) not null,
    td_date NVARCHAR2(10) not null,
    td_space NVARCHAR2(50)
);

drop table tbl_list;

create SEQUENCE seq_todo
start with 1 INCREMENT by 1;

INSERT INTO tbl_List(td_seq,td_work,td_date) 
VALUES(SEQ_TODO.nextval, '놀고먹고자기', '2021-13-32');

SELECT
    *
FROM tbl_list;

create view view_todo as(
select td_seq as 번호, td_work as 할일, td_date as 작성일자, td_space as 장소
from tbl_list);

select * from view_todo;

INSERT INTO tbl_List(td_seq,td_work,td_date,td_space) 
VALUES(SEQ_TODO.nextval, '포트폴리오 작성', '2021-05-24','집');