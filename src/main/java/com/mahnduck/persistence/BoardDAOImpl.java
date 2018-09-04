package com.mahnduck.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mahnduck.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	// 나중에 Template으로도 test 
	
	
	private static String namespace = "com.mahnduck.mapper.BoardMapper";
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace +".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public int delete(Integer bno) throws Exception {
		return session.delete(namespace + ".delete", bno);
	}
	/*
	@Override
	public boolean delete(Integer bno) throws Exception {
		 return session.delete(namespace + ".delete", bno);
	}
	*/

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
