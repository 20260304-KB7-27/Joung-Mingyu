use employees;

-- WHERE
-- 특정 조건에 맞는 행만 석택하는 데 사용된다.

select * from employees where gender = 'M'; -- 성별이 M인 데이터만

-- select에 조회 컬럼으로 선택하지 않은 컬럼으로 조건을 걸 수 있음
select first_name, last_name from employees where gender = 'M'; -- 성별이 M인 데이터만

-- ColumnA != B: 컬럼의 내용 중 B와 같지 않은 데이터만 보여주기 -> 확장 문법
-- ColumnA <> B: 컬럼의 내용 중 B와 같지 않은 데이터만 보여주기 -> 표준
select first_name, last_name, gender
from employees
where
    # gender != 'M'; -- 성별이 M이 아닌 데이터만
    gender <> 'M';

-- AND 연산자와 함꼐 where 절 사용
select first_name, last_name, gender
from employees
where gender = 'M' AND first_name = 'Aamod';

select emp_no, first_name, last_name, gender
from employees
where gender = 'F' OR emp_no < 10050;

/*
AND와 OR의 우선순위
- AND가 OR보다 우선순위가 높다
 */
select true or false and false;
select (true or false) and false;

select * from employees
where emp_no >= 10050 and emp_no <= 10060;

/*
BETWEEN
- 경계값을 포함한 사이의 값을 포함한다.
 */
select * from employees
where emp_no between 10050 and 10060;

-- BETWEEN의 부정 표현 (경계값을 포함하지 않음)
select * from employees
where emp_no not between 10050 and 499995;

/*
LIKE
- 특정 패턴관 일치하는 행을 검색
- 느림 -> 보통은 패턴검색용도로 검색엔진을 사용

패턴
%: 0개 이상의 문자를 나타낸다
'%apple%' -> apple  포함된 모든 문자열을 의미

_: 1개의 문자를 나타냄
'a_k'는 'a'로 시작하고 'k'로 끝나는 세 글자 문자열을 의미
 */
select first_name from employees
where first_name like 'Aa%'; -- first_name이 Aa로 시작하는 모든 데이터

select first_name from employees
where
    -- first_name이 Aa로 시작하고 d로 끝나는 5글자인 모든 데이터
    first_name like 'Aa__d';

/*
IN 연산자
- 특정 열의 값이 지정된 목록 중 하나와 일치하는 데이터
 */
select * from employees
where emp_no in (2, 3, 55333, 19525);

/*
IS NULL
- 값이 null인지 아닌지 확인하여 조회
 */
use sqldb;
select * from buytbl where groupName is null;