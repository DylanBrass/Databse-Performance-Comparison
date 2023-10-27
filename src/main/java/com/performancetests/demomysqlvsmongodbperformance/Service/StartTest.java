package com.performancetests.demomysqlvsmongodbperformance.Service;

import com.performancetests.demomysqlvsmongodbperformance.Entities.TestEntityMongo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.TestEntityMySql;
import com.performancetests.demomysqlvsmongodbperformance.repos.MongoRepo;
import com.performancetests.demomysqlvsmongodbperformance.repos.MySQLRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class StartTest {
    private final MySQLRepo mySQLRepo;
    private final MongoRepo mongoRepo;

    public void startTest() {
        log.info("Starting single insert test");
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(200);
                mySQLRepo.save(TestEntityMySql.builder()
                        .testString("Test String")
                        .testInt(1)
                        .testFloat(1.0f)
                        .testBoolean(true)
                        .testDate(java.time.LocalDate.now())
                        .build());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        log.info("Starting four inserts test");

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(100);
                mySQLRepo.saveAll(List.of(
                        TestEntityMySql.builder()
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build(),
                        TestEntityMySql.builder()
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build(),
                        TestEntityMySql.builder()
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build(),
                        TestEntityMySql.builder()
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void startMongoTest() {
        log.info("Starting single insert test");
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(200);
                System.out.println("Sleeping");
                mongoRepo.save(TestEntityMongo.builder()
                        .id(UUID.randomUUID().toString())
                        .testString("Test String")
                        .testInt(1)
                        .testFloat(1.0f)
                        .testBoolean(true)
                        .testDate(java.time.LocalDate.now())
                        .build());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("Starting four inserts test");
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(100);
                System.out.println("Sleeping");
                mongoRepo.saveAll(List.of(TestEntityMongo.builder()
                                .id(UUID.randomUUID().toString())
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build(),
                        TestEntityMongo.builder()
                                .id(UUID.randomUUID().toString())
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build(),
                        TestEntityMongo.builder()
                                .id(UUID.randomUUID().toString())
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build(),
                        TestEntityMongo.builder()
                                .id(UUID.randomUUID().toString())
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void speedTestSingleInsert() throws InterruptedException {

        new Thread() {
            public void run() {
                log.info("MongoDB started at : " + LocalDateTime.now());
                int i = 0;
                long date = new Date().getTime();
                for (; i < 10000; i++) {
                    mongoRepo.save(TestEntityMongo.builder()
                            .id(UUID.randomUUID().toString())
                            .testString("Test String")
                            .testInt(1)
                            .testFloat(1.0f)
                            .testBoolean(true)
                            .testDate(java.time.LocalDate.now())
                            .build());
                }

                log.info("Mongo finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();

            }
        }.start();

        new Thread() {
            public void run() {
                int i = 0;
                log.info("MySQL started at : " + LocalDateTime.now());
                long date = new Date().getTime();

                for (; i < 10000; i++) {
                    mySQLRepo.save(TestEntityMySql.builder()
                            .testString("Test String")
                            .testInt(1)
                            .testFloat(1.0f)
                            .testBoolean(true)
                            .testDate(java.time.LocalDate.now())
                            .build());
                }


                log.info("MySQL finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();
            }

        }.start();

    }


    public void speedTestBulkInsert() {

        new Thread() {
            public void run() {
                log.info("MongoDB started at : " + LocalDateTime.now());
                int i = 0;
                long date = new Date().getTime();
                ArrayList<TestEntityMongo> testEntityMongoArrayList = new ArrayList<>();
                for (; i < 100; i++) {
                    for (int j = 0; j < 100; j++) {
                        testEntityMongoArrayList.add(TestEntityMongo.builder()
                                .id(UUID.randomUUID().toString())
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build());
                    }
                    mongoRepo.saveAll(testEntityMongoArrayList);
                    testEntityMongoArrayList.clear();
                }

                log.info("Mongo finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();

            }
        }.start();

        new Thread() {
            public void run() {
                int i = 0;
                log.info("MySQL started at : " + LocalDateTime.now());
                long date = new Date().getTime();
                ArrayList<TestEntityMySql> testEntityMySql = new ArrayList<>();

                for (; i < 100; i++) {
                    for (int j = 0; j < 100; j++) {
                        testEntityMySql.add(TestEntityMySql.builder()
                                .testString("Test String")
                                .testInt(1)
                                .testFloat(1.0f)
                                .testBoolean(true)
                                .testDate(java.time.LocalDate.now())
                                .build());
                    }
                    mySQLRepo.saveAll(testEntityMySql);
                    testEntityMySql.clear();
                }
                log.info("MySQL finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();
            }

        }.start();

    }

    public void speedTestSelect() {
        new Thread() {
            public void run() {
                int i = 0;
                ArrayList<TestEntityMongo> testEntityMongoArrayList = new ArrayList<>();
                for (; i < 10000; i++) {
                    testEntityMongoArrayList.add(TestEntityMongo.builder()
                            .id(UUID.randomUUID().toString())
                            .testString("Test String")
                            .testInt(1)
                            .testFloat(1.0f)
                            .testBoolean(true)
                            .testDate(java.time.LocalDate.now())
                            .build());

                }

                mongoRepo.saveAll(testEntityMongoArrayList);

                log.info("Mongo started at : " + LocalDateTime.now());
                long date = new Date().getTime();

                List<TestEntityMongo> all = mongoRepo.findAll();

                log.info("Mongo finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");


                this.interrupt();

            }
        }.start();

        new Thread() {
            public void run() {
                int i = 0;

                ArrayList<TestEntityMySql> testEntityMySql = new ArrayList<>();

                for (; i < 10000; i++) {
                    testEntityMySql.add(TestEntityMySql.builder()
                            .testString("Test String")
                            .testInt(1)
                            .testFloat(1.0f)
                            .testBoolean(true)
                            .testDate(java.time.LocalDate.now())
                            .build());

                }
                mySQLRepo.saveAll(testEntityMySql);
                log.info("MySQL started at : " + LocalDateTime.now());
                long date = new Date().getTime();

                Iterable<TestEntityMySql> all = mySQLRepo.findAll();
                log.info("MySQL finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();

            }
        }.start();
    }


    public void speedDeleteRace(){
        new Thread(){
            public void run() {
                int i = 0;
                ArrayList<TestEntityMongo> testEntityMongoArrayList = new ArrayList<>();
                for (; i < 10000; i++) {
                    testEntityMongoArrayList.add(TestEntityMongo.builder()
                            .id(UUID.randomUUID().toString())
                            .testString("Test String")
                            .testInt(1)
                            .testFloat(1.0f)
                            .testBoolean(true)
                            .testDate(java.time.LocalDate.now())
                            .build());

                }

                mongoRepo.saveAll(testEntityMongoArrayList);

                log.info("Mongo started at : " + LocalDateTime.now());
                long date = new Date().getTime();

               mongoRepo.deleteAll();

                log.info("Mongo finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");


                this.interrupt();

            }
        }.start();

        new Thread(){
            public void run() {
                int i = 0;

                ArrayList<TestEntityMySql> testEntityMySql = new ArrayList<>();

                for (; i < 10000; i++) {
                    testEntityMySql.add(TestEntityMySql.builder()
                            .testString("Test String")
                            .testInt(1)
                            .testFloat(1.0f)
                            .testBoolean(true)
                            .testDate(java.time.LocalDate.now())
                            .build());

                }
                mySQLRepo.saveAll(testEntityMySql);
                log.info("MySQL started at : " + LocalDateTime.now());
                long date = new Date().getTime();

                mySQLRepo.deleteAll();
                log.info("MySQL finished in : " + String.format("%.2f", (float) ((new Date().getTime() - date) / 1000.0)) + "s");
                this.interrupt();
            }
        }.start();
    }

}
