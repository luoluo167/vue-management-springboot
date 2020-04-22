import request from '../utils/request';

export const fetchPermission = query => {
    return request({
        url: '/rest/permission/page',
        method: 'post',
        data: query
    });
};

export const savePermission = data => {
    return request({
        url: '/rest/permission/save',
        method: 'post',
        data: data
    });
};

export const updatePermission = data => {
    return request({
        url: '/rest/permission/update',
        method: 'post',
        data: data
    });
};

export const deletePermission = params => {
    return request({
        url: '/rest/permission/delete',
        method: 'get',
        params: params
    });
};
