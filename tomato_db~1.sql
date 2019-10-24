
------------------------------------»óÇ° Å×ÀÌºí-----------------------------
»óÇ°¹øÈ£
È¸¿ø¹øÈ£
»óÇ°ÀÌ¸§
»óÇ°¸ÞÀÎÄ«Å×°í¸®
»óÇ°¼­ºêÄ«Å×°í¸®
»óÇ°°¡°Ý
»óÇ°µî·ÏÀÏÀÚ
»óÇ°»óÅÂ
Á¶È¸¼ö
Âò¼ö  -> Ãß°¡»çÇ×
»óÇ°¼³¸í
»óÇ°¼ö·®
¹è¼Ûºñ¿©ºÎ
°Å·¡Áö¿ª
½æ³×ÀÏÆÄÀÏÀÌ¸§
½æ³×ÀÏÆÄÀÏ°æ·Î
»óÇ°°Å·¡»óÅÂ
=======
------------------------------------ï¿½ï¿½Ç° ï¿½ï¿½ï¿½Ìºï¿½-----------------------------
ï¿½ï¿½Ç°ï¿½ï¿½È£
È¸ï¿½ï¿½ï¿½ï¿½È£
ï¿½ï¿½Ç°ï¿½Ì¸ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½Ä«ï¿½×°ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½Ä«ï¿½×°ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿?
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½È¸ï¿½ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½Ûºñ¿©ºï¿?
ï¿½Å·ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿?
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ï°ï¿½ï¿½
ï¿½ï¿½Ç°ï¿½Å·ï¿½ï¿½ï¿½ï¿½ï¿½
>>>>>>> master




CREATE TABLE ITEM(
    ITEM_NO             NUMBER          PRIMARY KEY,
    MEMBER_NO           NUMBER,
    ITEM_NAME           VARCHAR2(100)   NOT NULL,
    ITEM_MAIN_CATEGORY  VARCHAR2(100)   NOT NULL,
    ITEM_SUB_CATEGORY   VARCHAR2(100),
    ITEM_PRICE          NUMBER          NOT NULL,
    ITEM_ENROLL_DATE    DATE            DEFAULT SYSDATE,
    ITEM_STATE          VARCHAR2(30)    NOT NULL,
    READCOUNT           NUMBER          DEFAULT 0,
     FAVORITE_COUNT       NUMBER         DEFAULT 0,
    ITEM_CONTENT        VARCHAR2(1000),
    ITEM_AMOUNT         NUMBER          NOT NULL,
    ITEM_DELIVERY_NY    NUMBER          NOT NULL,
    ITEM_DEAL_REGION    VARCHAR2(50)    NOT NULL,
    ITEM_THUM_FILENAME  VARCHAR2(100),
    ITEM_THUM_FILEPATH  VARCHAR2(100),
    ITEM_DEAL_STATE     VARCHAR2(30)    NOT NULL,
    CONSTRAINT FK_ITEM_MEMBER_NO FOREIGN KEY (MEMBER_NO)REFERENCES 
    MEMBER(MEMBER_NO) ON DELETE SET NULL
);

INSERT INTO ITEM VALUES (1,1,'A','A','A',1,DEFAULT,'A',1,DEFAULT,'A',1,1,'A',NULL,NULL,'A');

CREATE SEQUENCE ITEM_NO_SEQ;
DROP SEQUENCE ITEM_NO_SEQ;



DROP TABLE ITEM;
commit;
SELECT * FROM ITEM ;


---------------------------------------1:1ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½-----------------------
ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È£
ï¿½Û¼ï¿½ï¿½ï¿½ È¸ï¿½ï¿½ï¿½ï¿½È£
ï¿½Û¼ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½Ç³ï¿½ï¿½ï¿½
ï¿½Û¼ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿½
ï¿½ï¿½ï¿½Ï°ï¿½ï¿?
ï¿½ï¿½Ð·ï¿?
ï¿½ÒºÐ·ï¿½
ï¿½äº¯ï¿½ï¿½ï¿½ï¿½ 
ï¿½äº¯ï¿½ï¿½ï¿½ï¿½
ï¿½äº¯ ï¿½Û¼ï¿½ï¿½ï¿½

