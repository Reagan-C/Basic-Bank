CREATE database IF NOT EXISTS basicbank;

USE basicbank;

create TABLE IF NOT EXISTS `customer`  (
`customer_id` INT NOT NULL auto_increment,
`name` varchar(100) not null ,
`email` varchar(100) not null ,
`mobile_number` varchar(20) not null ,
`pwd` varchar(500) not null,
`role` varchar(100) not null,
`created_on` DATE DEFAULT null ,
primary key (`customer_id`)
);

create TABLE IF NOT EXISTS `accounts`  (
`customer_id` INT NOT NULL,
`account_number` INT not null ,
`account_type` varchar(100) not null ,
`branch_address` varchar(200) not null ,
`created_on` DATE DEFAULT null ,
primary key (`account_number`),
KEY `customer_id` (`customer_id`),
CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE
);

create TABLE IF NOT EXISTS `account_transactions`  (
`transaction_id` VARCHAR(200) NOT NULL,
`account_number` INT not null ,
`customer_id` INT not null ,
`transaction_date` DATE not null ,
`transaction_summary` varchar(200) not null ,
`transaction_type` varchar(100) not null ,
`transaction_amount` INT not null ,
`closing_balance` INT not null ,
`created_on` DATE DEFAULT null ,
primary key (`transaction_id`),
KEY `customer_id` (`customer_id`),
KEY `account_number` (`account_number`),
CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`account_number`) REFERENCES `accounts`(`account_number`) ON DELETE CASCADE,
CONSTRAINT `acct_user_idfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE
);

create TABLE IF NOT EXISTS `loans`  (
`loan_number` INT NOT NULL AUTO_INCREMENT,
`customer_id` INT NOT NULL,
`start_date` DATE not null ,
`loan_type` varchar(100) not null ,
`total_loan` INT NOT NULL,
`amount_paid` INT NOT NULL,
`outstanding_amount` INT NOT NULL,
`created_on` DATE DEFAULT null ,
primary key (`loan_number`),
KEY `customer_id` (`customer_id`),
CONSTRAINT `loan_customer_idfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE
);


create TABLE IF NOT EXISTS `cards`  (
`card_id` INT NOT NULL AUTO_INCREMENT,
`card_number` VARCHAR(100) not null ,
`customer_id` INT not null ,
`card_type` VARCHAR(100) not null ,
`total_limit` INT not null ,
`amount_used` INT not null ,
`available_amount` INT not null ,
`created_on` DATE DEFAULT null ,
primary key (`card_id`),
KEY `customer_id` (`customer_id`),
CONSTRAINT `card_customer_idfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`) ON DELETE CASCADE
);

create TABLE IF NOT EXISTS `notices`  (
`notice_id` INT NOT NULL AUTO_INCREMENT,
`notice_summary` VARCHAR(200) not null ,
`notice_details` VARCHAR(500) not null ,
`notice_begin_date` DATE not null ,
`notice_end_date` DATE DEFAULT null ,
`created_on` DATE DEFAULT null ,
`updated_on` DATE DEFAULT null ,
primary key (`notice_id`)
);

create TABLE IF NOT EXISTS `contact_messages`  (
`contact_id` VARCHAR(50) not null ,
`contact_name` VARCHAR(50) not null ,
`contact_email` VARCHAR(100) not null ,
`subject` VARCHAR(500) not null ,
`message` VARCHAR(2000) not null,
`created_on` DATE DEFAULT null ,
primary key (`contact_id`)
);

create TABLE IF NOT EXISTS `authorities`  (
`id` INT NOT NULL auto_increment,
`customer_id` int not null ,
`name` varchar(50) not null ,
primary key (`id`),
KEY `customer_id`(`customer_id`),
CONSTRAINT `authorities_idfk_1` FOREIGN KEY(`customer_id`) REFERENCES `customer`(`customer_id`)
);

--INSERT INTO `customer`(`name`, `email`, `mobile_number`,`pwd`, `role`, `created_on`)
-- values ('olive', 'olive@gmail.com', '9037163552', '$2a$12$IyTohCLMT12y.ozLRXA2LODMyAUs7wJgqAfHsjq6Q.KUlPzScYQ3S', 'admin', CURRENT_DATE);
--
--INSERT INTO `accounts`(`customer_id`, `account_number`, `account_type`,`branch_address`, `created_on`)
-- values (1, 2734231, 'savings', '111 obowo imo', CURRENT_DATE);
--
--INSERT INTO `account_transactions`(`transaction_id`, `account_number`, `customer_id`,`transaction_date`, `transaction_summary`,
-- `transaction_type`, `transaction_amount`, `closing_balance`, `created_on`)
-- values (UUID(), 2734231, 1, CURRENT_DATE, 'bills payment', 'Transfer', 35000, 100000, CURRENT_DATE);
--
--INSERT INTO `loans`(`customer_id`, `start_date`, `loan_type`,`total_loan`, `amount_paid`, `outstanding_amount`, `created_on`)
-- values (1, '2022-12-05', 'salary', 30000, 10000, 20000, CURRENT_DATE);
--
--INSERT INTO `cards`(`card_number`, `customer_id`, `card_type`,`total_limit`, `amount_used`, `available_amount`, `created_on`)
-- values ('5399236022241', 1, 'Credit', 100000, 25000, 75000, CURRENT_DATE);
--
-- INSERT INTO `notices` (`notice_summary`, `notice_details`, `notice_begin_date`, `notice_end_date`, `created_on`, `updated_on`)
-- values ('Launch of credit card', 'The credit card is a new feature which we are implementing. while using this, transactions are made easier',
-- CURRENT_DATE - INTERVAL 30 DAY, CURRENT_DATE + INTERVAL 30 DAY, '2022-11-26', CURRENT_DATE)
