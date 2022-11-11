DROP SEQUENCE SQ_DEPT;
CREATE SEQUENCE SQ_DEPT START WITH 50 INCREMENT BY  10;

DROP SEQUENCE SQ_EMP;
CREATE SEQUENCE SQ_EMP START WITH 8000 INCREMENT BY  1;

DROP SEQUENCE SQ_FAQ;
CREATE SEQUENCE SQ_FAQ START WITH 1 INCREMENT BY  1;

DROP TABLE TB_EMP CASCADE CONSTRAINT;
DROP TABLE TB_DEPT CASCADE CONSTRAINT;
DROP TABLE TB_FAQ CASCADE CONSTRAINT;

CREATE TABLE TB_DEPT (
     DNO NUMBER NOT NULL PRIMARY KEY,
     DNAME VARCHAR2(255),
     LOC VARCHAR2(255),
     INSERT_TIME VARCHAR2(255),
     UPDATE_TIME VARCHAR2(255)
);

CREATE TABLE TB_EMP
(ENO NUMBER NOT NULL PRIMARY KEY,
 ENAME VARCHAR2(255),
 JOB   VARCHAR2(255),
 MANAGER  NUMBER,
 HIREDATE VARCHAR2(255),
 SALARY NUMBER,
 COMMISSION NUMBER,
 DNO NUMBER,
 INSERT_TIME VARCHAR2(255),
 UPDATE_TIME VARCHAR2(255)
);

CREATE TABLE TB_FAQ (
    NO NUMBER NOT NULL PRIMARY KEY,
    TITLE VARCHAR2(255),
    CONTENT VARCHAR2(255),
    INSERT_TIME VARCHAR2(255),
    UPDATE_TIME VARCHAR2(255)
);

