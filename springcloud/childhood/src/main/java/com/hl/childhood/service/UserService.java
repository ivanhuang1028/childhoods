package com.hl.childhood.service;

import com.hl.childhood.mapper.UserMapper;

public interface UserService<T> extends BaseService<T>, UserMapper<T> {

}
