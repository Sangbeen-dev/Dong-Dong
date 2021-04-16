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
			list = dao.postListAll(session);
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
    public PostDTO getPostByPNum(int pNum) {
        SqlSession session = MySqlSessionFactory.getSession();
        PostDTO dto = null;
        try {
            PostDAO dao = new PostDAO();
            dto = dao.getPostByPNum(session, pNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dto;
    }

	public int deletePostByPNum(int pNum) {
		SqlSession session = MySqlSessionFactory.getSession();
        int deleteResult = 0;
        try {
            PostDAO dao = new PostDAO();
            deleteResult = dao.deletePostByPNum(session, pNum);
            if(deleteResult!=1) {
            	session.rollback();
            } else {
            	session.commit();
            }
        } catch (Exception e) {
        	session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return deleteResult;
	}
}// end class

