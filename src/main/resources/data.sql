insert into company(name,country,region)
values ('원티드','한국','서울');


insert into employment(position,compensation,content,skill,company_id)
values ('백엔드 주니어 개발자',1500000,"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은.",'Python',1),
('백엔드 주니어 개발자',1500000,"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은.",'Django',1);

insert into member(id,name,Employment_id)
values (1,'서명진',1);
