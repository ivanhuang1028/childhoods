package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.CommentImagesMapper;
import com.hl.childhood.service.CommentImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("commentImagesService")
public class CommentImagesServiceImp<T> extends BaseServiceImp<T> implements CommentImagesService<T> {

    @Override
    public CommentImagesMapper<T> getMapper() {
        return (CommentImagesMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("commentImagesMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
