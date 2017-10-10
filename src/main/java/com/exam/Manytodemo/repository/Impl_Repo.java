package com.exam.Manytodemo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by melayer on 9/10/17.
 */
@Repository
public interface Impl_Repo  {
    List<Map<String,Object>> getdata(Integer id);
}
