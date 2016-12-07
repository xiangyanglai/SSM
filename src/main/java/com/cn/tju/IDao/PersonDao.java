package com.cn.tju.IDao;

import com.cn.tju.pojo.Person;
import com.cn.tju.util.DataTablePageUtil;

import java.util.List;

public interface PersonDao {

    List<Person> selectPersonByPage(DataTablePageUtil dataTablePageUtil);
    Integer selectPersonPageSize(DataTablePageUtil dataTablePageUtil);
    List<Person> selectAllPerson(DataTablePageUtil dataTablePageUtil);
    Integer selectAllPersonSize();


}