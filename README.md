<img src="https://user-images.githubusercontent.com/36390038/95302811-12e94880-08a0-11eb-90cd-72f57e65838f.png" alt="WeShare Logo" width="100" height="100" style="display:inline" align="left">

# WeShare

![GitHub last commit](https://img.shields.io/github/last-commit/rvkantpujari/weshare?color=blue&style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/rvkantpujari/weshare?color=lightcoral&style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/rvkantpujari/weshare?color=green&style=for-the-badge)

> #### This project aims to provide a platform to create & manage communities where people can share and search for information or content based on their interests.


## Requirements
1. JDK 1.8
2. MySQL 5.5
3. Spring Tool Suite 4 
4. Lombok JAR with installation in STS 4


## Steps to Setup

**1. First setup JDK8, MySQL5.5, STS4 and Lombok.**

**2. Clone this repository.**

```bash
git clone https://github.com/rvkantpujari/weshare
```

**3. Create a MySQL database.**
```bash
create database WeShare
```

**4. Change the below details as per your configuration.**
+ open `src/main/resources/application.properties` in your application.
+ change `connection URL`, `username` and `password` as per your MySQL configuration in your application.

**5. Create a folder named postImages as `src/main/resources/static/postImages` to store images of your post.**

**6. Now you can run the app using maven from CMD.**
```bash
mvnw spring-boot:run
```

**7. Open your chrome browser and visit the below URL.** 
+ The application will start running at <http://localhost:8080>.

## Application Logins

Initially there are some users in memory. You can login as following or register yourself with your details:

ID: ```admin``` Password: ```1234``` with **ADMIN** role.

ID: ```abhi``` Password: ```1234``` with **USER** role.

## Common Functionalities [Non-registered user]
+ Register with email verification and login accordingly.
+ View all posts and comments.
+ View Categories and filter communities by category.
+ View popular communities.
+ Search any post or community.
+ Sort posts according to Most liked/Most Commented/Newest.
+ Give feedback.

## Functionalities [ADMIN]
+ Add/edit categories of communities.
+ View/Delete any post or comments.
+ View all feedbacks.
+ Block/Unblock users.
+ View Categories and filter communities by category.
+ View popular communities.
+ Search any post or community.
+ Sort posts according to Most liked/Most Commented/Newest.

## Functionalities [Registered USER]

+ View timeline where they can see popular communities, list of their joined communities and it's posts.
+ View Categories and filter communities by category.
+ Create new community.
+ Join/Leave any community.
+ Upvote/Downvote any post.
+ Save/Unsave any post.
+ Create 3 types of post [Textual/Image/Link].
+ Give comments on any post.
+ Delete own posts/comments.
+ Manage profile and change the password.
+ View popular communities.
+ Search any post or community.
+ Sort posts according to Most liked/Most Commented/Newest.
+ Give feedback.
