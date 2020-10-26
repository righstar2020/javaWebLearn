package com.hb.service;
import com.hb.bean.User;
public class UserCheck {
	public boolean validate(User user)
	{
		if(user!=null&&user.getName().equals("user"))
		{
			if(user.getPwd().equals("123"))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	

}
