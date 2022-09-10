INSERT INTO public."Subject"(id, code, "subjectName")
VALUES ('d50e807b-03e3-4382-9c05-3fd1a6616cb2', 'JD', 'Java');
INSERT INTO public."Subject"(id, code, "subjectName")
VALUES ('d50e807b-03e3-4382-9c05-3fd1a6616cb3', 'SFT', 'QA');
INSERT INTO public."Subject"(id, code, "subjectName")
VALUES ('d50e807b-03e3-4382-9c05-3fd1a6616cb4', 'MATH', 'Mathematics');

INSERT INTO public."Group"(id, "nameOfGroup")
VALUES ('d50e807b-03e3-4382-9c05-3fd1a6616asd', 'MK-1');
INSERT INTO public."Group"(id, "nameOfGroup")
VALUES ('d50e807b-03e3-4382-9c05-3fd1a6616as4', 'MK-2');
INSERT INTO public."Group"(id, "nameOfGroup")
VALUES ('d50e807b-03e3-4382-9c05-3fd1a6616as1', 'MK-3');


INSERT INTO public."Student"(id, age, "localDateTime", name, surname, group_id)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sg18',20, '2022-09-04 11:04:06.295255', 'Yurii', 'Nazarov', 'd50e807b-03e3-4382-9c05-3fd1a6616as1');
INSERT INTO public."Student"(id, age, "localDateTime", name, surname, group_id)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf19',20, '2022-09-04 11:04:06.295255', 'Maxim', 'Sykal', 'd50e807b-03e3-4382-9c05-3fd1a6616as1');
INSERT INTO public."Student"(id, age, "localDateTime", name, surname, group_id)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf20',20, '2022-09-04 11:04:06.295255', 'Nazar', 'Stepanov', 'd50e807b-03e3-4382-9c05-3fd1a6616as4');
INSERT INTO public."Student"(id, age, "localDateTime", name, surname, group_id)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf21',20, '2022-09-04 11:04:06.295255', 'Mykola', 'Lukov', 'd50e807b-03e3-4382-9c05-3fd1a6616as4');
INSERT INTO public."Student"(id, age, "localDateTime", name, surname, group_id)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf22',20, '2022-09-04 11:04:06.295255', 'Yurii', 'Vasechkin', 'd50e807b-03e3-4382-9c05-3fd1a6616asd');


INSERT INTO public."Teacher"(id, age, name, surname)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf22',55, 'Maxim', 'Mykytov');
INSERT INTO public."Teacher"(id, age, name, surname)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf23',55, 'Egor', 'Loktev');
INSERT INTO public."Teacher"(id, age, name, surname)
VALUES ('1abcfa1e-bcc1-487e-ab4c-1sss469sf24',55, 'Vasilii', 'Jurasik');


INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33381', 2, '1abcfa1e-bcc1-487e-ab4c-1sss469sg18', 'd50e807b-03e3-4382-9c05-3fd1a6616cb4');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33382', 3, '1abcfa1e-bcc1-487e-ab4c-1sss469sg18', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33383', 4, '1abcfa1e-bcc1-487e-ab4c-1sss469sf19', 'd50e807b-03e3-4382-9c05-3fd1a6616cb4');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33384', 4, '1abcfa1e-bcc1-487e-ab4c-1sss469sf19', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33385', 5, '1abcfa1e-bcc1-487e-ab4c-1sss469sf20', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33386', 5, '1abcfa1e-bcc1-487e-ab4c-1sss469sf20', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33387', 2, '1abcfa1e-bcc1-487e-ab4c-1sss469sf21', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33388', 3, '1abcfa1e-bcc1-487e-ab4c-1sss469sf21', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33389', 4, '1abcfa1e-bcc1-487e-ab4c-1sss469sf22', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
INSERT INTO public."Grade"(id, signification, student_id, subject_id)
VALUES ('d90cd5c1-f732-4670-ac7c-d28423f33390', 3, '1abcfa1e-bcc1-487e-ab4c-1sss469sf22', 'd50e807b-03e3-4382-9c05-3fd1a6616cb3');
