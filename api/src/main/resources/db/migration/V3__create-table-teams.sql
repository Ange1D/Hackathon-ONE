CREATE TABLE `teams` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(150) NOT NULL,
	`video_game` INT NOT NULL,
	`description` VARCHAR(255) NOT NULL,
	`create_at` DATE NOT NULL,
	`create_by` BIGINT NOT NULL,
	CONSTRAINT `FK_video_games_users` FOREIGN KEY (`video_game`) REFERENCES `video-games` (`id`),
	CONSTRAINT `FK_teams_users` FOREIGN KEY (`create_by`) REFERENCES `users` (`id`)

);