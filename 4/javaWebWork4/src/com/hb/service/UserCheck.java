package com.hb.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hb.bean.User;
import com.hb.dao.UserDao;
public class UserCheck {
	private UserDao userDao;
	public User validate(User user)
	{
		this.userDao = new UserDao();
		
		
		if(user!=null&&user.getName()!="")
		{   
			List<Map<String, Object>> parmList = new ArrayList<Map<String,Object>>();
			Map<String, Object> parm= new HashMap<String,Object>();
			parm.put("col", "name");
			parm.put("rel", "=");
			parm.put("value",user.getName());
			parmList.add(parm);
			List<User> userT = userDao.queryByParams(parmList);
			if(userT.size()==0)return null;
			User userC = userT.get(0);
			if(user.getPwd().equals(userC.getPwd()))
			{
				return userC;
			}
			return null;
		}
		return null;
	}
	

}
