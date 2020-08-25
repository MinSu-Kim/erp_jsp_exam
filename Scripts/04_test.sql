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

-- employee
SELECT e.EMP_NO, e.EMP_NAME, e.TNO, e.MANAGER, e.SALARY, e.DNO, e.HIREDATE, t.TITLE_NAME, d.DEPT_NAME, m.EMP_NAME MANAGER_NAME
  FROM EMPLOYEE e JOIN TITLE t ON e.TNO = t.TITLE_NO 
       LEFT JOIN EMPLOYEE m ON e.MANAGER = m.EMP_NO 
       JOIN DEPARTMENT d ON e.DNO = d.DEPT_NO;
       
   
SELECT EMP_NO , EMP_NAME , TNO , MANAGER , SALARY , DNO , HIREDATE 
  FROM EMPLOYEE
 WHERE EMP_NO = 4377;