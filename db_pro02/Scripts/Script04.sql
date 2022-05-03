SELECT ROWNUM
	 , EMPLOYEE_ID
	 , FIRST_NAME
	 , LAST_NAME
	 , SALARY
	 , COMMISSION_PCT
	FROM EMPLOYEES
	WHERE COMMISSION_PCT IS NOT NULL
	  AND ROWNUM <= 5
	ORDER BY SALARY DESC;


SELECT * 
	FROM (SELECT ROWNUM
			   , EMPLOYEE_ID
	 		   , FIRST_NAME
	 		   , LAST_NAME
	 		   , SALARY
	 		   , COMMISSION_PCT
			FROM EMPLOYEES
			WHERE COMMISSION_PCT IS NOT NULL
			ORDER BY SALARY DESC)
	WHERE ROWNUM <= 10;
	

-- WITH
WITH EMP_COM 
	AS (SELECT EMPLOYEE_ID
			 , FIRST_NAME
	  	     , LAST_NAME
	 		 , SALARY
	 		 , COMMISSION_PCT
		FROM EMPLOYEES
		WHERE COMMISSION_PCT IS NOT NULL
		ORDER BY SALARY DESC)
	SELECT * FROM EMP_COM;


-- RANK() OVER
SELECT *
	FROM (SELECT FIRST_NAME
			   , LAST_NAME
			   , RANK() OVER(ORDER BY SALARY DESC) AS 순위
			FROM EMPLOYEES
			ORDER BY FIRST_NAME)
	WHERE 순위 <= 10;
	

SELECT *
	FROM EMPLOYEES
	WHERE (SALARY, COMMISSION_PCT) = (SELECT SALARY, COMMISSION_PCT FROM EMPLOYEES WHERE EMPLOYEE_ID = 157);
	
SELECT *
	FROM EMPLOYEES
	WHERE (SALARY, COMMISSION_PCT) IN ((9500, 0.35), (9500, 0.25));