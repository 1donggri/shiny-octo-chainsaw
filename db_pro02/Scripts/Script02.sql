/*
 * 지출내역서(가계부)를 위한 테이블을 만들어 본다.
 *     - 테이블 이름은 지출내역서_T 라고 한다.
 *     - 날짜, 입금액, 출금액, 비고 를 저장할 수 있는 컬럼 필요하다.
 *     - 비고의 경우 한글 150자 까지 저장 가능해야 한다.
 */

CREATE TABLE 지출내역서_T (
	   날짜 DATE
	 , 입금액 NUMBER
	 , 출금액 NUMBER
	 , 비고 VARCHAR2(450)
);

-- 테이블 삭제
-- DROP TABLE 지출내역서_T;

-- 확인 구문
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = '지출내역서_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '지출내역서_T';


 /*
 * 위에서 만든 지출내역서에 다음의 컬럼 정보를 추가 및 수정 한다.
 *     - 행 데이터를 식별하기 위한 식별자용 컬럼을 추가 이 컬럼 이름은 ACCOUNT_ID 로 한다.
 *     - 비고의 데이터 저장 크기를 기존보다 2배 늘린다.
 *     - 지출내역 항목을 구분하기 위한 ACCOUNT_TYPE 컬럼을 추가하고
 *       해당 컬럼은 FK 로 만든다.
 *     - ACCOUNT_TYPE 컬럼이 참조하는 테이블은 "지출내역구분_T" 라는 테이블로 만들어 둔다.
 *     - 지출내역구분 테이블에는 식별자용 컬럼, 구분명 컬럼이 있어야 한다.
 */

-- 행 데이터를 식별하기 위한 식별자용 컬럼을 추가 이 컬럼 이름은 ACCOUNT_ID 로 한다.
ALTER TABLE 지출내역서_T ADD ACCOUNT_ID NUMBER CONSTRAINT PK_지출내역서_T_ACCOUNT_ID PRIMARY KEY;

-- 비고의 데이터 저장 크기를 기존보다 2배 늘린다.
ALTER TABLE 지출내역서_T MODIFY 비고 VARCHAR2(900);

-- ACCOUNT_TYPE 컬럼이 참조하는 테이블은 "지출내역구분_T" 라는 테이블로 만들어 둔다.
-- 지출내역구분 테이블에는 식별자용 컬럼, 구분명 컬럼이 있어야 한다.
CREATE TABLE 지출내역구분_T (
	   구분ID NUMBER CONSTRAINT PK_지출내역구분_T_구분ID PRIMARY KEY
	 , 구분명 VARCHAR2(100)
);

-- 지출내역 항목을 구분하기 위한 ACCOUNT_TYPE 컬럼을 추가하고 해당 컬럼은 FK 로 만든다.
ALTER TABLE 지출내역서_T ADD ACCOUNT_TYPE NUMBER CONSTRAINT FK_지출내역서_T_ACCOUNT_TYPE REFERENCES 지출내역구분_T(구분ID);

-- 확인 구문
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME LIKE '지출내역%';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE '지출내역%';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE '지출내역%';



/*
 * INSERT
 * 		테이블에 새로운 행을 추가하여 테이블의 행 개수를 증가시키는 구문
 */

INSERT INTO 지출내역구분_T VALUES(1, '은행적금');
INSERT INTO 지출내역구분_T VALUES(2, '은행예금');
INSERT INTO 지출내역구분_T(구분ID, 구분명) VALUES(3, '교통비');
INSERT INTO 지출내역구분_T(구분명, 구분ID) VALUES('통신비', 4);

CREATE TABLE 지출내역구분_COPY (
	   구분ID NUMBER CONSTRAINT PK_지출내역구분_COPY_구분ID PRIMARY KEY
	 , 구분명 VARCHAR2(100)
);

INSERT INTO 지출내역구분_COPY (
	   SELECT 구분ID, 구분명
	   	 FROM 지출내역구분_T
);

-- 커밋
COMMIT;

-- 복구
ROLLBACK;

-- 삭제
SELECT * FROM 지출내역구분_T;
DELETE FROM 지출내역구분_COPY;


CREATE TABLE 지출내역구분_COPY2
	AS SELECT 구분명 FROM 지출내역구분_T
		WHERE 1 = 0;

-- 매치되는지 확인
INSERT ALL
	INTO 지출내역구분_COPY VALUES(idx, name)
	INTO 지출내역구분_COPY2 VALUES(name)
SELECT 구분ID AS idx, 구분명 AS name
	FROM 지출내역구분_T;

SELECT * FROM 지출내역구분_COPY;
SELECT * FROM 지출내역구분_COPY2;



/*
 * COMMISSION_PCT 유무에 따라
 *     커미션이 있는 경우 EMP_COMMISSION 테이블에 사번, 이름, 급여, 커미션PCT 정보를 저장하고
 *     커미션이 없는 경우 EMP_NO_COMMISSION 테이블에 사번, 이름, 급여 정보를 저장한다.
 */

SELECT * FROM EMPLOYEES;

CREATE TABLE EMP_COMMISSION
	AS SELECT EMPLOYEE_ID AS 사번
			, FIRST_NAME || ' ' || LAST_NAME AS 이름
			, SALARY AS 급여
			, COMMISSION_PCT AS 커미션PCT
		FROM EMPLOYEES
		WHERE 1 = 0;

CREATE TABLE EMP_NO_COMMISSION
	AS SELECT EMPLOYEE_ID AS 사번
			, FIRST_NAME || ' ' || LAST_NAME AS 이름
			, SALARY AS 급여
		FROM EMPLOYEES
		WHERE 1 = 0;
	
INSERT ALL
WHEN COMMISSION_PCT IS NOT NULL THEN
		INTO EMP_COMMISSION VALUES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, COMMISSION_PCT)
WHEN COMMISSION_PCT IS NULL THEN
		INTO EMP_COMMISSION VALUES(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY)
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES;


