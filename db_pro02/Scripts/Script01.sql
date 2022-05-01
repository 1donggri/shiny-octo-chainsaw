/*
 * DDL
 * 		- Data Definition Laguage : 데이터 정의어
 * 		- 객체를 정의하기 위한 CREAT(생성), ALTER(수정), DROP(삭제) 구문이 있다.
 * 		- 오라클 객체는 TABLE, VIEW, SEQUENCE, FUNCTION, PROCEDUAL, USER, ... 등이 있다.
 */

/*
 * CREATE 테이블명 (
 *	   컬럼명 자료형(크기) [제약조건]
 *	 , ...
 * );
 */

/*
 * CHAR		 	 : 고정 길이 문자열
 * VARCHAR		 : 가변 길이 문자열, 최대 길이만 정하고 실제 저장되는 데이터의 크기에 맞추어 공간을 할당한다.
 * 			   	   최대 2000 바이트 문자
 * VARCHAR2	 	 : 최대 4000 바이트 문자
 * NUMBER		 : 숫자 타입
 * NUMBER(n)	 : 숫자 타입, 정수 자릿수 크기 지정
 * NUMBER(n, m)  : 숫자 타입, 정수, 소수점 자릿수 크기 지정
 * DATE		 	 : 날짜
 * TIMESTAMP	 : 타임스탬프, 날짜
 * LOB			 : LARGE OBJECT Byte Date (4000 바이트 이상)
 *			   	   BFILE, BLOB, CLOB
 */

/*
 * 제약조건(CONSTRAINT)
 * 	테이블에 데이터를 저장할 때 저장되는 데이터를 제한하기 위해 사용하는 조건
 * 	이는 데이터의 무결성 보장을 목적으로 한다.
 * 	입력되는 데이터의 오류 확인도 할 수 있다.
 * 	
 * 	NOT NULL : NULL 데이터를 허용하지 않음
 * 	UNIQUE : 중복값을 허용하지 않음
 *	PRIMARY KEY : NOT NULL + UNIQUE 결합된 제약조건
 * 				  유일한 고유값을 사용하기 위해 쓰인다.
 * 				  PK라고 한다.
 * 				  데이터 식별자로 사용하기 위해.
 *	FOREIGN KEY : 외래키(FK), 참조키(값) 라고 한다.
 * 				  다른 테이블의 값을 참조하기 위한 용도로 사용
 * 				  참조값이 있는 경우에만 저장할 수 있게 제약
 * 				  참조 되는 데이터가 있는 경우 수정, 삭제를 임의로 하지 못하게 제약
 * 
 * 		ON DELETE RESTRICTED 옵션
 * 		ON DELETE SET NULL 옵션 참조하는 값은 NULL 로 설정
 * 		ON DELETE CASCASE 옵션 참조하는 값을 연달아 삭제
 * 
 * 	CHECK : 미리 설정한 값만 저장할 수 있도록 검사를 하여 제약
 * 
 * 
 * 	컬럼 레벨
 * 		컬럼에 직접 명시하여 작성
 * 
 * 	테이블 레벨
 * 		컬럼 외로 명시하여 작성
 * 		복합 키 설정이 필요한 경우 사용
 */

CREATE TABLE sample_t (
	   u_id		 NUMBER			   -- PRIMARY KEY	-- NOT NULL + 중복x
	,  jumin	 CHAR(13)		   -- UNIQUE	-- 중복x
	,  name 	 VARCHAR2(50 CHAR) NOT NULL
	,  age  	 NUMBER(3)		   DEFAULT(0)
	,  gender    CHAR(1)		   CHECK(GENDER IN ('M', 'F'))	-- M, F 만 저장 가능
	,  birth_day DATE			   DEFAULT(SYSDATE)
	,  ref_col	 NUMBER			   -- REFERENCES ref_t(r_id)
	,  CONSTRAINT PK_U_ID PRIMARY KEY(u_id)
	,  CONSTRAINT UK_JUMIN UNIQUE(jumin)
	,  CONSTRAINT FK_REF_T_R_ID FOREIGN KEY(ref_col) REFERENCES ref_t(r_id)
);

CREATE TABLE ref_t (
	   r_id NUMBER			PRIMARY KEY
	 , note VARCHAR2(100)
);

-- 테이블 삭제
DROP TABLE sample_t;
DROP TABLE ref_t;

