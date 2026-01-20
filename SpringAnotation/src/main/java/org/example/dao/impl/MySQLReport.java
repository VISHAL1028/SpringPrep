package org.example.dao.impl;

import org.example.dao.ReportDao;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MySQLReport implements ReportDao {
    @Override
    public void getReport(){
        System.out.println("Getting report from MySQL database");
    }
}
