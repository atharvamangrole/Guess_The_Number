package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Initial;

@Repository
public class InitialDAOImpl implements InitialDAO {
				
				
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int save(Initial initial) {
		
		
		List<Integer> numbers = new ArrayList<>();
		for(int i=0;i<10;i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		int FNUM = numbers.get(0);
		int SNUM = numbers.get(1);
		int TNUM = numbers.get(2);
		int FONUM = numbers.get(3);
		int fnum = initial.getFnum();
		int snum = initial.getSnum();
		int tnum = initial.getTnum();
		int fonum = initial.getFonum();
		int e = 0;
		int p = 0;
		for (int s = 0; s<1;s++ ) {
			if (fnum == FNUM ) {
				e += 1;
				s += 1;
			}
			if (snum == SNUM ) {
				e += 1;
				s += 1;
			}
			if (tnum == TNUM ) {
				e += 1;
				s += 1;
			}
			if (fonum == FONUM ) {
				e += 1;
				s += 1;
			}
			if ( fnum == SNUM || fnum == TNUM || fnum == FONUM) {
				p += 1;
				s += 1;
			}
			if (snum == FNUM || snum == TNUM || snum == FONUM) {
				p += 1;
				s += 1;
			}
			if (tnum == FNUM || tnum == SNUM || tnum == FONUM) {
				p += 1;
				s += 1;
			}
			if (fonum == FNUM || fonum == SNUM || fonum == TNUM) {
				p += 1;
				s += 1;
			}
		}
		System.out.println("e="+e+"p="+p);
		
		return jdbcTemplate.update("INSERT INTO play (fnum, snum, tnum, fonum) VALUES (?,?,?,?)", 
				new Object[] {initial.getFnum(),initial.getSnum(), initial.getTnum(), initial.getFonum()});
		
		
	}

	
	//get all records
	@Override
	public List<Initial> getALL() {
		return jdbcTemplate.query("SELECT * FROM SCORES", new BeanPropertyRowMapper<Initial>(Initial.class) );
	}

	@Override
	public Initial getById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM SCORES WHERE id=?", new BeanPropertyRowMapper<Initial>(Initial.class), id);
	}

}
