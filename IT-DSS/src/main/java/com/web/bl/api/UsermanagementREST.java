package com.web.bl.api;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.web.bl.dao.UserandusergroupmapHome;
import com.web.bl.dao.UsersHome;
import com.web.bl.model.Userandusergroupmap;
import com.web.bl.model.Users;
import com.web.bl.utility.ProtectedConfigFile;

@RestController
public class UsermanagementREST {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserandusergroupmapHome userandusergroupmapHome;
	
	@Autowired
	private UsersHome userHome;

	@RequestMapping(value="/login/{userName}/{password}", method=RequestMethod.GET)
	public ResponseEntity<Userandusergroupmap> login(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		Userandusergroupmap userandusergroupmap = new Userandusergroupmap();
		//Usergrouppageaccess usergrouppageaccess = new Usergrouppageaccess();
		
		/*Test Code*/
		
		/*if(userName.equals("r") && password.equals("r")) {
			httpSession.setAttribute("userName", userName);
			httpSession.setAttribute("userAndUserGroupMap", userandusergroupmap);
			return new ResponseEntity<Userandusergroupmap>(userandusergroupmap, HttpStatus.OK);
		}*/
		
		/*End of Test code*/
		
		try
		{
		
			try {
				password = ProtectedConfigFile.encrypt(password);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			try {
				userandusergroupmap = userandusergroupmapHome.getUserandUserGroupMapByUserNameandPassword(userName, password); //Need to open
				
				if(userandusergroupmap != null) {
					//System.out.println("User Found. Name is: "+ userandusergroupmap.getUsers().getNetworkid());
					httpSession.setAttribute("userName", userName);
					httpSession.setAttribute("userAndUserGroupMap", userandusergroupmap);
					httpSession.setAttribute("userRole", userandusergroupmap.getUsers().getRoletype());
					return new ResponseEntity<Userandusergroupmap>(userandusergroupmap, HttpStatus.OK);
				} else
				{
					return new ResponseEntity<Userandusergroupmap>(userandusergroupmap, HttpStatus.EXPECTATION_FAILED);
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
				userandusergroupmap = null;
				return new ResponseEntity<Userandusergroupmap>(userandusergroupmap, HttpStatus.EXPECTATION_FAILED);
			}
			

		//return new ResponseEntity<Userandusergroupmap>(userandusergroupmap, HttpStatus.EXPECTATION_FAILED);
		
		} catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<Userandusergroupmap>(userandusergroupmap, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@RequestMapping(value="doRegistration/", method=RequestMethod.POST)
	public void doRegistration(@RequestBody Users users) {
		try {
			System.out.println("User is: "+ users.getNetworkid());
			//System.out.println("Users ID: "+ userHome.getUsersID());
			String password = ProtectedConfigFile.encrypt(users.getPassword());
			users.setPassword(password);
			userHome.persist(users); //Need to open
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
