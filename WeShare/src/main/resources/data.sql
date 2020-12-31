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
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(6,"Sports");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(7,"Animals and Pets");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(8,"Art");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(9,"Careers");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(10,"Celebrity");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(11,"Pics");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(12,"Food and Drink");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(13,"Learning and Education");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(14,"Politics");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(15,"Science");
INSERT IGNORE INTO `category` (category_id, category_name)
VALUES(16,"None of these topics");



INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(1, 'Resources for learning Java', 'learnjava', '2020-09-27 09:09:09.0', 1, 13, 3);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(2, 'A place for pictures and photographs.', 'pics', '2020-11-10 07:07:07.0', 0, 11, 2);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(3, 'Stock market news, Trading, investing, long term, short term traders, daytrading, technical analysis, fundamental analysis and more. We cover it all at stockmarket.', 'StockMarket', '2018-11-11 11:11:11.0', 0, 5, 3);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(4, 'Welcome to bangalore. The one and only official reddit page of Namma Bengaluru.', 'Bangalore', '2017-11-28 05:05:05.0', 0, 16, 4);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(5, "PLAYERUNKNOWN'S BATTLEGROUNDS (PUBG) Game subreddit.PUBG is centered around the game PLAYERUNKNOWN'S BATTLEGROUNDS (pubg for short) made by studio bluehole. This subreddit welcomes Xbox, PlayStation and PC Users !!!", 'PUBG', '2016-11-10 07:07:07.0', 0, 3, 5);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(6, 'This community is a place to share and discuss new scientific research. Read about the latest advances in astronomy, biology, medicine, physics, social science, and more. Find and submit new publications and popular science coverage of current research.', 'Science', '2020-11-10 07:07:07.0', 0, 15, 6);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(7, 'Things that make you go AWW! Like puppies, bunnies, babies, and so on... A place for really cute pictures and videos!', 'Aww', '2015-11-10 07:07:07.0', 0, 7, 7);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(8, 'Welcome to HarryPotter, the place where fans from around the world can meet and discuss everything in the Harry Potter universe! Be sorted, earn house points, take classes with our fine Hogwarts staff, debate which actor portrayed Dumbledore the best, and finally get some closure for your Post-Potter Depression.', 'harrypotter', '2016-11-10 07:07:07.0', 0, 16, 2);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(9, 'Subreddit dedicated to the news and discussions about the creation and use of technology and its surrounding issues.', 'technology', '2020-11-10 07:07:07.0', 0, 1, 3);

INSERT IGNORE INTO `community` (community_id, community_description, community_name, creation_date, members_count, category_id, user_id)
VALUES(10, 'travel is a community about exploring the world. Your pictures, questions, stories, or any good content is welcome. Clickbait, spam, memes, ads, brochures, classifieds, surveys or self-promotion will be removed.', 'travel', '2010-06-12 07:07:07.0', 0, 2, 4);

INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(1, 5, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', null, -2, null, '2020-02-03', 4, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(2, 2, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.', 'Nunc rhoncus dui vel sem. Sed sagittis.', 84, null, '2019-01-01', 7, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(3, 3, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 14, null, '2020-03-04', 8, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(4, 6, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', -75, null, '2018-08-22', 8, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(5, 7, 'Proin interdum mauris non ligula pellentesque ultrices.', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 11, null, '2019-03-20', 1, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(6, 7, 'Mauris ullamcorper purus sit amet nulla.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', -2, null, '2020-10-26', 6, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(7, 7, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus.', -72, null, '2015-10-07', 8, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(8, 6, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', -73, null, '2017-06-01', 1, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(9, 7, 'Morbi quis tortor id nulla ultrices aliquet.', 'In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', -46, null, '2015-04-20', 7, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(10, 2, 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat.', null, 92, null, '2016-11-16', 8, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(11, 6, 'Nunc purus. Phasellus in felis.', 'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.', 55, null, '2020-10-21', 2, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(12, 3, 'Duis at velit eu est congue elementum.', 'Integer ac leo. Pellentesque ultrices mattis odio.', 28, null, '2016-07-30', 6, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(13, 6, 'In quis justo. Maecenas rhoncus aliquam lacus.', null, 62, null, '2020-07-12', 2, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(14, 3, 'Morbi non quam nec dui luctus rutrum.', 'Phasellus in felis. Donec semper sapien a libero.', 89, null, '2016-02-11', 5, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(15, 5, 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 'Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum.', 51, null, '2017-12-31', 4, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(16, 6, 'Etiam vel augue.', null, 90, null, '2020-11-13', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(17, 4, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit.', 'Proin risus. Praesent lectus.', -40, null, '2018-04-06', 8, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(18, 5, 'Quisque id justo sit amet sapien dignissim vestibulum.', null, 58, null, '2016-07-29', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(19, 4, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', -41, null, '2016-02-05', 2, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(20, 5, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat.', 37, null, '2015-05-27', 9, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(21, 5, 'Duis at velit eu est congue elementum.', 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', -49, null, '2019-06-06', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(22, 4, 'Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', -10, null, '2019-08-20', 5, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(23, 6, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', null, 3, null, '2020-04-08', 4, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(24, 3, 'Ut tellus.', 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.', -89, null, '2015-04-14', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(25, 2, 'Donec ut mauris eget massa tempor convallis.', 'Proin risus.', 73, null, '2020-04-24', 7, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(26, 6, 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat.', null, 8, null, '2015-10-05', 7, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(27, 5, 'Integer ac leo. Pellentesque ultrices mattis odio.', null, -20, null, '2019-11-18', 1, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(28, 2, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', 'Nunc nisl.', 81, 'http://dummyimage.com/215x172.jpg/cc0000/ffffff', '2015-10-31', 1, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(29, 2, 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', -14, null, '2019-10-01', 3, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(30, 7, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', -96, null, '2015-01-03', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(31, 6, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', -86, null, '2015-02-22', 1, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(32, 6, 'Sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 86, null, '2015-02-22', 1, 0);
/*INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(32, 2, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', 'Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', 2, null, '2020-12-27', 10, 0);*/
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(33, 6, 'Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', 'Nulla nisl. Nunc nisl.', 95, null, '2017-06-27', 6, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(34, 6, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', 'In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', -27, null, '2015-10-27', 3, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(35, 3, 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.', 82, null, '2016-01-11', 1, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(36, 7, 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Suspendisse ornare consequat lectus.', 83, null, '2015-05-25', 5, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(37, 2, 'Proin interdum mauris non ligula pellentesque ultrices.', null, -50, null, '2016-07-02', 5, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(38, 2, 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.', -27, null, '2019-09-01', 7, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(39, 5, 'Curabitur gravida nisi at nibh.', null, 0, null, '2017-12-25', 9, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(40, 7, 'Praesent blandit. Nam nulla.', 'Aliquam erat volutpat. In congue.', 86, null, '2016-12-12', 9, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(41, 2, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.', -15, null, '2015-04-10', 2, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(42, 6, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', null, -90, null, '2016-02-10', 5, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(43, 5, 'Aenean sit amet justo.', 'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus.', 59, null, '2020-01-04', 5, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(44, 7, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', -78, null, '2019-02-12', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(45, 6, 'Etiam justo.', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', 0, null, '2019-07-14', 6, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(46, 2, 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.', 'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', -98, null, '2017-07-07', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(47, 2, 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.', 55, null, '2015-01-23', 9, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(48, 2, 'In hac habitasse platea dictumst.', 'Nunc purus.', 76, null, '2018-04-11', 2, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(49, 3, 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', 'Nunc rhoncus dui vel sem.', -90, null, '2016-11-02', 10, 0);
INSERT INTO `POST` (post_id, user_id, title, content, score, image_url, creation_date, community_id, comments_num) VALUES(50, 4, 'Curabitur in libero ut massa volutpat convallis.', null, -8, null, '2020-10-11', 8, 0);

UPDATE `POST` SET image_url = post_id WHERE content is NULL;


INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (1, 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', '2019-09-21', 17, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (2, 'Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', '2020-12-15', 2, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (3, 'Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', '2020-05-22', 15, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (4, 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2020-02-04', 37, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (5, 'Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2020-01-10', 2, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (6, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque.', '2019-09-28', 4, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (7, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', '2019-02-16', 24, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (8, 'In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', '2020-10-05', 29, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (9, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', '2020-09-17', 14, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (10, 'Nulla mollis molestie lorem. Quisque ut erat.', '2020-10-26', 31, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (11, 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.', '2019-10-10', 37, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (12, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.', '2019-08-12', 10, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (13, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', '2020-09-15', 11, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (14, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', '2020-02-23', 42, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (15, 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', '2020-03-20', 10, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (16, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '2019-10-01', 40, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (17, 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2019-06-01', 4, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (18, 'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2019-09-17', 13, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (19, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '2020-12-10', 37, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (20, 'Vivamus tortor. Duis mattis egestas metus.', '2019-06-16', 15, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (21, 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', '2020-10-08', 16, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (22, 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', '2019-03-11', 36, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (23, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2019-08-02', 11, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (24, 'Praesent id massa id nisl venenatis lacinia.', '2019-11-26', 50, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (25, 'Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '2019-11-05', 14, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (26, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', '2020-09-16', 26, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (27, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '2020-07-28', 22, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (28, 'Suspendisse potenti.', '2020-03-31', 19, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (29, 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.', '2019-08-09', 24, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (30, 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2019-06-28', 14, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (31, 'In congue. Etiam justo. Etiam pretium iaculis justo.', '2019-07-15', 11, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (32, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla.', '2019-06-09', 30, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (33, 'Quisque porta volutpat erat.', '2019-12-23', 4, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (34, 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2020-11-01', 18, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (35, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2019-10-02', 48, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (36, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus.', '2019-02-06', 21, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (37, 'Proin eu mi.', '2020-03-31', 43, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (38, 'Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '2019-08-03', 41, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (39, 'Aenean lectus. Pellentesque eget nunc.', '2019-11-16', 3, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (40, 'Praesent blandit. Nam nulla.', '2020-10-16', 22, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (41, 'In blandit ultrices enim.', '2020-05-21', 42, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (42, 'Aenean lectus. Pellentesque eget nunc.', '2019-09-16', 43, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (43, 'Duis bibendum.', '2020-06-28', 49, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (44, 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus.', '2019-01-12', 22, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (45, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2020-01-16', 26, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (46, 'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.', '2020-11-06', 12, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (47, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2019-11-03', 8, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (48, 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2020-02-13', 47, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (49, 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', '2020-04-30', 38, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (50, 'Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2019-02-26', 47, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (51, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2019-09-30', 33, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (52, 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.', '2020-10-13', 20, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (53, 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '2019-10-18', 48, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (54, 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.', '2019-11-19', 15, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (55, 'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2019-08-26', 8, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (56, 'Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2019-08-20', 40, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (57, 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', '2020-05-31', 48, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (58, 'Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis.', '2020-08-23', 7, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (59, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '2020-11-17', 45, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (60, 'Phasellus sit amet erat.', '2020-04-01', 10, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (61, 'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', '2020-07-14', 27, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (62, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2020-12-09', 8, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (63, 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2019-01-23', 27, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (64, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.', '2020-01-31', 47, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (65, 'Nullam varius. Nulla facilisi.', '2019-09-21', 25, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (66, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.', '2020-05-30', 3, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (67, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '2019-05-20', 32, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (68, 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.', '2020-02-24', 18, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (69, 'Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', '2020-04-15', 6, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (70, 'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante.', '2019-03-09', 22, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (71, 'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-09-30', 16, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (72, 'Curabitur convallis.', '2019-03-06', 11, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (73, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue.', '2020-04-02', 49, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (74, 'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', '2020-04-03', 34, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (75, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo.', '2019-12-23', 21, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (76, 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', '2020-10-10', 29, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (77, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2019-11-25', 31, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (78, 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', '2019-05-11', 31, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (79, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', '2019-10-08', 41, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (80, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', '2019-12-15', 37, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (81, 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.', '2020-01-08', 49, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (82, 'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', '2019-05-26', 42, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (83, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo.', '2019-10-18', 37, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (84, 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', '2020-11-06', 36, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (85, 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2020-07-20', 44, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (86, 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', '2020-01-31', 39, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (87, 'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', '2019-11-11', 12, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (88, 'Nulla ut erat id mauris vulputate elementum.', '2019-06-24', 29, 5);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (89, 'In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.', '2019-07-03', 30, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (90, 'Suspendisse potenti.', '2020-02-02', 30, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (91, 'Quisque ut erat.', '2020-10-15', 43, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (92, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2020-03-02', 26, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (93, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', '2020-02-09', 36, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (94, 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2020-09-22', 8, 4);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (95, 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc.', '2019-05-07', 1, 2);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (96, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', '2019-02-01', 36, 6);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (97, 'Mauris sit amet eros.', '2020-11-04', 20, 7);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (98, 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.', '2020-12-10', 40, 3);
INSERT INTO `comment` (comment_id, content, creation_date, post_id, user_id) VALUES (99, 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', '2020-01-16', 47, 3);


UPDATE post INNER JOIN (select post_id, count(post_id) as field2Sum
   from `comment`
  group by post_id) as temp
    ON post.post_id = temp.post_id
SET post.comments_num = temp.field2Sum;


INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 8);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (6, 6);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (6, 2);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (2, 9);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (2, 3);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (5, 2);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (2, 10);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 3);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 1);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (7, 6);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (4, 5);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (4, 1);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 10);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (4, 10);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 5);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (4, 8);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (2, 2);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (5, 8);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 7);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (7, 8);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (4, 2);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (6, 3);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 9);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (7, 5);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (7, 1);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (7, 4);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (2, 5);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (3, 4);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (6, 1);
INSERT INTO `COMMUNITY_MEMBERS` (user_id, community_id) VALUES (5, 10);

insert into feedback (id, content, email, feedback_given_on) values (1, 'installation', 'kkissock0@unc.edu', '2016-01-14');
insert into feedback (id, content, email, feedback_given_on) values (2, 'Managed', 'acarwithan1@ed.gov', '2015-12-26');
insert into feedback (id, content, email, feedback_given_on) values (3, 'Cross-platform', 'tcorde2@imgur.com', '2020-03-28');
insert into feedback (id, content, email, feedback_given_on) values (4, 'upward-trending', 'ccallicott3@webeden.co.uk', '2019-12-24');
insert into feedback (id, content, email, feedback_given_on) values (5, 'extranet', 'kgladman4@samsung.com', '2016-09-16');
insert into feedback (id, content, email, feedback_given_on) values (6, 'challenge', 'gciccottio5@arizona.edu', '2016-03-08');
insert into feedback (id, content, email, feedback_given_on) values (7, 'productivity', 'egoodge6@buzzfeed.com', '2017-11-21');
insert into feedback (id, content, email, feedback_given_on) values (8, 'empowering', 'smcalpin7@hud.gov', '2018-04-17');
insert into feedback (id, content, email, feedback_given_on) values (9, 'Multi-channelled', 'rcaccavari8@tinypic.com', '2017-08-30');
insert into feedback (id, content, email, feedback_given_on) values (10, 'holistic', 'gwheeldon9@storify.com', '2015-06-09');
insert into feedback (id, content, email, feedback_given_on) values (11, 'needs-based', 'rcreggana@msu.edu', '2015-12-12');



insert into saved_posts (user_id, post_id) values (5, 41);
insert into saved_posts (user_id, post_id) values (2, 2);
insert into saved_posts (user_id, post_id) values (2, 32);
insert into saved_posts (user_id, post_id) values (5, 6);
insert into saved_posts (user_id, post_id) values (3, 31);
insert into saved_posts (user_id, post_id) values (3, 39);
insert into saved_posts (user_id, post_id) values (2, 7);
insert into saved_posts (user_id, post_id) values (7, 1);
insert into saved_posts (user_id, post_id) values (4, 45);
insert into saved_posts (user_id, post_id) values (3, 47);
insert into saved_posts (user_id, post_id) values (2, 14);
insert into saved_posts (user_id, post_id) values (7, 9);
insert into saved_posts (user_id, post_id) values (5, 3);
insert into saved_posts (user_id, post_id) values (3, 16);
insert into saved_posts (user_id, post_id) values (3, 27);
insert into saved_posts (user_id, post_id) values (3, 23);
insert into saved_posts (user_id, post_id) values (4, 24);
insert into saved_posts (user_id, post_id) values (2, 35);
insert into saved_posts (user_id, post_id) values (3, 49);
insert into saved_posts (user_id, post_id) values (6, 46);
insert into saved_posts (user_id, post_id) values (6, 39);
insert into saved_posts (user_id, post_id) values (2, 49);
insert into saved_posts (user_id, post_id) values (3, 10);
insert into saved_posts (user_id, post_id) values (2, 15);
insert into saved_posts (user_id, post_id) values (7, 2);
insert into saved_posts (user_id, post_id) values (5, 26);
insert into saved_posts (user_id, post_id) values (5, 40);
insert into saved_posts (user_id, post_id) values (6, 9);
insert into saved_posts (user_id, post_id) values (7, 17);
insert into saved_posts (user_id, post_id) values (4, 50);
insert into saved_posts (user_id, post_id) values (4, 19);
insert into saved_posts (user_id, post_id) values (5, 46);
insert into saved_posts (user_id, post_id) values (7, 50);
insert into saved_posts (user_id, post_id) values (2, 32);
insert into saved_posts (user_id, post_id) values (3, 20);
insert into saved_posts (user_id, post_id) values (7, 25);
insert into saved_posts (user_id, post_id) values (2, 27);
insert into saved_posts (user_id, post_id) values (2, 21);
insert into saved_posts (user_id, post_id) values (3, 34);
insert into saved_posts (user_id, post_id) values (5, 47);
insert into saved_posts (user_id, post_id) values (7, 3);
insert into saved_posts (user_id, post_id) values (7, 4);
insert into saved_posts (user_id, post_id) values (4, 46);
insert into saved_posts (user_id, post_id) values (2, 12);
insert into saved_posts (user_id, post_id) values (2, 18);
insert into saved_posts (user_id, post_id) values (2, 29);
insert into saved_posts (user_id, post_id) values (4, 47);
insert into saved_posts (user_id, post_id) values (4, 22);
insert into saved_posts (user_id, post_id) values (5, 5);
insert into saved_posts (user_id, post_id) values (6, 26);
insert into saved_posts (user_id, post_id) values (2, 17);
insert into saved_posts (user_id, post_id) values (4, 28);
insert into saved_posts (user_id, post_id) values (5, 18);
insert into saved_posts (user_id, post_id) values (6, 24);
insert into saved_posts (user_id, post_id) values (5, 30);
insert into saved_posts (user_id, post_id) values (3, 19);
insert into saved_posts (user_id, post_id) values (4, 36);
insert into saved_posts (user_id, post_id) values (6, 23);
insert into saved_posts (user_id, post_id) values (3, 24);
insert into saved_posts (user_id, post_id) values (7, 41);
insert into saved_posts (user_id, post_id) values (5, 8);
insert into saved_posts (user_id, post_id) values (6, 32);
insert into saved_posts (user_id, post_id) values (4, 13);


insert into vote (user_id, post_id, vote_id, vote) values (3, 27, 1, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 41, 2, 1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 34, 3, 1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 44, 5, 1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 50, 6, 0);
insert into vote (user_id, post_id, vote_id, vote) values (2, 12, 7, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 39, 8, 0);
insert into vote (user_id, post_id, vote_id, vote) values (2, 44, 9, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 35, 10, 0);
insert into vote (user_id, post_id, vote_id, vote) values (3, 7, 11, 0);
insert into vote (user_id, post_id, vote_id, vote) values (2, 7, 12, 1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 22, 13, -1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 27, 14, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 19, 16, 1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 6, 17, -1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 38, 18, 0);
insert into vote (user_id, post_id, vote_id, vote) values (5, 36, 20, 0);
insert into vote (user_id, post_id, vote_id, vote) values (5, 12, 21, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 38, 22, -1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 18, 23, 1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 43, 24, -1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 36, 25, 0);
insert into vote (user_id, post_id, vote_id, vote) values (5, 1, 26, 0);
insert into vote (user_id, post_id, vote_id, vote) values (3, 48, 27, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 49, 28, 0);
insert into vote (user_id, post_id, vote_id, vote) values (2, 30, 29, 1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 27, 30, 1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 22, 31, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 3, 32, 0);
insert into vote (user_id, post_id, vote_id, vote) values (4, 36, 34, 1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 21, 35, 1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 48, 36, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 23, 37, -1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 34, 38, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 41, 39, 0);
insert into vote (user_id, post_id, vote_id, vote) values (4, 2, 40, 1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 4, 41, 0);
insert into vote (user_id, post_id, vote_id, vote) values (4, 15, 42, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 16, 43, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 6, 44, 1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 33, 45, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 10, 47, 1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 32, 49, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 47, 50, 1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 9, 51, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 30, 52, 0);
insert into vote (user_id, post_id, vote_id, vote) values (3, 31, 53, 1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 22, 54, -1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 29, 55, 1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 40, 56, 1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 46, 57, -1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 44, 58, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 45, 59, 1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 5, 61, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 36, 62, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 42, 63, -1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 41, 64, -1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 18, 65, 1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 15, 66, 0);
insert into vote (user_id, post_id, vote_id, vote) values (5, 22, 68, -1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 21, 69, 1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 3, 71, 1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 19, 72, 0);
insert into vote (user_id, post_id, vote_id, vote) values (2, 49, 73, 0);
insert into vote (user_id, post_id, vote_id, vote) values (4, 37, 74, 1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 13, 75, -1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 8, 76, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 37, 78, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 33, 79, 0);
insert into vote (user_id, post_id, vote_id, vote) values (2, 14, 80, -1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 50, 81, 0);
insert into vote (user_id, post_id, vote_id, vote) values (5, 39, 82, 0);
insert into vote (user_id, post_id, vote_id, vote) values (6, 2, 83, 1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 7, 84, 0);
insert into vote (user_id, post_id, vote_id, vote) values (7, 32, 85, 0);
insert into vote (user_id, post_id, vote_id, vote) values (3, 20, 86, -1);
insert into vote (user_id, post_id, vote_id, vote) values (4, 6, 87, 1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 16, 88, 1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 18, 90, 1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 32, 91, -1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 5, 92, -1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 30, 93, 1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 19, 94, -1);
insert into vote (user_id, post_id, vote_id, vote) values (5, 6, 95, 1);
insert into vote (user_id, post_id, vote_id, vote) values (7, 40, 96, -1);
insert into vote (user_id, post_id, vote_id, vote) values (3, 44, 97, 1);
insert into vote (user_id, post_id, vote_id, vote) values (2, 30, 98, 0);
insert into vote (user_id, post_id, vote_id, vote) values (4, 11, 99, 1);
insert into vote (user_id, post_id, vote_id, vote) values (6, 29, 100, 0);




INSERT IGNORE INTO `community_members` (user_id, community_id)
VALUES(2, 1);
