
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(8) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `age` int(4) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `wechat` varchar(20) DEFAULT NULL,
  `address` varchar(120) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `inx_user_id` (`id`) USING BTREE,
  KEY `inx_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `user`VALUES (1, 'root', NULL, NULL, NULL, NULL, NULL, NULL, '7ycBFnpIfXYfQog65JWWpA==', NULL, NULL, NULL);
