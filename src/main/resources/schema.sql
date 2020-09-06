-- DROP ALL TABLES. ORDER IS (MOSTLY) IMPORTANT DUE TO FK CONSTRAINTS --
DROP TABLE IF EXISTS `boarding_pass`;
DROP TABLE IF EXISTS `ticket`;
DROP TABLE IF EXISTS `itinerary`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `traveler`;
DROP TABLE IF EXISTS `travel_agency`;
DROP TABLE IF EXISTS `flight`;
DROP TABLE IF EXISTS `airport`;

-- AIRPORT --
CREATE TABLE `airport` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `postal_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
-- FLIGHT --
CREATE TABLE `flight` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `dest` BIGINT(11) NOT NULL,
  `origin` BIGINT(11) NOT NULL,
  `capacity` INT NULL,
  `price` DOUBLE NOT NULL,
  `arrival_date` DATETIME(2) NOT NULL,
  `departure_date` DATETIME(2) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `dest`
    FOREIGN KEY (`dest`)
    REFERENCES `airport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `origin`
    FOREIGN KEY (`origin`)
    REFERENCES `airport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
-- TRAVELER --
CREATE TABLE `traveler` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `postal_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

-- TRAVEL_AGENCY --
CREATE TABLE `travel_agency` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `commission_rate` DECIMAL(2) NULL,
  PRIMARY KEY (`id`));
  
  -- USER --
  CREATE TABLE `user` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` ENUM('TRAVELER', 'TRAVEL_AGENT', 'COUNTER') NOT NULL,
  `agency_id` BIGINT(11) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `phone` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `postal_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `agency_id`
    FOREIGN KEY (`agency_id`)
    REFERENCES `travel_agency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ITINERARY --
CREATE TABLE `itinerary` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `traveler_id` BIGINT(11) NOT NULL,
  `user_id` BIGINT(11) NOT NULL,
  `agency_id` BIGINT(11) NULL DEFAULT NULL,
  `price_total` DOUBLE NOT NULL,
  `date_created` DATETIME(2) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `traveler_id`
    FOREIGN KEY (`traveler_id`)
    REFERENCES `traveler` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- TICKET --
CREATE TABLE `ticket` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `flight_number` BIGINT(11) NOT NULL,
  `itinerary_id` BIGINT(11) NULL,
  `status` ENUM('COMPLETE', 'ACTIVE', 'CANCELLED') NULL,
  `seat_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `flight_number`
    FOREIGN KEY (`flight_number`)
    REFERENCES `flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `itinerary`
    FOREIGN KEY (`itinerary_id`)
    REFERENCES `itinerary` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- BOARDING_PASS --
CREATE TABLE `boarding_pass` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ticket_id` BIGINT(11) NOT NULL,
  `gate_number` VARCHAR(45) NOT NULL,
  `terminal_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `ticket_id`
    FOREIGN KEY (`ticket_id`)
    REFERENCES `ticket` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
