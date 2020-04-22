import request from '../utils/request';

export const fetchDepartment = query => {
    return request({
        url: '/rest/department/page',
        method: 'post',
        data: query
    });
};

export const saveDepartment = data => {
    return request({
        url: '/rest/department/save',
        method: 'post',
        data: data
    });
};

export const updateDepartment = data => {
    return request({
        url: '/rest/department/update',
        method: 'post',
        data: data
    });
};

export const deleteDepartment = params => {
    return request({
        url: '/rest/department/delete',
        method: 'get',
        params: params
    });
};
