package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.PostDAO;
import com.dto.PostDTO;

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