create table MTOM_INQUIRY(
MTOM_INQUIRY_NO NUMBER PRIMARY KEY,
MEMBER_NO NUMBER,
MTOM_INQUIRY_WRITER VARCHAR2(40) NOT NULL,
MTOM_INQUIRY_CONTENT VARCHAR2(1000) NOT NULL,
MTOM_INQUIRY_DATE DATE DEFAULT SYSDATE,
FILE_NAME VARCHAR2(100),
FILE_PATH VARCHAR2(100),
MTOM_INQUIRY_MAIN_CATEGORY VARCHAR2(40) NOT NULL,
MTOM_INQUIRY_SUB_CATEGORY VARCHAR2(40) NOT NULL,
MTOM_INQUIRY_ANSWER_STATE NUMBER NOT NULL,
MTOM_INQUIRY_ANSWER_CONTENT VARCHAR2(1000),
MTOM_INQUIRY_ANSWER_DATE DATE DEFAULT SYSDATE,
CONSTRAINT FK_MTOM_INQUIRY_MEMBER_NO FOREIGN KEY (MEMBER_NO) REFERENCES 
MEMBER(MEMBER_NO) ON DELETE CASCADE
);
CREATE SEQUENCE MTOM_INQUIRY_NO_SEQ;

DROP TABLE MTOM_INQUIRY;
SELECT * FROM MTOM_INQUIRY;
COMMIT;


------------------------------- ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½------------------------------
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È£
ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½
ï¿½Û¼ï¿½ï¿½ï¿½
ï¿½Û¼ï¿½ï¿½ï¿½ 
ï¿½ï¿½È¸ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿½
ï¿½ï¿½ï¿½Ï°ï¿½ï¿?

CREATE TABLE NOTICE(
NOTICE_NO NUMBER PRIMARY KEY,
NOTICE_TITLE VARCHAR2(40) NOT NULL,
NOTICE_CONTENT VARCHAR2(1000) NOT NULL,
NOTICE_WRITER VARCHAR(40) NOT NULL,
NOTICE_DATE DATE DEFAULT SYSDATE,
READCOUNT NUMBER,
FILE_NAME VARCHAR2(100),
FILE_PATH VARCHAR2(100),
CONSTRAINT FK_NOTICE_WRITER FOREIGN KEY (NOTICE_WRITER)REFERENCES 
MEMBER(SHOP_NAME) ON DELETE SET NULL
);

CREATE SEQUENCE NOTICE_NO_SEQ;

DROP TABLE NOTICE;
SELECT * FROM NOTICE;
COMMIT;

-------------------------------È¸ï¿½ï¿½ï¿½ï¿½ï¿½Ìºï¿½  = ï¿½ï¿½ï¿½ï¿½----------------------

È¸ï¿½ï¿½ï¿½ï¿½È£
ï¿½Ì¸ï¿½ï¿½ï¿½
ï¿½ï¿½Ð¹ï¿½È?
ï¿½Ì¸ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½Ã³
ï¿½ï¿½ï¿½Ö¼ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½È?
ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿½
ï¿½ï¿½ï¿½ï¿½ ï¿½Ò°ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ ï¿½æ¹®ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿½
ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿?


CREATE TABLE MEMBER(
MEMBER_NO NUMBER PRIMARY KEY,
EMAIL VARCHAR2(100) NOT NULL UNIQUE,
MEMBER_PW VARCHAR2(40) NOT NULL,
MEMBER_NAME VARCHAR2(40) NOT NULL,
ENROLL_DATE DATE DEFAULT SYSDATE,
PHONE VARCHAR2(40) NOT NULL,
ADDRESS VARCHAR2(100) NOT NULL,
ZIP_CODE VARCHAR2(50) NOT NULL,
MEMBER_BANK VARCHAR2(50),
MEMBER_ACCOUNT VARCHAR2(50),
SHOP_NAME VARCHAR2(40) UNIQUE,
SHOP_CONTENT VARCHAR2(500),
SHOP_READCOUNT NUMBER DEFAULT 0,
FILE_NAME VARCHAR2(100),
FILE_PATH VARCHAR2(100)
);
INSERT INTO MEMBER VALUES(1,'b','A','A',DEFAULT,'A','A','A','A','A','b','A',DEFAULT,NULL,NULL);

