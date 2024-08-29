CREATE DATABASE  IF NOT EXISTS `product_directory`;
USE `product_directory`;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `products_left` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `product`
--

INSERT INTO `product` VALUES
	(1,'Hamburgare',100,'Angus hamburgare', 5000),
	(2,'Brioche-bröd',100,'Smörigt och fluffigt', 1500),
	(3,'Ketchup',3,'Tomatketchup Felix original 5kg', 800),
	(4,'Senap',3,"French's mustard Felix original 5kg", 1000),
	(5,'Cheddar',8,'Intensiv och Aromatisk American style cheddar' 2500);

