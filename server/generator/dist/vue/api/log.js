import request from '../utils/request';

export const fetchLog = query => {
    return request({
        url: '/rest/log/page',
        method: 'post',
        data: query
    });
};

export const saveLog = data => {
    return request({
        url: '/rest/log/save',
        method: 'post',
        data: data
    });
};

export const updateLog = data => {
    return request({
        url: '/rest/log/update',
        method: 'post',
        data: data
    });
};

export const deleteLog = params => {
    return request({
        url: '/rest/log/delete',
        method: 'get',
        params: params
    });
};
