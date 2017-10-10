package com.exam.Manytodemo.implementation;

import com.exam.Manytodemo.repository.Impl_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by melayer on 9/10/17.
 */
@Repository
public class Impl_Join_Query implements Impl_Repo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getdata(Integer id) {
        String query="select j.subject_id, s.subject_name from joined_tab j join subject s where j.subject_id=s.subject_id and j.student_id=?";
        List<Map<String, Object>> list= jdbcTemplate.queryForList(query,new Object[]{id});
        return list;
    }
}
