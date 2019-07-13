-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- Server version:               10.1.38-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for translation
DROP DATABASE IF EXISTS `translation`;
CREATE DATABASE IF NOT EXISTS `translation` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `translation`;

-- Dumping structure for table translation.tb_article
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE IF NOT EXISTS `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` varchar(200) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `r_long_title` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `r_subheading` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `r_author` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `r_summary` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `r_content` varchar(10000) COLLATE utf8_bin NOT NULL,
  `create_time` varchar(200) COLLATE utf8_bin NOT NULL,
  `last_edit_time` varchar(200) COLLATE utf8_bin NOT NULL,
  `r_publish` tinyint(4) DEFAULT NULL COMMENT '0:未发表,1:发表',
  `r_status` tinyint(4) DEFAULT NULL COMMENT '0:存在,1:删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `r_id` (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.
-- Dumping structure for table translation.tb_user
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE IF NOT EXISTS `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(200) COLLATE utf8_bin NOT NULL,
  `power` tinyint(4) DEFAULT NULL COMMENT '0:管理员;1:普通用户;2.开发者',
  `user_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `pass_word` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL COMMENT '0:男性;1:女性',
  `create_time` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `last_edit_time` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.
-- Dumping structure for table translation.tb_word
DROP TABLE IF EXISTS `tb_word`;
CREATE TABLE IF NOT EXISTS `tb_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word_id` varchar(200) COLLATE utf8_bin NOT NULL,
  `open_id` varchar(200) COLLATE utf8_bin NOT NULL,
  `query` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `trans_src` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `trans_dst` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `from_word` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `to_word` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `status_code` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `last_edit_time` date DEFAULT NULL,
  `is_collection` tinyint(4) DEFAULT NULL COMMENT '0:不收藏,1:收藏',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '0:不删除,1:删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `word_id` (`word_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.
-- Dumping structure for table translation.tb_wxuser
DROP TABLE IF EXISTS `tb_wxuser`;
CREATE TABLE IF NOT EXISTS `tb_wxuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(200) COLLATE utf8_bin NOT NULL,
  `open_id` varchar(200) COLLATE utf8_bin NOT NULL,
  `nick_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `avatar_url` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL COMMENT '0:未知;1:男性;2:女性',
  `language` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