CREATE SEQUENCE MEMBER_NO_SEQ;

DROP TABLE MEMBER;
SELECT * FROM MEMBER;
COMMIT;
------------------------------ ï¿½Ë¸ï¿½ ï¿½ï¿½ï¿½Ìºï¿½ -----------------------------
ï¿½Ë¸ï¿½ï¿½ï¿½È£ 
ï¿½Ç¸ï¿½ï¿½ï¿½ È¸ï¿½ï¿½ï¿½ï¿½È£
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿½
ï¿½Ë¸ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½
ï¿½ï¿½Û³ï¿½ï¿½ï¿?
ï¿½Ä±â³»ï¿½ï¿½ 
ï¿½Ë¸ï¿½ ï¿½ï¿½ï¿? ï¿½Ã°ï¿½

CREATE TABLE ALARM(
ALARM_NO NUMBER PRIMARY KEY,
ALARM_SELLER_NO NUMBER,
ALARM_BUYER_SHOP_NAME VARCHAR2(40),
ALARM_TYPE VARCHAR2(100) NOT NULL,
ALARM_ITEM_NAME VARCHAR2(100),
ALARM_ITEM_INQUIRY_COMMENT VARCHAR2(1000),
ALARM_MEMBER_REVIEW_COMMENT VARCHAR2(500),
ALARM_DATE DATE DEFAULT SYSDATE,
CONSTRAINT FK_ARARM_SELLER_NO FOREIGN KEY (ALARM_SELLER_NO)REFERENCES 
MEMBER(MEMBER_NO) ON DELETE SET NULL,
CONSTRAINT FK_ARARM_BUYER_SHOP_NAME FOREIGN KEY (ALARM_BUYER_SHOP_NAME)REFERENCES 
MEMBER(SHOP_NAME) ON DELETE SET NULL
);

CREATE SEQUENCE ALARM_NO_SEQ;
DROP TABLE ALARM;
SELECT * FROM ALARM;
COMMIT;

<<<<<<< HEAD
------------------------------- Âò Å×ÀÌºí -------------------------------
Âò 

»óÁ¡¹øÈ£(»óÇ°À» ÂòÇÑ »óÁ¡)
»óÇ°¹øÈ£
=======
------------------------------- ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½ -------------------------------
ï¿½ï¿½ 
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È£(ï¿½ï¿½Ç°ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½)
ï¿½ï¿½Ç°ï¿½ï¿½È£
>>>>>>> master

CREATE TABLE FAVORITE(
SHOP_NO NUMBER NOT NULL,
ITEM_NO NUMBER NOT NULL,
CONSTRAINT FK_SHOP_NO FOREIGN KEY (SHOP_NO)REFERENCES 
MEMBER(MEMBER_NO) ON DELETE CASCADE,
CONSTRAINT FK_ITEM_NO FOREIGN KEY (ITEM_NO)REFERENCES
ITEM(ITEM_NO) ON DELETE CASCADE
);

DROP TABLE FAVORITE;
SELECT * FROM FAVORITE;
COMMIT;

-------------------------------ï¿½Ë»ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½ ------------------------------
ï¿½Ë»ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½Ë»ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½Ë»ï¿½ È¸ï¿½ï¿½

CREATE TABLE SEARCH(
SEARCH_CONTENT VARCHAR2(100) PRIMARY KEY,
SEARCH_DATE DATE DEFAULT SYSDATE,
SEARCH_COUNT NUMBER
);

