CREATE TABLE `profiles` (
  `id` bigint AUTO_INCREMENT,
  `bio` text,
  `phone_number` varchar(15),
  `date_of_birth` DATE,
  `loyalty_points` INT UNSIGNED DEFAULT 0,
  FOREIGN KEY (id) REFERENCES users(id)
);