//package com.cassandralearning.democassandra.script;
//
//import com.cassandralearning.democassandra.model.StudentBasicInfo;
//import com.cassandralearning.democassandra.repository.StudentBasicInfoRepository;
//import com.github.javafaker.Faker;
//
//
//public class PopulateStudentBasicInfo extends NullPointerException{
//
//    private static StudentBasicInfoRepository studentBasicInfoRepository;
//    private static StudentBasicInfo studentBasicInfo;
//
//    private static Faker faker = new Faker();
//
//    public static void main(String[] args)  {
//        int id = faker.number().numberBetween(1,10);
//        String name = faker.name().firstName();
//        String password = faker.phoneNumber().phoneNumber();
//        String location = faker.gameOfThrones().city();
//        int age = faker.number().numberBetween(20,50);
//
//        studentBasicInfo = new StudentBasicInfo(id,name,password,location,age);
//        studentBasicInfoRepository.save(studentBasicInfo);
//    }
//}
