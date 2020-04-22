import request from '../utils/request';

export const fetchPosition = query => {
    return request({
        url: '/rest/position/page',
        method: 'post',
        data: query
    });
};

export const savePosition = data => {
    return request({
        url: '/rest/position/save',
        method: 'post',
        data: data
    });
};

export const updatePosition = data => {
    return request({
        url: '/rest/position/update',
        method: 'post',
        data: data
    });
};

export const deletePosition = params => {
    return request({
        url: '/rest/position/delete',
        method: 'get',
        params: params
    });
};
