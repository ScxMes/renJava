-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2010 年 01 月 09 日 14:41
-- 服务器版本: 5.1.36
-- PHP 版本: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `work`
--

-- --------------------------------------------------------

--
-- 表的结构 `change`
--

CREATE TABLE IF NOT EXISTS `change` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` int(11) NOT NULL,
  `change` int(11) NOT NULL,
  `rec_time` date NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student` (`student`,`change`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `change`
--

INSERT INTO `change` (`id`, `student`, `change`, `rec_time`, `description`) VALUES
(1, 87, 4, '2010-01-07', '成绩优秀，提前毕业！哇哈哈哈！！'),
(2, 87, 3, '2010-01-08', '转系啦！！！1111qdafew'),
(5, 87, 2, '2010-01-09', '妨害ufhu 午饭wfafawfawfaw');

-- --------------------------------------------------------

--
-- 表的结构 `change_code`
--

CREATE TABLE IF NOT EXISTS `change_code` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `change_code`
--

INSERT INTO `change_code` (`code`, `description`) VALUES
(0, '转系'),
(1, '休学'),
(2, '复学'),
(3, '退学'),
(4, '毕业');

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `monitor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `department` (`department`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `class`
--

INSERT INTO `class` (`id`, `department`, `name`, `monitor`) VALUES
(1, 1, '网络工程1班', 1),
(2, 1, '网络工程2班', 2),
(3, 1, '网络工程3班', 3),
(4, 1, '网络工程4班', 4),
(5, 1, '计算机1班', 5);

-- --------------------------------------------------------

--
-- 表的结构 `counter`
--

CREATE TABLE IF NOT EXISTS `counter` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `counter_val` int(11) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `counter`
--


-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, '计算机科学与工程学院'),
(2, '信息技术与自动化'),
(3, '数学与计算科学学院'),
(4, '人文教育学院'),
(5, '机械工程学院'),
(6, '土木工程学院'),
(7, '建筑科学与技术学院'),
(8, '商学院'),
(9, '外国语学院'),
(10, '体育学院');

-- --------------------------------------------------------

--
-- 表的结构 `punishment`
--

CREATE TABLE IF NOT EXISTS `punishment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` int(11) NOT NULL,
  `levels` int(11) NOT NULL,
  `rec_time` date NOT NULL,
  `enable` varchar(4) NOT NULL DEFAULT 'T',
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student` (`student`,`levels`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `punishment`
--

INSERT INTO `punishment` (`id`, `student`, `levels`, `rec_time`, `enable`, `description`) VALUES
(1, 50, 0, '2010-01-08', 'T', '警告！！！'),
(2, 64, 0, '2010-01-08', 'T', ''),
(5, 87, 1, '2010-01-09', 'F', 'kjjjjj');

-- --------------------------------------------------------

--
-- 表的结构 `punish_levels`
--

CREATE TABLE IF NOT EXISTS `punish_levels` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `punish_levels`
--

INSERT INTO `punish_levels` (`code`, `description`) VALUES
(0, '警告'),
(1, '严重警告'),
(2, '记过'),
(3, '记大过'),
(4, '开除');

-- --------------------------------------------------------

--
-- 表的结构 `reward`
--

CREATE TABLE IF NOT EXISTS `reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` int(11) NOT NULL,
  `levels` int(11) NOT NULL,
  `rec_time` date NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student` (`student`,`levels`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `reward`
--

INSERT INTO `reward` (`id`, `student`, `levels`, `rec_time`, `description`) VALUES
(1, 1, 3, '2010-01-07', '打击好哈啊啊！'),
(2, 6, 1, '2010-01-07', '作弊被抓，给与奖励！！！'),
(3, 87, 4, '2010-01-08', '恩嫩恩恩ahahah海河的好玩的'),
(4, 87, 2, '2010-01-08', '啊哈哈哈哈！！！'),
(5, 87, 3, '2010-01-09', 'afaefaef');

-- --------------------------------------------------------

--
-- 表的结构 `reward_levels`
--

CREATE TABLE IF NOT EXISTS `reward_levels` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `reward_levels`
--

INSERT INTO `reward_levels` (`code`, `description`) VALUES
(0, '校特等奖学金'),
(1, '校一等奖学金'),
(2, '校二等奖学金'),
(3, '校三等奖学金'),
(4, '系一等奖学金'),
(5, '系二等奖学金'),
(6, '系三等奖学金');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(24) NOT NULL,
  `sex` varchar(4) NOT NULL,
  `class` int(11) NOT NULL,
  `department` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `native_place` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class` (`class`,`department`)
) ENGINE=MyISAM  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=92 ;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `name`, `sex`, `class`, `department`, `birthday`, `native_place`) VALUES
(1, '吕窘窘', 'm', 3, 1, '1989-03-22', '山东省青岛市'),
(2, '吕大号', 'm', 2, 1, '1989-08-24', '江苏'),
(3, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(4, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(5, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(6, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(7, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(8, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(9, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(10, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(11, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(12, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(13, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(14, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(15, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(16, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(17, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(18, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(19, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(20, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(21, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(22, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(23, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(24, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(25, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(26, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(27, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(28, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(29, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(30, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(31, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(32, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(33, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(34, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(35, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(36, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(37, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(38, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(39, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(40, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(41, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(42, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(43, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(44, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(45, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(46, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(47, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(48, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(49, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(50, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(51, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(52, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(53, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(54, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(55, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(56, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(57, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(58, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(59, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(60, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(61, '满肠胃1', 'm', 3, 1, '0000-00-00', '广西省XX市1额达'),
(62, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(63, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(64, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(65, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(66, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(67, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(68, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(69, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(70, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(71, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(72, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(73, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(74, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(75, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(76, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(77, '赵吕吕', 'm', 4, 1, '0000-00-00', '湖南省长沙市'),
(78, '刘坤', 'm', 3, 1, '0000-00-00', '陕西省二二市'),
(79, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(80, '车超', 'm', 3, 1, '2010-01-07', '东北小而球'),
(81, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(82, '吕毅', 'm', 3, 1, '0000-00-00', '山东省青岛市'),
(83, '吕一', 'm', 2, 1, '0000-00-00', '江苏'),
(84, '吕', 'm', 5, 1, '0000-00-00', '甘肃省敦煌市'),
(85, '赵姗姗', 'f', 2, 1, '0000-00-00', '湖南省湘潭市'),
(86, '赵吕吕', 'm', 5, 1, '1988-12-11', '湖南省长沙市雨湖区'),
(87, '刘坤', 'f', 2, 1, '1988-03-21', '陕西省二二市'),
(88, '满肠胃', 'm', 3, 1, '0000-00-00', '广西省XX市'),
(89, '车超', 'm', 3, 1, '2010-01-07', '辽宁省'),
(90, '大便男', 'm', 3, 1, '2010-01-11', '山东青岛'),
(91, '吕毅', 'm', 3, 1, '1989-03-22', '山东青岛');
