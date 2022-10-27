package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Initial;

public interface InitialDAO {
	
	int save(Initial initial);
	
	List<Initial> getALL(); //get all records
	
	Initial getById(int id); //get mentioned record
}
