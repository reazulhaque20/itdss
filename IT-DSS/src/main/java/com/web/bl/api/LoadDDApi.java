package com.web.bl.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.bl.dao.DropdownHome;
import com.web.bl.model.Dropdown;

@RestController
public class LoadDDApi {
	
	@Autowired
	private DropdownHome dropdownHome;
	
	
	@RequestMapping(value="loadDD/{ddName}", method=RequestMethod.GET)
	public ResponseEntity<List<Dropdown>> loadDD(@PathVariable("ddName") String ddName) {
		List<Dropdown> listDropdowns = new ArrayList<Dropdown>();
		
		listDropdowns = dropdownHome.findByName(ddName);
		
		return new ResponseEntity<List<Dropdown>>(listDropdowns, HttpStatus.OK);
	}

}
