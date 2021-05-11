package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FavoriteDAO;
import com.dto.FavoriteDTO;
import com.dto.PostDTO;

public class FavoriteService {

	public List<PostDTO> favoriteList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<PostDTO> list = null;
		try {
			FavoriteDAO dao = new FavoriteDAO();
			list = dao.favoriteList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}

	public FavoriteDTO getFavorite(FavoriteDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		FavoriteDTO returnDTO = null;
		try {
			FavoriteDAO dao = new FavoriteDAO();
			returnDTO = dao.getFavorite(session, dto);
		} finally {
			session.close();
		}
		return returnDTO;
	}

	public int insertFavoite(FavoriteDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
        int insertResult = 0;
        try {
        	FavoriteDAO dao = new FavoriteDAO();
            insertResult = dao.insertFavoite(session, dto);
            session.commit();
        } catch (Exception e) {
        	session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return insertResult;
	}

	public int deleteFavoite(FavoriteDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
	    int deleteResult = 0;
	    try {
	    	FavoriteDAO dao = new FavoriteDAO();
	        deleteResult = dao.deleteFavoite(session, dto);
	        session.commit();
	    } catch (Exception e) {
	    	session.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return deleteResult;
	}

	public int favoriteDel(int num) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavoriteDAO dao = new FavoriteDAO();
			n = dao.favoriteDel(session, num);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}

	public int favoriteAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n =0;
		try {
			FavoriteDAO dao = new FavoriteDAO();
			n = dao.favoriteAllDel(session, list);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}

	public int getFavoriteCountByPNum(int pNum) {
		SqlSession session = MySqlSessionFactory.getSession();
		int count = 0;
		try {
			FavoriteDAO dao = new FavoriteDAO();
			count = dao.getFavoriteCountByPNum(session, pNum);
		} finally {
			session.close();
		}
		return count;
	}

}
