package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {//�����Ͻ� ������ ������
	
	@Autowired
	BoardMapper boardMapper;
	
	//�����Ͻ�����,�Խ���List�� ���� ����ϴ·���
	public List<BoardVO> selectBoardList(){
		return boardMapper.selectBoardList();
	}
	
	//�Խ��ǿ��� ������ ���� ���� 
	//2���� ȣ���ϴ°��� �����Ͻ�����
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
