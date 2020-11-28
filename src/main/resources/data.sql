INSERT INTO USER(ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES(1, 'yoojin', '123', '유진', 'abc@gmail.com');
INSERT INTO USER(ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES(2, 'treabear', '123', '보배', 'xyz@gmail.com');

INSERT INTO QUESTION(ID, writer_id, title, contents, create_date, count_of_answer) values(1, 1, '테스트 데이터 제목', '테스트 데이터 내용', CURRENT_TIMESTAMP(), 0);
INSERT INTO QUESTION(ID, writer_id, title, contents, create_date, count_of_answer) values(2, 2, 'trea 테스트 데이터 제목', 'trea 테스트 데이터 내용', CURRENT_TIMESTAMP(), 0);