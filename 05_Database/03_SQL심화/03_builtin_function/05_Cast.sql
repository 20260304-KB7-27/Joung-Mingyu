-- 형 변환 내장 함수

use employees;

/*
CAST(value AS type)
- value를 지정한 type으로 변경
- CHAR, SIGNED(정수), UNSIGNED(양의 정수), DECIMAL, DATE, DATETIME
*/
select
    emp_no,
    # 문자열의 크기를 명시하지 않으면 필요한 크기만큼 자동 생성
    concat('사번: ', cast(emp_no as char(30))) as 사번_문자
from employees limit 5, 10;

/*
CONVERT(value, type)
- CAST와 동일한 역할을 수행
- 문자셋 변환에도 사용할 수 있다. CONVERT(str USING utf8mb4)
*/
select
    emp_no, hire_date,
    convert(year(hire_date), char) as 입사년도_문자,
    convert(year(hire_date), signed) as 입사년도_정수
from employees limit 5, 10;