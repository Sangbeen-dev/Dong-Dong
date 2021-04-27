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
            deleteResult = pDAO.deletePostByPNum(session, pNum);
            if(deleteResult==1) {
            	session.commit();
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
            e.printStackTrace();
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
            updateResult = pDAO.updatePost(session, dto);
            if(updateResult==1) {
            	session.commit();
            } else {
            	session.rollback();
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
            updateResult = pDAO.updatePHit(session, dto);
            if(updateResult==1) {
            	session.commit();
            } else {
            	session.rollback();
            }
        } catch (Exception e) {
        	session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return updateResult;
	}


	public List<PostDTO> searchByKeyword(String keyword) {
		SqlSession session = MySqlSessionFactory.getSession();
        List<PostDTO> list = null;
        try {
            PostDAO dao = new PostDAO();
            list = dao.searchByKeyword(session, keyword);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}
	public List<PostDTO> mypostList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<PostDTO> list = null;
		try {
			PostDAO dao = new PostDAO();
			list = dao.mypostList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}//end mypostList

	public int postAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n =0;
		try {
			PostDAO dao = new PostDAO();
			n = dao.postAllDel(session, list);
			session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;

	}
}// end class

