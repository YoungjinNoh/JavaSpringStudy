insert into article(id,title,content) values (1,'aaa','111');
insert into article(id,title,content) values (2,'bbb','222');
insert into article(id,title,content) values (3,'ccc','333');

--article dummy data
insert into article(id,title,content) values (4,'what','111gg');
insert into article(id,title,content) values (5,'how','222gg');
insert into article(id,title,content) values (6,'when','333gg');

--comment dummy data
insert into comment(id,article_id,nickname,body) values (1,4,'park','fuck');
insert into comment(id,article_id,nickname,body) values (2,4,'kim','good');
insert into comment(id,article_id,nickname,body) values (3,4,'noh','sad');

insert into comment(id,article_id,nickname,body) values (4,5,'park','fudsfck');
insert into comment(id,article_id,nickname,body) values (5,5,'kim','gosdfod');
insert into comment(id,article_id,nickname,body) values (6,5,'noh','ssdafad');

insert into comment(id,article_id,nickname,body) values (7,6,'park','yo');
insert into comment(id,article_id,nickname,body) values (8,6,'kim','exactly');
insert into comment(id,article_id,nickname,body) values (9,6,'noh','excellent');