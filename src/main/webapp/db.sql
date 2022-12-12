CREATE TABLE memberTbl(
    code NUMBER PRIMARY KEY,
    memberId VARCHAR2(10),
    memberName VARCHAR2(10),
    memberPwd VARCHAR2(10),
    memberBan VARCHAR2(10),
    authority  VARCHAR2(10)
);

CREATE SEQUENCE student_seq
NOCACHE;
CREATE SEQUENCE teacher_seq
NOCACHE;
drop table memberTbl;

INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'kim','김길동','1234','A','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'na','나길순','1234','A','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'do','도길동','1234','A','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'bae','배길순','1234','B','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'sung','성길동','1234','B','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'ryu','류길순','1234','A','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'jang','장길석','1234','B','학생');
INSERT INTO memberTbl
VALUES(student_seq.NEXTVAL,'lee','이길자','1234','B','학생');


INSERT INTO memberTbl
VALUES(teacher_seq.NEXTVAL,'hong','홍길동','1234','A','선생');
INSERT INTO memberTbl
VALUES(teacher_seq.NEXTVAL,'pi','피길자','1234','B','선생');

commit;

CREATE TABLE studentScoreTbl(
    memberName VARCHAR2(10),  
    kor NUMBER,
    eng NUMBER,
    math NUMBER,
    science NUMBER,
    social NUMBER,
    total number DEFAULT 0,
    avg number DEFAULT 0
);
drop TABLE studentScoreTbl;





INSERT INTO  studentScoreTbl (memberName,kor,eng,math,science,social)
VALUES('김길동',75,80,64,77,70); 
INSERT INTO studentScoreTbl(memberName,kor,eng,math,science,social)
VALUES('나길순',95,69,58,77,97); 
INSERT INTO studentScoreTbl (memberName,kor,eng,math,science,social)
VALUES('도길동',85,54,83,69,75); 
INSERT INTO studentScoreTbl (memberName,kor,eng,math,science,social)
VALUES('배길순',85,65,56,53,68); 
INSERT INTO studentScoreTbl(memberName,kor,eng,math,science,social)
VALUES('성길동',91,91,82,79,74); 
    

commit;



select * from memberTbl;
select * from studentScoreTbl;
