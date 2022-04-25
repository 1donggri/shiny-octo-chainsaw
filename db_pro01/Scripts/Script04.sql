
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