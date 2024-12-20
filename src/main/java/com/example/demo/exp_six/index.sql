-- 打开数据库
use springtest;
-- Table structure for `t_article`
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`
(
    `title`   varchar(200) DEFAULT NULL COMMENT '文章标题',
    `id`      int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
    `content` longtext COMMENT '文章内容',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

-- Records of t_article
INSERT INTO `t_article`
VALUES ('SpringBoot基础入门', '1', '从入门到精通讲解...');
INSERT INTO `t_article`
VALUES ('SpringCloud基础入门', '2', '从入门到精通讲解...');

-- Table structure for `t_comment`
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`
(
    `id`      int(11) NOT NULL COMMENT '评论id',
    `content` longtext COMMENT '评论内容',
    `author`  varchar(200) DEFAULT NULL COMMENT '评论作者',
    `a_id`    int(20)      DEFAULT NULL COMMENT '关联的文章id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- Records of t_comment
INSERT INTO `t_comment`
VALUES ('1', '很全、很详细', '狂奔的蜗牛', '1');
INSERT INTO `t_comment`
VALUES ('2', '赞一个', 'tom', '1');
INSERT INTO `t_comment`
VALUES ('3', '很详细', 'kitty', '1');
INSERT INTO `t_comment`
VALUES ('4', '很好，非常详细', '张三', '1');
INSERT INTO `t_comment`
VALUES ('5', '很不错', '张杨', '2');