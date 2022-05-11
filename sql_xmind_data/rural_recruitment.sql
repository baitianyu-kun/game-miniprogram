/*
 Navicat Premium Data Transfer

 Source Server         : miniprogram
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : rural_recruitment

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 11/05/2022 14:32:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enterprise_info
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_info`;
CREATE TABLE `enterprise_info` (
  `enterprise_id` int NOT NULL AUTO_INCREMENT,
  `enterprise_name` varchar(255) DEFAULT NULL,
  `enterprise_info` varchar(255) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of enterprise_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for expected_job_info
-- ----------------------------
DROP TABLE IF EXISTS `expected_job_info`;
CREATE TABLE `expected_job_info` (
  `expected_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `work_time` varchar(255) DEFAULT NULL,
  `work_location` varchar(255) DEFAULT NULL,
  `work_payment` varchar(255) DEFAULT NULL,
  `work_type` varchar(255) DEFAULT NULL,
  `work_content` varchar(255) DEFAULT NULL,
  `work_period` varchar(255) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `release_time` datetime DEFAULT NULL,
  PRIMARY KEY (`expected_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of expected_job_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for recruit_info
-- ----------------------------
DROP TABLE IF EXISTS `recruit_info`;
CREATE TABLE `recruit_info` (
  `recruit_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `enterprise_id` int DEFAULT NULL,
  `recruit_type` varchar(255) DEFAULT NULL COMMENT 'personal or enterprise',
  `recruit_position` varchar(255) DEFAULT NULL,
  `work_type` varchar(255) DEFAULT NULL,
  `work_time` varchar(255) DEFAULT NULL,
  `work_location` varchar(255) DEFAULT NULL,
  `work_payment` varchar(255) DEFAULT NULL,
  `work_content` varchar(255) DEFAULT NULL,
  `work_period` varchar(255) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `release_time` datetime DEFAULT NULL,
  PRIMARY KEY (`recruit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of recruit_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for resume_info
-- ----------------------------
DROP TABLE IF EXISTS `resume_info`;
CREATE TABLE `resume_info` (
  `resume_id` int NOT NULL AUTO_INCREMENT,
  `recruit_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `resume_file_url` varchar(255) DEFAULT NULL,
  `resume_status` varchar(255) DEFAULT NULL COMMENT 'ing accepted refused',
  PRIMARY KEY (`resume_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of resume_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_type` varchar(255) DEFAULT NULL COMMENT 'boss or person',
  `phone_number` varchar(255) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL COMMENT 'head pic url',
  `nick_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `appid` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
