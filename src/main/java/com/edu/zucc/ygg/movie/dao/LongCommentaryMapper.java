package com.edu.zucc.ygg.movie.dao;

import com.edu.zucc.ygg.movie.domain.LongCommentary;
import com.edu.zucc.ygg.movie.dto.LongCommentaryDto;
import com.edu.zucc.ygg.movie.dto.LongCommentarySearchDto;
import com.edu.zucc.ygg.movie.util.MyMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LongCommentaryMapper extends MyMapper<LongCommentary> {

    public List<LongCommentaryDto> getLongCommentaryList();

    public List<LongCommentaryDto> getCollectionCommentaryList(int userId);

    public LongCommentaryDto get(int id);

    public List<LongCommentaryDto> search(LongCommentarySearchDto searchDto);

    @Update("update long_commentary set state=1,delete_time=now() where id = #{id}")
    public int deleteSoft(int id);
}