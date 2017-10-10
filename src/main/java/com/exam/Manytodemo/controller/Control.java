package com.exam.Manytodemo.controller;

import com.exam.Manytodemo.model.Student;
import com.exam.Manytodemo.model.Subject;
import com.exam.Manytodemo.repository.Impl_Repo;
import com.exam.Manytodemo.repository.Student_Repo;
import com.exam.Manytodemo.repository.Subject_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by melayer on 7/10/17.
 */
@RestController
public class Control {
    @Autowired
    Student_Repo student_repo;

    @Autowired
    Subject_Repo subject_repo;

    @Autowired
    Impl_Repo impl_repo;


    @PostMapping(value = "/datainsert")
    String insert(@RequestBody Student student){
        student_repo.save(student);
        return "Data Inserted..!";
    }


    @GetMapping(value = "getdata")
    List<Map<String, Object>> getdata(@RequestParam Integer id){
        List<Map<String, Object>> list= impl_repo.getdata(id);
        return list;
    }

    @PostMapping(value = "/updatedata")
    String update(@RequestBody Student student){
        Integer stud_id=student.getStudent_id();
        Student dbstud= student_repo.findOne(stud_id);
        if(dbstud!=null){
            Set<Subject> sblist=dbstud.getSubject();
            sblist.addAll(student.getSubject());
            student.setSubject(sblist);
            student_repo.save(student);
            return "Data inserted into student where id Already Present";
        }else{
            student_repo.save(student);
            return "Data insertd into Student";
        }

    }

}
