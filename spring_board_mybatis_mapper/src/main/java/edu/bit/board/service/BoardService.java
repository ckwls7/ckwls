package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {//비지니스 로직이 들어가야함
	
	@Autowired
	BoardMapper boardMapper;
	
	//비지니스로직,게시판List를 위한 출력하는로직
	public List<BoardVO> selectBoardList(){
		return boardMapper.selectBoardList();
	}
	
	//게시판에서 리플을 쓰는 로직 
	//2개를 호출하는것이 비지니스로직
	public void writeReply(BoardVO boardVO) {
		boardMapper.updateShape(boardVO);
		boardMapper.insertReply(boardVO);
	}

	public void insertBoard(BoardVO boardVO) {
		
		boardMapper.insertBoard(boardVO);
		
	}

	public BoardVO selectBoardOne(String bId) {
	
		return boardMapper.selectBoardOne(bId);
	}

	public void updateBoard(BoardVO boardVO) {
		
		boardMapper.updateBoard(boardVO);
		
	}

	public void Delete(BoardVO boardVO) {
		// TODO Auto-generated method stub\
		boardMapper.Delete(boardVO);
		
	}

	public int selectCountBoard() {
		
		return boardMapper.selectCountBoard();
	}
	
	public List<BoardVO> selectBoardListPage(Criteria criteria){
		return boardMapper.selectBoardListPage(criteria);
	}




}
