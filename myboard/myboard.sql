-- Adminer 4.3.1 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';

DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `m_id` varchar(255) NOT NULL,
  `authority` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `board_config`;
CREATE TABLE `board_config` (
  `num` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `board_table` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE KEY `table` (`board_table`),
  KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `m_num` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` varchar(255) NOT NULL,
  `m_name` varchar(255) NOT NULL,
  `m_password` varchar(255) NOT NULL,
  PRIMARY KEY (`m_num`),
  UNIQUE KEY `m_id` (`m_id`),
  KEY `m_name` (`m_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tbl_pro`;
CREATE TABLE `tbl_pro` (
  `b_no` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `b_subject` varchar(255) DEFAULT NULL,
  `b_content` text,
  `b_views` int(11) DEFAULT NULL,
  `b_registdate` datetime DEFAULT NULL,
  PRIMARY KEY (`b_no`),
  KEY `b_subject` (`b_subject`),
  KEY `b_registdate` (`b_registdate`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;


-- 2017-07-23 03:17:17
