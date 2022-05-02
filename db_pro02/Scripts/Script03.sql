/*
 * 세 달치 분량의 지출내역을 지출내역서_T 와 지출내역구분_T 에 만들어 본다.
 * 		- 실제 체크카드 내역 및 신용카드 내역을 확인해서 데이터 추가 작업 진행.
 * 		- 구분은 교통비, 식비, 편의점 등의 사용 정보를 확인하여 5 ~ 10 개 정도의 구분을 생성.
 * 		- 지출내역서는 매달 사용한 내역을 기준으로 10 ~ 15 개 정도를 생성.
 */

-- 지출내역구분
INSERT INTO 지출내역구분_T VALUES(5, '식비');
INSERT INTO 지출내역구분_T VALUES(6, '편의점');
INSERT INTO 지출내역구분_T VALUES(7, '의류');
INSERT INTO 지출내역구분_T VALUES(8, '월세');

-- 지출내역서
INSERT INTO 지출내역서_T VALUES('20220318', 0, 43345, '카페', 7, 5);
INSERT INTO 지출내역서_T VALUES('20220322', 0, 4500, '편의점', 8, 6);
INSERT INTO 지출내역서_T VALUES('20220329', 0, 18200, '카페', 9, 5);

INSERT INTO 지출내역서_T VALUES('20220410', 0, 18000, '카페', 10, 5);
INSERT INTO 지출내역서_T VALUES('20220412', 0, 6700, '식당', 11, 5);
INSERT INTO 지출내역서_T VALUES('20220412', 0, 3600, '편의점', 12, 6);
INSERT INTO 지출내역서_T VALUES('20220423', 0, 12100, '시외버스', 13, 3);
INSERT INTO 지출내역서_T VALUES('20220424', 0, 300000, '월세', 14, 8);


-- 수정
UPDATE 지출내역서_T
	SET ACCOUNT_ID = 4
	WHERE 날짜 = '20220310';

UPDATE 지출내역서_T
	SET ACCOUNT_ID = 5
	WHERE 날짜 = '20220310';

UPDATE 지출내역서_T
	SET ACCOUNT_ID = 6
	WHERE 날짜 = '20220311';

-- 삭제
DELETE FROM 지출내역서_T WHERE ACCOUNT_ID = 7;

-- 확인
SELECT * FROM 지출내역서_T;
SELECT * FROM 지출내역구분_T ORDER BY 구분ID;
COMMIT;



/*
 * 위의 작업을 완료한 후에는 다음의 작업을 진행 한다.
 * 		- 지출내역을 토대로 매달 결산을 위한 테이블을 생성한다. (지출결산_T)
 * 		- 지출결산_T 에는 년, 월, 입금액, 출금액, 비고 컬럼을 사용하도록 한다.
 */

CREATE TABLE 지출결산_T
	AS SELECT EXTRACT(YEAR FROM 날짜) AS 년, EXTRACT(MONTH FROM 날짜) AS 월, 입금액, 출금액, 비고
	FROM 지출내역서_T
	WHERE 1 = 0;

INSERT ALL INTO 지출결산_T VALUES(년, 월, 입금액, 출금액, 비고)
SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(입금액) AS 입금액
	 , SUM(출금액) AS 출금액
	 , CASE WHEN SUM(입금액) < SUM(출금액) THEN '너무 많은 소비를 했습니다.'
	 		WHEN SUM(입금액) > SUM(출금액) THEN '절약을 했습니다.'
	 		ELSE '칼같이 사용하셨군요.'
	 	END AS 비고
	FROM 지출내역서_T
	GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜)
	ORDER BY 년, 월;
	
SELECT * FROM 지출결산_T;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = '지출결산_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '지출결산_T';



/*
 * 2022년 부터 월세가 10% 인상 된 것을 깜빡하고 반영을 하지 않았다.
 * 이를 UPDATE 문을 사용하여 10% 인상된 월세로 수정하고 결산 테이블에도 수정하도록 한다.
 */

UPDATE 지출내역서_T
	SET 출금액 = 출금액 * 1.1
	WHERE ACCOUNT_ID = 14;

UPDATE 지출결산_T
	SET (입금액, 출금액) = (SELECT SUM(입금액) AS 입금액, SUM(출금액) AS 출금액
						FROM 지출내역서_T
						WHERE EXTRACT(YEAR FROM 날짜) = 2022
						AND EXTRACT(MONTH FROM 날짜) = 4
						GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜)
					   )
	WHERE 년 = 2022
	AND 월 = 4;

SELECT * FROM 지출결산_T;

COMMIT;