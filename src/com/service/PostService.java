package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FavoriteDAO;
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
            PostDAO pDAO = new PostDAO();
            FavoriteDAO fDAO = new FavoriteDAO();
            int pDeleteResult = pDAO.deletePostByPNum(session, pNum);
            int favoriteConut = fDAO.selectCountByPNum(session, pNum);
            int fDeleteResult = fDAO.deleteFavoriteByPNum(session, pNum);
            if(pDeleteResult==1 && favoriteConut==fDeleteResult) {
            	session.commit();
            	deleteResult = 1;
            } else {
            	session.rollback();
            	deleteResult = 0;
            }
        } catch (Exception e) {
        	session.rollback();
        	deleteResult = 0;
            e.printStackTrace();
        } finally {
            session.close();
        }
        return deleteResult;
	}

	public int newPost(PostDTO post) {
		SqlSession session = MySqlSessionFactory.getSession();
		int result = 0;
		try {
			PostDAO dao = new PostDAO();
			result = dao.newPost(session, post);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public int updatePost(PostDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
        int updateResult = 0;
        try {
            PostDAO pDAO = new PostDAO();
            FavoriteDAO fDAO = new FavoriteDAO();
            int pUpdateResult = pDAO.updatePost(session, dto);
            int favoriteCount = fDAO.selectCountByPNum(session, dto.getpNum());
	        int fUpdateResult = fDAO.updateFavoriteByPost(session, dto);
            if(pUpdateResult==1 && fUpdateResult==favoriteCount) {
            	session.commit();
            	updateResult = 1;
            } else {
            	session.rollback();
            	updateResult=0;
            }
        } catch (Exception e) {
        	session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return updateResult;

	}

	public int updatePHit(PostDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
        int updateResult = 0;
        try {
            PostDAO pDAO = new PostDAO();
	    	FavoriteDAO fDAO = new FavoriteDAO();
            int pUpdateResult = pDAO.updatePHit(session, dto);
            int favoriteCount = fDAO.selectCountByPNum(session, dto.getpNum());
            int fUpdateResult = fDAO.updateFavoriteByPost(session, dto);
            if(pUpdateResult==1 && (fUpdateResult==favoriteCount)) {
            	session.commit();
            	updateResult = 1;
            } else {
            	session.rollback();
            	updateResult = 0;
            }
        } catch (Exception e) {
        	session.rollback();
        	updateResult = 0;
            e.printStackTrace();
        } finally {
            session.close();
        }
        return updateResult;
	}
}// end class

