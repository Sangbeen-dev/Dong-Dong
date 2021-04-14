--관심목록 테이블
CREATE TABLE favorite(
    pNum NUMBER(6) NOT NULL,
    userid VARCHAR2(10) NOT NULL,--좋아요 한 사람의 유저아이디
    pCategory VARCHAR2(20) NOT NULL,
    pTitle VARCHAR2(100) NOT NULL,
    pContent VARCHAR2(800) NOT NULL,
    pPrice NUMBER(6) NOT NULL,
    pImage VARCHAR2(20) NOT NULL,
    pHit NUMBER(5) NOT NULL
);