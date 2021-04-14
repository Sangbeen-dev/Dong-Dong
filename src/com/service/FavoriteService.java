package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FavoriteDAO;
import com.dto.FavoriteDTO;

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

}
