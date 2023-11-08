package com.performancetests.demomysqlvsmongodbperformance.Service;

import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB.MongoPost;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB.MongoPostRepo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB.MongoUser;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB.MongoUserRepo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlPost;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlPostRepo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlUser;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlUserRepo;
import com.performancetests.demomysqlvsmongodbperformance.repos.MongoRepo;
import com.performancetests.demomysqlvsmongodbperformance.repos.MySQLRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RelationalStartTest {
    private final SqlUserRepo mySQLRepo;
    private final SqlPostRepo sqlPostRepo;
    private final MongoUserRepo mongoRepo;
    private final MongoPostRepo mongoPostRepo;


    public void speedTestSingleInsertOfRelationship() throws InterruptedException {

        new Thread() {
            public void run() {
                log.info("MySQL started at : " + LocalDateTime.now());
                long date = new Date().getTime();
                SqlUser sqlUser = SqlUser.builder()
                        .username("user1")
                        .build();

                mySQLRepo.save(sqlUser);

                SqlPost sqlPost = SqlPost.builder()
                        .title("title1")
                        .content("content1")
                        .sqlUser(sqlUser)
                        .build();
                sqlPostRepo.save(sqlPost);

                log.info("MySQL finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();
            }
        }.start();

        new Thread() {
            public void run() {
                log.info("MongoDB started at : " + LocalDateTime.now());
                long date = new Date().getTime();
               MongoUser mongoUser = MongoUser.builder()
                        .username("user1")
                        .build();

                mongoRepo.save(mongoUser);

                MongoPost mongoPost = MongoPost.builder()
                        .title("title1")
                        .content("content1")
                        .userId(mongoUser.getId())
                        .build();

                mongoPostRepo.save(mongoPost);

                log.info("MongoDB finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();
            }

        }.start();


    }


    public void speedTestSelectAllRelationShip() throws InterruptedException {

        new Thread() {
            public void run() {

                sqlPostRepo.deleteAll();
                mySQLRepo.deleteAll();


                SqlUser sqlUser = SqlUser.builder()
                        .username("user1")
                        .build();

                mySQLRepo.save(sqlUser);
                log.info("MySQL started at to insert posts : " + LocalDateTime.now());
                long date = new Date().getTime();
                for (int i = 0; i < 1000; i++) {
                    SqlPost sqlPost = SqlPost.builder()
                            .title("title" + i)
                            .content("content" + i)
                            .sqlUser(sqlUser)
                            .build();
                    sqlPostRepo.save(sqlPost);
                }
                log.info("MySQL finished in to insert posts : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");

                log.info("MySQL started at : " + LocalDateTime.now());
                date = new Date().getTime();

                List<SqlPost> sqlPosts = sqlPostRepo.findAllBySqlUser(sqlUser);

                log.info("MySQL finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                log.info("MySQL size : " + sqlPosts.size());
                this.interrupt();
            }
        }.start();

        new Thread() {
            public void run() {

                mongoPostRepo.deleteAll();
                mongoRepo.deleteAll();
                MongoUser mongoUser = MongoUser.builder()
                        .username("user1")
                        .build();
                mongoRepo.save(mongoUser);
                log.info("MongoDB started at to insert posts : " + LocalDateTime.now());
                long date = new Date().getTime();
                for (int i = 0; i < 1000; i++) {
                    MongoPost mongoPost = MongoPost.builder()
                            .title("title" + i)
                            .content("content" + i)
                            .userId(mongoUser.getId())
                            .build();
                    mongoPostRepo.save(mongoPost);
                }
                log.info("MongoDB finished in to insert posts : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                log.info("MongoDB started at : " + LocalDateTime.now());
                date = new Date().getTime();

                List<MongoPost> posts = mongoPostRepo.findAllByUserId(mongoUser.getId());
                log.info("MongoDB finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                log.info("MongoDB size : " + posts.size());
                this.interrupt();
            }

        }.start();
    }
}
