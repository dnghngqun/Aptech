package org.example.school_system_analysis;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,String> {
    List<Student> findAll();


    @Aggregation(pipeline = {
            "{$match: {$expr: {$and: [{$eq: [{$month: '$Date'}, ?0]},{$eq: [{$year: '$Date'}, ?1]}]}}}",
            " {$addFields: {DateString: {$dateToString: {format: '%Y-%m-%d', date: '$Date'}}}}",
            "{$project: {_id: 0, Date: 0}}"
    })
    List<Student> findAllByMonth(int month, int year);
}
