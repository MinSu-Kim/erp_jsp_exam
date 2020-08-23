-- 접속자 확인
SELECT USER FROM DUAL;

-- 접속한 계정의 테이블 목록 조회
SELECT TABLE_NAME 
  FROM USER_TABLES;
 
-- 접속한 계정의 테이블별 컬럼 조회
SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_PRECISION, DATA_LENGTH, NULLABLE, DATA_DEFAULT
  FROM USER_TAB_COLUMNS
 WHERE TABLE_NAME IN ('EMPLOYEE', 'DEPARTMENT', 'TITLE');

-- 접속한 계정의 테이블별 제약조건 조회
SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION, DELETE_RULE
  FROM USER_CONSTRAINTS 
 WHERE TABLE_NAME IN ('EMPLOYEE', 'DEPARTMENT', 'TITLE');
 
-- 데이터 확인
SELECT * FROM TITLE;
SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;