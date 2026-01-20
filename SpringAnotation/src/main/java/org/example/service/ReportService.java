package org.example.service;

import org.example.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
//            @Qualifier("abc")
    ReportDao dao;          /*MYSQL ,Orcale field level injection*/
    public void generateReport(){
        dao.getReport();
        System.out.println("Report generated");
    }

}
