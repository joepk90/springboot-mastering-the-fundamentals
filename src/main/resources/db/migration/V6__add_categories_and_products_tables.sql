CREATE TABLE `categories` (
  `id` TINYINT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `products` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL(10, 2),
  `category_id` TINYINT,
  FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
);
