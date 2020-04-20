module.exports = {
    publicPath: './',
    assetsDir: 'static',
    productionSourceMap: false,
    devServer: {
        proxy: {
            '/rest': {
                target: 'http://localhost:9090/', //对应自己的接口
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/rest': ''
                }
            }
        }
    }
};
