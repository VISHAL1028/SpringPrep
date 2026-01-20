package org.example.dao.impl;

import org.example.dao.ReportDao;
import org.springframework.stereotype.Repository;

@Repository("abc")
public class OracleReport  implements ReportDao {
    @Override
    public void getReport(){
        System.out.println("Getting report from Oracle database");
    }
}
