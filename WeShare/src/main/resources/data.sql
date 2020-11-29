REPLACE INTO `roles` VALUES (1,'ADMIN');
REPLACE INTO `roles` VALUES (2,'USER');


INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(1, true,'admin@gmail.com', 'Admin', 'Shah', '2020-11-01 00:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'admin');

INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(2, true,'abhi@gmail.com', 'Abhi', 'Shah', '2020-11-01 09:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'abhi');

INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(3, true,'ketan@gmail.com', 'Ketan', 'Suthar', '2020-11-02 10:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'ketan');

INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(4, true,'archi@gmail.com', 'Archi', 'Shah', '2020-11-03 11:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'archi');

INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(5, true,'ravikant@gmail.com', 'Ravikant', 'Pujari', '2020-11-04 12:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'ravikant');

INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(6, true,'naika@gmail.com', 'Naika', 'Bhatt', '2020-11-05 13:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'naika');

INSERT IGNORE INTO `users` (user_id, active, email, first_name, last_name, joined_on, password, user_name)
VALUES(7, true,'jay@gmail.com', 'Jay', 'Thakkar', '2020-11-06 14:00:00.0', '$2a$10$ao.Sy9kgFozmWibNAR8pAe46ddFp54EBFWg0mN9ktMNg3mWAhlWMy', 'jay');



INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(1,1);
INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(2,2);
INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(3,2);
INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(4,2);
INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(5,2);
INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(6,2);
INSERT IGNORE INTO `user_role` (user_id, role_id)
VALUES(7,2);



INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(1,"Technology");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(2,"Travel");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(3,"Gaming");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(4,"News");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(5,"Business");



INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(1, 'The Java community', 'Java', '2020-09-27 09:09:09.0', 1, 1, 2);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(2, 'The Spring community', 'Spring', '2020-11-28 10:10:10.0', 0, 1, 4);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(3, 'The Stock Market community', 'StockMarket', '2020-11-11 11:11:11.0', 0, 5, 2);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(4, 'The Bangalore community', 'Bangalore', '2020-11-28 05:05:05.0', 0, 2, 3);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(5, 'The PUBG community', 'PUBG', '2020-11-10 07:07:07.0', 0, 3, 7);


INSERT IGNORE INTO `community_members` (user_id, community_id)
VALUES(2, 1);
