-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

INSERT INTO `bookedroom` (`reserve_id`, `arrivaldate`, `bedtype`, `departuredate`, `guests`, `note`, `room`, `hotel_id`, `email`, `statues`) VALUES
(85,	'02/19/2019',	'Single',	'02/26/2019',	'1 Guest',	'',	'1 Room',	21,	24,	0),
(59,	'02/12/2019',	'Single',	'02/20/2019',	'1 Guest',	'',	'1 Room',	1,	24,	0),
(60,	'02/26/2019',	'Single',	'02/19/2019',	'1 Guest',	'',	'1 Room',	49,	24,	1);

INSERT INTO `comments` (`comment`, `on_date`, `email`, `hotel_id`, `id`) VALUES
('asdfghjkfgvhjnkldfgjnkl',	'22',	2,	1,	64),
('Hay your Hotel is too Nice asdffgghjasdadasd',	'23/1/119',	24,	1,	65),
('aasdfg',	'23/1/119',	24,	49,	87),
('asdda',	'23/1/119',	24,	49,	88);

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(89),
(89),
(89),
(89),
(89),
(89);

INSERT INTO `hotel` (`hotel_id`, `city`, `description`, `hotel_name`, `moto`, `phone`, `star`, `sub_city`, `is_confirmed`) VALUES
(1,	'addis ababa',	NULL,	'ethiopis',	NULL,	'',	0,	'addis ababa',	0),
(8,	'addis ababa',	NULL,	'Sheraton',	NULL,	NULL,	0,	'arada',	-1),
(13,	'addis ababa',	'adsds',	'Addisasss',	'Heavens Seems Small at our Hotel',	'0941676278',	0,	'addis ababa',	1),
(18,	'addis ababa',	NULL,	'Sheraton34',	NULL,	NULL,	0,	'addis ababa',	-1),
(21,	'addis ababa',	NULL,	'Sheraton56',	NULL,	NULL,	0,	'addis ababa',	1),
(49,	'addis ababa',	NULL,	'KalKidan',	NULL,	'+251941676278',	0,	'addis ababa',	1),
(56,	'Addis Ababa',	NULL,	'Sheraton67',	NULL,	NULL,	0,	'Arada',	0);



INSERT INTO `img_path` (`id`, `path`, `user_id`, `hotel_id`) VALUES
(72,	'../image/big_image_1/big_image_1.jpg',	NULL,	49),
(79,	'../image/img_2/img_2.jpg',	NULL,	49),
(81,	'../image/Golden_Tulip_Addis_Ababa_Hotel/Golden_Tulip_Addis_Ababa_Hotel.jpg',	NULL,	49),
(80,	'../image/Global_Hotel/Global_Hotel.jpg',	NULL,	49),
(86,	'../image/Golden_Tulip_Addis_Ababa_Hotel/Golden_Tulip_Addis_Ababa_Hotel.jpg',	NULL,	49);

INSERT INTO `role` (`id`, `name`, `user_id`) VALUES
(3,	'MANAGER',	2),
(5,	'ADMIN',	4),
(7,	'ADMIN',	6),
(10,	'MANAGER',	9),
(12,	'ADMIN',	11),
(15,	'MANAGER',	14),
(17,	'USER',	16),
(20,	'MANAGER',	19),
(23,	'MANAGER',	22),
(25,	'USER',	24),
(48,	'USER',	47),
(51,	'MANAGER',	50),
(54,	'USER',	53),
(58,	'MANAGER',	57);


INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`, `hotel_id`, `accno`, `city`, `idno`, `middle_name`, `state`, `sub_city`, `confirmation_token`, `enabled`) VALUES
(2,	'kiberleabeniyew@gmail.com',	NULL,	NULL,	'$2a$10$r4HH7vgFt7MoCGuItpvEW.I119diAcQq1/H6Xml1ZYnGgTZux1y26',	1,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL),
(4,	'abeba@gmail.com',	NULL,	NULL,	'$2a$10$9XYcyIPSLD5OQyR3VIl6lerzefGmy1lqP9zG8d9mr9nYg.bVU96pm',	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL),
(6,	'kira@gmail.com',	NULL,	NULL,	'$2a$10$dj7hqacIwPoQwE3dI/uJXuUbCX1oWLyVBzoMgYeAKmlrspl6P0oNC',	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL),
(9,	'henok@gmail.com',	NULL,	NULL,	'$2a$10$/ZcFXIir5EHJxWYKfdfP9eKN23mA8X3bCNBTUieNXdeWhWSwxTkom',	8,	NULL,	'addis ababa',	NULL,	NULL,	NULL,	'arada',	NULL,	NULL),
(11,	'aebaeniyew@gmail.com',	NULL,	NULL,	'$2a$10$sYDG6NH1zpmaw7Ou50Vmsu7VB0uSgB7zHxNKzMC3notjMuGaszoca',	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL,	NULL),
(14,	'asd@gmail.com',	NULL,	NULL,	'$2a$10$LplCKZdX/e/mYIiZXuJyOONxo6F7I7HEQpWHdVxaYNd.RticvYztm',	13,	NULL,	'addis ababa',	NULL,	NULL,	NULL,	'addis ababa',	NULL,	NULL),
(16,	'kiberleabeniyew@gmail.com12',	'Policekit',	'Demassie',	'$2a$10$I2wgCXdX8FOXyqR/s58NA.YSRvb/4FdhpUQukG7qaPLtcNYnM1GsG',	NULL,	'',	'2513',	'12345678',	'1234',	'aaa',	'aa',	NULL,	NULL),
(19,	'henok34@gmail.com',	NULL,	NULL,	'$2a$10$xhxdSJNa57svmu4X/mIPTef18lktSOXPhHnr76jtCXcTTQxlH/V4K',	18,	NULL,	'addis ababa',	NULL,	NULL,	NULL,	'addis ababa',	NULL,	NULL),
(22,	'henok67@gmail.com',	NULL,	NULL,	'$2a$10$EISFgAikWtLEjgKDZ.MvvOT3ihU1dkAAiOUgK35ph5epY4/.sVhxG',	21,	NULL,	'addis ababa',	NULL,	NULL,	NULL,	'addis ababa',	NULL,	NULL),
(24,	'kiberleabeniyew12@gmail.com',	'kiberleab',	'Demassie',	'$2a$10$4Ylp4SILSlK8wCTVj0pGu.4Y8RSlhLIgkKgXgeU90TwXt.FThxyoK',	NULL,	'12345678',	'aa',	'12345678',	'123456789',	'aaa',	'aa',	NULL,	NULL),
(47,	'kiberleabeniyew23@gmail.com',	'kiberleab',	'Demassie',	'$2a$10$whsX06YpuejrQZJHMikzH.1OncSK9RURvU1DzZ77kok7HM.YS/rqu',	NULL,	'12345678',	'addis ababa',	'12345678',	'kiber',	'addisababa',	'addis ababa',	NULL,	NULL),
(50,	'kiberleabeniyew35@gmail.com',	NULL,	NULL,	'$2a$10$.ELFykWKx1rLpNc13t76seOW2dGaZkoAbJ3LjVP2Q0ajZq57Ars.2',	49,	NULL,	'addis ababa',	NULL,	NULL,	NULL,	'addis ababa',	NULL,	NULL),
(53,	'',	'',	'',	'$2a$10$Tm4w850pBnN8APjsd4yCueioMfjVm3N0eY2DhJcAvps0EEsU8wlFW',	NULL,	'',	'',	'',	'',	'',	'',	NULL,	NULL),
(57,	'asd34@gmail.com',	NULL,	NULL,	'$2a$10$ZyiG2TBoX0GhKtI2LfjjLegbL.gWkLD2dFVTb1cOsTi3j/Iq1TM86',	56,	NULL,	'Addis Ababa',	NULL,	NULL,	NULL,	'Arada',	NULL,	NULL);


-- 2019-02-25 01:11:24
