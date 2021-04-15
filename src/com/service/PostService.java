package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.PostDAO;
import com.dto.PostDTO;

public class PostService {

	public List<PostDTO> postListAll() {
		SqlSession session = MySqlSessionFactory.getSession();
		List<PostDTO> list = null;
		try {
			PostDAO dao = new PostDAO();
			System.out.println("service->postListAll불러짐");
			list = dao.postListAll(session);
			System.out.println("service->postListAll->list값 받아옴");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<PostDTO> postListByAddr(String addr){
		SqlSession session = MySqlSessionFactory.getSession();
		List<PostDTO> list = null;
		try {
			PostDAO dao = new PostDAO();
			list = dao.postListByAddr(session, addr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	public HashMap<String, String> getPostDetailByPNum(int pNum) {
		SqlSession session = MySqlSessionFactory.getSession();
		HashMap<String, String> map = null;
		try {
			PostDAO dao = new PostDAO();
			map = dao.getPostDetailByPNum(session, pNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return map;
	}

}// end class
