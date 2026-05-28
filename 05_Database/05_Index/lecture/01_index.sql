create database if not exists testdb;

use testdb;

/*
클러스터형 인덱스
- 테이블의 기본키(PK)가 자동으로 클러스터형 인덱스가 됨
데이터가 기본키 순서대로 정렬(클러스터형 인덱스 대로 정렬되서 저장)
- 한 테이블에 클러스터형 인덱스 한개만 존재 가능

보조 인덱스
- PRIMARY KEY가 아닌 모든 인덱스
- 인덱스를 직접 생성해줄 수 있음
- UNIQUE 제약조건을 넣으면 고유 인덱스가 생성됨
*/
drop table if exists usertbl;
create table usertbl(
    userID char(8) not null primary key, -- 클러스터형 인덱스
    name varchar(10) not null unique , -- 보조 인덱스
    birthYear int not null,
    addr nchar(2) not null
);

show index from usertbl;

insert into usertbl values('LSG', '이승기', 1987, '서울');
insert into usertbl values('KBS', '김범수', 1979, '경남');
insert into usertbl values('KKH', '김경호', 1971, '전남');
insert into usertbl values('JYP', '조용필', 1950, '경기');
insert into usertbl values('ANA', '성시경', 1979, '서울');

select * from usertbl; -- userID 기준으로 정렬됨

alter table usertbl drop primary key; -- PK 삭제
alter table usertbl -- PK name 컬럼으로 등록
add constraint pk_name primary key(name);

show index from usertbl;

select * from usertbl; -- name 기준으로 정렬