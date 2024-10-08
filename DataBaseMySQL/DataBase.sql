--
-- Set character set the client will use to send SQL statements to the server
--
CREATE DATABASE hr
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;

SET NAMES 'utf8';

--
-- Set default database
--
USE hr;

--
-- Create table `system_users`
--
CREATE TABLE system_users
(
    id                INT NOT NULL AUTO_INCREMENT,
    role              VARCHAR(100) DEFAULT NULL,
    Privilege_Role_id INT          DEFAULT NULL,
    PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 3276,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create index `UK_system_users_Privilege_Role_id` on table `system_users`
--
ALTER TABLE system_users
    ADD UNIQUE INDEX UK_system_users_Privilege_Role_id (Privilege_Role_id);

--
-- Create table `users`
--
CREATE TABLE users (
                       id           INT        NOT NULL AUTO_INCREMENT,
                       isactivated  TINYINT(1) NOT NULL,
                       status       TINYINT(1) NOT NULL,
                       email        VARCHAR(100) DEFAULT NULL,
                       createddate  DATE         DEFAULT (now()),
                       password     VARCHAR(255) DEFAULT NULL,
                       Privilege_id INT          DEFAULT NULL,
                       PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 22,
    AVG_ROW_LENGTH = 780,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE users
    ADD CONSTRAINT FK_users_Privilege_id FOREIGN KEY (Privilege_id)
        REFERENCES system_users (Privilege_Role_id);

--
-- Create table `employers`
--
CREATE TABLE employers (
                           id          INT NOT NULL AUTO_INCREMENT,
                           userid      INT          DEFAULT NULL,
                           companyname VARCHAR(50)  DEFAULT NULL,
                           website     VARCHAR(100) DEFAULT NULL,
                           phonenumber VARCHAR(15)  DEFAULT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 21,
    AVG_ROW_LENGTH = 819,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE employers
    ADD CONSTRAINT fk_userid FOREIGN KEY (userid)
        REFERENCES users (id);

--
-- Create foreign key
--
ALTER TABLE employers
    ADD CONSTRAINT fk_userid1 FOREIGN KEY (userid)
        REFERENCES users (id);

--
-- Create table `department`
--
CREATE TABLE department (
                            id              INT          NOT NULL AUTO_INCREMENT,
                            department_name VARCHAR(255) NOT NULL,
                            PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 21,
    AVG_ROW_LENGTH = 819,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `schools`
--
CREATE TABLE schools (
                         id            INT          NOT NULL AUTO_INCREMENT,
                         school_name   VARCHAR(200) NOT NULL,
                         department_id INT DEFAULT NULL,
                         PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 21,
    AVG_ROW_LENGTH = 819,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE schools
    ADD CONSTRAINT fk_department_id FOREIGN KEY (department_id)
        REFERENCES department (id);

--
-- Create foreign key
--
ALTER TABLE schools
    ADD CONSTRAINT fk_department_id1 FOREIGN KEY (department_id)
        REFERENCES department (id);

--
-- Create table `departments`
--
CREATE TABLE departments (
                             id              INT NOT NULL,
                             department_name VARCHAR(255) DEFAULT NULL,
                             PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 3276,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE departments
    ADD CONSTRAINT fk_id FOREIGN KEY (id)
        REFERENCES schools (id);

--
-- Create foreign key
--
ALTER TABLE departments
    ADD CONSTRAINT fk_id1 FOREIGN KEY (id)
        REFERENCES schools (id);

--
-- Create table `work_time`
--
CREATE TABLE work_time (
                           id             INT NOT NULL,
                           work_time_name VARCHAR(255) DEFAULT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 3276,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `work_place`
--
CREATE TABLE work_place (
                            id              INT NOT NULL,
                            work_place_name VARCHAR(255) DEFAULT NULL,
                            PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 3276,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `cities`
--
CREATE TABLE cities (
                        id        INT          NOT NULL AUTO_INCREMENT,
                        city_name VARCHAR(200) NOT NULL,
                        PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 21,
    AVG_ROW_LENGTH = 819,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `job_positions`
--
CREATE TABLE job_positions (
                               id            INT NOT NULL,
                               position_name VARCHAR(50) DEFAULT NULL,
                               PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 3276,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `work_experiences`
--
CREATE TABLE work_experiences (
                                  id             INT          NOT NULL AUTO_INCREMENT,
                                  position_id    INT          NOT NULL,
                                  workplace_name VARCHAR(255) NOT NULL,
                                  starting_date  DATE         NOT NULL,
                                  quit_date      DATE DEFAULT NULL,
                                  job_seeker_id  INT          NOT NULL,
                                  PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 655,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE work_experiences
    ADD CONSTRAINT fk_position_id FOREIGN KEY (position_id)
        REFERENCES job_positions (id);

--
-- Create foreign key
--
ALTER TABLE work_experiences
    ADD CONSTRAINT fk_position_id1 FOREIGN KEY (position_id)
        REFERENCES job_positions (id);

--
-- Create table `jobs`
--
CREATE TABLE jobs (
                      id                        INT           NOT NULL AUTO_INCREMENT,
                      general_position_id       INT           NOT NULL,
                      description               VARCHAR(3400) NOT NULL,
                      city_id                   INT           NOT NULL,
                      min_salary                INT           NOT NULL,
                      max_salary                INT           NOT NULL,
                      number_of_empty_positions INT           NOT NULL,
                      is_active                 TINYINT(1)    NOT NULL,
                      deadline                  DATE          NOT NULL,
                      created_date              DATE          NOT NULL,
                      employer_id               INT           NOT NULL,
                      work_place_id             INT           NOT NULL,
                      work_time_id              INT           NOT NULL,
                      PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 21,
    AVG_ROW_LENGTH = 819,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_city_id FOREIGN KEY (city_id)
        REFERENCES cities (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_city_id1 FOREIGN KEY (city_id)
        REFERENCES cities (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_employer_id FOREIGN KEY (employer_id)
        REFERENCES employers (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_employer_id1 FOREIGN KEY (employer_id)
        REFERENCES employers (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_general_position_id FOREIGN KEY (general_position_id)
        REFERENCES job_positions (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_general_position_id1 FOREIGN KEY (general_position_id)
        REFERENCES job_positions (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_work_place_id FOREIGN KEY (work_place_id)
        REFERENCES work_place (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_work_place_id1 FOREIGN KEY (work_place_id)
        REFERENCES work_place (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_work_time_id FOREIGN KEY (work_time_id)
        REFERENCES work_time (id);

--
-- Create foreign key
--
ALTER TABLE jobs
    ADD CONSTRAINT fk_work_time_id1 FOREIGN KEY (work_time_id)
        REFERENCES work_time (id);

--
-- Create table `activation_panel_for_system_user`
--
CREATE TABLE activation_panel_for_system_user
(
    id              INT       NOT NULL AUTO_INCREMENT,
    detail          VARCHAR(200)   DEFAULT NULL,
    activation_date TIMESTAMP NULL DEFAULT NULL,
    is_approved     TINYINT(1)     DEFAULT NULL,
    system_user     INT            DEFAULT NULL,
    job_id          INT            DEFAULT NULL,
    PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 655,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE activation_panel_for_system_user
    ADD CONSTRAINT fk_job_id FOREIGN KEY (job_id)
        REFERENCES jobs (id);

--
-- Create table `job_seekers`
--
CREATE TABLE job_seekers (
                             id                    INT NOT NULL AUTO_INCREMENT,
                             userid                INT          DEFAULT NULL,
                             firstname             VARCHAR(50)  DEFAULT NULL,
                             lastname              VARCHAR(50)  DEFAULT NULL,
                             birthdate             INT          DEFAULT NULL,
                             nationalityid         BIGINT       DEFAULT NULL,
                             github_account        VARCHAR(255) DEFAULT NULL,
                             info_about_job_seeker VARCHAR(255) DEFAULT NULL,
                             linkedin_account      VARCHAR(255) DEFAULT NULL,
                             job_position_id       INT          DEFAULT NULL,
                             PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 655,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE job_seekers
    ADD CONSTRAINT fk_job_position_id FOREIGN KEY (job_position_id)
        REFERENCES job_positions (id);

--
-- Create foreign key
--
ALTER TABLE job_seekers
    ADD CONSTRAINT fk_job_position_id1 FOREIGN KEY (job_position_id)
        REFERENCES job_positions (id);

--
-- Create table `attended_schools`
--
CREATE TABLE attended_schools (
                                  id                            INT       NOT NULL AUTO_INCREMENT,
                                  school_id                     INT       NOT NULL,
                                  startingDateOfUniversity      DATE      NOT NULL,
                                  graduationDateOfUniversity    DATE           DEFAULT NULL,
                                  job_seeker_id                 INT            DEFAULT NULL,
                                  graduation_date_of_university TIMESTAMP NULL DEFAULT NULL,
                                  starting_date_of_university   TIMESTAMP NULL DEFAULT NULL,
                                  PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 655,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE attended_schools
    ADD CONSTRAINT fk_job_seeker_id FOREIGN KEY (job_seeker_id)
        REFERENCES job_seekers (id);

--
-- Create foreign key
--
ALTER TABLE attended_schools
    ADD CONSTRAINT fk_job_seeker_id1 FOREIGN KEY (job_seeker_id)
        REFERENCES job_seekers (id);

--
-- Create foreign key
--
ALTER TABLE attended_schools
    ADD CONSTRAINT fk_school_id FOREIGN KEY (school_id)
        REFERENCES schools (id);

--
-- Create foreign key
--
ALTER TABLE attended_schools
    ADD CONSTRAINT fk_school_id1 FOREIGN KEY (school_id)
        REFERENCES schools (id);

--
-- Create table `language_levels`
--
CREATE TABLE language_levels (
                                 id                INT          NOT NULL,
                                 level_description VARCHAR(200) NOT NULL,
                                 PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AVG_ROW_LENGTH = 3276,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `known_languages`
--
CREATE TABLE known_languages (
                                 id                INT          NOT NULL AUTO_INCREMENT,
                                 language_level_id INT          NOT NULL,
                                 language_name     VARCHAR(255) NOT NULL,
                                 job_seeker_id     INT DEFAULT NULL,
                                 PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 655,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE known_languages
    ADD CONSTRAINT fk_language_level_id FOREIGN KEY (language_level_id)
        REFERENCES language_levels (id);

--
-- Create foreign key
--
ALTER TABLE known_languages
    ADD CONSTRAINT fk_language_level_id1 FOREIGN KEY (language_level_id)
        REFERENCES language_levels (id);

--
-- Create table `workplace`
--
CREATE TABLE workplace (
                           id              INT          NOT NULL AUTO_INCREMENT,
                           work_place_name VARCHAR(255) NOT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create table `job`
--
CREATE TABLE job (
                     id            INT          NOT NULL AUTO_INCREMENT,
                     job_title     VARCHAR(255) NOT NULL,
                     work_place_id INT DEFAULT NULL,
                     PRIMARY KEY (id)
)
    ENGINE = INNODB,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;

--
-- Create foreign key
--
ALTER TABLE job
    ADD CONSTRAINT job_ibfk_1 FOREIGN KEY (work_place_id)
        REFERENCES workplace (id);

--
-- Create table `images`
--
CREATE TABLE images (
                        id            INT          NOT NULL AUTO_INCREMENT,
                        job_seeker_id INT          NOT NULL,
                        image_title   VARCHAR(100) NOT NULL,
                        image         VARCHAR(500) NOT NULL,
                        PRIMARY KEY (id)
)
    ENGINE = INNODB,
    AUTO_INCREMENT = 26,
    AVG_ROW_LENGTH = 655,
    CHARACTER SET utf8mb4,
    COLLATE utf8mb4_0900_ai_ci,
    ROW_FORMAT = DYNAMIC;