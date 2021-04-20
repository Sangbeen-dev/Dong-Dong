package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.FavoriteDTO;

public class FavoriteDAO {

	public List<FavoriteDTO> favoriteList(SqlSession session, String userid) {
		List<FavoriteDTO> list = session.selectList("FavoriteMapper.favoriteList", userid);
		return list;
	}

	public int deleteFavoriteByPNum(SqlSession session, int pNum) {
		return session.delete("FavoriteMapper.deleteFavoriteByPNum",pNum);
	}

	public FavoriteDTO getFavorite(SqlSession session, FavoriteDTO dto) {
		FavoriteDTO returnDTO = session.selectOne("FavoriteMapper.getFavorite", dto);
		return returnDTO;
	}

	public int insertFavoite(SqlSession session, FavoriteDTO fDTO) {
		return session.insert("FavoriteMapper.insertFavoite",fDTO);
	}

	public int deleteFavoite(SqlSession session, FavoriteDTO fDTO) {
		return session.delete("FavoriteMapper.deleteFavoite",fDTO);
	}

}
