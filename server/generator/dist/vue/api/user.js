import request from '../utils/request';

export const fetchUser = query => {
    return request({
        url: '/rest/user/page',
        method: 'post',
        data: query
    });
};

export const saveUser = data => {
    return request({
        url: '/rest/user/save',
        method: 'post',
        data: data
    });
};

export const updateUser = data => {
    return request({
        url: '/rest/user/update',
        method: 'post',
        data: data
    });
};

export const deleteUser = params => {
    return request({
        url: '/rest/user/delete',
        method: 'get',
        params: params
    });
};
