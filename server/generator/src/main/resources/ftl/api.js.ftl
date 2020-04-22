import request from '../utils/request';

export const fetch${entity} = query => {
    return request({
        url: '/rest/${table.entityPath}/page',
        method: 'post',
        data: query
    });
};

export const save${entity} = data => {
    return request({
        url: '/rest/${table.entityPath}/save',
        method: 'post',
        data: data
    });
};

export const update${entity} = data => {
    return request({
        url: '/rest/${table.entityPath}/update',
        method: 'post',
        data: data
    });
};

export const delete${entity} = params => {
    return request({
        url: '/rest/${table.entityPath}/delete',
        method: 'get',
        params: params
    });
};