INSERT INTO TB_DEPT VALUES (10,'ACCOUNTING','NEW YORK',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_DEPT VALUES (20,'RESEARCH','DALLAS',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_DEPT VALUES (30,'SALES','CHICAGO',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_DEPT VALUES (40,'OPERATIONS','BOSTON',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);

INSERT INTO TB_EMP VALUES (7369,'SMITH','CLERK',    7902,TO_CHAR(to_date('17-12-1980','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),800, NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7499,'ALLEN','SALESMAN', 7698,TO_CHAR(to_date('20-2-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1600, 300,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7521,'WARD','SALESMAN',  7698,TO_CHAR(to_date('22-2-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1250, 500,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7566,'JONES','MANAGER',  7839,TO_CHAR(to_date('2-4-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),2975,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7654,'MARTIN','SALESMAN',7698,TO_CHAR(to_date('28-9-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1250,1400,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7698,'BLAKE','MANAGER',  7839,TO_CHAR(to_date('1-5-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),2850,NULL,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7782,'CLARK','MANAGER',  7839,TO_CHAR(to_date('9-6-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),2450,NULL,10, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7788,'SCOTT','ANALYST',  7566,TO_CHAR(to_date('13-07-1987','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),3000,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7839,'KING','PRESIDENT', NULL,TO_CHAR(to_date('17-11-1981','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),5000,NULL,10, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7844,'TURNER','SALESMAN',7698,TO_CHAR(to_date('8-9-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1500,   0,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7876,'ADAMS','CLERK',    7788,TO_CHAR(to_date('13-07-1987','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1100,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7900,'JAMES','CLERK',    7698,TO_CHAR(to_date('3-12-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),950, NULL,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7902,'FORD','ANALYST',   7566,TO_CHAR(to_date('3-12-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),3000,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMP VALUES (7934,'MILLER','CLERK',   7782,TO_CHAR(to_date('23-1-1982', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1300,NULL,10, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);


INSERT INTO TB_FAQ VALUES (1,'제목','해결방법',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_FAQ VALUES (2,'제목2','해결방법2',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_FAQ VALUES (3,'제목3','해결방법3',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_FAQ VALUES (4,'제목4','해결방법4',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);

-- EMPLOYEE / DEPARTMENT
DROP SEQUENCE SQ_EMPLOYEE;
CREATE SEQUENCE SQ_EMPLOYEE START WITH 8000 INCREMENT BY  1;

DROP SEQUENCE SQ_DEPARTMENT;
CREATE SEQUENCE SQ_DEPARTMENT START WITH 1 INCREMENT BY  1;

DROP TABLE TB_EMPLOYEE CASCADE CONSTRAINT;
DROP TABLE TB_DEPARTMENT CASCADE CONSTRAINT;

CREATE TABLE TB_DEPARTMENT (
                         DNO NUMBER NOT NULL PRIMARY KEY,
                         DNAME VARCHAR2(255),
                         LOC VARCHAR2(255),
                         INSERT_TIME VARCHAR2(255),
                         UPDATE_TIME VARCHAR2(255)
);

CREATE TABLE TB_EMPLOYEE
(ENO NUMBER NOT NULL PRIMARY KEY,
 ENAME VARCHAR2(255),
 JOB   VARCHAR2(255),
 MANAGER  NUMBER,
 HIREDATE VARCHAR2(255),
 SALARY NUMBER,
 COMMISSION NUMBER,
 DNO NUMBER,
 INSERT_TIME VARCHAR2(255),
 UPDATE_TIME VARCHAR2(255)
);


INSERT INTO TB_DEPARTMENT VALUES (10,'ACCOUNTING','NEW YORK',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_DEPARTMENT VALUES (20,'RESEARCH','DALLAS',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_DEPARTMENT VALUES (30,'SALES','CHICAGO',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_DEPARTMENT VALUES (40,'OPERATIONS','BOSTON',  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);

INSERT INTO TB_EMPLOYEE VALUES (7369,'SMITH','CLERK',    7902,TO_CHAR(to_date('17-12-1980','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),800, NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7499,'ALLEN','SALESMAN', 7698,TO_CHAR(to_date('20-2-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1600, 300,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7521,'WARD','SALESMAN',  7698,TO_CHAR(to_date('22-2-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1250, 500,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7566,'JONES','MANAGER',  7839,TO_CHAR(to_date('2-4-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),2975,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7654,'MARTIN','SALESMAN',7698,TO_CHAR(to_date('28-9-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1250,1400,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7698,'BLAKE','MANAGER',  7839,TO_CHAR(to_date('1-5-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),2850,NULL,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7782,'CLARK','MANAGER',  7839,TO_CHAR(to_date('9-6-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),2450,NULL,10, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7788,'SCOTT','ANALYST',  7566,TO_CHAR(to_date('13-07-1987','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),3000,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7839,'KING','PRESIDENT', NULL,TO_CHAR(to_date('17-11-1981','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),5000,NULL,10, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7844,'TURNER','SALESMAN',7698,TO_CHAR(to_date('8-9-1981',  'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1500,   0,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7876,'ADAMS','CLERK',    7788,TO_CHAR(to_date('13-07-1987','dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1100,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7900,'JAMES','CLERK',    7698,TO_CHAR(to_date('3-12-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),950, NULL,30, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7902,'FORD','ANALYST',   7566,TO_CHAR(to_date('3-12-1981', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),3000,NULL,20, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);
INSERT INTO TB_EMPLOYEE VALUES (7934,'MILLER','CLERK',   7782,TO_CHAR(to_date('23-1-1982', 'dd-mm-yyyy'), 'YYYY-MM-DD HH24:MI:SS'),1300,NULL,10, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), NULL);

-- Person / Phone
DROP SEQUENCE SQ_PERSON;
CREATE SEQUENCE SQ_PERSON START WITH 3 INCREMENT BY  1;

DROP SEQUENCE SQ_PHONE;
CREATE SEQUENCE SQ_PHONE START WITH 3 INCREMENT BY  1;

DROP TABLE TB_PERSON CASCADE CONSTRAINT;
DROP TABLE TB_PHONE CASCADE CONSTRAINT;

CREATE TABLE TB_PERSON (
   NO NUMBER NOT NULL,
   NAME VARCHAR2(255),
   JOB VARCHAR2(255),
   INSERT_TIME VARCHAR2(255),
   UPDATE_TIME VARCHAR2(255),
   PRIMARY KEY (NO)
);

CREATE TABLE TB_PHONE (
      PNO NUMBER NOT NULL,
      PNAME VARCHAR2(255),
      VENDOR VARCHAR2(255),
      NO NUMBER,
      INSERT_TIME VARCHAR2(255),
      UPDATE_TIME VARCHAR2(255),
      PRIMARY KEY (PNO)
);

ALTER TABLE TB_PHONE
ADD CONSTRAINT FK_PERSON_NO
FOREIGN KEY (NO)
REFERENCES TB_PERSON;

INSERT INTO TB_PERSON VALUES (1,'HongGilDong','Sales', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_PERSON VALUES (2,'JangGilSan','IT Developer', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);

INSERT INTO TB_PHONE VALUES (1,'Galuxy S10','Samsung',1,  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO TB_PHONE VALUES (2,'iPhone 14','Apple',2,  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), null);

COMMIT;