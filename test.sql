/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 27/06/2023 12:59:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ledger
-- ----------------------------
DROP TABLE IF EXISTS `ledger`;
CREATE TABLE `ledger`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` int NOT NULL,
  `store_id` int NOT NULL,
  `product_id` int NOT NULL,
  `newday` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `store_id`(`store_id` ASC) USING BTREE,
  INDEX `product_id`(`product_id` ASC) USING BTREE,
  CONSTRAINT `ledger_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ledger_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ledger
-- ----------------------------
INSERT INTO `ledger` VALUES (1, 220, 1, 1, '2023-06-26');
INSERT INTO `ledger` VALUES (2, 100, 2, 1, '2023-06-26');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `out_time` datetime NULL DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `product_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '2023-06-20 13:30:42', '您购买的mate50，已于2023-06-26T21:30:42.124发货，您购买的数量为10', 'false', 1);
INSERT INTO `message` VALUES (2, '2021-10-20 23:22:31', NULL, 'true', NULL);
INSERT INTO `message` VALUES (3, '2024-05-24 23:22:39', NULL, NULL, NULL);
INSERT INTO `message` VALUES (4, '2023-06-27 02:37:23', '用户购买的mate50，已于2023-06-27T10:37:23.407发货，购买的数量为10', 'false', 1);
INSERT INTO `message` VALUES (5, '2023-06-27 02:37:28', '用户购买的mate50，已于2023-06-27T10:37:27.508发货，购买的数量为10', 'false', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `specification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'mate50', NULL, 10.00);
INSERT INTO `product` VALUES (2, 'xiaomi10', NULL, 8.00);
INSERT INTO `product` VALUES (4, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (5, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (6, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (7, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (8, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (9, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (10, 'xiaomi10', NULL, 0.00);
INSERT INTO `product` VALUES (11, '苹果', NULL, 15.00);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `num` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '上海', NULL);
INSERT INTO `store` VALUES (2, '深圳', NULL);

SET FOREIGN_KEY_CHECKS = 1;
