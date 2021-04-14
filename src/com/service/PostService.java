package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import com.config.MySqlSessionFactory;
import com.dto.PostDTO;
import com.dto.MemberDTO;

public class PostService {
	 
	  
	  public List<PostDTO> postList(String gCategory) {
			SqlSession session = MySqlSessionFactory.getSession();
			List<PostDTO> list = null;
			try {
				PostDAO dao = new PostDAO();
				 list = dao.goodsList(session, gCategory);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return list;
		}//end idCheck
}//end class
