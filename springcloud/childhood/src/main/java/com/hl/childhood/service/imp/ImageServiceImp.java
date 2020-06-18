package com.hl.childhood.service.imp;

import com.hl.childhood.mapper.BaseMapper;
import com.hl.childhood.mapper.ImageMapper;
import com.hl.childhood.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("imageService")
public class ImageServiceImp<T> extends BaseServiceImp<T> implements ImageService<T> {

    @Override
    public ImageMapper<T> getMapper() {
        return (ImageMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("imageMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


}
