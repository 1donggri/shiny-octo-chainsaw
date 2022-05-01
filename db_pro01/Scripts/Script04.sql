-- 길이
SELECT FIRST_NAME
	,  LENGTH(FIRST_NAME) AS "길이"
	FROM EMPLOYEES;
	
SELECT LENGTH ('Hello Oracle')
	,  LENGTH ('오라클 안녕')
	FROM DUAL;
	
SELECT LENGTHB('Hello Oracle')
	,  LENGTHB('오라클 안녕')
	FROM DUAL;
	
SELECT INSTR('sample@example@com', '@', 1)
	,  INSTR('sample@example@com', '@', -1) 
	,  INSTR('sample@example@com', '@', -1, 2) 
	FROM DUAL;

-- 공백
SELECT '!' || LPAD('A', 4)
	,  '!' || LPAD('AB', 4)
	,  '!' || LPAD('ABC', 4)
	,  '!' || LPAD('ABCD', 4)
	,  '!' || LPAD('A', 4, '_') 
	,  RPAD('A', 4) || '!' 
	,  RPAD('AB', 4) || '!' 
	,  RPAD('ABC', 4) || '!' 
	,  RPAD('ABCD', 4) || '!' 
	,  RPAD('ABCD', 4, '0') || '!' 
	FROM DUAL;
	

-- 제거
SELECT RTRIM('user@example.com', '@example.com')
	,  LTRIM('010-1234-5678', '010-') 
	,  LTRIM(RTRIM('     PASSWORD INPUT    '))	-- 양쪽 공백 제거
	,  TRIM('     PASSWORD INPUT    ')	-- 양쪽 공백 제거
	,  TRIM('A' FROM 'AAAAHelloAAAA')	-- 양쪽 A 제거
	,  TRIM(LEADING 'A' FROM 'AAAAHelloAAAA')	-- 앞쪽 A 제거
	,  TRIM(TRAILING 'A' FROM 'AAAAHelloAAAA')	-- 뒤쪽 A 제거
	,  TRIM(BOTH 'A' FROM 'AAAAHelloAAAA')	-- 양쪽 A 제거
	FROM DUAL;
	

SELECT SUBSTR('userId@example.com', 1, 6)	-- 1 에서 부터 6 글자
	,  SUBSTR('userId@example.com', 8, 7)	-- 8 에서 부터 7 글자
	,  SUBSTR('userId@example.com', 8)		-- 지정 안하면 끝까지
	,  SUBSTR('userId@example.com', -3)		-- 뒤에서 3 글자
	FROM DUAL;
	

SELECT LOWER('userId@example.com')		-- 소문자로 변환
	,  UPPER('userId@example.com')		-- 대문자로 변환
	,  INITCAP('userId@example.com')	-- 첫번째 글자에 대해 Cap을 씌어주는 것
	FROM DUAL;


SELECT CONCAT('Hello', ' World')
	FROM DUAL;


-- REPLACE(원본, 찾을 문자열, 변경할 문자열)
SELECT REPLACE('userId@example.com', '@example.com', '@example.co.kr')
	FROM DUAL;
	

SELECT ABS(10)
	,  ABS(-10)
	,  ABS(-10.12)
	FROM DUAL;


-- 나머지
SELECT MOD(10, 3)
	,  MOD(-10, 3)
	,  MOD(10.5, 3)
	,  MOD(-10.5, 3)
	FROM DUAL;
	

-- 반올림
SELECT ROUND(10.4)
	,  ROUND(10.5)
	,  ROUND(10.45, 1)		-- 소수점 1 번째 자리까지 반올림
	,  ROUND(10.456, 2)		-- 소수점 2 번째 자리까지 반올림
	,  ROUND(18.456, -1)	-- 정수 1 번째 자리까지 반올림 
	FROM DUAL;
	

-- 내림 올림?
SELECT FLOOR(10.34)
	,  FLOOR(-10.34)
	,  CEIL(10.34)
	,  CEIL(-10.34)
	FROM DUAL;
	

-- 버림 (절사)
SELECT TRUNC(10.34, 1)
	,  TRUNC(10.36, 1)
	,  TRUNC(10.3456, 2)
	,  TRUNC(1234, -1) 
	FROM DUAL;
	