DROP TABLE SEARCH;
SELECT * FROM SEARCH;
COMMIT;
------------------------------ï¿½ï¿½È£ï¿½Ï´ï¿½ ï¿½ï¿½ï¿½ï¿½(3ï¿½ï¿½ï¿½ï¿½) ï¿½ï¿½ï¿½Ìºï¿½-------------------
È¸ï¿½ï¿½ï¿½ï¿½È£
ï¿½Ö¼Ò¼ï¿½ï¿½ï¿½

CREATE TABLE MEMBER_ADDRESS(
EMAIL VARCHAR2(100),
ADDR_CHOICE VARCHAR2(100),
CONSTRAINT FK_MEMBER_ADDRS_EMAIL FOREIGN KEY (EMAIL)REFERENCES 
MEMBER(EMAIL) ON DELETE CASCADE
);

DROP TABLE MEMBER_ADDRESS;
SELECT * FROM MEMBER_ADDRESS;
COMMIT;
-----------------------------ï¿½ï¿½ï¿½ï¿½ ï¿½Ä±ï¿½ ï¿½ï¿½ï¿½Ìºï¿½ ---------------------------------

ï¿½Ä±ï¿½ï¿½È?
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È£
ï¿½Û¼ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Ì¸ï¿½
ï¿½Ä±ï¿½ ï¿½Û¼ï¿½ï¿½ï¿½
ï¿½Ä±â³»ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½

CREATE TABLE REVIEW(
REVIEW_NO NUMBER PRIMARY KEY,
SHOP_NO NUMBER,
REVIEW_WRITER VARCHAR2(40),
REVIEW_DATE DATE DEFAULT SYSDATE,
REVIEW_CONTENT VARCHAR2(500) NOT NULL,
REVIEW_SCORE NUMBER,
CONSTRAINT FK_REVIEW_SHOP_NO FOREIGN KEY (SHOP_NO)REFERENCES 
MEMBER(MEMBER_NO) ON DELETE CASCADE,
CONSTRAINT FK_REVIEW_WRITER FOREIGN KEY (REVIEW_WRITER)REFERENCES 
MEMBER(SHOP_NAME) ON DELETE SET NULL
);

CREATE SEQUENCE REVIEW_NO_SEQ;

DROP TABLE REVIEW;
SELECT * FROM REVIEW;
COMMIT;
-------------------------------  ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½---------------------------------
ï¿½ï¿½Ç°ï¿½ï¿½È£
È¸ï¿½ï¿½ï¿½ï¿½È£
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ID
ï¿½ï¿½ï¿½ï¿½ï¿½Ý¾ï¿½ 
ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
Ä«ï¿½ï¿½ ï¿½ï¿½ï¿½Î¹ï¿½È£
ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿½ï¿½ ï¿½Å·ï¿½ID
È¯ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

CREATE TABLE PAYMENT(
MERCHANT_UID VARCHAR2(40) PRIMARY KEY,
ITEM_NO NUMBER,
MEMBER_NO NUMBER,
IMP_UID VARCHAR2(40) ,
PAYMENT_PAY NUMBER NOT NULL,
PAYMENT_STATE VARCHAR2(40) NOT NULL,
PAYMENT_DATE DATE DEFAULT SYSDATE,
PAYMENT_APPLY_NUM VARCHAR2(40) NOT NULL,
PAYMENT_COMMISSION NUMBER,
PAYMENT_NY VARCHAR2(40) NOT NULL DEFAULT 'N',
CONSTRAINT FK_PAYMENT_ITEM_NO FOREIGN KEY (ITEM_NO)REFERENCES 
ITEM(ITEM_NO) ON DELETE SET NULL,
CONSTRAINT FK_PAYMENT_MEMBER_NO FOREIGN KEY (MEMBER_NO)REFERENCES 
MEMBER(MEMBER_NO) ON DELETE SET NULL
);

DROP TABLE PAYMENT;
SELECT * FROM PAYMENT;
COMMIT;

-------------------------- ï¿½Å·ï¿½ ï¿½ï¿½ï¿½Ìºï¿½ ----------------------------------------
ï¿½Å·ï¿½ ï¿½ï¿½È£ 
ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
ï¿½Ç¸ï¿½ï¿½ï¿½
ï¿½ï¿½Ç°ï¿½ï¿½È£
ï¿½Å·ï¿½ï¿½ï¿½ï¿½ï¿½

