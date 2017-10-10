package com.exam.Manytodemo.repository;

import com.exam.Manytodemo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by melayer on 7/10/17.
 */
@Repository
public interface Subject_Repo extends JpaRepository<Subject, Integer> {

}