ALTER SESSION SET NLS_LANGUAGE = KOREAN;

SELECT * FROM "GV$NLS_PARAMETERS" WHERE PARAMETER LIKE '%LANG%'

ALTER SESSION SET NLS_CURRENCY = '\';
SELECT * FROM "GV$NLS_PARAMETERS" WHERE PARAMETER = 'NLS_CURRENCY';

SELECT SYSDATE
	,  ADD_MONTHS(SYSDATE, 3)
	,  ADD_MONTHS(SYSDATE, -3)
	,  LAST_DAY(SYSDATE)
	-- ,  NEXT_DAY(SYSDATE, 'FRYDAY')
	-- ,  NEXT_DAY(SYSDATE, 'FRI')
	,  NEXT_DAY(SYSDATE, '금요일')	-- 가장 가까운 금요일
	,  NEXT_DAY(SYSDATE, '금')		-- 가장 가까운 금요일
	,  NEXT_DAY(SYSDATE, 6)			-- 1: 일요일, 2: 월요일, .... 6: 금요일, 7: 토요일
	FROM DUAL;
	

SELECT EXTRACT(YEAR FROM SYSDATE)
	,  EXTRACT(MONTH FROM SYSDATE)
	,  EXTRACT(DAY FROM SYSDATE)
	,  EXTRACT(HOUR FROM SYSTIMESTAMP)
	,  EXTRACT(MINUTE FROM SYSTIMESTAMP)
	,  EXTRACT(SECOND FROM SYSTIMESTAMP)
	,  SYSDATE
	,  SYSTIMESTAMP
	FROM DUAL;
	

SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 3))
	,  MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 3), SYSDATE) 
	FROM DUAL;
	

SELECT SYSDATE
	,  SYSDATE + 1
	,  SYSDATE + 2
	,  SYSDATE - 1
	,  SYSDATE - 2
	,  SYSDATE + INTERVAL '1' DAY
	,  SYSDATE + INTERVAL '1' MONTH 
	,  SYSDATE + INTERVAL '1' YEAR 
	FROM DUAL;
	

SELECT SYSTIMESTAMP
	,  SYSTIMESTAMP + INTERVAL '3' DAY
	,  SYSTIMESTAMP + INTERVAL '3' MONTH 
	,  SYSTIMESTAMP + INTERVAL '3' YEAR
	,  SYSTIMESTAMP + INTERVAL '30' SECOND
	,  SYSTIMESTAMP + INTERVAL '30' MINUTE
	,  SYSTIMESTAMP + INTERVAL '3' HOUR
	,  SYSTIMESTAMP - INTERVAL '30' SECOND
	,  SYSTIMESTAMP - INTERVAL '30' MINUTE
	,  SYSTIMESTAMP - INTERVAL '3' HOUR
	FROM DUAL;
	

-- 문자로 변환
SELECT 1234
	,  TO_CHAR(1234)
	,  TO_CHAR(SYSDATE, 'YYYYMMDD') 
	,  TO_CHAR(SYSDATE, 'YYYY/MM/DD')
	,  TO_CHAR(SYSDATE, 'YYYY-MM-DD')
	,  TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일"')
	,  TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS')
	,  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')
	,  TO_CHAR(SYSTIMESTAMP, 'YYYY-MM-DD AM HH:MI:SS.FF3')
	,  TO_CHAR(1000000, '999,999,999')
	,  TO_CHAR(1000000, '000,000,000')
	,  TO_CHAR(1000000, '999,999,999L')
	FROM DUAL;
	

-- 날짜로 변환
SELECT TO_DATE('20220425', 'YYYYMMDD')
	,  TO_DATE('20220425')
	,  TO_DATE(20220425) 
	,  TO_DATE('2022/04/25')
	,  TO_DATE('2022.04.25')
	,  TO_DATE('2022년 04월 25일', 'YYYY"년" MM"월" DD"일"')
	FROM DUAL;
	

--  숫자로 변환
SELECT TO_NUMBER('20220425')
	,  TO_NUMBER('20,220,425', '999,999,999')
	,  TO_NUMBER('FFFF', 'XXXX')
	FROM DUAL;
	

-- 날짜를 숫자로 변환 : 먼저 문자로 변환 후 숫자로 변환
SELECT TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD'))
	FROM DUAL;
	
