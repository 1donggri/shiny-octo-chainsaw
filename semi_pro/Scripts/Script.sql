-- 계정 생성
CREATE USER semi1 IDENTIFIED BY semi1;

-- 생성한 계정에 권한 부여
GRANT RESOURCE, CONNECT TO semi1;
GRANT INSERT ANY TABLE, UPDATE ANY TABLE
	, DELETE ANY TABLE, CREATE VIEW
	TO semi1;
	

-- 테이블 생성
CREATE TABLE account_t (
	   res_id		NUMBER
	 , res_name		VARCHAR2(20)
	 , res_type		VARCHAR2(20)
	 , location		VARCHAR2(20)
	 , res_likes	VARCHAR2(20)
);

CREATE TABLE restaurant_t (
	   userid		VARCHAR2(20)
	 , userpw		VARCHAR2(20)
	 , username		VARCHAR2(20)
	 , createDate	DATE
);

COMMIT;

-- 확인
SELECT * FROM account_t;
SELECT * FROM restaurant_t;