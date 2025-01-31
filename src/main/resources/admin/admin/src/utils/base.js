const base = {
    get() {
        return {
            url : "http://localhost:8080/springboottvfo8kua/",
            name: "springboottvfo8kua",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboottvfo8kua/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于JAVA的个人摄影作品售卖网站设计与实现"
        } 
    }
}
export default base
