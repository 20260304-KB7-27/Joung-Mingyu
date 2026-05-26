/*
SAFE MODE
- 한번의 쿼리 실수로 모든 데이터가 수정되거나 삭제되는 것을 방지하기 위해
- 조건문이 없을 때 UPDATE, DELETE가 동작하지 않게 막는 기능
*/

use sqldb;

set sql_safe_updates = 0; -- MySQL safe mode 끄기

update buytbl set price = price * 1.5; -- 모든 가격 1.5배

set sql_safe_updates = 1; -- MySQL safe mode 켜기

use testdb;

drop table if exists board;

create table board (
    post_no int not null auto_increment,
    title varchar(100) not null,
    author varchar(50) not null,
    primary key (post_no)
);

insert into board (title, author) values ('첫 번째 글', '홍길동');
insert into board (title, author) values ('두 번째 글', '김철수');
insert into board (title, author) values ('세 번째 글', '이영희');
insert into board (title, author) values ('네 번째 글', '박민준');
insert into board (title, author) values ('다섯 번째 글', '최지수');

/*
DELETE
- 테이블의 행(row)을 삭제하는 DML 명령어
- WHERE 조건으로 특정 행을 삭제할 수 있다.
- 트랜잭션(ROLLBACK)으로 복구 가능
*/

delete from board where post_no = 5;

select * from board;

-- auto_increment 값이 초기화되지 않고 이어서 증가함
insert into board (title, author) values ('여섯 번째 글', '최지수');

/*
TRUNCATE
- 테이블의 전체 행을 한번에 삭제하는 DDL 명령어
- WHERE 사용 불가 (전체 삭제 전용)
- 트랜잭션(ROLLBACK) 불가
- DELETE보다 처리 속도가 빠름
- 테이블 구조(컬럼, 제약조건) 유지, auto_increment는 초기화
*/

truncate table board;

insert into board (title, author) values ('첫 번째 글', '홍길동');

/*
DROP
- 테이블 자체를 데이터베이스에서 완전히 제거하는 DDL 명령어
- 트랜잭션(ROLLBACK) 복구 불가능
*/

-- 테이블이 없으면 에러 발생
drop table board;

-- 일반적으로는 IF EXISTS를 붙여서 사용
drop table if exists board;