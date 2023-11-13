CREATE TABLE author (
                      id                INT NOT NULL ,
                      username          VARCHAR(255) NOT NULL,
                      password          VARCHAR(255) NOT NULL,
                      email             VARCHAR(255) NOT NULL,
                      PRIMARY KEY (id)
);

CREATE TABLE blog (
                    id          INT NOT NULL ,
                    author_id   INT NOT NULL,
                    title       VARCHAR(64),
                    body        VARCHAR(256),
                    PRIMARY KEY (id)
);

CREATE TABLE comment (
                       id          INT NOT NULL ,
                       blog_id     INT NOT NULL,
                       name        VARCHAR(256) NOT NULL,
                       comment     VARCHAR(256) NOT NULL,
                       PRIMARY KEY (id)
);
insert into author(id,username, password, email) values (101,'占友','123456','751642@qq.com');
insert into author(id,username, password, email) values (102,'江涛','3455666','12345@qq.com');
insert into blog(id,author_id,title,body) values (1,101,'自学java','java 是一门很牛逼的语言！');
insert into blog(id,author_id,title,body) values (2,102,'自学python','python 很难！');
insert into comment(id,blog_id,name,comment) values (1,1,'占友','这个地方写的有点问题');
insert into comment(id,blog_id,name,comment) values (2,1,'江涛','这个地方很好');