COMMENT ON COLUMN sample_t.name IS '이름';
COMMENT ON COLUMN sample_t.age IS '나이';
COMMENT ON COLUMN sample_t.gender IS '성별(M:남자, F:여자)';
COMMENT ON COLUMN sample_t.birth_day IS '생년월일';

-- 테이블 정보 확인하기
-- DESC SAMPLE_T;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'SAMPLE_T';

SELECT * FROM sample_t;


CREATE TABLE ALT_T (
	   u_id NUMBER
	 , name VARCHAR(10)
	 , g_type CHAR(1)
	 , now_date DATE
	 , remark VARCHAR(100)
);

CREATE TABLE MY_TEST_REF(
	   ref_id NUMBER PRIMARY KEY
	 , ref_text VARCHAR(100)
);

-- 테이블 삭제
-- DROP TABLE ALT_T;
-- DROP TABLE MY_TEST;
-- DROP TABLE MY_TEST_REF;

-- 테이블명 변경 : 비추천!
ALTER TABLE ALT_T RENAME TO MY_TEST;	
-- 확인 구문
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'MY_TEST';

-- 컬럼명 변경 : 비추천!
ALTER TABLE MY_TEST RENAME COLUMN now_date TO birth_date;
-- 확인 구문
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'MY_TEST';

-- 컬럼 추가 : 가급적 디폴트값을 써야 한다. 
ALTER TABLE MY_TEST ADD age NUMBER(3) DEFAULT(0) NOT NULL;
ALTER TABLE MY_TEST ADD ref_col NUMBER;
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';

-- 바이트 크기 수정
-- 줄일 때에는 기존에 저장된 데이터의 가장 길이가 긴 데이터가 무엇인지 고려하여 수정 
ALTER TABLE MY_TEST MODIFY name VARCHAR(50);

-- 형변환 : 비추천! 테이블을 새로 만드는 것이 좋음.
ALTER TABLE MY_TEST MODIFY name NUMBER;

-- 컬럼 삭제 : 비추천!
ALTER TABLE MY_TEST DROP COLUMN remark;
-- 확인 구문
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'MY_TEST';

-- 테이블 정보를 수정할 때 기존 데이터 유무와 다른 테이블과의 관계에 대한 사항을 고려하여 작성해야 한다.


-- 제약 조건 추가 1 : 컬럼 레벨로 컬럼 수정하면서 추가
ALTER TABLE MY_TEST MODIFY name UNIQUE;
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';

-- 제약 조건 추가 2 : 테이블 레벨로 추가
ALTER TABLE MY_TEST ADD UNIQUE(name);
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';


-- 외래키 추가 1 : 컬럼 레벨로 컬럼 수정하면서 추가
ALTER TABLE MY_TEST MODIFY ref_col REFERENCES MY_TEST_REF(ref_id);
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';

-- 외래키 추가 2 : 테이블 레벨로 추가
ALTER TABLE MY_TEST ADD FOREIGN KEY(ref_col) REFERENCES MY_TEST_REF(ref_id);
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';

-- 제약 조건 삭제
ALTER TABLE MY_TEST
		DROP CONSTRAINT NM_MY_TEST_G_TYPE
		DROP CONSTRAINT CK_MY_TEST_AGE;
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';


-- 제약조건 추가 예시 (CONSTRAINT_NAME)
ALTER TABLE MY_TEST MODIFY g_type CONSTRAINT NN_MY_TEST_G_TYPE NOT NULL;
ALTER TABLE MY_TEST MODIFY age CONSTRAINT CK_MY_TEST_AGE CHECK(AGE BETWEEN 0 AND 150);
-- 확인 구문
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MY_TEST';


-- 관계 테이블 컬럼 삭제 : 비추천!
-- 컬럼 삭제 시 참조하고 있는 컬럼이 있다면 컬럼 삭제 불가능 -> CASCADE CONSTRAINT 추가
ALTER TABLE MY_TEST_REF DROP COLUMN ref_id CASCADE CONSTRAINT;

-- 관계 테이블 삭제 : 비추천!
-- 테이블 삭제 시 참조하고 있는 컬럼이 있다면 테이블 삭제 불가능 -> CASCADE CONSTRAINT 추가
DROP TABLE MY_TEST_REF CASCADE CONSTRAINT;



