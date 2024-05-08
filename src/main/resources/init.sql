CREATE DATABASE IF NOT EXISTS ssm_db CHARACTER SET utf8;

USE ssm_db;

-- 创建tbl_book表
CREATE TABLE tbl_book
(
    id          INT PRIMARY KEY AUTO_INCREMENT, -- 图书编号
    type        VARCHAR(100),                   -- 图书类型
    name        VARCHAR(100),                   -- 图书名称
    description VARCHAR(100)                    -- 图书描述
);

-- 添加初始化数据
INSERT INTO tbl_book
VALUES (NULL, '计算机理论', 'Spring实战 第5版', 'Spring入门经典教材，深入理解Spring原理技术内幕');
INSERT INTO tbl_book
VALUES (NULL, '计算机理论', 'Spring 5核心原理与30个类手写实战', '十年沉淀之作,手写Spring精华思想');
INSERT INTO tbl_book
VALUES (NULL, '计算机理论', 'Spring 5设计模式', '深入Spring源码剖析,Spring源码蕴含的10大设计模式');
INSERT INTO tbl_book
VALUES (NULL, '市场营销', '直播就该这么做:主播高效沟通实战指南', '李子柒、李佳琦、薇娅成长为网红的秘密都在书中');
INSERT INTO tbl_book
VALUES (NULL, '市场营销', '直播销讲实战一本通', '和秋叶一起学系列网络营销书籍');
INSERT INTO tbl_book
VALUES (NULL, '市场营销', '直播带货:淘宝、天猫直播从新手到高手', '一本教你如何玩转直播的书,10堂课轻松实现带货月入3W+');

select id,type,name,description from tbl_book;

select id,type,name,description from tbl_book where id = 1;

update tbl_book set type="修改1之后的type",name="修改1之后的name",description="修改1之后的description" where id = 1;

delete from tbl_book where id = 1;

insert tbl_book(type,name,description) values ('图书type','图书name','图书description');