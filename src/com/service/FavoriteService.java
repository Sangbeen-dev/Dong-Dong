package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FavoriteDAO;
import com.dto.FavoriteDTO;
import com.dto.PostDTO;

public class FavoriteService {

	public List<FavoriteDTO> favoriteList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<FavoriteDTO> list = null;
		try {
			FavoriteDAO dao = new FavoriteDAO();
			list = dao.favoriteList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}

	public int deleteFavoriteByPNum(int pNum) {
		SqlSession session = MySqlSessionFactory.getSession();
        int deleteResult = 0;
        try {
        	FavoriteDAO dao = new FavoriteDAO();
            deleteResult = dao.deleteFavoriteByPNum(session, pNum);
            session.commit();
        } catch (Exception e) {
        	session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return deleteResult;
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
	
	public int updateFavoriteByPost(PostDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
	    int updateResult = 0;
	    try {
	    	FavoriteDAO dao = new FavoriteDAO();
	        updateResult = dao.updateFavoriteByPost(session, dto);
	        session.commit();
	    } catch (Exception e) {
	    	session.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return updateResult;
	}

}
