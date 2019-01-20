USE proetnica;

#proetnic_Admin: 3GprG0NpPm+p
#proetnic_Partner: AB6My1BuJ?6h

#1. Address
#2. ContactPerson
#3. Branch
#4. Meals
#5. Accommodation
#6. Partner
#7. Participation
#8. Program
# Zuordungs_Tabellen


-- ************************************** `partnerCat`

CREATE TABLE IF NOT EXISTS `partnercat`
(
 `partnerCategoryID` smallint NOT NULL AUTO_INCREMENT,
 `partnerCategory`   varchar(255),
PRIMARY KEY (`partnerCategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `participationcat`

CREATE TABLE IF NOT EXISTS `participationcat`
(
 `participationCategoryID` smallint NOT NULL AUTO_INCREMENT,
 `participationCategory`   varchar(255),
PRIMARY KEY (`participationCategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `location`

CREATE TABLE IF NOT EXISTS `location`
(
 `locID`    smallint NOT NULL AUTO_INCREMENT,
 `location` varchar(255) NOT NULL UNIQUE,
PRIMARY KEY (`locID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `dates`

CREATE TABLE IF NOT EXISTS `dates`
(
 `dateID`        smallint NOT NULL AUTO_INCREMENT,
 `festivalDates` date NOT NULL UNIQUE,
PRIMARY KEY (`dateID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `contactperson`

CREATE TABLE IF NOT EXISTS `contactperson`
(
 `contactPersonID` smallint NOT NULL AUTO_INCREMENT,
 `name`            varchar(255),
 `mail`            varchar(255),
 `mobile`           varchar(50),
PRIMARY KEY (`contactPersonID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `admin`

CREATE TABLE IF NOT EXISTS `admin`
(
 `adminID`  smallint NOT NULL AUTO_INCREMENT,
 `username` varchar(255) NOT NULL UNIQUE,
 `password` varchar(255),
 `role`     varchar(255),
PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `address`

CREATE TABLE IF NOT EXISTS `address`
(
 `addressID` smallint NOT NULL AUTO_INCREMENT PRIMARY KEY,
 `StreetNr`  varchar(255),
 `zipCode`   varchar(10),
 `city`      varchar(255),
 `district`  varchar(255),
 `country`   varchar(255),
 `phone`     varchar(50),
 `mobile`    varchar(50),
 `fax`       varchar(50),
 `mail`      varchar(255),
 `webpage`   varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `partner`

CREATE TABLE IF NOT EXISTS `partner`
(
 `partnerID`         smallint NOT NULL AUTO_INCREMENT,
 `name`              varchar(255),
 `head`              varchar(255),
 `description`       longtext,
 `descrie`           longtext,
 `beschreibung`      longtext,
 `legalForm`         varchar(255),
 `festivalEdition`   year,
 `partnerCategoryID` smallint,
 `officeAddressID`   smallint,
PRIMARY KEY (`partnerID`),
FOREIGN KEY (`partnerCategoryID`) REFERENCES `partnerCat` (`partnerCategoryID`) ON DELETE SET NULL,
FOREIGN KEY (`officeAddressID`) REFERENCES `address` (`addressID`)
 ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `participation`

CREATE TABLE IF NOT EXISTS `participation`
(
 `participationID`         smallint NOT NULL AUTO_INCREMENT,
 `ensembleName`            varchar(255),
 `artisticDirector`        varchar(255),
 `participants`            int,
 `ageStructure`            varchar(100),
 `activity`                varchar(255),
 `technical`               longtext,
 `description`             longtext,
 `descrie`                 longtext,
 `beschreibung`            longtext,
 `performanceMinutes`      varchar(30),
 `logistical`              longtext,
 `programmeDays`           longtext,
 `specialEve`              tinyint NOT NULL DEFAULT 0,
 `partakeProg`             tinyint NOT NULL DEFAULT 0,
 `participationCategoryID` smallint,
 `responsiblePersonID`     smallint,
 `arrivalDateID`           smallint,
 `departureDateID`         smallint,
PRIMARY KEY (`participationID`),
FOREIGN KEY (`responsiblePersonID`) REFERENCES `contactperson` (`contactPersonID`) ON DELETE SET NULL,
FOREIGN KEY (`arrivalDateID`) REFERENCES `dates` (`dateID`) ON DELETE SET NULL,
FOREIGN KEY (`departureDateID`) REFERENCES `dates` (`dateID`) ON DELETE SET NULL,
FOREIGN KEY (`participationCategoryID`) REFERENCES `participationcat` (`participationCategoryID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `meals`

CREATE TABLE IF NOT EXISTS `meals`
(
 `mealID`         smallint NOT NULL AUTO_INCREMENT,
 `restaurantName` varchar(255),
 `breakfast`      int,
 `lunch`          int,
 `dinner`         int,
 `amtWePay`       decimal(10,2),
 `addressID`      smallint,
 `dateID`         smallint,
PRIMARY KEY (`mealID`),
FOREIGN KEY (`addressID`) REFERENCES `address` (`addressID`) ON DELETE SET NULL,
FOREIGN KEY (`dateID`) REFERENCES `dates` (`dateID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `branch`

CREATE TABLE IF NOT EXISTS `branch`
(
 `branchID`            smallint NOT NULL AUTO_INCREMENT,
 `branchName`          varchar(255),
 `branchHead`          varchar(255),
 `responsiblePersonID` smallint,
 `branchAddressID`     smallint,
PRIMARY KEY (`branchID`),
FOREIGN KEY (`branchAddressID`) REFERENCES `address` (`addressID`) ON DELETE SET NULL,
FOREIGN KEY (`responsiblePersonID`) REFERENCES `contactperson` (`contactPersonID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `accommodation`

CREATE TABLE IF NOT EXISTS `accommodation`
(
 `accommID`        smallint NOT NULL AUTO_INCREMENT,
 `name`            varchar(255),
 `persons`          int,
 `amtWePay`        decimal(10,2),
 `addressID`       smallint,
 `arrivalDateID`   smallint,
 `departureDateID` smallint,
PRIMARY KEY (`accommID`),
FOREIGN KEY (`addressID`) REFERENCES `address` (`addressID`) ON DELETE SET NULL,
FOREIGN KEY (`arrivalDateID`) REFERENCES `dates` (`dateID`) ON DELETE SET NULL,
FOREIGN KEY (`departureDateID`) REFERENCES `dates` (`dateID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



-- ************************************** `program`

CREATE TABLE IF NOT EXISTS `program`
(
 `programID`       smallint NOT NULL AUTO_INCREMENT,
 `locID`           smallint,
 `duration`        mediumint,
 `participationID` smallint,
PRIMARY KEY (`programID`),
FOREIGN KEY (`locID`) REFERENCES `location` (`locID`) ON DELETE SET NULL,
FOREIGN KEY (`participationID`) REFERENCES `participation` (`participationID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



-- ************************************** `partner_branch`

CREATE TABLE IF NOT EXISTS `partner_branch`
(
 `pbID`      smallint NOT NULL AUTO_INCREMENT,
 `partnerID` smallint,
 `branchID`  smallint,
PRIMARY KEY (`pbID`),
FOREIGN KEY (`partnerID`) REFERENCES `partner` (`partnerID`) ON DELETE SET NULL,
FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `participation_accommodation`

CREATE TABLE IF NOT EXISTS `participation_accommodation`
(
 `paID`            smallint NOT NULL AUTO_INCREMENT,
 `participationID` smallint,
 `accommID`        smallint,
PRIMARY KEY (`paID`),
FOREIGN KEY (`participationID`) REFERENCES `participation` (`participationID`) ON DELETE SET NULL,
FOREIGN KEY (`accommID`) REFERENCES `accommodation` (`accommID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `branch_participation`

CREATE TABLE IF NOT EXISTS `branch_participation`
(
 `bparID`          smallint NOT NULL AUTO_INCREMENT,
 `branchID`        smallint,
 `participationID` smallint,
PRIMARY KEY (`bparID`),
FOREIGN KEY (`branchID`) REFERENCES `branch` (`branchID`) ON DELETE SET NULL,
FOREIGN KEY (`participationID`) REFERENCES `participation` (`participationID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `program_date`

CREATE TABLE IF NOT EXISTS `program_date`
(
 `parProgID`        smallint NOT NULL AUTO_INCREMENT,
 `programID`        smallint,
 `performanceDateID` smallint,
 `time`             time,
PRIMARY KEY (`parProgID`),
FOREIGN KEY (`programID`) REFERENCES `program` (`programID`) ON DELETE SET NULL,
FOREIGN KEY (`performanceDateID`) REFERENCES `dates` (`dateID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ************************************** `participation_meals`

CREATE TABLE IF NOT EXISTS `participation_meals`
(
 `pfID`            smallint NOT NULL AUTO_INCREMENT,
 `participationID` smallint,
 `mealID`          smallint,
PRIMARY KEY (`pfID`),
FOREIGN KEY (`participationID`) REFERENCES `participation` (`participationID`) ON DELETE SET NULL,
FOREIGN KEY (`mealID`) REFERENCES `meals` (`mealID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;