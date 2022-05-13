/*
 Navicat Premium Data Transfer

 Source Server         : miniprogram
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : rural_recruitment

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 13/05/2022 18:30:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enterprise_info
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_info`;
CREATE TABLE `enterprise_info`  (
  `enterprise_id` int(0) NOT NULL AUTO_INCREMENT,
  `enterprise_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `enterprise_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`enterprise_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enterprise_info
-- ----------------------------
INSERT INTO `enterprise_info` VALUES (1, 'baitianyucompany', 'info', '1596666666');
INSERT INTO `enterprise_info` VALUES (2, 'baitianyu1111', 'newinfo', '159');
INSERT INTO `enterprise_info` VALUES (3, 'baitianyucompany', 'info', '1596666666');
INSERT INTO `enterprise_info` VALUES (4, 'baitianyucompany', 'info', '1596666666');
INSERT INTO `enterprise_info` VALUES (5, 'baitianyucompany', 'info', '1596666666');

-- ----------------------------
-- Table structure for expected_job_info
-- ----------------------------
DROP TABLE IF EXISTS `expected_job_info`;
CREATE TABLE `expected_job_info`  (
  `expected_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `work_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_payment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_period` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `release_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`expected_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expected_job_info
-- ----------------------------
INSERT INTO `expected_job_info` VALUES (1, 1, '15h', 'hebei', '1500', 'computer', 'work content change', '1-8', '155', '2022-05-13 18:26:36.072');
INSERT INTO `expected_job_info` VALUES (2, 2, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.959');
INSERT INTO `expected_job_info` VALUES (3, 3, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.965');
INSERT INTO `expected_job_info` VALUES (4, 4, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.972');
INSERT INTO `expected_job_info` VALUES (5, 5, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.977');
INSERT INTO `expected_job_info` VALUES (6, 6, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.986');
INSERT INTO `expected_job_info` VALUES (7, 7, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.992');
INSERT INTO `expected_job_info` VALUES (8, 8, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:35.999');
INSERT INTO `expected_job_info` VALUES (9, 9, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.004');
INSERT INTO `expected_job_info` VALUES (10, 10, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.011');
INSERT INTO `expected_job_info` VALUES (11, 11, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.017');
INSERT INTO `expected_job_info` VALUES (12, 12, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.023');
INSERT INTO `expected_job_info` VALUES (13, 13, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.029');
INSERT INTO `expected_job_info` VALUES (14, 14, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.034');
INSERT INTO `expected_job_info` VALUES (15, 15, '15h', 'handan', '1500', 'computer', 'work content', '1-5', '15932366827', '2022-05-13 18:26:36.04');

-- ----------------------------
-- Table structure for recruit_info
-- ----------------------------
DROP TABLE IF EXISTS `recruit_info`;
CREATE TABLE `recruit_info`  (
  `recruit_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `enterprise_id` int(0) NULL DEFAULT NULL,
  `recruit_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'personal or enterprise',
  `recruit_position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `recruit_requirement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_payment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `work_period` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `release_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`recruit_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recruit_info
-- ----------------------------
INSERT INTO `recruit_info` VALUES (1, 1, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (2, 2, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (3, 3, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (4, 4, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (5, 5, 1, 'ENTERPRISE', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (6, 6, 0, 'ENTERPRISE', 'computer-manager', NULL, 'computer', '10h', 'handan', '199/h', 'content', '5-11', '15932366855', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (7, 7, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (8, 8, 2, 'ENTERPRISE', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (9, 9, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (10, 10, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (11, 11, 3, 'ENTERPRISE', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (12, 12, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (13, 13, 4, 'ENTERPRISE', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (14, 14, 0, 'PERSONAL', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');
INSERT INTO `recruit_info` VALUES (15, 15, 5, 'ENTERPRISE', 'computer-manager', NULL, 'computer', '10h', 'handan', '100/h', 'content', '5-10', '15932366827', '2022-05-13 18:28:15');

-- ----------------------------
-- Table structure for resume_info
-- ----------------------------
DROP TABLE IF EXISTS `resume_info`;
CREATE TABLE `resume_info`  (
  `resume_id` int(0) NOT NULL AUTO_INCREMENT,
  `recruit_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `resume_file_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resume_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ing accepted refused',
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume_info
-- ----------------------------
INSERT INTO `resume_info` VALUES (1, 1, 1, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (2, 2, 2, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (3, 3, 3, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (4, 4, 4, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (5, 5, 5, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (6, 6, 6, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (7, 7, 7, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (8, 8, 8, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (9, 9, 9, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (10, 10, 10, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (11, 11, 11, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (12, 12, 12, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (13, 13, 13, 'file url', 'RESUME_ACCEPTED');
INSERT INTO `resume_info` VALUES (14, 14, 14, 'file url rejected', 'RESUME_REJECTED');
INSERT INTO `resume_info` VALUES (15, 15, 15, 'file url', 'RESUME_POSTED');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'boss or person',
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'head pic url',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `appid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '5555', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (2, '5556', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (3, '5557', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (4, '5558', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (5, '5559', 'ENTERPRISE', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (6, '5560', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (7, '5561', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (8, '5562', 'ENTERPRISE', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (9, '5563', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (10, '5564', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (11, '5565', 'ENTERPRISE', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (12, '5566', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (13, '5567', 'ENTERPRISE', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (14, '5568', 'PERSONAL', '', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);
INSERT INTO `user_info` VALUES (15, '5569', 'ENTERPRISE', '15932366827', 'photo_url', 'baitianyu', 'boy', 'ZH-CN', 'China', 'hebei', 'handan', 12346);

SET FOREIGN_KEY_CHECKS = 1;
