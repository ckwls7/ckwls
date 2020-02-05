package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardMapper {//BoardMapper영속계층(dao)
	
	@Select("select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc")
	public List<BoardVO> selectBoardList();
	
	@Insert("insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, #{bName}, #{bTitle}, #{bContent}, 0, mvc_board_seq.currval, 0, 0 )")
	public void insertBoard(BoardVO param);
	
	@Select("select * from mvc_board where bId = #{bId}")
	public BoardVO selectBoardOne(String bId);
	
	@Select("select count(*) from mvc_board")
	public int selectCountBoard();//result가 있어서 자기가 알아서 int로 값을반환
	
	@Select("update mvc_board set bName=#{boardVO.bName},bTitle=#{boardVO.bTitle},bContent=#{boardVO.bContent} where bId=#{boardVO.bId}")
	public void updateBoard(@Param("boardVO")BoardVO boardVO);
	
	@Update("update mvc_board set bStep = bStep + 1 where bGroup = #{bGroup} and bStep > #{bStep}")
	public void updateShape(BoardVO boardVO);
	
	@Insert("insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, #{bName}, #{bTitle},#{bContent}, #{bGroup}, #{bStep}+1, #{bIndent}+1) ")
	public void insertReply(BoardVO boardVO);
	
	@Select("delete from mvc_board where bId=#{bId}")
	public void Delete(BoardVO boardVO);

	
	public List<BoardVO> selectBoardListPage(Criteria criteria);
	
	
	

}
