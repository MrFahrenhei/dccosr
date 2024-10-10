CREATE TABLE IF NOT EXISTS `item`
(
    `item_id`         INT NOT NULL AUTO_INCREMENT,
    `tag_translation` VARCHAR(255) DEFAULT NULL,
    `roll_dice`       INT DEFAULT NULL,
    `price`           VARCHAR(255) DEFAULT NULL,
    `dt_insert`       DATETIME,
    PRIMARY KEY (`item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

ALTER TABLE `item`
    ADD KEY `tb_idfk_1`(`tag_translation`);

CREATE TABLE IF NOT EXISTS `translation_table`
(
    `translation_id`  INT          NOT NULL,
    `language`        ENUM ('eng', 'pt-br', 'es'),
    `tag_translation` VARCHAR(255) NOT NULL,
    `text_translated` VARCHAR(255) NOT NULL,
    `dt_insert`       DATETIME
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

AlTER TABLE `translation_table`
    ADD PRIMARY KEY (`tag_translation`);

ALTER TABLE `translation_table`
    ADD CONSTRAINT `tb_idfk_1` FOREIGN KEY (`tag_translation`) REFERENCES `item` (`tag_translation`);

CREATE TABLE IF NOT EXISTS `weapon`
(
    `weapon_id` INT NOT NULL AUTO_INCREMENT,
    `item_id`   INT NOT NULL,
    `damage`    VARCHAR(255) DEFAULT NULL,
    `range`     VARCHAR(255) DEFAULT NULL,
    `dt_insert` DATETIME,
    PRIMARY KEY (`weapon_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

ALTER TABLE `weapon`
    ADD CONSTRAINT `weapong_idfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`);

CREATE TABLE IF NOT EXISTS `occupation`
(
    `occupation_id` INT NOT NULL AUTO_INCREMENT,
    `roll` INT NOT NULL,
    `occupation` VARCHAR(255) NOT NULL,
    `trained_weapon` VARCHAR(255) NOT NULL,
    `trade_goods`   VARCHAR(255) NOT NULL,
    `dt_insert` DATETIME,
    PRIMARY KEY (`occupation_id`)
) ENGINE = InnoDB
DEFAULT CHARSET = latin1;