CREATE TABLE DEAL(
DEAL_NO NUMBER PRIMARY KEY,
BUYER NUMBER ,
SALER NUMBER ,
ITEM_NO NUMBER ,
DEAL_STATE VARCHAR2(20),
DEAL_END_DATE DATE,
CONSTRAINT FK_BUYER FOREIGN KEY (BUYER)REFERENCES 
MEMBER(MEMBER_NO) ON DELETE SET NULL,
CONSTRAINT FK_SALER FOREIGN KEY (SALER)REFERENCES 
MEMBER(MEMBER_NO) ON DELETE SET NULL,
CONSTRAINT FK_DEAL_ITEM_NO FOREIGN KEY (DEAL_NO)REFERENCES 
ITEM(ITEM_NO) ON DELETE SET NULL,
CONSTRAINT FK_DEAL_STATE FOREIGN KEY (DEAL_STATE)REFERENCES 
ITEM(ITEM_STATE) ON DELETE SET NULL
);

CREATE SEQUENCE DEAL_NO_SEQ;
DROP TABLE DEAL;
SELECT * FROM DEAL;
COMMIT;

------------------------------ ï¿½ï¿½Ç° ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½ --------------------------
ï¿½ï¿½ï¿? ï¿½ï¿½È£
ï¿½Û¼ï¿½ï¿½ï¿½ ï¿½Ð³ï¿½ï¿½ï¿½
ï¿½ï¿½Û´Þ¸ï¿? ï¿½ï¿½Ç°ï¿½ï¿½È£
ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿? ï¿½Û¼ï¿½ï¿½ï¿½
ï¿½ï¿½ï¿? ï¿½Ü°ï¿½
ï¿½ï¿½Û´Þ¸ï¿? ï¿½ï¿½Û¹ï¿½È?

CREATE TABLE ITEM_INQUIRY(
ITEM_INQUIRY_NO NUMBER PRIMARY KEY,
ITEM_INQUIRY_WRITER VARCHAR2(40),
ITEM_REF NUMBER,
ITEM_INQUIRY_COMMENT VARCHAR2(1000) NOT NULL,
ITEM_INQUIRY_DATE DATE DEFAULT SYSDATE,
ITEM_INQUIRY_LEVEL NUMBER NOT NULL,
ITEM_INQUIRY_REF NUMBER ,
CONSTRAINT FK_ITEM_INQUIRY_NO FOREIGN KEY (ITEM_INQUIRY_NO)REFERENCES 
ITEM(ITEM_NO) ON DELETE SET NULL,
CONSTRAINT FK_ITEM_INQUIRY_REF FOREIGN KEY (ITEM_INQUIRY_REF)REFERENCES 
ITEM_INQUIRY(ITEM_INQUIRY_NO) ON DELETE SET NULL
);

CREATE SEQUENCE ITEM_INQUIRY_NO_SEQ;

DROP TABLE ITEM_INQUIRY;
SELECT * FROM ITEM_INQUIRY;
COMMIT;


------------------------------ï¿½ï¿½Ç° ï¿½Ì¹ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ìºï¿½-------------------------
ï¿½ï¿½Ç° ï¿½ï¿½È£
ï¿½ï¿½ï¿½ï¿½ï¿½Ì¸ï¿½
ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿?
ï¿½ï¿½ï¿½ï¿½ï¿? ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½

CREATE TABLE ITEM_IMAGE(
ITEM_NO NUMBER NOT NULL,
FILE_NAME VARCHAR2(100) NOT NULL,
FILE_PATH VARCHAR2(100) NOT NULL,
THUM_NY NUMBER NOT NULL,
CONSTRAINT FK_ITEM_IMAGE_ITEM_NO FOREIGN KEY (ITEM_NO)REFERENCES 
ITEM(ITEM_NO) ON DELETE SET NULL
);

DROP TABLE ITEM_IMAGE;
SELECT * FROM ITEM_IMAGE;
COMMIT;










