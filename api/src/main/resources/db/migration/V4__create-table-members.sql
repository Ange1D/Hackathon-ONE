CREATE TABLE `members` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`user` BIGINT NOT NULL,
	`team` INT NOT NULL,
	CONSTRAINT `FK_members_users` FOREIGN KEY (`user`) REFERENCES `users` (`id`) ,
	CONSTRAINT `FK_members_teams` FOREIGN KEY (`team`) REFERENCES `teams` (`id`)
);